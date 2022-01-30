package file.acces;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Gestiona la lectura i escriptura en arxius de tipus csv
 */
public class Csv {

    private File file;
    private File newFile;
    private File colorChart;


    /**Construeix la classe csv per a llegir i escriure dades de pebrots en format csv
     * @param file l'arxiu on guardem els pebrots
     */
    // un cop iniciem la classe haurem de fixar-nos si ja existeix el file i haurem de decidir si el sobreescribim. Com que aixó es per a mostrar-ho més tard en una web o semblant, sobreescriuria l'arxiu i ja mirariem més tard si ja està actualitzat, si hi ha algún de nou, etc...
    public Csv(File file) {
        this.colorChart = new File("src/dades/colorChart.csv");
        if (!colorChart.exists()) {
            try {
                colorChart.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.file = file;
        String[] header = {"nombre", "description", "origen", "distanciaEntrePlantas", "distanciaEntreSemillas", "scoville", "anchoPlanta", "familia", "colorFlor", "tempCrecimiento", "luz", "alturaPlanta", "rendimiento", "tiempoMinimoCosecha", "profSemilla", "tempGerminacion", "img"};
        if (!file.exists()) writePimientoOpen(header);

    }

    // Converteix les dades d'un pebrot a un array d'String

    /**
     * Prepara les dades d'un pebrot per a ser guardades a l'arxiu csv amb openCSV i invoca el mètode per a guardar-lo
     *
     * @param nombre nom del pebrot String
     * @param description una descripció String
     * @param origen l'origen del pebrot String
     * @param distanciaEntrePlantas la distancia entre plantes String
     * @param distanciaEntreSemillas la distancia entre llavors String
     * @param scoville l'escala scoville de picant del pebrot String
     * @param anchoPlanta ample de la planta String
     * @param familia la família a la que pertany String
     * @param colorFlor el o els colors de la flor String
     * @param tempCrecimiento les temperatures optimes pel creixement String
     * @param luz la llum que requereix String
     * @param alturaPlanta la altura de la planta String
     * @param rendimiento el rendiment en quant a la pproducció String
     * @param tiempoMinimoCosecha el temps minim per a collir String
     * @param profSemilla la profunditat a la que es planta la llavor String
     * @param tempGerminacion la temperatura idel per a que germini String
     * @param img l'enllaç a la imatge del pebrot String
     */
    public void newPimientoToCSV(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {

        String[] arrayLinia = {nombre, description, origen, distanciaEntrePlantas, distanciaEntreSemillas, scoville, anchoPlanta, familia, colorFlor,
                tempCrecimiento, luz, alturaPlanta, rendimiento, tiempoMinimoCosecha, profSemilla, tempGerminacion, img};

               /* String str = nombre + "," + description + "," + origen + "," + distanciaEntrePlantas + "," + distanciaEntreSemillas + "," + scoville + "," + anchoPlanta + "," + familia + "," + colorFlor + "," +
                tempCrecimiento + "," + luz + "," + alturaPlanta + "," + rendimiento + "," + tiempoMinimoCosecha + "," + profSemilla + "," + tempGerminacion + "," + img;*/

        writePimientoOpen(arrayLinia);


    }


    /**metode  per a guardar cadascún dels pebrots a l'arxiu csv amb openCSV
     * @param linia String[] amb les dades d'una row
     */
    // Guarda un nou pebrot ja convertit a String[] a l'arxiu csv
    public void writePimientoOpen(String[] linia) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("src/dades/pebrotsOpen.csv", true));
            writer.writeNext(linia);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**Guarda una taula de dades en format csv
     * @param taula La taula a guardar en format List<String[]> a l'arxiu de la classe preparat per aquesta funció
     */
    // guarda la taula de colors
    public void writeColorChartToCSV(List<String[]> taula) {
        try {

            CSVWriter writer = new CSVWriter(new FileWriter(colorChart));
            writer.writeAll(taula);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /** retorna true si el numero de linia del csv que se li passa no apareix a l'arxiu
     *
     * @param num El numero a compprovar
     * @return true or false depnent de si la linia existeix o no. Si no existeix és true.
     */
    // verifica que el numero estigui dins del rang demanat
    private boolean numForaDeRang(int num) {
        if (num < 0) {
            System.out.println("A partir de zero cap amunt");
            return true;
        }
        if (num > getNumGuardats()) {
            System.out.println("No hi ha tants");
            return true;
        }
        return false;


    }

    /**
     * @return el numero de pebrots o rows de l'arxiu pebrotsOpen.csv
     */
    public int getNumGuardats() {

        // retorna el numero de linies guardades a l'arxiu csv

        int num = 0;
        try {
            CSVReader csvR = new CSVReader(new FileReader(file));
            String[] line;
            /*num=csvR.getMultilineLimitreadAll();   // controlar que aixó es faci bé. = contar les linies de l'arxiu  NO VA   */
            List<String[]> hola = csvR.readAll();
            num = hola.size();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }


        return num;

    }


    public String getHtmlColorFromCSVChart(String color) {

        String[] line = new String[3];
        try {
            CSVReader csvR = new CSVReader(new FileReader(colorChart));
            while ((line = csvR.readNext()) != null) {
                if (color.toLowerCase(Locale.ROOT).equals(line[0].toLowerCase(Locale.ROOT))) {
                    return line[2];
                }
            }
            csvR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "NotFound";
    }

    /** Retorna el numero de linia de l'arxiu pebrotsOpen.csv que li passem per parametre
     * @param numLinia El numero de linia que volem que ens torni
     * @return un array d'Strings amb la línia corresponent.
     */
    public String[] getLine(int numLinia) {

        String[] line = new String[18];
        if (!numForaDeRang(numLinia)) {
            try {
                CSVReader csvReader = new CSVReader(new FileReader(file));
                try {
                    for (int i = 0; i <= numLinia; i++) {
                        line = csvReader.readNext();
                    }
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return line;
    }


    /*
    // imprimeix per terminal una linia del csv
    public void csvLineToScreen(String[] line) {

        for (String parametre :
                line) {

            System.out.print(parametre + ", ");
        }
        System.out.println("----------------------------------------------");
    }
*/

 /* Deprecated XD

   public void writePimiento(String str) {

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(str);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


/*           DEPRECATED

    // retorna el numero de linies guardades a l'arxiu csv
    public int getNumGuardats() {
        int num = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            try {
                while ((line = br.readLine()) != null) {
                    num++;
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }
*/

    /*DEPRECATED
     */
 /*   // retorna el contingut d'un numero concret de linia de l'arxiu csv
    public String getLine(int numLinia) {

        String line = "";
        if (!numForaDeRang(numLinia)) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                try {
                    for (int i = 0; i == numLinia; i++) {
                        line = br.readLine();
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return line;
    }*/

}
