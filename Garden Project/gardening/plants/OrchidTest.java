package gardening.plants;
import gardening.plants.Plant;
import gardening.plants.Orchid;
import gardening.utils.GrowthRate;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;

import check.CheckThat;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

public class OrchidTest{

    @Test
    public void tOne(){
        Plant bob = new Plant(GrowthRate.FAST, 15);
        bob.toString();
        bob.grow();
        bob.grow();
        bob.grow();
        bob.grow();
        bob.toString();
        bob.grow();
        bob.grow();
        bob.grow();
        bob.grow();
        bob.toString();
    }
}