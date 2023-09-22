package gardening.plants;
import gardening.utils.GrowthRate;


public class PalmTree extends Plant{
    private int coconutFruitCount ;
    public static final int  COCONUT_YIELD = 2;
    
    public PalmTree(){
        super(GrowthRate.MODERATE, 12);
        this.coconutFruitCount = 0;
        
    }

    public void grow(){
        this.maturity = this.maturity + getGrowthRateModifier(this.growthRate);
        this.coconutFruitCount+= this.COCONUT_YIELD;
    }

    public boolean isMature() {
        return super.isMature() && coconutFruitCount == 12;
    }

    @Override
    public String toString(){
        String value;
        if(this.isMature()){
            value = "is mature";
        }
        else{
            value = "is not mature";
        }
        return "(" + "Palm Tree" + " " + this.id + ";" + " " + "coconut fruit count" + ":" + " " + this.coconutFruitCount + ";" + " " + "maturity level" + ":" + " " + this.maturity + ";" + " " + value; 
    }
}