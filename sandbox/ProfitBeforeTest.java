import org.junit.*;
import static org.junit.Assert.*;

public class ProfitBeforeTest {

    @Test
    public void life_the_universe_and_everything() {
        assertEquals(18845.9, ProfitBefore.calculate(), 0.001);
    }
}
