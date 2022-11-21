import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Matrix {
    int m, n;
    public ArrayList<ArrayList<Double>> grid;

    public Matrix(int m, int n) {
        this.m = m; this.n = n; 
        grid = new ArrayList<ArrayList<Double>>();
        for(int i = 0; i<m; i++) {
            grid.add(new ArrayList<Double>());
            for(int  j = 0; j<n; j++) {
                grid.get(i).add(0.0);
            }
        }
    }

    public void setGrid(MatrixFields n) {
        for(int i = 0; i<n.m; i++) {
            for(int j = 0; j<n.n; j++) {
                grid.get(i).set(j, n.getTextField(i, j));
            }
        }
    }

    private boolean isValid(Matrix matrix1, Matrix matrix2) {
        if(matrix1.n != matrix2.n || matrix1.m != matrix2.m) {
            JOptionPane.showMessageDialog(new JFrame(), "Dimenzije matrica trebaju biti jednake");
            return false;
        }
        return true;
    }

    public void sum(Matrix matrix1, Matrix matrix2) {
        double a, b;       
        
        if(!isValid(matrix1, matrix2)) return;
        

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                a = matrix1.grid.get(i).get(j);
                b = matrix2.grid.get(i).get(j);

                grid.get(i).set(j, a + b);
            }
        }
    }

    public void subtract(Matrix matrix1, Matrix matrix2) {
        double a, b;       
        
        if(!isValid(matrix1, matrix2)) return;
        

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                a = matrix1.grid.get(i).get(j);
                b = matrix2.grid.get(i).get(j);

                grid.get(i).set(j, a - b);
            }
        }
    }

    public void multiply(Matrix matrix1, Matrix matrix2) {
        double a = 0;

        if(matrix1.n != matrix2.m) {
            JOptionPane.showMessageDialog(new JFrame(), "Pogrešne dimenzije");
            return;
        }

        for(int i = 0; i<matrix1.m; i++) {
            for(int j = 0; j<matrix2.n; j++) {
                a = 0;
                for(int k = 0; k<matrix1.n; k++) {
                    a += matrix1.grid.get(i).get(k) * matrix2.grid.get(k).get(j);
                }
                grid.get(i).set(j, a);
            }
        }
    }

    public double determinant() {
        if(grid.size() != grid.get(0).size()) return 0;
        double s1 = 0, s2 = 0, c;
        int a;
        
        if(n == 2) return grid.get(0).get(0)*grid.get(1).get(1) - grid.get(0).get(1)*grid.get(1).get(0);

        for(int i = 0; i<n; i++) {
            a = i;
            c = 1.0;
            for(int j = 0; j<n; j++) {
                System.out.print(grid.get(j).get(a));
                c *= grid.get(j).get(a);
                a++;
                if(a == n) a = 0;
            }
            System.out.println(" ");
            s1 += c;
        }

        for(int i = 0; i<n; i++) {
            a = i;
            c = 1.0;
            for(int j = n-1; j>-1; j--) {
                System.out.print(grid.get(j).get(a));
                c *= grid.get(j).get(a);
                a++;
                if(a == n) a = 0;
            }
            System.out.println(" ");
            s2 += c;
        }
        System.out.println(s1 + " " + s2);
        return s1 - s2;
    }
}
