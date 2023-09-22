import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GrowthRateStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theEnum("gardening.utils.GrowthRate")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasEnumElements("SLOW", "MODERATE", "FAST");
    }
}
