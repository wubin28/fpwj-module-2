
import java.util.Date;
import java.util.function.Supplier;

public class Timing {

    public static Double timedDouble(String description, Supplier<Double> code) {
        final Date before = new Date();
        final Double result = code.get();
        final Long duration = new Date().getTime() - before.getTime();
        System.out.println(description + " took " + duration + " ms");
        return result;
    }

    public static <A> A timed(String description,
                              Supplier<A> code) {
        final Date before = new Date();

        final A result = code.get();

        final Long duration = new Date().getTime() - before.getTime();
        System.out.println(description + " took " + duration + " ms");
        return result;
    }
}
