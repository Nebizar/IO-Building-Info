package pl.put.poznan.building_info.structures;
import java.util.ArrayList;
import java.util.List;

/** Klasa przechowujaca stworzone obiekty oraz ich ilosc.
 * @since 0.2
 */
public class Collection{
	
	/** <p>Przechowywane informacje:</p>
	   * @param buildings - lista wszystkich stworzonych budynkow
	   * @param levels - lista wszystkich stworzonych poziomow
	   * @param rooms - lista wszystkich stworzonych pomieszczen
	   * @param numberOfElements - laczna ilosc stworzonych obiektow
	   */
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private ArrayList<Level> levels = new ArrayList<Level>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private int numberOfElements = 0;

    /**
     * <p>Funkcja dodajaca budynek do listy buildings</p>
     * @param n- obiekt dodawany do listy buildings
     */
    public void insertBuilding(Building n){
        numberOfElements ++;
        buildings.add(n);
    }

    public ArrayList<Building> getBuildings(){
        return buildings;
    }

    /**
     * <p>Funkcja dodajaca poziom do listy levels</p>
     * @param n- obiekt dodawany do listy levels
     */
    public void insertLevel(Level n){
        numberOfElements ++;
        levels.add(n);
    }

    public ArrayList<Level> getLevels(){
        return levels;
    }

    /**
     * <p>Funkcja dodajaca pomieszczenie do listy rooms</p>
     * @param n- obiekt dodawany do listy rooms
     */
    public void insertRoom(Room n){
        numberOfElements ++;
        rooms.add(n);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }
}