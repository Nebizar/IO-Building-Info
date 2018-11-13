package pl.put.poznan.building_info.structures;
/** Klasa reprezentujaca obiekt (w) budynku. Zawiera podstawowe informacje o obiekcie. Dziedzicza z niej klasy: Building, Level, Room
 * @since 0.1
 */

public class Location{
	/**
     * <p>Podstawowe cechy obiektu:</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     */
    private int ID;
    private String name;
    
    /**
     * <p>Konstruktor tworzacy obiekt wraz z informacja o nazwie i identyfikatorze</p>
     */
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