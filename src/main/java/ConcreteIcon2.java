import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Buonopane
 */
public class ConcreteIcon2 implements Icon {
    private static final int SIZE = 512;
    private static final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.RED};

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int step = SIZE / colors.length / 2;
        int arc = step * 2;

        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);

            int s = step * i;
            int dim = SIZE - s * 2;
            g.fillRoundRect(
                    x + s,
                    y + s,
                    dim, dim,
                    arc, arc
            );
        }
    }

    @Override
    public int getIconWidth() {
        return SIZE;
    }

    @Override
    public int getIconHeight() {
        return SIZE;
    }
}
