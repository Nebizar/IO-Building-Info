package pl.put.poznan.building_info.structures;
import java.util.ArrayList;

public abstract class LocationGroup extends Location{

    private ArrayList<Location> locations = new ArrayList<Location>();

    public LocationGroup(int id, String name, String type){
        super(id,name, type);
    }

    //CHANGES
    protected void addLocation(Location newLocation){
        locations.add(newLocation);
    }

    @Override
    public ArrayList<Location> getLocations() {
        return locations;
    }

    @Override
    public float getHeating() {
        float sum = 0;
        for(Location e:locations){
            sum += e.getHeating();
        }

        return sum;
    }

    @Override
    public float getCube() {
        float sum = 0;
        for(Location e:locations){
            sum += e.getCube();
        }

        return sum;
    }

    @Override
    public float getArea() {
        float sum = 0;
        for(Location e:locations){
            sum += e.getArea();
        }

        return sum;
    }

    @Override
    public float getLightPower() {
        float sum = 0;
        for(Location e:locations){
            sum += e.getLightPower();
        }

        return sum;
    }

    @Override
    public float getRent() {
        float sum = 0;
        for(Location e:locations){
            sum += e.getRent();
        }

        return sum;
    }

    @Override
    public Location getEntityByID(int ID) {
        if(this.getID() == ID){
            return this;
        }
        for(Location e : locations){
            Location found = e.getEntityByID(ID);
            if(found != null){
                return found;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Location> getEntitiesByIDs(ArrayList<Integer> IDs) {
        ArrayList<Location> result = new ArrayList<Location>();
        if(IDs.contains(this.getID())){
            result.add(this);
        }

        for(Location e : locations){
            ArrayList<Location> found = e.getEntitiesByIDs(IDs);
            if(!found.isEmpty()){
                result.addAll(found);
            }
        }

        return result;
    }

    @Override
    public ArrayList<Room> getRooms(){
        ArrayList<Room> found = new ArrayList<Room>();
        for(Location l:this.getLocations()){
            found.addAll(l.getRooms());
        }
        return found;
    }

}