import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    GrowthRateStructureTest.class,
    GrowableStructureTest.class,

    PlantStructureTest.class,

    OrchidStructureTest.class,
    PalmTreeStructureTest.class,

    GardenStructureTest.class
})
public class GardeningTestSuite {}
