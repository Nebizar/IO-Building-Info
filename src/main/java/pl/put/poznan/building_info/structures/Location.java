package pl.put.poznan.building_info.structures;

public class Location{
    private int ID;
    private String name;

    public Location(int id, String name){
        this.ID = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    
}