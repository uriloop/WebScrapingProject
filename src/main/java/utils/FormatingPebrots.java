package utils;

import java.util.ArrayList;
import java.util.List;

public class FormatingPebrots {


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

    public String familyFilter(String familia) {    // fet
        String[] noms = familia.split(" ");
        if (noms.length == 1) return noms[0];
        else if (noms.length == 2) return noms[1];
        else return noms[noms.length - 1];

    }   // fet

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


    public int[] setMaxMinValuesFromAnchoPlanta(String anchoPlanta) {    // Fet

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
    }   // fet

    public int getIntFromStringWithText(String distanciaEntreSemillas) {
        // Separar els digits del text i convertir-los a integer
        String num1 = "";

        System.out.println(distanciaEntreSemillas);
        for (int i = 0; i < distanciaEntreSemillas.toCharArray().length; i++) {
            // si el caracter es un numero el guardem a la variable de retorn

            if (Character.isDigit(distanciaEntreSemillas.charAt(i))) {
                num1 += (distanciaEntreSemillas.charAt(i));
            } /*else break;*/
        }
        return Integer.parseInt(num1);
    }   // fet

    public String[] getValuesFromOrigen(String origen) {

        return origen.split("/");
    }   // fet

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
