/**
 * @author Paul Buonopane
 */
public class Part2Tester extends Tester {
    public Part2Tester() {
        super("Part 2");

        add(new IconAdapter(new ConcreteIcon1()));
    }

    public static TesterFactory<Part2Tester> factory() {
        return new TesterFactory<Part2Tester>() {
            @Override
            protected Part2Tester instantiate() {
                return new Part2Tester();
            }
        };
    }
}
