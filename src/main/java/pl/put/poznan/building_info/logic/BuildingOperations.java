package pl.put.poznan.building_info.logic;
import java.util.ArrayList;
import java.util.List;
import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;
import pl.put.poznan.building_info.structures.Collection;
import pl.put.poznan.building_info.structures.Value;
import pl.put.poznan.building_info.structures.allLocations;
import pl.put.poznan.building_info.info.Result;
import java.util.Random;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


/**
 * BuildingOperations class contains data of all elements and performs basic operations on them
 */

public class BuildingOperations{

    private ArrayList<Building> buildings = new ArrayList<Building>();
    private allLocations locations = new allLocations();

    /**
     * Each location has own unique ID, 
     * Each new location gets ID = current ID and increase curent ID by 1
     * So locations can't be removed
     */
    private int currentID = 0;


    public BuildingOperations(){
        buildings = createSomeData();
    }
    
    public void setBuildings(ArrayList<Building> arr) {
        buildings = arr;
        
        for(Building b: arr){
            locations.addBuilding(b);
        }
    }
    
    public void setLocations(allLocations param) {
    	locations = param;
    }


    /**
     * Creates new data 
     */
    public ArrayList<Building> createSomeData(){
        Random generator = new Random();
        ArrayList<Building> buildingCreator = new ArrayList<Building>();

        for(int k = 0; k < 2; k++){
            Building building = new Building(currentID, "Building");
            currentID ++;
            locations.addBuilding(building);
            buildingCreator.add(building);
            for(int z = 0; z < 4; z++){
                Level level = new Level(currentID, "Level");
                currentID ++;
                for(int i = 0; i < 6; i++){
                    Room room = new Room(currentID, "Room", generator.nextFloat() * 10, generator.nextFloat() * 5, generator.nextFloat() * 2, generator.nextFloat() * 200, generator.nextFloat() * 500, generator.nextFloat() * 750);
                    currentID ++;
                    level.addRoom(room);
                }
                building.addLevel(level);
            } 
        }

        generator = null;
        return buildingCreator;
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
        locations.addBuilding(newBuilding);
        return new Result(Integer.toString(currentID - baseID) + " locations created", 0);
    }

    public ArrayList<Building> getBuildings(){
        return buildings;
    }

//Find locations specified by IDs

