package pl.put.poznan.building_info.structures;
import java.util.ArrayList;
import java.util.List;

public class LevelContent{
    private Level level;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public LevelContent(Level l){
        level = l;
    }

    public Level getLevel(){
        return level;
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public void addRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
    }
}