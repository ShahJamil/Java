package gardening.plants;
import gardening.utils.GrowthRate;

public class Orchid extends Plant{
    private int flowerCount;

    public Orchid(){
        super(GrowthRate.FAST, 15);
        this.flowerCount = 0;
    }

    public void grow(){
        this.maturity = this.maturity + getGrowthRateModifier(this.growthRate);

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
        return "(" + "Palm Tree" + " " + this.id + ";" + " " + "flower count" + ":" + " " + this.flowerCount + ";" + " " + "maturity level" + ":" + " " + this.maturity + ";" + " " + value; 

    }
}