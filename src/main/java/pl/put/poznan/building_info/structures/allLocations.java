package pl.put.poznan.building_info.structures;

import java.util.ArrayList;

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