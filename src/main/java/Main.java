import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Buonopane
 */
public class Main extends JFrame {
    public Main() {
        super("Paul Buonopane: CS225 DesignPatternLab");

        JButton part1 = new JButton("Part 1 Tester");
        JButton part2 = new JButton("Part 2 Tester");

        part1.addActionListener(new TestLauncher<>(Part1Tester.factory().setButton(part1)));
        part2.addActionListener(new TestLauncher<>(Part2Tester.factory().setButton(part2)));

        setLayout(new GridLayout(2, 1));
        add(part1);
        add(part2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            JOptionPane.showMessageDialog(null, "Unable to use system look and feel.  Continuing anyway, but the GUI may appear malformed.\n\nDetails: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        Main frame = new Main();
        frame.pack();
        frame.setVisible(true);
    }
}
