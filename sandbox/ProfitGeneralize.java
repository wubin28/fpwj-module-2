import java.util.logging.Logger;
import java.util.Random;

public class ProfitGeneralize {
    static final Logger logger = 
        Logger.getLogger(ProfitGeneralize.class.getName());

    public static Double calculate() {

        final Double costs = Timing.timed(
                "ProfitGeneralize: Cost calculation",
                ProfitGeneralize::calculateCosts);

        final Double revenue = Timing.timed(
                "ProfitGeneralize: Revenue calculation",
                ProfitGeneralize::calculateRevenue);

        final Double profit = Timing.timed(
                "ProfitGeneralize: Profit calculation",
                () -> calculateProfit(costs, revenue));

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

    private static Double calculateProfit(Double costs, Double revenue){
        pretendToWorkHard();
        return revenue - costs;
    }

    private static final Random r = new Random();
    private static final Integer MAX_WORK_TIME_MS = 200;
    private static void pretendToWorkHard() {
        try {
            Thread.sleep(r.nextInt(MAX_WORK_TIME_MS));
        } catch (InterruptedException e) {
            logger.severe("Work was interrupted. Exception message: " + 
                e.toString());
        }
    }
}
