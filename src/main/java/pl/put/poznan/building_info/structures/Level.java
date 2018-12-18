package pl.put.poznan.building_info.structures;
/** Klasa reprezentujaca poziom budynku. Zawiera podstawowe informacje o obiekcie. Dziedziczy z klasy Location
 * @since 0.1
 */

import java.util.ArrayList;
import java.util.List;

public class Level extends LocationGroup{

    
    /**
     * <p>Konstruktor tworzacy poziom wraz z podstawowymi informacjami o nim</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     * dziedziczone z klasy location
     */

    public Level(int id, String name){
        super(id, name, "Level");
    }

    /**
     * <p>Dodaje nową lokacje klasy Room do obiektu</p>
     */
    @Override
    public void addRoom(Room newRoom){
        super.addLocation(newRoom);
    }
    
    /**
     * <p>Funkcja określająca typ lokalizacji jako Level</p>
     */
    @Override
    public boolean isLevel(){
        return true;
    }

    /**
     * <p>Zwraca wszystkie obiekty typu Room zawierające się w obiekcie</p>
     * @return Lista pokoi
     */
    public ArrayList<Room> getRooms(){
        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Location> locations = this.getLocations();

        for(Location l:locations){
            rooms.add((Room) l);
        }
        return rooms;
    }
}