
/**
 * Beschreiben Sie hier die Klasse Part2.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String endCodon) {
        if (dna == dna.toLowerCase()) {
            startCodon = startCodon.toLowerCase();
            endCodon = endCodon.toLowerCase();
        } else {
            startCodon = startCodon.toUpperCase();
            endCodon = endCodon.toUpperCase();
        }
        int startIndex = dna.indexOf(startCodon);
        if (startIndex < 0) {
            return "";
        }
        int endIndex = dna.indexOf(endCodon, startIndex + 3);
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
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ctaatgblablataacgatagc";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "CTAGATGBLABLTAACGATAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "CTAGATGBLABLACGATAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "CTAGBLABLATAACGATAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
    }
}
