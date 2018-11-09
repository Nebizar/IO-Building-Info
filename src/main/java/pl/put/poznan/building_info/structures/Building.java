package pl.put.poznan.building_info.structures;
import java.util.ArrayList;
import java.util.List;

public class Building extends Location{
    
    private ArrayList<Level> levels = new ArrayList<Level>();


    public Building(int id, String name){
        super(id, name);
    }

    public void addLevel(Level newLevel){
        levels.add(newLevel);
    }

    public ArrayList<Level> getLevels(){
        return levels;
    }
    
}