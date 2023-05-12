/**
 * Beschreiben Sie hier die Klasse Part2.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        // Return integer describing how many times stringa appears in stringb, without overlap.
        int indexStart = 0;
        int count = 0;
        int indexStringa = 0;
        while (true) {
            indexStringa = stringb.indexOf(stringa, indexStart);
            if(indexStringa >= 0) {
                count = count + 1;
                indexStart = indexStringa + stringa.length();
            } else {
                break;
            }
        }
        
        return count;
    }
        
    
    public void testHowMany() {
        // Test howMany().
        System.out.println(howMany("AA", "TAAAAA"));
        System.out.println(howMany("ACAG", "ACAAGTACAGTACAC"));
        System.out.println(howMany("ACAC", "ACACAGTACAGTACACAC"));
    }
}
