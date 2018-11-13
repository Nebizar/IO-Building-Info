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
                    Room room = new Room(currentID, "Room", generator.nextFloat() * 10, generator.nextFloat() * 5, generator.nextFloat() * 2, generator.nextFloat() * 200, generator.nextFloat() * 500);
                    currentID ++;
                    level.addRoom(room);
                }
                building.addLevel(level);
            } 
        }

        generator = null;
    }

//Change new building elements ID's and add building to existing data structures

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

//Find locations specified by IDs

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

//Check if the value is in the array

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
    
//Find a building by id visible for user or a special error building

    private Building findBuildingByID(int id) {
    	for(Building building: buildings) {
    		if(building.getID()==id) {
    			return building;
    		}
    	}
    	Building error=new Building(-1,"Error");
    	return error;
    }

//Find a level by id visible for user or a special error level

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
    
//Find a room by id visible for user or a special error room

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
    	Room error=new Room(-1,"Error",0,0,0,0,0);
    	return error;
    }

    /*************          TODO          *************/
    /** 
     * PrzykĹ‚ad funkcji przyjmujÄ…cej kolekcje obiektĂłe
     * Powinna zwrĂłciÄ‡ Ĺ‚Ä…cznÄ… powierzchniÄ™ dla kaĹĽdego obiektu w kolekcji
     * Nie wiem do koĹ„ca w jakÄ… klasÄ™ zamknÄ…Ä‡ wynik bo trzeba to zwrĂłciÄ‡ jako JSON
    */
//Calculate the total area of a building with an id passed as a parameter

    public Value getBuildingArea(Integer id){
    	float area=0;
    	
    	Building building=findBuildingByID(id);
    	if(building.getID()==-1){
    		Value value=new Value("ERROR! That is not a building ID!",id,-1);
    		return value;
    	}
    	
        for (Level level : building.getLevels()) {
    
             for (Room room : level.getRooms()) {
            	 area += room.getArea();
             }
        }
        Value value=new Value("BuildingArea",id,area);
        return value;
    }
    
//Calculate the total area of a level with an id passed as a parameter

    public Value getLevelArea(Integer id){
    	float area=0;
    	
    	Level level=findLevelByID(id);
    	if(level.getID()==-1){
    		Value value=new Value("ERROR! That is not a level ID!",id,-1);
    		return value;
    	}
    	
        for (Room room : level.getRooms()) {
        	area+=room.getArea();
        }
        Value value=new Value("LevelArea",id,area);
        return value;
    }
    
//Calculate the total cube of a room with an id passed as a parameter

    public Value getRoomArea(Integer id){
    	Room room=findRoomByID(id);
    	if(room.getID()==-1){
    		Value value=new Value("ERROR! That is not a room ID!",id,-1);
    		return value;
    	}
        else{
            float area=room.getArea();
            Value value=new Value("RoomArea",id,area);
            return value;
        }
    }
    
//Calculate the total cube of a building with an id passed as a parameter

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
    
//Calculate the total cube of a level with an id passed as a parameter

    public Value getLevelCube(Integer id){
    	float cube=0;
    	
    	Level level=findLevelByID(id);
    	if(level.getID()==-1){
    		Value value=new Value("ERROR! That is not a level ID!",id,-1);
    		return value;
    	}
    	
        for (Room room : level.getRooms()) {
        	cube+=room.getCube();
        }
        Value value=new Value("LevelCube",id,cube);
        return value;
    }
    
//Calculate the total cube of a room with an id passed as a parameter

    public Value getRoomCube(Integer id){
    	float cube=0;
    	
    	Room room=findRoomByID(id);
    	if(room.getID()==-1){
    		Value value=new Value("ERROR! That is not a room ID!",id,-1);
    		return value;
    	}
    	
        cube=room.getCube();
        Value value=new Value("RoomCube",id,cube);
        return value;
    }
    
