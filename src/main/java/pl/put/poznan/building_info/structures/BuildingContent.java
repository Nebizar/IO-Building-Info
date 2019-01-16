package pl.put.poznan.building_info.structures;
import java.util.ArrayList;
import java.util.List;

public class BuildingContent{
	
    private Building building;
    private ArrayList<LevelContent> levels = new ArrayList<LevelContent>();

    public BuildingContent(Building b){
        this.building = b;
    }

    public void addLevelContent(LevelContent l){
        levels.add(l);
    }

    public Building getBiuiding(){
        return building;
    }
    
    public ArrayList<LevelContent> getLevelContent(){
        return levels;
    }
}