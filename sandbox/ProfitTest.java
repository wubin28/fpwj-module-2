import org.junit.*;
import static org.junit.Assert.*;

public class ProfitTest {

    @Test
    public void ProfitBefore_should_calculate_profits() {
        assertEquals(18845.9, ProfitBefore.calculate(), 0.001);
    }

    @Test
    public void ProfitNaive_should_calculate_profits() {
        assertEquals(18845.9, ProfitNaive.calculate(), 0.001);
    }

    @Test
    public void ProfitDeduplicate_should_calculate_profits() {
        assertEquals(18845.9, ProfitDeduplicate.calculate(), 0.001);
    }

    @Test
    public void ProfitGeneralize_should_calculate_profits() {
        assertEquals(18845.9, ProfitGeneralize.calculate(), 0.001);
    }

    @Test
    public void ProfitIsolation_should_calculate_profits() {
        assertEquals(18845.9, ProfitIsolation.calculate(), 0.001);
    }

    @Test
    public void ProfitJava6_should_calculate_profits() {
        assertEquals(18845.9, ProfitJava6.calculate(), 0.001);
    }
}