//Calculate the power per square meter of a room with an id passed as a parameter

    public Value getRoomPowerPerSquare(Integer id){
    	float powerPerSquare=0;
    	
    	Room room=findRoomByID(id);
    	if(room.getID()==-1){
    		Value value=new Value("ERROR! That is not a room ID!",id,-1);
    		return value;
    	}
    	
        powerPerSquare=room.getLightPower()/room.getArea();
        Value value=new Value("RoomPowerPerSquare",id,powerPerSquare);
        return value;
    }
    
//Calculate the average power per square meter of a level with an id passed as a parameter

    public Value getLevelPowerPerSquare(Integer id){
    	float powerPerSquare=0;
    	float power=0;
    	int count=0;
    	float val=0;
    	
    	Level level=findLevelByID(id);
    	if(level.getID()==-1){
    		Value value=new Value("ERROR! That is not a level ID!",id,-1);
    		return value;
    	}
    	
        for (Room room : level.getRooms()) {
        	val=room.getLightPower()/room.getArea();
        	power+=val;
        	count++;
        }
        
        powerPerSquare=power/count;
        Value value=new Value("LevelPowerPerSquare",id,powerPerSquare);
        return value;
    }
    
// Calculate the average power per square meter of a building with an id passed as a parameter

    public Value getBuildingPowerPerSquare(Integer id){
    	float powerPerSquare=0;
    	float power=0;
    	int count=0;
    	int levelCount=0;
    	float val=0;
    	float powerPerLevel=0;
    	
    	Building building=findBuildingByID(id);
    	if(building.getID()==-1){
    		Value value=new Value("ERROR! That is not a building ID!",id,-1);
    		return value;
    	}
    	
        for (Level level : building.getLevels()) {
    
             for (Room room : level.getRooms()) {
             	val=room.getLightPower()/room.getArea();
            	power+=val;
            	count++;
             }
             powerPerLevel=power/count;
             levelCount++;
             power=0;
             count=0;
        }
        
        powerPerSquare=powerPerLevel/levelCount;
        Value value=new Value("BuildingPowerPerSquare",id,powerPerSquare);
        return value;
    }
    
// Calculate the avarage heating per cube of a room with an id passed as a parameter

    public Value getRoomHeatPerCube(Integer id){
    	Room room=findRoomByID(id);
    	if(room.getID()==-1){
    		Value value=new Value("ERROR! That is not a room ID!",id,-1);
    		return value;
    	}
    	
        float heatPerCube=room.getHeating()/room.getCube();
        Value value=new Value("RoomHeatPerCube",id,heatPerCube);
        return value;
    }
    
     //Calculate the average heating per cube of a level with an id passed as a parameter

    public Value getLevelHeatPerCube(Integer id){
    	float heatPerCube=0;
    	float heating=0;
    	int count=0;
    	float val=0;
    	
    	Level level=findLevelByID(id);
    	if(level.getID()==-1){
    		Value value=new Value("ERROR! That is not a level ID!",id,-1);
    		return value;
    	}
    	
        for (Room room : level.getRooms()) {
        	val=room.getHeating()/room.getCube();
        	heating+=val;
        	count++;
        }
        
        heatPerCube=heating/count;
        Value value=new Value("LevelHeatPerCube",id,heatPerCube);
        return value;
    }
    

     //Calculate the average heating per cube meter of a building with an id passed as a parameter

    public Value getBuildingHeatPerCube(Integer id){
    	float heatPerCube=0;
    	float heating=0;
    	int count=0;
    	int levelCount=0;
    	float val=0;
    	float heatPerLevel=0;
    	
    	Building building=findBuildingByID(id);
    	if(building.getID()==-1){
    		Value value=new Value("ERROR! That is not a building ID!",id,-1);
    		return value;
    	}
    	
        for (Level level : building.getLevels()) {
    
             for (Room room : level.getRooms()) {
             	val=room.getHeating()/room.getCube();
            	heating+=val;
            	count++;
             }
             heatPerLevel=heating/count;
             levelCount++;
             heating=0;
             count=0;
        }
        
        heatPerCube=heatPerLevel/levelCount;
        Value value=new Value("BuildingHeatPerCube",id,heatPerCube);
        return value;
    }
}
