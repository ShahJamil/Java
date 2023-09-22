package gardening.plants;

import gardening.utils.GrowthRate;

public class Plant{
    public int populationCount;
    protected int id;
    protected GrowthRate growthRate;
    protected int maturityGoal;
    protected int maturity;

    public Plant(GrowthRate growthRate, int maturityGoal){
        
        this.maturity = 0;
        this.populationCount++;
        this.id = this.populationCount;
       
    }
    public int getGrowthRateModifier(GrowthRate growthRate){
        if (growthRate == GrowthRate.FAST){
            return 6;
        }
        else if(growthRate == growthRate.MODERATE){
            return 2;
        }
        else {
            return 1;
        }
    }
    public void grow(){
        this.maturity = this.maturity + getGrowthRateModifier(this.growthRate);
    }
    public boolean isMature(){
        return maturity == maturityGoal;
    }

    
}