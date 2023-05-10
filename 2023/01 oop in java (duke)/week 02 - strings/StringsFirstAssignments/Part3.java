/**
 * Beschreiben Sie hier die Klasse Part3.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Part3 {
    public String twoOccurrences(String stringa, String stringb) {
        int index1 = stringb.indexOf(stringa);
        if (index1 >= 0) {
            int index2 = stringb.indexOf(stringa, index1 + stringa.length());
            if (index2 >= 0) {
                return "true";
            }
        }
        return "false";
    }
    
    public String lastPart(String stringa, String stringb) {
        int index1 = stringb.indexOf(stringa);
        if (index1 >= 0) {
            return stringb.substring(index1 + stringa.length());
        }
        return stringb;
    }    
    
    public void testing() {
        System.out.println(twoOccurrences("bl", "blah"));
        System.out.println(twoOccurrences("bl", "blahblah"));
        System.out.println(lastPart("bl", "zoo"));
        System.out.println(lastPart("bl", "blahblah"));
    }
}
