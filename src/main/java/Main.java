import java.io.File;

public class Main {


    // En el main gestionarem tot el procés de llegir la informació de la web així com de passar a csv i més tard a xml


    public static void main(String[] args) {




        File csvFile= new File("src/dades/pebrots.csv");
        File xmlFile= new File("src/dades/pebrots.xml");
        ScrapingClass sc= new ScrapingClass(csvFile);

        /// Proves de color
        String colorInEnglish=sc.translateToEnglish("Verde"); // se li passa el color a traduir i a convertir a html
        System.out.println(sc.getHtmlColorFromName(colorInEnglish));
        // Agafem totes les url dels pebrots
        sc.getPimientosURL();

        // Agafem tota la info de cada pebrot
        sc.getPimientosInfo();




    }


}
