package pl.put.poznan.building_info;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Room;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.structures.Level;

public class LevelTest {
	public static Level level;
	public static Room room;
	public static float value1;
	
	@BeforeAll
	public static void init() {
		level = new Level(0,"Level");
	}
	
	@BeforeEach
	public void reset() {
		value1 = 0;
	}
	
	@Test
	public void addRoomAreaUpgradedTest() {
		value1 = level.getArea();
		room = new Room(1,"Room",2,4,6,8,10);
		level.addRoom(room);
		assertEquals(8,level.getArea()-value1);
	}
	
	@Test
	public void addRoomCubeUpgradedTest() {
		value1 = level.getCube();
		room = new Room(1,"Room",2,4,6,8,10);
		level.addRoom(room);
		assertEquals(48,level.getCube()-value1);
	}
	
	@Test
	public void addRoomPowerUpgradedTest() {
		value1 = level.getLightPower();
		room = new Room(1,"Room",2,4,6,8,10);
		level.addRoom(room);
		assertEquals(10,level.getLightPower()-value1);
	}
	
	@Test
	public void addRoomHeatingUpgradedTest() {
		value1 = level.getHeating();
		room = new Room(1,"Room",2,4,6,8,10);
		level.addRoom(room);
		assertEquals(8,level.getHeating()-value1);
	}
	
	
	
}