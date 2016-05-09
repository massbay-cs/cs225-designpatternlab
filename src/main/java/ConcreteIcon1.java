import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Buonopane
 */
public class ConcreteIcon1 implements Icon {
    private static final float BLUE_HUE = 240f / 360f;
    private static final int SIZE = 512;
    private static final Color[] colors;

    static {
        colors = new Color[8];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.getHSBColor(BLUE_HUE, 0.8f, (float) i / colors.length);
        }
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int step = SIZE / colors.length;

        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);

            int s = step * i / 2;
            int r = (colors.length - i) * step;
            g.fillOval(s + x, s + y, r, r);
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
