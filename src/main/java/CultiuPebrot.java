public class CultiuPebrot {


    private float profSemilla;
    private int distanciaEntrePlantes,  tempCrecimientoMax , tempCrecimientoMin;
    private int tempGerminacionMin, tempGerminacionMax, distanciaEntreSemillas;
    private String luz;

    FormatingPebrots format= new FormatingPebrots();

    public CultiuPebrot(String profSemilla,String distanciaEntrePlantas, String distanciaEntreSemillas,  String tempCrecimiento, String luz, String tempGerminacion) {

        this.luz=luz;
        int[] temperatures=format.getIntsFromStringWithNumberAndText(tempCrecimiento);
        this.tempCrecimientoMin=temperatures[0];
        if (temperatures.length==2){
            this.tempCrecimientoMax=temperatures[1];
        }
        temperatures=format.getIntsFromStringWithNumberAndText(tempGerminacion);
        this.tempGerminacionMin=temperatures[0];
        if (temperatures.length==2){
            this.tempGerminacionMax=temperatures[1];
        }
        this.distanciaEntrePlantes= format.getIntFromStringWithText(distanciaEntrePlantas);
        this.distanciaEntreSemillas= format.getIntFromStringWithText(distanciaEntreSemillas);
        this.profSemilla=format.getFloatFromStringWithText(profSemilla);

    }

    public float getProfSemilla() {
        return profSemilla;
    }

    public int getDistanciaEntrePlantes() {
        return distanciaEntrePlantes;
    }

    public int getTempCrecimientoMax() {
        return tempCrecimientoMax;
    }

    public int getTempCrecimientoMin() {
        return tempCrecimientoMin;
    }

    public int getTempGerminacionMin() {
        return tempGerminacionMin;
    }

    public int getTempGerminacionMax() {
        return tempGerminacionMax;
    }

    public int getDistanciaEntreSemillas() {
        return distanciaEntreSemillas;
    }

    public String getLuz() {
        return luz;
    }
}
