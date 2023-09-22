package gardening.garden;
import java.util.ArrayList;
import gardening.plants.Orchid;
import gardening.plants.PalmTree;
import gardening.plants.Plant;



public class Garden{
    public ArrayList<Plant> seedlings;
    public ArrayList<Plant> maturePlants;
    public Garden(){ }


    public void plantPalmTree(){
        seedlings.add(new PalmTree());
    }

    public void plantOrchid(){
        seedlings.add(new Orchid());
    }

    public void growAll()
    {
       for (Plant plant : seedlings){
        plant.grow();
        if(plant.isMature()){
            seedlings.remove(plant);
            maturePlants.add(plant);
        }
       }
    }
}