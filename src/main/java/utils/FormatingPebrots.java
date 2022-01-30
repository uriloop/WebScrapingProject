package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * S'encarrega de formatejar les dades que recopilem dels pebrots per a poder crear els pebrots amb dades amb sentit
 */
public class FormatingPebrots {


    /**Retorna dos ints amb un valor max i un valor min tot treient el text que hi pugui haber
     * @param alturaPlanta l'String a convertir exm: "40 - 50 cm"
     * @return retorna dos valors en format int[]  exm: {40 - 50}
     */
    public int[] getIntsFromStringWithNumberAndText(String alturaPlanta) {
        String num1 = "";
        String num2 = "";
        int ints[] = new int[2];
        boolean primerSegonNum = false;
        boolean hiHaSegon = false;
        for (int i = 0; i < alturaPlanta.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn
            if (Character.isDigit(alturaPlanta.charAt(i))) {
                if (!primerSegonNum) num1 += alturaPlanta.charAt(i);
                else {
                    num2 += alturaPlanta.charAt(i);
                    hiHaSegon = true;
                }
            } else if (!Character.isDigit(alturaPlanta.charAt(i))) {
                primerSegonNum = true;
            }
        }

        try{
            ints[0] = Integer.parseInt(num2);
        }catch(NumberFormatException e){
            ints[0]=0;
        }
        try {
            ints[1] = Integer.parseInt(num1);
        } catch (NumberFormatException e) {
            ints[1]=0;

        }


        return ints;
    }   // falla amb el cas que estigui buit

    /** formateja les dades del grau d'scoville per a que mostri dos integers del max i min o si només hi ha una dada retorna -100 a l'altre dada
     * @param scoville string que hem de transformar. exm: "entre 100.000 ~ 120.000 sc"
     * @return dos integers en format int[]  exm: {100000,120000}
     */
    public int[] setMaxAndMinScoville(String scoville) {
        String num1 = "";
        String num2 = "";
        List<String> scovilleList = new ArrayList<>();

        boolean hiHaSegon = false;
        for (int i = 0; i < scoville.toCharArray().length; i++) {
            if (scoville.charAt(i) == '~' || scoville.charAt(i) == 'y'|| scoville.charAt(i) == '/') {
                hiHaSegon = true;
            } else if (Character.isDigit(scoville.charAt(i))) {
                if (!hiHaSegon) num1 += scoville.charAt(i);
                else {
                    num2 += scoville.charAt(i);
                }
            }
        }

            int[] scovilleNums = new int[2];
            try{scovilleNums[0] = Integer.parseInt(num1);}catch (NumberFormatException e){
                scovilleNums[0]= -100;
            }
            try{scovilleNums[1] = Integer.parseInt(num2);}catch (NumberFormatException e){
                scovilleNums[1]= -100;
            }


            return scovilleNums;

        // JA TIRA


    }   // fet

    /**formateja les dades de la familia del pebrot
     * @param familia string on podem trobar la familia i més caracters que es treuen. exm: "C. annum"
     * @return un string amb la familia només  exm: "annum"
     */
    public String familyFilter(String familia) {    // fet
        String[] noms = familia.split(" ");
        if (noms.length == 1) return noms[0];
        else if (noms.length == 2) return noms[1];
        else return noms[noms.length - 1];

    }   // fet

    /** formateja el temps max min de collita
     * @param tiempoMinimoCosecha un string mb coses tipu "De 60 a 70 dias"
     * @return dos integerrs en format int[] exm: {60,70}
     */
    public int[] setMaxAndMinHarvestTime(String tiempoMinimoCosecha) {   // fet


        String num1 = "";
        String num2 = "";
        int temps[] = new int[2];
        boolean primerSegonNum = false;
        boolean hiHaSegon = false;
        for (int i = 0; i < tiempoMinimoCosecha.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn
            if (Character.isDigit(tiempoMinimoCosecha.charAt(i))) {
                if (!primerSegonNum) num1 += Character.toString(tiempoMinimoCosecha.charAt(i));
                else {
                    num2 += Character.toString(tiempoMinimoCosecha.charAt(i));
                    hiHaSegon = true;
                }
            } else if (!Character.isDigit(tiempoMinimoCosecha.charAt(i))) {
                primerSegonNum = true;
            }
        }

        try{
            temps[0] = Integer.parseInt(num2);
        }catch(NumberFormatException e){
            temps[0]=-100;
        } try{
            temps[1] = Integer.parseInt(num1);
        }catch(NumberFormatException e){
            temps[1]=-100;
        }

        return temps;
    }   /// fet

