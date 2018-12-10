package pl.put.poznan.building_info;

import org.junit.jupiter.api.Test;
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

    @Test
    public void findBuildingByIDTest() {
    	BuildingOperations bo = new BuildingOperations();
    	Building result = bo.findBuildingByID(0);
        assertEquals(0, result.getID());
    }

}