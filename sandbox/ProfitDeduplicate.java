
import java.util.Random;

public class ProfitDeduplicate {
    public static Double calculate() {

        final Double costs = Timing.timedDouble(
                "Cost calculation",
                ProfitDeduplicate::calculateCosts);

        final Double revenue = Timing.timedDouble(
                "Revenue calculation",
                ProfitDeduplicate::calculateRevenue);

        final Double profit = Timing.timedDouble(
                "Profit calculation",
                ProfitDeduplicate::calculateProfit);

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
        }
    }
}
