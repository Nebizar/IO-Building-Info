package pl.put.poznan.building_info.structures;
/** Klasa reprezentujaca budynek. Zawiera podstawowe informacje o obiekcie. Dziedziczy z klasy LocationGroup
 * @since 0.2
 */

import java.util.ArrayList;

public class Building extends LocationGroup{
    /**
     * <p>Konstruktor tworzacy budynek wraz z podstawowymi informacjami o nim</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     * dziedziczone z klasy LocationGroup
     */
    public Building(int id, String name){
        super(id, name, "Building");
    }
    
    /**
     * <p>Funkcja dodajaca poziom do listy levels</p>
     *
     * @param newLevel- obiekt dodawany do listy levels
     */
    @Override
    public void addLevel(Level newLevel){
        super.addLocation(newLevel);
    }

    /**
     * <p>Funkcja okreslajaca typ Lokacji jako Building</p>
     */
    @Override
    public boolean isBuilding(){
        return true;
    }

    /**
     * <p>Zwraca wszystkie obiekty typu Level wchodzace w sklad budynku</p>
     * @return Lista poziomow
     */
    public ArrayList<Level> getLevels(){
        ArrayList<Level> levels = new ArrayList<Level>();
        ArrayList<Location> locations = this.getLocations();

        for(Location l:locations){
            levels.add((Level) l);
        }
        return levels;
    }


}