import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Paul Buonopane
 */
public class TestLauncher<T extends Tester> implements ActionListener {
    private final TesterFactory<T> testerFactory;

    public TestLauncher(TesterFactory<T> testerFactory) {
        this.testerFactory = testerFactory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        testerFactory
                .setVisible(true)
                .build();
    }
}