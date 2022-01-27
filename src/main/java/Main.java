import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    // En el main gestionarem tot el procés de llegir la informació de la web així com de passar a csv i més tard a xml


    public static void main(String[] args) {


        File csvFile = new File("src/dades/pebrotsOpen.csv");
        File xmlFile = new File("src/dades/pebrots.xml");
        ScrapingClass sc = new ScrapingClass(csvFile);
        List<Pebrot> pebrots = new ArrayList<>();
        Csv csv = new Csv(csvFile);

        /// Aki el codi original sense proves

        System.out.println("Start web scraping------------------");

        // Agafem totes les urls de posts de pebrots
        sc.getPimientosURL();

        // Agafem tota la info de cada post de pebrot
        sc.getPimientosInfo();


        // imprimim  la quantitat de pebrots al csv
        System.out.println("Total pebrots descarregats: " + (csv.getNumGuardats() - 1));


        // passem els pebrots del csv a objectes de la classe pebrot dins de la classe biblioteca de pebrots
        // creem la llista de pebrots amb els new Pebrot
        for (int i = 1; i < csv.getNumGuardats(); i++) {
            pebrots.add(new Pebrot(csv.getLine(i)));

        }
        // construim la biblioteca de pebrts amb la llista de pebrots
        BibliotecaPebrots enciclopedia = new BibliotecaPebrots(pebrots);
        System.out.println("Total pebrots: " + enciclopedia.getPebrotsList().size());
        System.out.println("Escriu una quantitat de scoville(picor) 0=tots / ha de ser un enter:");
        Scanner scan = new Scanner(System.in);
        try {
            int minScoville = scan.nextInt();
            for (Pebrot pebrot :
                    enciclopedia.getPebrotsList()) {
                if (pebrot.getCaracteristiquesPebrot().getMinScoville() > minScoville) {
                    System.out.println("nom: " + pebrot.getNombre());
                    System.out.println("img: " + pebrot.getImg());
                    System.out.println("info/descripció: " + pebrot.getInfoPebrot().getDescripcion());
                    System.out.println("info/família: " + pebrot.getInfoPebrot().getFamilia());
                    System.out.println("info/origen: " + pebrot.getInfoPebrot().getOrigen());
                    System.out.println("cultiu/temp. MIN creixement: " + pebrot.getCultiuPebrot().getTempCrecimientoMin());
                    System.out.println("cultiu/temp. MAX creixement: " + pebrot.getCultiuPebrot().getTempCrecimientoMax());
                    System.out.println("cultiu/temp. MIN germinació: " + pebrot.getCultiuPebrot().getTempGerminacionMin());
                    System.out.println("cultiu/temp. MAX germinació: " + pebrot.getCultiuPebrot().getTempGerminacionMax());
                    System.out.println("cultiu/dist. semillas: " + pebrot.getCultiuPebrot().getDistanciaEntreSemillas());
                    System.out.println("cultiu/dist. plantas: " + pebrot.getCultiuPebrot().getDistanciaEntrePlantes());
                    System.out.println("cultiu/prof. semillas: " + pebrot.getCultiuPebrot().getProfSemilla());
                    System.out.println("cultiu/luz: " + pebrot.getCultiuPebrot().getLuz());
                    System.out.println("característiques/rendiment: " + pebrot.getCaracteristiquesPebrot().getRendimiento());
                    System.out.println("característiques/alt. MIN planta: " + pebrot.getCaracteristiquesPebrot().getAlturaPlantaMin());
                    System.out.println("característiques/alt. MAX planta: " + pebrot.getCaracteristiquesPebrot().getAlturaPlantaMax());
                    System.out.println("característiques/ampl. MIN planta: " + pebrot.getCaracteristiquesPebrot().getAnchoPlantaMin());
                    System.out.println("característiques/ampl. MAX planta: " + pebrot.getCaracteristiquesPebrot().getAnchoPlantaMax());
                    System.out.println("característiques/dies cultiu. MIN: " + pebrot.getCaracteristiquesPebrot().getDiesMinCultiu());
                    System.out.println("característiques/dies cultiu. MAX: " + pebrot.getCaracteristiquesPebrot().getDiesMaxCultiu());
                    System.out.println("característiques/scoville MIN: " + pebrot.getCaracteristiquesPebrot().getMinScoville());
                    System.out.println("característiques/scoville MAX: " + pebrot.getCaracteristiquesPebrot().getMaxScoville());
                    System.out.println("característiques/_HEX_color/s: " + pebrot.getCaracteristiquesPebrot().getHexColors());
                }
            }
        } catch (Exception e) {
            System.out.println("No és un enter!");
        }
    }
}
