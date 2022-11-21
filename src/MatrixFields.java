import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MatrixFields {
    public int m, n;
    public ArrayList<ArrayList<JTextField>> grid;

    public MatrixFields(JTextField input) {
        
        grid = new ArrayList<ArrayList<JTextField>>();

        String[] splittedString = input.getText().split(" ");

        if(splittedString.length != 2) {
            JOptionPane.showMessageDialog(new JFrame(), "Krivi unos. Unos treba veličine biti m n. \nNpr: 4 5");
        }

        try {
            m = Integer.parseInt(splittedString[0]);
            n = Integer.parseInt(splittedString[1]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Krivi unos. Unos veličine treba biti m n. \nNpr: 4 5");
        }

        for(int i = 0; i<m; i++) {
            grid.add(new ArrayList<JTextField>());
            for(int j = 0; j<n; j++) {
                grid.get(i).add(new JTextField());
            }
        }
    }
    
    public MatrixFields() {
        grid = new ArrayList<ArrayList<JTextField>>();
    }

    public double getTextField(int i, int j) {
        return Double.parseDouble(grid.get(i).get(j).getText());
    }

    public void clear() {
        grid.clear();
    }

    
}
