import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * @author Paul Buonopane
 */
public class CompositeIcon extends LinkedList<IconInfo> implements Icon {
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // Trim padding; this isn't a component, it shouldn't have padding.
        Rectangle bounds = getIconBounds();
        x -= bounds.getX();
        y -= bounds.getY();

        for (IconInfo i : this) {
            Icon icon = i.getIcon();
            Graphics subG = g.create(
                    x + i.getX(),
                    y + i.getY(),
                    icon.getIconWidth(),
                    icon.getIconHeight()
            );

            try {
                icon.paintIcon(c, subG, 0, 0);
            } finally {
                subG.dispose();
            }
        }
    }

    @Override
    public int getIconWidth() {
        return getIconBounds().width;
    }

    @Override
    public int getIconHeight() {
        return getIconBounds().height;
    }

    public Dimension getIconSize() {
        // Note that this will trim any padding on the top/left.
        return getIconBounds().getSize();
    }

    public Rectangle getIconBounds() {
        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;

        boolean first = true;
        for (IconInfo i : this) {
            int x = i.getX();
            int y = i.getY();

            if (first || x < minX) {
                minX = x;
            }
            if (first || y < minY) {
                minY = y;
            }

            x += i.getIcon().getIconWidth();
            y += i.getIcon().getIconHeight();

            if (first || x > maxX) {
                maxX = x;
            }
            if (first || y > maxY) {
                maxY = y;
            }

            if (first) {
                first = false;
            }
        }

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    public void addIcon(Icon icon, int x, int y) {
        add(new IconInfo(icon, x, y));
    }
}