    /**formateja les dades dels colors
     * @param colorFlor un string amb un o varios colors exm: "amarillo/blanco"
     * @return retorna un array d'string amb els diferents colors per separat   exm: {"amarillo","blanco"}
     */
    public String[] setColorsOrColor(String colorFlor) {

        String[] colors = new String[2];
        boolean primerSegonColor = false;
        boolean hiHaSegon = false;
        String primer = "", segon = "";
        for (int i = 0; i < colorFlor.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn
            if (Character.isLetter(colorFlor.charAt(i))) {
                if (!primerSegonColor) primer += Character.toString(colorFlor.charAt(i));
                else {
                    segon += Character.toString(colorFlor.charAt(i));
                    hiHaSegon = true;
                }
            } else if (!Character.isDigit(colorFlor.charAt(i))) {
                primerSegonColor = true;
            }
        }
        if (!hiHaSegon) segon = "NULL";
        colors[0] = primer;
        colors[1] = segon;

        return colors;
    }  /// fet


   /* public int[] setMaxMinValuesFromAnchoPlanta(String anchoPlanta) {    // Fet

        String num1 = "";
        String num2 = "";
        int ample[] = new int[2];
        boolean primerSegonNum = false;
        boolean hiHaSegon = false;
        for (int i = 0; i < anchoPlanta.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn
            if (Character.isDigit(anchoPlanta.charAt(i))) {
                if (!primerSegonNum) num1 += Character.toString(anchoPlanta.charAt(i));
                else {
                    num2 += Character.toString(anchoPlanta.charAt(i));
                    hiHaSegon = true;
                }
            } else if (!Character.isDigit(anchoPlanta.charAt(i))) {
                primerSegonNum = true;
            }
        }
        if (!hiHaSegon) num2 = "-1";
        ample[0] = Integer.parseInt(num2);
        ample[1] = Integer.parseInt(num1);
        return ample;
    }   // fet*/

    /**formateja les dades per obtenir un sol int
     * @param distanciaEntreSemillas un string tipus exm: "40 cm"
     * @return un integer  exm: 40
     */
    public int getIntFromStringWithText(String distanciaEntreSemillas) {
        // Separar els digits del text i convertir-los a integer
        String num1 = "";

        for (int i = 0; i < distanciaEntreSemillas.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn

            if (Character.isDigit(distanciaEntreSemillas.charAt(i))) {
                num1 += (distanciaEntreSemillas.charAt(i));
            } /*else break;*/
        }
        return Integer.parseInt(num1);
    }   // fet

    /**formateja les dades sobre l'origen.
     * @param origen  un string a formatejar  exm: "trinidad/chile"
     * @return un array de integers amb els difechile"}
     */
    public String[] getValuesFromOrigen(String origen) {

        return origen.split("/");
    }   // fet

    /**formateja les ddes per obtenir un float d'un String
     * @param valor String a formatejar.   exm: "20.50 cm"
     * @return  un float amb el valor.   exm: 20.5f
     */
    public float getFloatFromStringWithText(String valor) {

        // s'ha de revisar !!!!    quan agafem els decimals s'haurà de comprovar quants decimals tenim i dividir-ho per :  1 digit= 10, 2 digits= 100 .....
        float result;
        String num1 = "";
        String num2 = "";
        int contadorDecimals = 0;
        boolean decimals = false;
        for (int i = 0; i < valor.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn
            /*if (Character.isDigit(profSemilla.charAt(i)) || profSemilla.charAt(i) == ',') {
                if (!decimals) {
                    if (profSemilla.charAt(i) != ',') num1 += Character.toString(profSemilla.charAt(i));
                    else {
                        decimals = true;
                    }
                } else if (Character.isDigit(profSemilla.charAt(i))) {
                    num2 += profSemilla.charAt(i);
                    contadorDecimals++;
                }

            }*/
            if (valor.charAt(i) == ',') decimals = true;
            if (!decimals && Character.isDigit(valor.charAt(i))) {
                num1 += valor.charAt(i);
            } else if (Character.isDigit(valor.charAt(i))) {
                num2 += valor.charAt(i);
                contadorDecimals++;
            }
        }
        int divisor = 1;
        for (int i = 0; i < contadorDecimals; i++) {
            divisor *= 10;
        }
        if (decimals) {
            return Float.parseFloat(num1) + (Float.parseFloat(num2) / divisor);
        } else return Float.parseFloat(num1);


    }
}
