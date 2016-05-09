import javax.swing.*;
import java.awt.*;

/**
 * @author Paul Buonopane
 */
public class IconAdapter extends JComponent {
    private final Icon icon;

    public IconAdapter(Icon icon) {
        this.icon = icon;

        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        icon.paintIcon(this, g, 0, 0);
    }
}
