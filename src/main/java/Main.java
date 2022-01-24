import java.io.File;

public class Main {


    // En el main gestionarem tot el procés de llegir la informació de la web així com de passar a csv i més tard a xml


    public static void main(String[] args) {




        File csvFile= new File("src/dades/pebrots.csv");
        File xmlFile= new File("src/dades/pebrots.xml");
        ScrapingClass sc= new ScrapingClass(csvFile);

       /* // probes formateig de dades
        FormatingPebrots format= new FormatingPebrots();
        System.out.println("----------------------------getFloatFrom... '0,5 cm' -------------------------------");
        float profLlavor= format.getFloatFromStringWithText("0,5 cm");
        System.out.println("profLlavor= "+profLlavor);
        System.out.println("----------------------------setMAxMinScoville '100.000 ~ 300.000' -------------------------------");
        int[] scoville= format.setMaxAndMinScoville("100.000 ~ 300.000");
        System.out.println("num1= "+scoville[0]+"      num2= "+scoville[1]);
        System.out.println("----------------------------setColorsOrColor 'verde amarillo' -------------------------------");
        String[] colors= format.setColorsOrColor("verde / amarillo");
        System.out.println("color1= "+colors[0]+"      color2= "+colors[1]);
        System.out.println("----------------------------getIntFromStringWithText '5 cm' -------------------------------");
        int distanciaEntreLlavors= format.getIntFromStringWithText("5 cm");
        System.out.println("distancia= "+distanciaEntreLlavors);
        System.out.println("----------------------------setMinHarvestTime '30 - 40 dies' -------------------------------");
        int[] temps= new int[2];
        temps= format.setMaxAndMinHarvestTime("30 - 40 dies");
        System.out.println("tempsMax= "+temps[0]+"   tempsMin= "+temps[1]);
        System.out.println("----------------------------FamilyFilter 'C. mm chinensis' -------------------------------");
        String familia="";
        familia=format.familyFilter("C. mm chinensis");
        System.out.println(familia);
        System.out.println("----------------------------AmplePlanta '20 - 30 cm' -------------------------------");
        int ample[]=new int[2];
        ample=format.setMaxMinValuesFromAnchoPlanta("20 - 30 cm");
        System.out.println("ampleMax= "+ ample[0]+"    ampleMin= "+ample[1]);
        System.out.println("----------------------------getColorsInHex  'Verde' -------------------------------");
        /// Proves de color  es pot posar un metode dintre de laltre? perque falla? SOLUCIONAT
        System.out.println("hex -> "+sc.getHtmlColorFromName(sc.translateToEnglish("Verde")));*/



        /// Aki el codi original sense proves


        System.out.println("Start ------------------");
        // Agafem totes les url dels pebrots
        sc.getPimientosURL();

        // Agafem tota la info de cada pebrot
        sc.getPimientosInfo();




    }


}
