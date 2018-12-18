package pl.put.poznan.building_info.info;

/** Klasa zawierajaca informacje o powodzeniu/niepowodzeniu operacji
 * @since 0.2
 */
public class Result{
	
	/** <p>Przechowywane informacje:</p>
	   * @param feedback - zwraca informacje jaka operacja zostala wykonana, a w przypadku zakonczenia bledem jaki blad nastapil
	   * @param code - liczba okreslajaca, czy operacja zakonczyla sie poprawnie (0), czy z bledem (-1)
	   */
    private String feedback;
    private int code;

    /**
     * <p>Konstruktor tworzacy obiekt Result wraz z podstawowymi informacjami o nim</p>
     	* @param feedback - wartosc podstawiamy pod feedback
	 	* @param code - wartosc podstawiamy pod code
     */
    public Result(String feedback, int code){
        this.feedback = feedback;
        this.code = code;
    }

    /**
     * @return informacje o operacji w formacie JSON
     */
    public String getAsJsonString(){
        String rs = "{\"feedback\": \"" + feedback + "\", \"code\": " + Integer.toString(code) + "}";
        return rs;
    }
}