import com.google.common.base.Supplier;
import java.util.logging.Logger;
import java.util.Random;

public class ProfitJava6 {
  static final Logger logger = Logger.getLogger(ProfitJava6.class.getName());

  public static void calculate() {

    final Double costs = timed("Cost calculation",
            new Supplier<Double>() {
              @Override
              public Double get() {
                return calculateCosts();
              }
            });

    final Double revenue = timed("Revenue calculation",
            new Supplier<Double>() {
              @Override
              public Double get() {
                return calculateRevenue();
              }
            });

    final Double profit = timed("Profit calculation",
            LoggerFunctions.info(logger),
            new Supplier<Double>() {
              @Override
              public Double get() {
                return calculateProfit(costs, revenue);
              }
            });

    return profit;
  }

  private static Double calculateCosts() {
    pretendToWorkHard();
    return 4567.3;
  }

  private static Double calculateRevenue() {
    pretendToWorkHard();
    return 23413.2;
  }

  private static Double calculateProfit(Double costs, Double revenue) {
    pretendToWorkHard();
    return revenue - costs;
  }

  private static final Random r = new Random();
  private static final Integer MAX_WORK_TIME_MS = 200;
  private static void pretendToWorkHard() {
    try {
      Thread.sleep(r.nextInt(MAX_WORK_TIME_MS));
    } catch (InterruptedException e) {
    }
  }
}
