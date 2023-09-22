import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GrowableStructureTest {
    @BeforeAll
    public static void init() {
        
        CheckThat.theInterface("gardening.utils.Growable")
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodGrow() {
        it.hasMethod("grow", withNoParams())
            .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}

