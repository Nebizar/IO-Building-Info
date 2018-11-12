package pl.put.poznan.building_info.logic;
import java.util.ArrayList;
import java.util.List;
import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;
import pl.put.poznan.building_info.structures.Collection;
import pl.put.poznan.building_info.structures.Value;
import pl.put.poznan.building_info.info.Result;
import java.util.Random;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


/**
 * BuildingOperations class contains data of all elements and performs basic operations on them
 */

public class BuildingOperations{

    private ArrayList<Building> buildings = new ArrayList<Building>();

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
     * Find locations specified by IDs
     * @param IDs
     * @return Collection of elements of specified IDs
     */
    public Collection getLocationsByIDs(ArrayList<Integer> IDs){
        Collection found = new Collection();

        for (Building building : buildings){
            if(contains(IDs, building.getID())){
                found.insertBuilding(building);
            }

            for (Level level : building.getLevels()) {
                if(contains(IDs, level.getID())){
                    found.insertLevel(level);
                }
    
                for (Room room : level.getRooms()) {
                    if(contains(IDs, room.getID())){
                        found.insertRoom(room);
                    }
                }
            }
        }
        

        return found;
    }

    /**
     * Check if the value is in the array
     * @param array
     * @param val
     * @return
     */
    public boolean contains(ArrayList<Integer> array, int val){

        for(int k: array){
            if(k == val){
                return true;
            }
        }

        return false;
    }

    public ArrayList<Integer> getElementsIDs(Collection cl){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(Location location: cl.getBuildings()){
            result.add(location.getID());
        }
        for(Location location: cl.getLevels()){
            result.add(location.getID());
        }
        for(Location location: cl.getRooms()){
            result.add(location.getID());
        }

        return result;
    }
    
    /**
     *Find a building by id visible for user or a special error building
     *@param id- id of the building to search for
     *@return building with the id specified in the params 
    */
    private Building findBuildingByID(int id) {
    	for(Building building: buildings) {
    		if(building.getID()==id) {
    			return building;
    		}
    	}
    	Building error=new Building(-1,"Error");
    	return error;
    }

    /**
     *Find a level by id visible for user or a special error level
     *@param id- id of the level to search for
     *@return level with the id specified in the params 
    */
    private Level findLevelByID(int id) {
    	for(Building building: buildings) {
    		for(Level level: building.getLevels()) {
	    		if(level.getID()==id) {
	    			return level;
	    		}
    		}
    	}
    	Level error=new Level(-1,"Error");
    	return error;
    }
    
    /**
     *Find a room by id visible for user or a special error room
     *@param id- id of the room to search for
     *@return room with the id specified in the params 
    */
    private Room findRoomByID(int id) {
    	for(Building building: buildings) {
    		for(Level level: building.getLevels()) {
    			for(Room room: level.getRooms()) {
		    		if(room.getID()==id) {
		    			return room;
		    		}
    			}
    		}
    	}
    	Room error=new Room(-1,"Error",0,0,0,0);
    	return error;
    }

    /*************          TODO          *************/
    /** 
     * Przykład funkcji przyjmującej kolekcje obiektóe
     * Powinna zwrócić łączną powierzchnię dla każdego obiektu w kolekcji
     * Nie wiem do końca w jaką klasę zamknąć wynik bo trzeba to zwrócić jako JSON
    */
    public Collection getTotalArea(Collection collection){

        return collection;
    }
    
    /** 
     * Calculate the total cube of a building with an id passed as a parameter
     * @param id 
     * @retrun value- class containing information about building cube
    */
    public Value getBuildingCube(Integer id){
    	float cube=0;
    	Building building=findBuildingByID(id);
    	if(building.getID()==-1){
    		Value value=new Value("ERROR! That is not a building ID!",id,-1);
    		return value;
    	}
        for (Level level : building.getLevels()) {
    
             for (Room room : level.getRooms()) {
            	 cube+=room.getCube();
             }
        }
        Value value=new Value("BuildingCube",id,cube);
        return value;
    }
}
