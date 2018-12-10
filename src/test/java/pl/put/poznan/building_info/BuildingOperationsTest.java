package pl.put.poznan.building_info;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;
import pl.put.poznan.building_info.structures.Collection;
import pl.put.poznan.building_info.structures.Value;
import pl.put.poznan.building_info.info.Result;
import pl.put.poznan.building_info.logic.BuildingOperations;

public class BuildingOperationsTest {
	
	public static BuildingOperations bo;
	
	@BeforeAll
	public static void initialize() {
		bo = new BuildingOperations();
	}

    @Test
    public void findBuildingByIDGoodTest() {
    	Building result = bo.findBuildingByID(0);
        assertEquals(0, result.getID());
        assertEquals("Building", result.getName());
    }
    
    @Test
    public void findBuildingByIDBadTest() {
    	Building result = bo.findBuildingByID(148);
        assertEquals(-1, result.getID());
        assertEquals("Error", result.getName());
    }
    
    @Test
    public void findLevelByIDGoodTest() {
    	Level result = bo.findLevelByID(1);
        assertEquals(1, result.getID());
        assertEquals("Level", result.getName());
    }
    
    @Test
    public void findLevelByIDBadTest() {
    	Level result = bo.findLevelByID(123);
        assertEquals(-1, result.getID());
        assertEquals("Error", result.getName());
    }
    
    @Test
    public void findRoomByIDGoodTest() {
    	Room result = bo.findRoomByID(10);
        assertEquals(10, result.getID());
        assertEquals("Room", result.getName());
    }
    
    @Test
    public void findRoomByIDBadTest() {
    	Room result = bo.findRoomByID(254);
        assertEquals(-1, result.getID());
        assertEquals("Error", result.getName());
    }
    
    

}