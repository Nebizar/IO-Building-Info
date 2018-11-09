package pl.put.poznan.building_info.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building_info.logic.BuildingOperations;

import java.util.Arrays;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import pl.put.poznan.building_info.structures.Location;
import pl.put.poznan.building_info.structures.Building;
import pl.put.poznan.building_info.info.Result;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    BuildingOperations transformer = new BuildingOperations();

    /**
     * Creates and saves building object based on JSON data
     * Creates new, unique ID for each location copied from JSON data
     * @param newBuilding JSON format building object
     * @return JSON response
     */
    @RequestMapping(value = "/building/new/", method = RequestMethod.POST, produces = "application/json")
    public String createBuilding(@RequestBody String newBuilding) {

        Gson g = new Gson(); 
        Building newBuildingObj = g.fromJson(newBuilding, Building.class);
        Result result = transformer.addBuilding(newBuildingObj);
        g = null;
        return result.getAsJsonString();
    }

    /**
     * searches and shows an element with ID = locationId if locationId is sent
     * show each element if the locationId isn't sent
     * @param locationId    
     * @return location/locations in JSON format
     */
    @RequestMapping(value = "/building", method = RequestMethod.GET, produces = "application/json")
    public String getEntity(@RequestParam(value = "id", required = false) String locationId) {

        if(locationId != null){
            try
            {
                int i = Integer.parseInt(locationId);
            
                Gson g = new Gson();
                

                /**
                 * Type of location is stored in Building operatrions class as last found type
                 * Using stored type allows to show all location informations
                 */
                Location location = transformer.getLocationByID(i);
                String json = g.toJson(location, transformer.getLastFoundType());
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
        }else{
            Gson g = new Gson();
            ArrayList<Building> list = transformer.getBuildings();
            Type type = new TypeToken<ArrayList<Building>>() {}.getType();
            String json = g.toJson(list, type);
            g = null;
            return json;
        }
    }

}