import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Gui extends JPanel implements ActionListener {
    JTabbedPane tabbedPane;
    JPanel panel1, panel2;

    // Panel 1
    JPanel matrix1Panel, matrix2Panel, matrix3Panel, panelUp, panelDown, panelCenter, panelUpLeft, panelUpRight, operatorPanel, eqPanel;
    JTextField size1Field, size2Field;
    JButton okButton, clearButton;
    JLabel eqLabel;
    JComboBox<String> operatorBox;
    MatrixFields matrix1Fields, matrix2Fields;
    Matrix matrix1, matrix2, matrix3;

    // Panel 2
    Matrix matrixD, matrixR;
    JPanel leftPanel, rightPanel, upPanel;
    JButton okDButton, clearDButton;
    JTextField sizeDField;
    JLabel eqDLabel;

    public Gui() {
        super(new GridLayout(1, 1));
        setTabs(); setPanel1(); setPanel2();
        declareListeners();
    }

    private void setTabs() {
        tabbedPane = new JTabbedPane();
        super.add(tabbedPane);

        panel1 = new JPanel(); panel2 = new JPanel();

        tabbedPane.add("Računanje", panel1); tabbedPane.add("Determinanta", panel2);
        tabbedPane.setFocusable(false);
    }

    private void setPanel1() {
        panelUp = new JPanel(); panelCenter = new JPanel(); panelDown = new JPanel();
        panelUpLeft = new JPanel(); panelUpRight = new JPanel();
        matrix1Panel = new JPanel(); matrix2Panel = new JPanel(); matrix3Panel = new JPanel(); operatorPanel = new JPanel(); eqPanel = new JPanel(); 

        size1Field = new JTextField(10); size2Field = new JTextField(10);
        okButton = new JButton("U redu"); clearButton = new JButton("Izbriši");
        eqLabel = new JLabel("="); eqLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        operatorBox = new JComboBox<String>(new String[] {"+", "-", "*"});
        operatorBox.setFont(new Font("Arial", Font.PLAIN, 30));

        panel1.setLayout(new BorderLayout());
        panel1.add(panelUp, BorderLayout.PAGE_START); panelUp.setLayout(new GridBagLayout());
        panel1.add(panelCenter, BorderLayout.CENTER); panelCenter.setLayout(new GridBagLayout());
        panel1.add(panelDown, BorderLayout.PAGE_END);

        panelUp.add(panelUpLeft, setLocation(0, 0, GridBagConstraints.BOTH, 1, 1));
        panelUpLeft.add(new JLabel("Veličina:"));
        panelUpLeft.add(size1Field);

        panelUp.add(panelUpRight, setLocation(1, 0, GridBagConstraints.BOTH, 1, 1));
        panelUpRight.add(new JLabel("Veličina:"));
        panelUpRight.add(size2Field);

        panelDown.add(okButton); panelDown.add(clearButton);

        panelCenter.add(matrix1Panel, setLocation(0, 0, GridBagConstraints.BOTH, 1, 1)); 
        panelCenter.add(operatorPanel, setLocation(1, 0, GridBagConstraints.BOTH, 0.5, 1));         
        panelCenter.add(matrix2Panel, setLocation(2, 0, GridBagConstraints.BOTH, 1, 1));         
        panelCenter.add(eqPanel, setLocation(3, 0, GridBagConstraints.BOTH, 0.5, 1));         
        panelCenter.add(matrix3Panel, setLocation(4, 0, GridBagConstraints.BOTH, 1, 1));

        eqPanel.setLayout(new GridBagLayout());
        eqPanel.add(eqLabel, setLocation(0, 0, GridBagConstraints.NONE, 0, 0));
        operatorPanel.setLayout(new GridBagLayout()); 
        operatorPanel.add(operatorBox, setLocation(0, 0, GridBagConstraints.NONE, 0, 0));
    }

    private void setPanel2() {
        leftPanel = new JPanel(); rightPanel = new JPanel(); upPanel = new JPanel();
        okDButton = new JButton("U redu"); clearDButton = new JButton("Izbriši");
        eqDLabel = new JLabel("="); eqDLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        sizeDField = new JTextField(8);

        panel2.setLayout(new BorderLayout());
        panel2.add(upPanel, BorderLayout.PAGE_START); upPanel.add(sizeDField);
        panel2.add(leftPanel, BorderLayout.LINE_START);
        panel2.add(rightPanel, BorderLayout.LINE_END);
    }

    private void declareListeners() {
        okButton.addActionListener(this);
        clearButton.addActionListener(this);
        size1Field.addActionListener(this);
        size2Field.addActionListener(this);
        okDButton.addActionListener(this);
        clearDButton.addActionListener(this);
        sizeDField.addActionListener(this);
    }

    private GridBagConstraints setLocation(int x, int y, int fill, double weightx, double weighty) {
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = weightx; c.weighty = weighty;
        c.gridx = x; c.gridy = y;
        c.fill = fill;
        return c;
    }

    private void displayAnsMatrix() {
        matrix3Panel.removeAll();
        matrix3Panel.setLayout(new GridBagLayout());
        for(int i = 0; i<matrix3.m; i++) {
            for(int j = 0; j<matrix3.n; j++) {
                matrix3Panel.add(new JLabel(Double.toString(matrix3.grid.get(i).get(j))), setLocation(j, i, GridBagConstraints.HORIZONTAL, 1, 1));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == size1Field) {
            matrix1Panel.removeAll();
            matrix1Panel.setLayout(new GridBagLayout());
            matrix1Fields = new MatrixFields(size1Field);
            for(int i = 0; i<matrix1Fields.m; i++) {
                for(int j = 0; j<matrix1Fields.n; j++) {
                    matrix1Panel.add(matrix1Fields.grid.get(i).get(j), setLocation(j, i, GridBagConstraints.HORIZONTAL, 1, 1));
                }
            }
            this.repaint();
        }else if(e.getSource() == size2Field) {
            matrix2Panel.removeAll();
            matrix2Panel.setLayout(new GridBagLayout());
            matrix2Fields = new MatrixFields(size2Field);
            for(int i = 0; i<matrix2Fields.m; i++) {
                for(int j = 0; j<matrix2Fields.n; j++) {
                    matrix2Panel.add(matrix2Fields.grid.get(i).get(j), setLocation(j, i, GridBagConstraints.HORIZONTAL, 1, 1));
                }
            }
            this.repaint();
        }else if(e.getSource() == okButton) {
            matrix1 = new Matrix(matrix1Fields.m, matrix1Fields.n);
            matrix2 = new Matrix(matrix2Fields.m, matrix2Fields.n);
            matrix1.setGrid(matrix1Fields);
            matrix2.setGrid(matrix2Fields);
            matrix3 = new Matrix(matrix1.m, matrix1.n);

            if(operatorBox.getSelectedItem() == "+") matrix3.sum(matrix1, matrix2);
            else if(operatorBox.getSelectedItem() == "-") matrix3.subtract(matrix1, matrix2);
            else if(operatorBox.getSelectedItem() == "*") {matrix3 = new Matrix(matrix1.m, matrix2.n); matrix3.multiply(matrix1, matrix2);}

            displayAnsMatrix();
            this.repaint();
        }else if(e.getSource() == clearButton) {
            matrix1Panel.removeAll();
            matrix2Panel.removeAll();
            matrix3Panel.removeAll();
            matrix1 = null;
            matrix2 = null;
            matrix3 = null;
        }
    }
}
