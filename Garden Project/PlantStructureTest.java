import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class PlantStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("gardening.plants.Plant", withInterfaces("gardening.utils.Growable"))
            .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldPopulationCount() {
        it.hasField("populationCount", ofType("int"))
            .thatIs(USABLE_WITHOUT_INSTANCE, MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldId() {
        it.hasField("id", ofType("int"))
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldGrowthRate() {
        it.hasField("growthRate", ofType("gardening.utils.GrowthRate"))
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldMaturityGoal() {
        it.hasField("maturityGoal", ofType("int"))
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldMaturity() {
        it.hasField("maturity", ofType("int"))
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("gardening.utils.GrowthRate", "int"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodGetGrowthRateModifier() {
        it.hasMethod("getGrowthRateModifier", withParams("gardening.utils.GrowthRate"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test
    public void methodGrow() {
        it.hasMethod("grow", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodIsMature() {
        it.hasMethod("isMature", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }
}
