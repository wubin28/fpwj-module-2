
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.util.Random;


public class ProfitIsolation {
    static final Logger logger = 
        LogManager.getLogManager().getLogger(
            ProfitIsolation.class.getName());

    public static Double calculate() {

        final Double costs = Timing.timed(
                "Cost calculation",
                ProfitIsolation::calculateCosts);

        final Double revenue = Timing.timed(
                "Revenue calculation",
                ProfitIsolation::calculateRevenue);

        System.out.println("logger is null?" + (logger == null ? "yes" : "no"));
        final Double profit = Timing.timed(
                "Profit calculation",
                logger::info,
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
    private static final Integer MAX_WORK_TIME_MS = 2000;
    private static void pretendToWorkHard() {
        try {
            Thread.sleep(r.nextInt(MAX_WORK_TIME_MS));
        } catch (InterruptedException e) {
        }
    }
}
