import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Buonopane
 */
public class Part1Tester extends Tester {
    public Part1Tester() {
        super("Part 1");

        setLayout(new GridLayout(1, 1, 0, 0));

        JPanel panel = new IconPanel();
        add(panel);
    }

    public static TesterFactory<Part1Tester> factory() {
        return new TesterFactory<Part1Tester>() {
            @Override
            protected Part1Tester instantiate() {
                return new Part1Tester();
            }
        };
    }

    private static class IconPanel extends JPanel {
        private final CompositeIcon icon;

        public IconPanel() {
            icon = new CompositeIcon();
            CompositeIcon subIcon = new CompositeIcon();
            subIcon.addIcon(new ConcreteIcon1(), 512, 512);
            subIcon.addIcon(new ConcreteIcon2(), 0, 0);
            icon.addIcon(subIcon, 256, 0);
            icon.addIcon(new ConcreteIcon2(), 512, 256);
            icon.addIcon(new ConcreteIcon1(), 512, 512);

            Dimension size = icon.getIconSize();
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);

            setBackground(Color.WHITE);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            icon.paintIcon(this, g, 0, 0);
        }
    }
}
