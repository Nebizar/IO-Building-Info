package pl.put.poznan.building_info.structures;
import java.util.ArrayList;
import java.util.List;


public class Collection{
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private ArrayList<Level> levels = new ArrayList<Level>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private int numberOfElements = 0;

    public void insertBuilding(Building n){
        numberOfElements ++;
        buildings.add(n);
    }

    public ArrayList<Building> getBuildings(){
        return buildings;
    }

    public void insertLevel(Level n){
        numberOfElements ++;
        levels.add(n);
    }

    public ArrayList<Level> getLevels(){
        return levels;
    }

    public void insertRoom(Room n){
        numberOfElements ++;
        rooms.add(n);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }
}