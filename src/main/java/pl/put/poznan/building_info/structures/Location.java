package pl.put.poznan.building_info.structures;

import java.util.ArrayList;

/**
 * Klasa abstrakcyjna reprezentujaca obiekt (w) budynku. Zawiera podstawowe informacje o
 * obiekcie. Dziedzicza z niej klasy: Location Group, Room
 * 
 * @since 0.1
 */

public abstract class Location{
	/**
     * <p>Podstawowe cechy obiektu:</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     * @param type typ obiektu "Room", "Building"...
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

    /**
     * <p>Zwraca nazwę lokacji</p>
     * @return nazwa lokacji
     */
    public String getName(){
        return name;
    }

    /**
     * <p>Zwraca identyfikator lokacji</p>
     * @return ID
     */
    public int getID(){
        return ID;
    }

    /**
     * <p>Nadaje nowy identyfikator lokacji</p>
     * @param ID - nowy identyfikator
     */
    public void setID(int ID){
        this.ID = ID;
    }
    
    /**
     * <p>Dodanie nowego poziomu do lokacji</p>
     * @param newLevel
     */
    public void addLevel(Level newLevel){
        throw new UnsupportedOperationException();
    }

    /**
     * <p>Dodanie nowego pokoju do lokacji</p>
     */
    public void addRoom(Room newRoom){
        throw new UnsupportedOperationException();
    }

    /**
     * <p>Dodanie nowego budynku do lokacji</p>
     * @param newBuilding
     */
    public void addBuilding(Building newBuilding){
        throw new UnsupportedOperationException();
    }

    /**
     * <p>Funkcja sprawdzająca czy lokacja jest budynkiem</p>
     * @return wartość true/false
     */
    public boolean isBuilding(){
        return false;
    }

    /**
     * <p>Funkcja sprawdzająca czy lokacja jest poziomem</p>
     * @return wartość true/false
     */
    public boolean isLevel(){
        return false;
    }

    /**
     * <p>Funkcja sprawdzająca czy lokacja jest pokojem</p>
     * @return wartość true/false
     */
    public boolean isRoom(){
        return false;
    }

    /**
     * <p>Funkcja zwracająca wszystkie lokacja zawarte w lokacji</p>
     * @return - Lista lokacji
     */
    public abstract ArrayList<Location> getLocations();

    /**
     * <p>Zwraca zyżycie energii na ogrzewanie całej lokacji (wraz z elementami wewnąrz)</p>
     * @return - zużycie energii
     */
    public abstract float getHeating();
    
    /**
     * <p>Zwraca kubaturę całej lokacji (wraz z elementami wewnąrz)</p>
     * @return - kubatura
     */
    public abstract float getCube();
    
    /**
     * <p>Zwraca powierzchnie całej lokacji (wraz z elementami wewnąrz)</p>
     * @return - lokacja
     */
    public abstract float getArea();
    
    /**
     * <p>Zwraca moc zuzywana na oswietlenie całej lokacji (wraz z elementami wewnąrz)</p>
     * @return - moc
     */
    public abstract float getLightPower();
    
    /**
     * <p>Zwraca koszt wynajecia calej lokacji (wraz z elementami wewnąrz)</p>
     * @return - koszt
     */
    public abstract float getRent();

    /**
     * <p>Wyszukuje wewnątrz lokacji lokacji o zadanym ID</p>
     * @param ID - szykany identyfikator
     * @return - null jeżeli taka lokacja nie istnieje lub lokacja jeżeli istnieje
     */
    public abstract Location  getEntityByID(int ID);

    /**
     * <p>Wyszukuje wewnątrz lokacji lokacji o zadanym ID</p>
     * @param IDs - szukane identyfikatory
     * @return - lista elementów spełniających kryteria
     */
    public abstract ArrayList<Location>  getEntitiesByIDs(ArrayList<Integer> IDs);
}