import java.util.ArrayList;

import javax.swing.JTextField;

public class MatrixFields {
    private ArrayList<ArrayList<JTextField>> grid;

    public JTextField getTextField(int i, int j) {
        return grid.get(i).get(j);
    }

    public void clear() {
        grid.clear();
    }
}
