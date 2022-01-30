import enciclopedia.BibliotecaPebrots;
import enciclopedia.Pebrot;
import file.acces.CreateXML;
import file.acces.Csv;
import file.acces.MyJAXB;
import web.scraping.ScrapingClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Inici de la app i control de les principals  funcions
 */
public class Main {


    // En el main gestionarem tot el procés de llegir la informació de la web així com de passar a csv i més tard a xml


    /**
     * Fil principal d'execució de la app
     *
     * @param args No es tenen en compte
     */
    public static void main(String[] args) {


        File csvFile = new File("src/dades/pebrotsOpen.csv");
        File xmlFile = new File("src/dades/pebrots.xml");
        File colorChart = new File("src/dades/colorChart.csv");
        ScrapingClass sc = new ScrapingClass(csvFile);
        List<Pebrot> pebrots = new ArrayList<>();
        Csv csv = new Csv(csvFile);
        MyJAXB jax;

        /// Web scraping

        System.out.println("Start web scraping------------------");

        // Agafem totes les urls de posts de pebrots
        /*String[] urls=sc.getPimientosURL();
        String[] urls2= new String[20];
        for (int i = 0; i < 20; i++) {
           urls2[i]= urls[i];
        }
*/
        // Agafem tota la info de cada post de pebrot
        //sc.getPimientosInfo(urls2);

        // agafem un pebrot en concret passant-li la url (Probes)
        //sc.getPimientosInfo("https://elholandespicante.com/plantas/chiles-y-ajies/aji-angelo/");

        // .... final web scraping

        // imprimim  la quantitat de pebrots al csv
        System.out.println("Total pebrots descarregats al csv: " + (csv.getNumGuardats() - 1));


        // Descarreguem una taula de colors i noms d'una web a un fitxer csv ja que els traductors que utilitzava han petat //a vegades deixen de funcionar
        //csv.writeColorChartToCSV(sc.getHtmlColorWebChart());
        //System.out.println("final color chart scraping");


        // passem els pebrots del csv a objectes de la classe pebrot dins de la classe biblioteca de pebrots
        // creem la llista de pebrots amb els new pebrots del csv
        for (int i = 1; i < csv.getNumGuardats(); i++) {
            pebrots.add(new Pebrot(csv.getLine(i)));
        }

        // construim la biblioteca de pebrots amb la llista de pebrots que hem creat
        BibliotecaPebrots enciclopedia = new BibliotecaPebrots(pebrots);
        System.out.println("Total pebrots a la biblioteca: " + enciclopedia.getPebrotsList().size());

        //System.out.println("All \"Biblioteca\" to String = \n" + enciclopedia);


        CreateXML createXML= new CreateXML();
        createXML.write(enciclopedia,xmlFile);


        /*System.out.println("-------   JAXB  --------");
        /// Transformar les classes a xml amb JAXB amb la classe file.acces.MyJAXB
        jax = new MyJAXB();
        jax.generateXML(enciclopedia, xmlFile);
        jax.printFromXML(enciclopedia, xmlFile);
        enciclopedia.removeAllData();
        jax.generateObjectsFromXML(enciclopedia, xmlFile);
*/

    }







    /*
    * System.out.println("nom: " + pebrot.getNombre());
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
                    *
                    *
                    *
                    *
                    * System.out.println("Escriu una quantitat de scoville(picor) 0=tots / ha de ser un enter:");
        Scanner scan = new Scanner(System.in);
        try {
            int minScoville = scan.nextInt();
            for (enciclopedia.Pebrot pebrot :
                    enciclopedia.getPebrotsList()) {
                if (pebrot.getCaracteristiquesPebrot().getMinScoville() < minScoville) {
                    pebrot.toString();
                }
            }
        } catch (Exception e) {
            System.out.println("No és un enter!");
        }
    * */
}
