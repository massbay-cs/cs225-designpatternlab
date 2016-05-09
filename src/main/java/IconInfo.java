import javax.swing.*;

/**
 * @author Paul Buonopane
 */
public final class IconInfo {
    private final Icon icon;
    private final int x;
    private final int y;

    public IconInfo(Icon icon, int x, int y) {
        this.icon = icon;
        this.x = x;
        this.y = y;
    }

    public Icon getIcon() {
        return icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
