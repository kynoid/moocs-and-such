
/**
 * Beschreiben Sie hier die Klasse Part1.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex < 0) {
            return "";
        }
        int endIndex = dna.indexOf("TAA", startIndex + 3);
        if (endIndex < 0) {
            return "";
        }
        if ((endIndex - startIndex) % 3 != 0){
            return "";
        }
        String gene = dna.substring(startIndex, endIndex + 3);
        return gene;
    }
    
    public void testSimpleGene() {
        String dna = "CTAGATGBLABLATAACGATAGC";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CTAGATGBLABLTAACGATAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CTAGATGBLABLACGATAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CTAGBLABLATAACGATAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
}
