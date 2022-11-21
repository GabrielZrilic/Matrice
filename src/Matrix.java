import java.util.ArrayList;

import javax.swing.JTextField;

public class Matrix {
    int m, n;
    private ArrayList<ArrayList<Double>> grid;

    public Matrix(int m, int n) {
        this.m = m; this.n = n; 
        grid = new ArrayList<ArrayList<Double>>();
    }

    public void setGrid(int i, int j, MatrixFields n) {
        grid.get(i).set(j, Double.parseDouble(n.getTextField(i, j).getText()));
    }
}
