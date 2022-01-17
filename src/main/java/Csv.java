import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    private File file;


    // un cop iniciem la classe haurem de fixar-nos si ja existeix el file i haurem de decidir si el sobreescribim. Com que aixó es per a mostrar-ho més tard en una web o semblant, sobreescriuria l'arxiu i ja mirariem més tard si ja està actualitzat, si hi ha algún de nou, etc...
    public Csv(File file) {
        this.file = file;
        String header = "nombre,description,origen,distanciaEntrePlantas,distanciaEntreSemillas,scoville,anchoPlanta,familia,colorFlor,tempCrecimiento,luz,alturaPlanta,rendimiento,tiempoMinimoCosecha,profSemilla,tempGerminacion,img\n";
        file.delete();

        writePimiento(header);

    }

    // Converteix un pebrot a una linia csv
    public void newPimientoToCSV(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {

        String str = nombre + "," + description + "," + origen + "," + distanciaEntrePlantas + "," + distanciaEntreSemillas + "," + scoville + "," + anchoPlanta + "," + familia + "," + colorFlor + "," +
                tempCrecimiento + "," + luz + "," + alturaPlanta + "," + rendimiento + "," + tiempoMinimoCosecha + "," + profSemilla + "," + tempGerminacion + "," + img;


        writePimiento(str);


    }

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

    }

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


    public int getNumGuardats() {
        int num=0;
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


    public String getLine(int numLinia){

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
    }

    public void csvLineToScreen(String line) {

        String[] separated = line.split(",");
        for (int i = 0; i < separated.length; i++) {
            if (separated[i].length() > 50) {
                int j = 0;
                for (char c :
                        separated[i].toCharArray()) {
                    if (j%50==0) System.out.println();
                    j++;
                }
            }
            System.out.printf("%20s", separated[i]);
        }
    }


}
