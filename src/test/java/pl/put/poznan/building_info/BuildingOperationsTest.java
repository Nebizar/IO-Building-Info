package pl.put.poznan.building_info;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;
import pl.put.poznan.building_info.structures.Value;
import pl.put.poznan.building_info.structures.allLocations;
import pl.put.poznan.building_info.logic.BuildingOperations;

public class BuildingOperationsTest {
	
	public static BuildingOperations bo;
	public static BuildingOperations boMocked;
	public static BuildingOperations boMocked2;
	public static BuildingOperations boMocked3;
	public static Value result;
	public static allLocations allLocationsMock;
	public static allLocations allLocationsMockLevel;
	public static allLocations allLocationsMockRoom;
	public static Location locationMock;
	public static Location locationMockLevel;
	public static Location locationMockRoom;
	
	
	@BeforeAll
	public static void initialize() {
		
		bo = new BuildingOperations();
		boMocked = new BuildingOperations();
		boMocked2 = new BuildingOperations();
		boMocked3 = new BuildingOperations();
		//Building Mock
		locationMock = mock(Location.class);
		when(locationMock.isBuilding()).thenReturn(true);
		when(locationMock.getArea()).thenReturn((float)5.0);
		when(locationMock.getCube()).thenReturn((float)10.0);
		when(locationMock.getRent()).thenReturn((float)15.0);
		when(locationMock.getLightPower()).thenReturn((float)20.0);
		when(locationMock.getHeating()).thenReturn((float)25.0);
		
		allLocationsMock = mock(allLocations.class);
		when(allLocationsMock.getEntityByID(0)).thenReturn(locationMock);
		boMocked.setLocations(allLocationsMock);
		//Level Mock
		locationMockLevel = mock(Location.class);
		when(locationMockLevel.isLevel()).thenReturn(true);
		when(locationMockLevel.getArea()).thenReturn((float)5.0);
		when(locationMockLevel.getCube()).thenReturn((float)10.0);
		when(locationMockLevel.getRent()).thenReturn((float)15.0);
		when(locationMockLevel.getLightPower()).thenReturn((float)20.0);
		when(locationMockLevel.getHeating()).thenReturn((float)25.0);
		
		allLocationsMockLevel = mock(allLocations.class);
		when(allLocationsMockLevel.getEntityByID(1)).thenReturn(locationMockLevel);
		boMocked2.setLocations(allLocationsMockLevel);
		//Room Mock
		locationMockRoom = mock(Location.class);
		when(locationMockRoom.isRoom()).thenReturn(true);
		when(locationMockRoom.getArea()).thenReturn((float)5.0);
		when(locationMockRoom.getCube()).thenReturn((float)10.0);
		when(locationMockRoom.getRent()).thenReturn((float)15.0);
		when(locationMockRoom.getLightPower()).thenReturn((float)20.0);
		when(locationMockRoom.getHeating()).thenReturn((float)25.0);
		
		allLocationsMockRoom = mock(allLocations.class);
		when(allLocationsMockRoom.getEntityByID(2)).thenReturn(locationMockRoom);
		boMocked3.setLocations(allLocationsMockRoom);
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
    	verify(locationMock, times(1)).getArea();
    	assertEquals(5, result.getValue());
    }
    
    @Test
    public void getLevelAreaTest() {
    	result = boMocked2.getLevelArea(1);
    	verify(locationMockLevel, times(1)).getArea();
    	assertEquals(5, result.getValue());
    }
    
    @Test
    public void getRoomAreaTest() {
    	result = boMocked3.getRoomArea(2);
    	verify(locationMockRoom, times(2)).getArea();
    	assertEquals(5, result.getValue());
    }
    //END AREA TESTS
    //CUBE TESTS
    @Test
    public void getBuildingCubeTest() {
        
    	result = boMocked.getBuildingCube(0);
    	verify(locationMock, times(1)).getCube();
    	assertEquals(10, result.getValue());
    }
    
    @Test
    public void getLevelCubeTest() {
    	result = boMocked2.getLevelCube(1);
    	verify(locationMockLevel, times(1)).getCube();
    	assertEquals(10, result.getValue());
    }
    
    @Test
    public void getRoomCubeTest() {
    	result = boMocked3.getRoomCube(2);
    	verify(locationMockRoom, times(2)).getCube();
    	assertEquals(10, result.getValue());
    }
    //END CUBE TESTS
    //RENT TESTS
    @Test
    public void getBuildingRentTest() {
    	result = boMocked.getBuildingRent(0);
    	verify(locationMock, times(1)).getRent();
    	assertEquals(15, result.getValue());
    }
    
    @Test
    public void getLevelRentTest() {
    	result = boMocked2.getLevelRent(1);
    	verify(locationMockLevel, times(1)).getRent();
    	assertEquals(15, result.getValue());
    }
    
    @Test
    public void getRoomRentTest() {
    	result = boMocked3.getRoomRent(2);
    	verify(locationMockRoom, times(1)).getRent();
    	assertEquals(15, result.getValue());
    }
    //END RENT TESTS
    //POWER TESTS
    @Test
    public void getBuildingPowerPerSquareTest() {
    	result = boMocked.getBuildingPowerPerSquare(0);
    	verify(locationMock, times(2)).getArea();
    	verify(locationMock, times(1)).getLightPower();
    	assertEquals(4, result.getValue());
    }
    
    @Test
    public void getLevelPowerPerSquareTest() {
    	result = boMocked2.getLevelPowerPerSquare(1);
    	verify(locationMockLevel, times(2)).getArea();
    	verify(locationMockLevel, times(1)).getLightPower();
    	assertEquals(4, result.getValue());
    }
    
    @Test
    public void getRoomPowerPerSquareTest() {
    	result = boMocked3.getRoomPowerPerSquare(2);
    	verify(locationMockRoom, times(1)).getArea();
    	verify(locationMockRoom, times(1)).getLightPower();
    	assertEquals(4, result.getValue());
    }
    //END POWER TESTS
    //HEAT TESTS
    @Test
    public void getBuildingHeatPerCubeTest() {
    	result = boMocked.getBuildingHeatPerCube(0);
    	verify(locationMock, times(2)).getCube();
    	verify(locationMock, times(1)).getHeating();
    	assertEquals(2.5, result.getValue());
    }
    
    @Test
    public void getLevelHeatPerCubeTest() {
    	result = boMocked2.getLevelHeatPerCube(1);
    	verify(locationMockLevel, times(2)).getCube();
    	verify(locationMockLevel, times(1)).getHeating();
    	assertEquals(2.5, result.getValue());
    }
    
    @Test
    public void getRoomHeatPerCubeTest() {
    	result = boMocked3.getRoomHeatPerCube(2);
    	verify(locationMockRoom, times(1)).getCube();
    	verify(locationMockRoom, times(1)).getHeating();
    	assertEquals(2.5, result.getValue());
    }
    //END HEAT TESTS
}