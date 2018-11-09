package pl.put.poznan.building_info.structures;
import java.util.ArrayList;
import java.util.List;

public class Level extends Location{

    private ArrayList<Room> rooms = new ArrayList<Room>();
    
    public Level(int id, String name){
        super(id, name);
    }

    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }
    
}