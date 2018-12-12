package pl.put.poznan.building_info;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;
import pl.put.poznan.building_info.structures.Collection;
import pl.put.poznan.building_info.structures.Value;
import pl.put.poznan.building_info.info.Result;
import pl.put.poznan.building_info.logic.BuildingOperations;

import java.util.ArrayList;
import java.util.List;

public class BuildingOperationsTest {
	
	public static BuildingOperations bo;
	public static BuildingOperations boMocked;
	public static Value result;
	public static Level levelMock;
	//public static Room roomMock;
	
	@BeforeAll
	public static void initialize() {
		
		
		
		ArrayList<Building> buildingData = new ArrayList<Building>();
		int currentID = 0;
		
        //basic test data creation for building computation
        Building building = new Building(currentID, "Building");
        currentID ++;
        buildingData.add(building);
        
        //Mocking Level object and its methods
        levelMock = mock(Level.class);
    	when(levelMock.getArea()).thenReturn((float)10.0);
    	when(levelMock.getCube()).thenReturn((float)5.0);
    	when(levelMock.getHeating()).thenReturn((float)20.0);
    	when(levelMock.getLightPower()).thenReturn((float)50.0);
    	
    	//Adding 5 same Mocked Level objects
    	for(int i = 0;i < 5;i++) {
    		building.addLevel(levelMock);
    	}
    	
    	//create normal Objects
    	boMocked = new BuildingOperations();
		boMocked.setBuildings(buildingData);
		bo = new BuildingOperations();
            
            /*roomMock = mock(Room.class);
            when(roomMock.getArea()).thenReturn((float)10.0);
        	when(roomMock.getCube()).thenReturn((float)10.0);
        	when(roomMock.getHeating()).thenReturn((float)10.0);
        	when(roomMock.getLightPower()).thenReturn((float)10.0);*/
            //levelMock.addRoom(roomMock);
     
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
    
    @Test
    public void getBuildingAreaTest() {
    	result = boMocked.getBuildingArea(0);
    	verify(levelMock, times(5)).getArea();
    	assertEquals(50, result.getValue());
    }
    
    @Test
    public void getBuildingCubeTest() {
    	result = boMocked.getBuildingCube(0);
    	verify(levelMock, times(5)).getCube();
    	assertEquals(25, result.getValue());
    }
    
    @Test
    public void getBuildingPowerPerSquareTest() {
    	result = boMocked.getBuildingPowerPerSquare(0);
    	verify(levelMock, times(10)).getArea();
    	verify(levelMock, times(5)).getLightPower();
    	assertEquals(5, result.getValue());
    }
    
    @Test
    public void getBuildingHeatPerCubeTest() {
    	result = boMocked.getBuildingHeatPerCube(0);
    	verify(levelMock, times(10)).getCube();
    	verify(levelMock, times(5)).getHeating();
    	assertEquals(4, result.getValue());
    }
    

}