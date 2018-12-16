package pl.put.poznan.building_info.structures;

/** Klasa zawierajaca informacje przekazywane uzytkownikowi aplikacji
 * @since 0.2
 */
public class Value{
	
	/** <p>Przechowywane informacje:</p>
	   * @param type - zwraca informacje jaka operacja zostala wykonana, a w przypadku zakonczenia bledem jaki blad nastapil
	   * @param id - id obiektu
	   * @param value - wynik operacji lub -1 w przypadku zakonczenia bledem
	   */
	private String type;
    private int id;
    private float value;
    
    /**
     * <p>Konstruktor tworzacy obiekt Value wraz z podstawowymi informacjami o nim</p>
     */
    public Value(String param1,int param2,float param3) {
    	type=param1;
    	id=param2;
    	value=param3;
    }
    
    public float getValue() {
    	return value;
    }
    
}