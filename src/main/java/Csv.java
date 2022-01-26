import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    private File file;
    private File newFile;

    

    // un cop iniciem la classe haurem de fixar-nos si ja existeix el file i haurem de decidir si el sobreescribim. Com que aixó es per a mostrar-ho més tard en una web o semblant, sobreescriuria l'arxiu i ja mirariem més tard si ja està actualitzat, si hi ha algún de nou, etc...
    public Csv(File file) {
        this.file = file;
        String[] header = {"nombre","description","origen","distanciaEntrePlantas","distanciaEntreSemillas","scoville","anchoPlanta","familia","colorFlor","tempCrecimiento","luz","alturaPlanta","rendimiento","tiempoMinimoCosecha","profSemilla","tempGerminacion","img"};
        if (!file.exists()) writePimientoOpen(header);



    }

    // Converteix les dades d'un pebrot a un array d'String

    public void newPimientoToCSV(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {

        String[] arrayLinia= {nombre, description,origen, distanciaEntrePlantas , distanciaEntreSemillas, scoville , anchoPlanta , familia ,colorFlor,
                tempCrecimiento , luz , alturaPlanta , rendimiento , tiempoMinimoCosecha ,profSemilla , tempGerminacion, img};

               /* String str = nombre + "," + description + "," + origen + "," + distanciaEntrePlantas + "," + distanciaEntreSemillas + "," + scoville + "," + anchoPlanta + "," + familia + "," + colorFlor + "," +
                tempCrecimiento + "," + luz + "," + alturaPlanta + "," + rendimiento + "," + tiempoMinimoCosecha + "," + profSemilla + "," + tempGerminacion + "," + img;*/

        writePimientoOpen(arrayLinia);


    }



   // Guarda un nou pebrot ja convertit a String[] a l'arxiu csv
    public void writePimientoOpen(String[] linia){
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter("src/dades/pebrotsOpen.csv",true));
            writer.writeNext(linia);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


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

    public String[] getLine(int numLinia) {

        String[] line =new String[18];
        if (!numForaDeRang(numLinia)) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                CSVReader csvReader= new CSVReader(new FileReader(file));
                try {
                    for (int i = 0; i <= numLinia; i++) {
                        /*line = br.readLine().split(",");*/
                        line= csvReader.readNext();
                    }
                    /*br.close();*/
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

    // imprimeix per terminal una linia del csv
    public void csvLineToScreen(String[] line) {

        for (String parametre:
             line) {

            System.out.print(parametre+", ");
        }
        System.out.println("----------------------------------------------");
    }

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

}
