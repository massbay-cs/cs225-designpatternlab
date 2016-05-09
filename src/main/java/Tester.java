import javax.swing.*;

/**
 * @author Paul Buonopane
 */
public abstract class Tester extends JFrame {
    public Tester(String title) {
        super(title);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
}
