import java.util.logging.Logger;
import java.util.Random;

public class ProfitJava6 {
  static final Logger logger = Logger.getLogger(ProfitJava6.class.getName());

  public static Double calculate() {

    final Double costs = Timing.timedJava6("ProfitJava6: Cost calculation",
            new MySupplier<Double>() {
              @Override
              public Double get() {
                return calculateCosts();
              }
            });

    final Double revenue = Timing.timedJava6("ProfitJava6: Revenue calculation",
            new MySupplier<Double>() {
              @Override
              public Double get() {
                return calculateRevenue();
              }
            });

    final Double profit = Timing.timedJava6("ProfitJava6: Profit calculation",
            LoggerFunctions.info(logger),
            new MySupplier<Double>() {
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
