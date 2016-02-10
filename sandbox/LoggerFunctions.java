import org.apache.logging.log4j.Logger;

public class LoggerFunctions {

  public static MyFunction<String, Void> info(final Logger logger) {
    return new MyFunction<String, Void>() {
      @Override
      public Void apply(String s) {
        logger.info(s);
        return null;
      }
    };
  }
}
