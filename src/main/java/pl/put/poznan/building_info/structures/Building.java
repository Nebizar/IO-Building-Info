package pl.put.poznan.building_info.structures;
/** Klasa reprezentujaca budynek. Zawiera podstawowe informacje o obiekcie. Dziedziczy z klasy Location
 * @since 0.2
 */

import java.util.ArrayList;
import java.util.List;

public class Building extends Location{
	
	  /** <p>Podstawowe cechy obiektu:</p>
	   * @param levels - lista poziomow znajdujacych sie w budynku
	   */
    
    private ArrayList<Level> levels = new ArrayList<Level>();

    /**
     * <p>Konstruktor tworzacy budynek wraz z podstawowymi informacjami o nim</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     * dziedziczone z klasy location
     */
    public Building(int id, String name){
        super(id, name);
    }
    
    /**
     * <p>Funkcja dodajaca poziom do listy levels</p>
     *
     * @param newLevel- obiekt dodawany do listy levels
     */
    public void addLevel(Level newLevel){
        levels.add(newLevel);
    }

    public ArrayList<Level> getLevels(){
        return levels;
    }
    
}