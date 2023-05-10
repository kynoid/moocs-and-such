import edu.duke.*;
/**
 * Beschreiben Sie hier die Klasse Part4.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Part4 {
    public String youtubeURLs(String url) {
        String urlList = "";
        URLResource urlRes = new URLResource(url);
        for (String word : urlRes.words()) {
            if (word.toLowerCase().contains("youtube")) {
                int quote1 = word.indexOf("\"");
                int quote2 = word.lastIndexOf("\"");
                urlList = urlList + word.substring(quote1 + 1, quote2) + "\n";
                urlList = urlList + word + "\n";
            }
            
        }
        return urlList;
    }
    
    public void testing() {
        System.out.println(youtubeURLs(
        "https://www.dukelearntoprogram.com//course2/data/manylinks.html"));
    }
}
