package pl.put.poznan.building_info.structures;

import java.util.ArrayList;

/**
 * Klasa reprezentujaca obiekt (w) budynku. Zawiera podstawowe informacje o
 * obiekcie. Dziedzicza z niej klasy: Building, Level, Room
 * 
 * @since 0.1
 */

public abstract class Location{
	/**
     * <p>Podstawowe cechy obiektu:</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     */
    private int ID;
    private String name;
    private String type;
    
    /**
     * <p>Konstruktor tworzacy obiekt wraz z informacja o nazwie i identyfikatorze</p>
     */
    public Location(int id, String name, String type){
        this.ID = id;
        this.name = name;
        this.type = type;
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
    


    //CHANGES
    public void addLevel(Level newLevel){
        throw new UnsupportedOperationException();
    }

    public void addRoom(Room newRoom){
        throw new UnsupportedOperationException();
    }

    public void addBuilding(Building newBuilding){
        throw new UnsupportedOperationException();
    }

    public boolean isBuilding(){
        return false;
    }

    public boolean isLevel(){
        return false;
    }

    public boolean isRoom(){
        return false;
    }

    public abstract ArrayList<Location> getLocations();

    public abstract float getHeating();
    
    public abstract float getCube();
    
    public abstract float getArea();
    
    public abstract float getLightPower();
    
    public abstract float getRent();

    public abstract Location  getEntityByID(int ID);

    public abstract ArrayList<Location>  getEntitiesByIDs(ArrayList<Integer> IDs);
}