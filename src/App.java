import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();

        mainFrame.setSize(900, 900);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(new Gui());
        mainFrame.setVisible(true);
    }
}
