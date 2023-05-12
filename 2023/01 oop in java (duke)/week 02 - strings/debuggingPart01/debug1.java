
/**
 * Beschreiben Sie hier die Klasse debug1.
 * 
 * @author (Ihr Name) 
 * 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class debug1 {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }
}
