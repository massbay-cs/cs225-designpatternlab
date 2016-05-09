import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Paul Buonopane
 */
public abstract class TesterFactory<T extends Tester> {
    private boolean visible = true;
    private JButton button;

    protected abstract T instantiate();

    public TesterFactory<T> setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    public TesterFactory<T> setButton(JButton button) {
        this.button = button;
        return this;
    }

    public T build() {
        T i = instantiate();

        if (button != null) {
            button.setEnabled(false);

            i.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    button.setEnabled(true);
                }
            });
        }

        i.pack();
        i.setVisible(visible);
        return i;
    }
}
