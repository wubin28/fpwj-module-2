
import java.util.Random;

public class ProfitDeduplicate {
    public static void calculate() {

        final Double costs = Timing.timedDouble(
                "Cost calculation",
                () -> calculateCosts());

        // repeat
        final Double revenue = calculateRevenue();

        final Double profit = calculateProfit(costs, revenue);

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
