/**
 * Beschreiben Sie hier die Klasse Part1.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        // Return index of the first occurrence of stopCodon that appears 
        // past startIndex and is a multiple of 3 away from startIndex.
        // If no such stopCodon, return the length of the dna strand.
        int stopIndex = startIndex + 3;
        
        while (true) {
            stopIndex = dna.indexOf(stopCodon, stopIndex);
            if (stopIndex < 0) {
                stopIndex = dna.length();
                break;
            }
            if ((stopIndex - startIndex) % 3 != 0) {
                stopIndex = stopIndex + 1;
            } else {
                break;
            }
        }
        
        return stopIndex;
    }
    
    public String findGene(String dna) {
        // Find index of first start codon ATG. If none, return empty string.
        int startIndex = dna.indexOf("ATG");
        String gene = "";
        
        if (startIndex < 0) {
            return gene;
        }
        // Using findStopCodon(), find first instance of end codon TAA, TAG, 
        // or TGA, that is multiple of three away from ATG.
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        // Return gene if present, otherwise empty string.
        if ((taaIndex == tagIndex && tagIndex == tgaIndex)) {
            return gene;
        } else if (taaIndex < tagIndex && taaIndex < tgaIndex) {
            gene = dna.substring(startIndex, taaIndex + 3);
        } else if (tagIndex < tgaIndex) {
            gene = dna.substring(startIndex, tagIndex + 3);
        } else {
            gene = dna.substring(startIndex, tgaIndex + 3);
        }
        return gene;
    }
    
    public int countGenes(String dna) {
        // Find all genes in string of DNA
        int index = 0;
        int count = 0;
        String gene = "";
        
        while (true) {
            gene = findGene(dna.substring(index, dna.length()));
            
            if (gene.isEmpty()) {
                break;
            } else {
                count = count + 1;
                index = dna.indexOf(gene) + gene.length();
            }
        }
        
        return count;
    }
    
    public void testFindStopCodon() {
        // Test findStopCodon()
        System.out.println(findStopCodon("xxATGxxxxxxTAAxxx", 2, "TAA"));
        System.out.println(findStopCodon("xxATGxxxxxTAAxxx", 2, "TAA"));
        System.out.println(findStopCodon("xxATGxxxxxTAAxTAAxx", 2, "TAA"));
    }
    
    public void testFindGene () {
        // Test findGene()
        System.out.println(findGene("xxATG123456TAAxxx")); // ATG123456TAA
        System.out.println(findGene("xxATG12345TAAxxx")); // no gene
        System.out.println(findGene("xxATG12345TAA6TAAxx")); // ATG12345TAA6TAA
        System.out.println(findGene("xxATG12345TAA6TAGxx")); // ATG12345TAA6TAG
        System.out.println(findGene("xxATG123456TGA7TAGxx")); // ATG123456TGA
        System.out.println(findGene("xx123456TAAxxx")); // no gene
        System.out.println(findGene("xxATG12345TAA67TGA89TAGxx")); // 12345TAA67TGA89TAG
    }
    
    public void printAllGenes(String dna) {
        // Find all genes in string of DNA
        int index = 0;
        String gene = "";
        
        while (true) {
            gene = findGene(dna.substring(index, dna.length()));
            
            if (gene.isEmpty()) {
                break;
            } else {
                System.out.println(gene);
                index = dna.indexOf(gene) + gene.length();
            }
        }
        // test with "xATG123TAAxxxxATG12TAA3TAGxxxxxxxxATG12TAA3456TGAxxATG"
    }
    
    public void testCountGenes() {
        // Count all genes in string of DNA.
        System.out.println(countGenes("xATG123TAAxxxxATG12TAA3TAGxxxxxxxxATG12TAA3456TGAxxATG"));
    }
}
