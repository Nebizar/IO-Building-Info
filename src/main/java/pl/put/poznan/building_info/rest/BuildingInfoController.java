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
import pl.put.poznan.building_info.structures.Collection;
import pl.put.poznan.building_info.structures.Value;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    BuildingOperations transformer = new BuildingOperations();

    /**
     * Creates and saves building object based on JSON data
     * Creates new, unique ID for each location copied from JSON data
     param newBuilding JSON format building object
     @return JSON response
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
     * param locationId    
     * @return location/locations in JSON format
     */
    @RequestMapping(value = "/building", method = RequestMethod.GET, produces = "application/json")
    public String getEntity(@RequestParam(value = "id", required = false) String locationId) {

        if(locationId != null){
            try
            {
                int i = Integer.parseInt(locationId);
            
                Gson g = new Gson();
                ArrayList<Integer> iArr = new ArrayList<Integer>();
                iArr.add(i);

                Collection location = transformer.getLocationsByIDs(iArr);
                Type type = new TypeToken<Collection>() {}.getType();
                String json = g.toJson(location, type);
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


    /*************          TODO          *************/

    /** PrzykĹ‚ad procedury przyjmujÄ…cej obiekty w formacie JSON (obiekty mogÄ… mieĹ› tylko przydzielone ID)
     * Funkcja powinna zwrĂłciÄ‡ w formacie JSONA informacje o powierzni kaĹĽdego elementu, nie wszystkich razem a kaĹĽdego z osobna)
     * Nie jestem pewny czy funkcja do koĹ„ca dziaĹ‚a - tylko taki przykĹ‚ad 
     * Na bazie tego moĹĽecie budowaÄ‡ kolejne "Buisness value"
     */
    /** 
     * Calculates and shows the area of a room
     * param id- room's id
     * @return area of a room in json format
     */
    @RequestMapping(value = "/roomArea", method = RequestMethod.GET, produces = "application/json")
    public String roomArea(@RequestParam(value = "id", required = true) String roomId) {
         try
            {
                int i = Integer.parseInt(roomId);
            
                Gson g = new Gson();
                 Value power = transformer.getRoomArea(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the area of a level
     * param id- level's id
     * @return area of a level in json format
     */
    @RequestMapping(value = "/levelArea", method = RequestMethod.GET, produces = "application/json")
    public String levelArea(@RequestParam(value = "id", required = true) String levelId) {
         try
            {
                int i = Integer.parseInt(levelId);
            
                Gson g = new Gson();
                 Value power = transformer.getLevelArea(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the area of a building
     * param id- level's id
     * @return area of a building in json format
     */
    @RequestMapping(value = "/buildingArea", method = RequestMethod.GET, produces = "application/json")
    public String buildingArea(@RequestParam(value = "id", required = true) String buildingId) {
         try
            {
                int i = Integer.parseInt(buildingId);
            
                Gson g = new Gson();
                 Value power = transformer.getBuildingArea(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
	

    /** 
     * Calculates and shows the cube of a building
     * param id- building's id
     * @return the cube of a building in json format
     */
    @RequestMapping(value = "/buildingCube", method = RequestMethod.GET, produces = "application/json")
    public String buildingCube(@RequestParam(value = "id", required = true) String buildingId) {

        try
            {
                int i = Integer.parseInt(buildingId);
            
                Gson g = new Gson();

                Value cube = transformer.getBuildingCube(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(cube, type);
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the cube of a level
     * param id- level's id
     * @return the cube of a level in json format
     */
    @RequestMapping(value = "/levelCube", method = RequestMethod.GET, produces = "application/json")
    public String levelCube(@RequestParam(value = "id", required = true) String levelId) {

        try
            {
                int i = Integer.parseInt(levelId);
            
                Gson g = new Gson();

                Value cube = transformer.getLevelCube(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(cube, type);
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the cube of a room
     * param id- room's id
     * @return the cube of a room in json format
     */
    @RequestMapping(value = "/roomCube", method = RequestMethod.GET, produces = "application/json")
    public String roomCube(@RequestParam(value = "id", required = true) String roomId) {

        try
            {
                int i = Integer.parseInt(roomId);
            
                Gson g = new Gson();

                Value cube = transformer.getRoomCube(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(cube, type);
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the power per square meter of a room
     * param id- room's id
     * @return power per square of a room in json format
     */
    @RequestMapping(value = "/roomPowerPerSquare", method = RequestMethod.GET, produces = "application/json")
    public String roomPowerPerSquare(@RequestParam(value = "id", required = true) String roomId) {

        try
            {
                int i = Integer.parseInt(roomId);
            
                Gson g = new Gson();

                Value power = transformer.getRoomPowerPerSquare(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the average power per square meter of a level
     * param id- level's id
     * @return average power per square of a level in json format
     */
    @RequestMapping(value = "/levelPowerPerSquare", method = RequestMethod.GET, produces = "application/json")
    public String levelPowerPerSquare(@RequestParam(value = "id", required = true) String levelId) {

        try
            {
                int i = Integer.parseInt(levelId);
            
                Gson g = new Gson();

                Value power = transformer.getLevelPowerPerSquare(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the average power per square meter of a building
     * param id- level's id
     * @return average power per square of a building in json format
     */
    @RequestMapping(value = "/buildingPowerPerSquare", method = RequestMethod.GET, produces = "application/json")
    public String buildingPowerPerSquare(@RequestParam(value = "id", required = true) String buildingId) {

        try
            {
                int i = Integer.parseInt(buildingId);
            
                Gson g = new Gson();

                Value power = transformer.getBuildingPowerPerSquare(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;

                return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the avarage heating per cube of a room
     * param id- room's id
     * @return avarage heating per cube of a room in json format
     */
    @RequestMapping(value = "/roomHeatingPerCube", method = RequestMethod.GET, produces = "application/json")
    public String roomHeatingPerCube(@RequestParam(value = "id", required = true) String roomId) {
         try
            {
                int i = Integer.parseInt(roomId);
            
                Gson g = new Gson();
                 Value power = transformer.getRoomHeatPerCube(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the avarage heating per cube of a level
     * param id- level's id
     * @return avarage heating per cube of a level in json format
     */
    @RequestMapping(value = "/levelHeatingPerCube", method = RequestMethod.GET, produces = "application/json")
    public String levelHeatingPerCube(@RequestParam(value = "id", required = true) String levelId) {
         try
            {
                int i = Integer.parseInt(levelId);
            
                Gson g = new Gson();
                 Value power = transformer.getLevelHeatPerCube(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the avarage heating per cube of a building
     *param id- level's id
     * @return avarage heating per cube of a building in json format
     */
    @RequestMapping(value = "/buildingHeatingPerCube", method = RequestMethod.GET, produces = "application/json")
    public String buildingHeatingPerCube(@RequestParam(value = "id", required = true) String buildingId) {
         try
            {
                int i = Integer.parseInt(buildingId);
            
                Gson g = new Gson();
                 Value power = transformer.getBuildingHeatPerCube(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the rent of a room
     * param id- room's id
     * @return rent of a room in json format
     */
    @RequestMapping(value = "/roomRent", method = RequestMethod.GET, produces = "application/json")
    public String roomRent(@RequestParam(value = "id", required = true) String roomId) {
         try
            {
                int i = Integer.parseInt(roomId);
            
                Gson g = new Gson();
                 Value power = transformer.getRoomRent(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the rent of a level
     * param id- level's id
     * @return rent of a level in json format
     */
    @RequestMapping(value = "/levelRent", method = RequestMethod.GET, produces = "application/json")
    public String levelRent(@RequestParam(value = "id", required = true) String levelId) {
         try
            {
                int i = Integer.parseInt(levelId);
            
                Gson g = new Gson();
                 Value power = transformer.getLevelRent(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
    
    /** 
     * Calculates and shows the area of a building
     * param id- level's id
     * @return area of a building in json format
     */
    @RequestMapping(value = "/buildingRent", method = RequestMethod.GET, produces = "application/json")
    public String buildingRent(@RequestParam(value = "id", required = true) String buildingId) {
         try
            {
                int i = Integer.parseInt(buildingId);
            
                Gson g = new Gson();
                 Value power = transformer.getBuildingRent(i);
                Type type = new TypeToken<Value>() {}.getType();
                String json = g.toJson(power, type);
                g = null;
                 return json;
            }
            catch (NumberFormatException e)
            {
                Result result = new Result("Invalid data", -1);
                return result.getAsJsonString();
            }
    }
}