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
}
