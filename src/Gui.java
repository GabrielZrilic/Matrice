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
    JButton okButton, clearButton, copy1Button, copy2Button, copy3Button, paste1Button, paste2Button;
    JLabel eqLabel;
    JComboBox<String> operatorBox;
    MatrixFields matrix1Fields, matrix2Fields;
    Matrix matrix1, matrix2;
    


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
        copy1Button = new JButton("Kopiraj"); copy2Button = new JButton("Kopiraj"); copy3Button = new JButton("Kopiraj");
        paste1Button = new JButton("Zalijepi"); paste2Button = new JButton("Zalijepi");
        okButton = new JButton("U redu"); clearButton = new JButton("Izbriši");
        eqLabel = new JLabel("="); eqLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        operatorBox = new JComboBox<String>(new String[] {"+", "-", "*","/"});
        operatorBox.setFont(new Font("Arial", Font.PLAIN, 30));

        panel1.setLayout(new BorderLayout());
        panel1.add(panelUp, BorderLayout.PAGE_START); panelUp.setLayout(new GridBagLayout());
        panel1.add(panelCenter, BorderLayout.CENTER); panelCenter.setLayout(new GridBagLayout());
        panel1.add(panelDown, BorderLayout.PAGE_END);

        panelUp.add(panelUpLeft, setLocation(0, 0, GridBagConstraints.BOTH, 1, 1));
        panelUpLeft.add(new JLabel("Veličina:"));
        panelUpLeft.add(size1Field);
        panelUpLeft.add(copy1Button);
        panelUpLeft.add(paste1Button);

        panelUp.add(panelUpRight, setLocation(1, 0, GridBagConstraints.BOTH, 1, 1));
        panelUpRight.add(new JLabel("Veličina:"));
        panelUpRight.add(size2Field);
        panelUpRight.add(copy2Button);
        panelUpRight.add(paste2Button);

        panelUp.add(copy3Button, setLocation(2, 0, GridBagConstraints.BOTH, 1, 1));

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

    private void setPanel2() {}

    private void declareListeners() {
        okButton.addActionListener(this);
        clearButton.addActionListener(this);
        copy1Button.addActionListener(this);
        copy2Button.addActionListener(this);
        copy3Button.addActionListener(this);
        paste1Button.addActionListener(this);
        paste2Button.addActionListener(this);
    }

    private GridBagConstraints setLocation(int x, int y, int fill, double weightx, double weighty) {
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = weightx; c.weighty = weighty;
        c.gridx = x; c.gridy = y;
        c.fill = fill;

        return c;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == size1Field) {

        }else if(e.getSource() == size2Field) {

        }
    }

}
