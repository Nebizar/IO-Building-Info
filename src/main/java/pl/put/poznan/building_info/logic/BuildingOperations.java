package pl.put.poznan.building_info.logic;
import java.util.ArrayList;
import java.util.List;
import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;
import pl.put.poznan.building_info.info.Result;
import java.util.Random;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * BuildingOperations class contains data of all elements and performs basic operations on them
 */

public class BuildingOperations{

    private ArrayList<Building> buildings = new ArrayList<Building>();

    private Type lastFoundType = null;

    /**
     * Each location has own unique ID, 
     * Each new location gets ID = current ID and increase curent ID by 1
     * So locations can't be removed
     */
    private int currentID = 0;


    public BuildingOperations(){
        createSomeData();
    }


    /**
     * Creates new data 
     */
    public void createSomeData(){
        Random generator = new Random();

        for(int k = 0; k < 2; k++){
            Building building = new Building(currentID, "Building");
            currentID ++;
            buildings.add(building);
            for(int z = 0; z < 4; z++){
                Level level = new Level(currentID, "Level");
                currentID ++;
                for(int i = 0; i < 6; i++){
                    Room room = new Room(currentID, "Room", generator.nextFloat() * 50, generator.nextFloat() * 100, generator.nextFloat() * 200, generator.nextFloat() * 500);
                    currentID ++;
                    level.addRoom(room);
                }
                building.addLevel(level);
            } 
        }

        generator = null;
    }

    /**
     * Change new building elements ID's and add building to existing data structures
     * @param newBuilding 
     * @return Result class response
     */
    public Result addBuilding(Building newBuilding){
        int baseID = currentID;

        newBuilding.setID(currentID);
        currentID ++;

        for (Level level : newBuilding.getLevels()) {
            level.setID(currentID);
            currentID ++;

            for (Room room : level.getRooms()) {
                room.setID(currentID);
                currentID ++;   
            }
        }

        buildings.add(newBuilding);
        return new Result(Integer.toString(currentID - baseID) + " locations created", 0);
    }

    public ArrayList<Building> getBuildings(){
        return buildings;
    }

    /**
     * Find location specified by ID
     * Store type of found location
     * @param ID
     * @return found location element or null if location not found
     */
    public Location getLocationByID(int ID){
        if(ID >= currentID){
            return null;
        }

        for (Building building : buildings){
            if(building.getID() == ID){
                lastFoundType = new TypeToken<Building>() {}.getType();
                return building;
            }

            for (Level level : building.getLevels()) {
                if(level.getID() == ID){
                    lastFoundType = new TypeToken<Level>() {}.getType();
                    return level;
                }
    
                for (Room room : level.getRooms()) {
                    if(room.getID() == ID){
                        lastFoundType = new TypeToken<Room>() {}.getType();
                        return room;
                    }
                }
            }
        }
        

        return null;
    }

    public Type getLastFoundType(){
        return lastFoundType;
    }
}
