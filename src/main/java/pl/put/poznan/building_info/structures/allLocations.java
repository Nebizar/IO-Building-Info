package pl.put.poznan.building_info.structures;
/** Klasa reprezentujaca budynek. Zawiera podstawowe informacje o obiekcie. Dziedziczy z klasy Location
 * @since 0.2
 */

import java.util.ArrayList;
import java.util.List;

public class allLocations extends LocationGroup{

    public allLocations(){
        super(-1, "All locations", "NONE");
    }

     @Override
    public void addBuilding(Building newBuilding){
        super.addLocation(newBuilding);
    }

    public ArrayList<Building> getBuildings(){
        ArrayList<Building> buildings = new ArrayList<Building>();
        ArrayList<Location> locations = this.getLocations();

        for(Location l:locations){
            buildings.add((Building) l);
        }
        return buildings;
    }

}