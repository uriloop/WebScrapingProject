public class CultiuPebrot {


    private float profSemilla;
    private int distanciaEntrePlantes,  tempCrecimientoMax , TempCrecimientoMin;
    private int tiempoMinCosechaMax, tiempoMinCosechaMin, distanciaEntreSemillas;
    private String luz;

    FormatingPebrots format= new FormatingPebrots();

    public CultiuPebrot(String profSemilla,String distanciaEntrePlantas, String distanciaEntreSemillas,  String tempCrecimiento, String luz, String tempGerminacion) {

        this.distanciaEntreSemillas= format.getIntFromStringWithText(distanciaEntreSemillas);
        this.profSemilla=format.getFloatFromStringWithText(profSemilla);

    }
}
