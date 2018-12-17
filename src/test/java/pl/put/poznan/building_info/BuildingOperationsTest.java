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
	public static BuildingOperations boMockedRooms;
	public static Value result;
	public static Level levelMock;
	public static Room roomMock;
	
	@BeforeAll
	public static void initialize() {
		ArrayList<Building> buildingData = new ArrayList<Building>();
		ArrayList<Building> buildingDataRoom = new ArrayList<Building>();
		
		//Mocking Level object and its methods
        levelMock = mock(Level.class);
    	when(levelMock.getArea()).thenReturn((float)10.0);
    	when(levelMock.getCube()).thenReturn((float)5.0);
    	when(levelMock.getHeating()).thenReturn((float)20.0);
    	when(levelMock.getLightPower()).thenReturn((float)50.0);
    	when(levelMock.getRent()).thenReturn((float)100.0);
    	//Mocking room object and its methods
    	roomMock = mock(Room.class);
        when(roomMock.getArea()).thenReturn((float)5.0);
        when(roomMock.getCube()).thenReturn((float)10.0);
        when(roomMock.getHeating()).thenReturn((float)15.0);
        when(roomMock.getLightPower()).thenReturn((float)20.0);
        when(roomMock.getRent()).thenReturn((float)25.0);
        when(roomMock.getID()).thenReturn(3);
		
		int currentID = 0;
		
        //basic test data creation for building computation
        Building building = new Building(currentID, "Building");
        currentID ++;
        buildingData.add(building);
    	//Adding 5 same Mocked Level objects
    	for(int i = 0;i < 5;i++) {
    		building.addLevel(levelMock);
    	}
    	//create normal Objects
    	boMocked = new BuildingOperations();
		boMocked.setBuildings(buildingData);
		//END #1 Object
		
		currentID = 0;
		//Second BuildingOperations Object -> mocked Room objects
        Building building2 = new Building(currentID, "Building");
        currentID ++;
        buildingDataRoom.add(building2);
        //new level
        Level level = new Level(currentID, "Level");
        currentID ++;
        //new mockRoom
        for(int a = 0; a < 3; a++){
        	level.addRoom(roomMock);
        }
        building2.addLevel(level); 
		boMockedRooms = new BuildingOperations();
		boMockedRooms.setBuildings(buildingDataRoom);
        //END #2 Object
		
        bo = new BuildingOperations();
	}
	//FIND BY ID TESTS
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
    //END ID TESTS
    //AREA TESTS
    @Test
    public void getBuildingAreaTest() {
    	result = boMocked.getBuildingArea(0);
    	verify(levelMock, times(5)).getArea();
    	assertEquals(50, result.getValue());
    }
    
    @Test
    public void getLevelAreaTest() {
    	result = boMockedRooms.getLevelArea(1);
    	verify(roomMock, times(3)).getArea();
    	assertEquals(15, result.getValue());
    }
    
    @Test
    public void getRoomAreaTest() {
    	result = boMockedRooms.getRoomArea(3);
    	verify(roomMock, times(5)).getArea();
    	assertEquals(5, result.getValue());
    }
    //END AREA TESTS
    //CUBE TESTS
    @Test
    public void getBuildingCubeTest() {
    	result = boMocked.getBuildingCube(0);
    	verify(levelMock, times(5)).getCube();
    	assertEquals(25, result.getValue());
    }
    
    @Test
    public void getLevelCubeTest() {
    	result = boMockedRooms.getLevelCube(1);
    	verify(roomMock, times(3)).getCube();
    	assertEquals(30, result.getValue());
    }
    
    @Test
    public void getRoomCubeTest() {
    	result = boMockedRooms.getRoomCube(3);
    	verify(roomMock, times(5)).getCube();
    	assertEquals(10, result.getValue());
    }
    //END CUBE TESTS
    //RENT TESTS
    @Test
    public void getBuildingRentTest() {
    	result = boMocked.getBuildingRent(0);
    	verify(levelMock, times(5)).getRent();
    	assertEquals(500, result.getValue());
    }
    
    @Test
    public void getLevelRentTest() {
    	result = boMockedRooms.getLevelRent(1);
    	verify(roomMock, times(3)).getRent();
    	assertEquals(75, result.getValue());
    }
    
    @Test
    public void getRoomRentTest() {
    	result = boMockedRooms.getRoomRent(3);
    	verify(roomMock, times(4)).getRent();
    	assertEquals(25, result.getValue());
    }
    //END RENT TESTS
    //POWER TESTS
    @Test
    public void getBuildingPowerPerSquareTest() {
    	result = boMocked.getBuildingPowerPerSquare(0);
    	verify(levelMock, times(10)).getArea();
    	verify(levelMock, times(5)).getLightPower();
    	assertEquals(5, result.getValue());
    }
    
    @Test
    public void getLevelPowerPerSquareTest() {
    	result = boMockedRooms.getLevelPowerPerSquare(1);
    	verify(roomMock, times(5)).getArea();
    	verify(roomMock, times(4)).getLightPower();
    	assertEquals(4, result.getValue());
    }
    
    @Test
    public void getRoomPowerPerSquareTest() {
    	result = boMockedRooms.getRoomPowerPerSquare(3);
    	verify(roomMock, times(4)).getArea();
    	verify(roomMock, times(4)).getLightPower();
    	assertEquals(4, result.getValue());
    }
    //END POWER TESTS
    //HEAT TESTS
    @Test
    public void getBuildingHeatPerCubeTest() {
    	result = boMocked.getBuildingHeatPerCube(0);
    	verify(levelMock, times(10)).getCube();
    	verify(levelMock, times(5)).getHeating();
    	assertEquals(4, result.getValue());
    }
    
    @Test
    public void getLevelHeatPerCubeTest() {
    	result = boMockedRooms.getLevelHeatPerCube(1);
    	verify(roomMock, times(3)).getCube();
    	verify(roomMock, times(3)).getHeating();
    	assertEquals(1.5, result.getValue());
    }
    
    @Test
    public void getRoomHeatPerCubeTest() {
    	result = boMockedRooms.getRoomHeatPerCube(3);
    	verify(roomMock, times(4)).getCube();
    	verify(roomMock, times(4)).getHeating();
    	assertEquals(1.5, result.getValue());
    }
    //END HEAT TESTS
}