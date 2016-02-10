
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

  private static MyFunction<String, Void> DO_NOTHING = 
    new MyFunction<String, Void>(){
        @Override
        public Void apply(String s) {
          return null;
        }
  };

  private static MyFunction<String, Void> PRINT_TO_STDOUT = 
    new MyFunction<String, Void>(){
        @Override
        public Void apply(String s) {
          System.out.println(s);
          return null;
        }
  };

  public static <A> A timedJava6(String description,
                            Supplier<A> code) {
    return timedJava6(description, PRINT_TO_STDOUT, code);
  }

  public static <A> A timedJava6(String description,
                            MyFunction<String, Void> output,
                            Supplier<A> code) {

    final Date before = new Date();
    A result = code.get();
    final Long duration = new Date().getTime() -
            before.getTime();
    output.apply(description + " took " + duration
            + " milliseconds");

    return result;
  }
}