    public Collection getLocationsByIDs(ArrayList<Integer> IDs){
        Collection found = new Collection();

        ArrayList<Location> collected = locations.getEntitiesByIDs(IDs);
        for(Location c:collected){
            if(c.isBuilding()){
                found.insertBuilding((Building) c);
            }
            if(c.isLevel()){
                found.insertLevel((Level) c);
            }
            if(c.isRoom()){
                found.insertRoom((Room) c);
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

    public Building findBuildingByID(int id) {
    	for(Building building: buildings) {
    		if(building.getID()==id) {
    			return building;
    		}
    	}
    	Building error=new Building(-1,"Error");
        return error;
    }

//Find a level by id visible for user or a special error level

    public Level findLevelByID(int id) {
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

    public Room findRoomByID(int id) {
    	for(Building building: buildings) {
    		for(Level level: building.getLevels()) {
    			for(Room room: level.getRooms()) {
		    		if(room.getID()==id) {
		    			return room;
		    		}
    			}
    		}
    	}
    	Room error=new Room(-1,"Error",0,0,0,0,0,0);
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
        Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isBuilding()){
                value=new Value("BuildingArea", id, found.getArea());
            }else{
                value=new Value("ERROR! That is not a building ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the total area of a level with an id passed as a parameter

    public Value getLevelArea(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isLevel()){
                value=new Value("LevelArea", id, found.getArea());
            }else{
                value=new Value("ERROR! That is not a Level ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the total cube of a room with an id passed as a parameter

    public Value getRoomArea(Integer id){
        Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isRoom()){
                value=new Value("RoomArea", id, found.getArea());
            }else{
                value=new Value("ERROR! That is not a Room ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the total cube of a building with an id passed as a parameter

    public Value getBuildingCube(Integer id){
        
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isBuilding()){
                value=new Value("BuildingCube", id, found.getCube());
            }else{
                value=new Value("ERROR! That is not a building ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the total cube of a level with an id passed as a parameter

    public Value getLevelCube(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isLevel()){
                value=new Value("LevelCube", id, found.getCube());
            }else{
                value=new Value("ERROR! That is not a Level ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the total cube of a room with an id passed as a parameter

    public Value getRoomCube(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isRoom()){
                value=new Value("RoomCube", id, found.getCube());
            }else{
                value=new Value("ERROR! That is not a Room ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the power per square meter of a room with an id passed as a parameter

    public Value getRoomPowerPerSquare(Integer id){
        Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isRoom()){
                value=new Value("RoomPowerPerSquare", id, found.getLightPower()/found.getArea());
            }else{
                value=new Value("ERROR! That is not a Room ID!", id, -1);
            }
        }
        return value;
    }
    
//Calculate the average power per square meter of a level with an id passed as a parameter

    public Value getLevelPowerPerSquare(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isLevel()){
                value=new Value("LevelPowerPerSquare", id, found.getLightPower()/found.getArea());
            }else{
                value=new Value("ERROR! That is not a Level ID!", id, -1);
            }
        }
        return value;
    }
    
// Calculate the average power per square meter of a building with an id passed as a parameter

    public Value getBuildingPowerPerSquare(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isBuilding()){
                value=new Value("BuildingPowerPerSquare", id, found.getLightPower()/found.getArea());
            }else{
                value=new Value("ERROR! That is not a Building ID!", id, -1);
            }
        }
        return value;
    }
    
// Calculate the avarage heating per cube of a room with an id passed as a parameter

    public Value getRoomHeatPerCube(Integer id){
        Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isRoom()){
                value=new Value("RoomHeatPerCube", id, found.getHeating()/found.getCube());
            }else{
                value=new Value("ERROR! That is not a Room ID!", id, -1);
            }
        }
        return value;
    }
    
     //Calculate the average heating per cube of a level with an id passed as a parameter

    public Value getLevelHeatPerCube(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isLevel()){
                value=new Value("LevelHeatPerCube", id, found.getHeating()/found.getCube());
            }else{
                value=new Value("ERROR! That is not a Level ID!", id, -1);
            }
        }
        return value;
    }
    

     //Calculate the average heating per cube meter of a building with an id passed as a parameter

    public Value getBuildingHeatPerCube(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isBuilding()){
                value=new Value("BuildingHeatPerCube", id, found.getHeating()/found.getCube());
            }else{
                value=new Value("ERROR! That is not a Building ID!", id, -1);
            }
        }
        return value;
    }
    
  //Calculate the total rent of a building with an id passed as a parameter

    public Value getBuildingRent(Integer id){
        Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isBuilding()){
                value=new Value("BuildingRent", id, found.getRent());
            }else{
                value=new Value("ERROR! That is not a Building ID!", id, -1);
            }
        }
        return value;
    }
    
  //Calculate the total rent of a level with an id passed as a parameter

    public Value getLevelRent(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isLevel()){
                value=new Value("LevelRent", id, found.getRent());
            }else{
                value=new Value("ERROR! That is not a Level ID!", id, -1);
            }
        }
        return value;
    }
    
  //Calculate the total rent of a room with an id passed as a parameter

    public Value getRoomRent(Integer id){
    	Location found = locations.getEntityByID(id);
        Value value;
        if(found == null){
            value=new Value("ERROR! Can't find ID", id, -1);		
        }else{
            if(found.isRoom()){
                value=new Value("RoomRent", id, found.getRent());
            }else{
                value=new Value("ERROR! That is not a Room ID!", id, -1);
            }
        }
        return value;
    }
    
    //Add all rooms with rent that is greater than the threshold passed as a parameter in a building with the ID passed as a parameter
    
    public ArrayList<Location> getRoomsWithRentThreshold(Integer id, float threshold){
        Location found = locations.getEntityByID(id);
        Value value;
        ArrayList<Location> roomsWithRent=new ArrayList<>();
        if(found == null){
        	roomsWithRent.add(new Building(id,"ERROR! Can't find ID"));		
        }else{
            if(found.isBuilding()){
            	Building building=(Building) found;
                ArrayList<Level> levels=building.getLevels();
                for(Level l: levels) {
                	ArrayList<Room>rooms=l.getRooms();
                	for(Room r: rooms) {
                		if(r.getRent()>threshold) {
                			roomsWithRent.add(r);
                		}
                	}
                }
                if(roomsWithRent.size()==0) {
                	roomsWithRent.add(new Building(id,"There are no rooms with rent over that threshold in the Building with that ID!"));
                }
            }else{
                roomsWithRent.add(new Building(id,"ERROR! That is not a Building ID!"));
            }
        }
        return roomsWithRent;
    }
}
