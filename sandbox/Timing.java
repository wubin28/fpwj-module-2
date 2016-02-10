
import java.util.Date;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Timing {

    public static Double timedDouble(String description, 
            Supplier<Double> code) {
        final Date before = new Date();
        final Double result = code.get();
        final Long duration = new Date().getTime() - before.getTime();
        System.out.println(description + " took " + duration + " ms");
        return result;
    }

    public static <A> A timed(String description,
                              Supplier<A> code) {
        final Consumer<String> defaultPrinter = System.out::println;

        // change default to do nothing 
        // final Consumer<String> defaultPrinter = (s) -> {};  

        return timed(description, defaultPrinter, code);
    }

    public static <A> A timed(String description,
                              Consumer<String> printer,
                              Supplier<A> code) {
        final Date before = new Date();

        final A result = code.get();

        final Long duration = new Date().getTime() - before.getTime();
        printer.accept(description + " took " + duration + " ms");
        return result;
    }

  private static Function<String, Void> DO_NOTHING = new Function<String, Void>(){
    @Override
    public Void apply(java.lang.String s) {
      return null;
    }
  };

  public static <A> A timedJava6(String description,
                            MySupplier<A> code) {
    return timed(description, DO_NOTHING, code);
  }

  public static <A> A timedJava6(String description,
                            Function<String, Void> output,
                            MySupplier<A> code) {

    final Date before = new Date();
    A result = code.get();
    final Long duration = new Date().getTime() -
            before.getTime();
    output.apply(description + " took " + duration
            + " milliseconds");

    return result;
  }
}
