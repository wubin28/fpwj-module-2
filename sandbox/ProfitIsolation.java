
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.util.Random;


public class ProfitIsolation {
    Logger logger = LogManager.getLogManager().getLogger("");

    public static Double calculate(final String[] args) {

        final Double costs = timed(
                "Cost calculation",
                Example::calculateCosts);

        final Double revenue = timed(
                "Revenue calculation",
                Example::calculateRevenue);

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