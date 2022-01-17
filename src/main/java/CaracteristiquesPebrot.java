import java.sql.Time;

public class CaracteristiquesPebrot {

    private String rendimiento;
    private int minScoville, maxScoville;
    private float anchoPlanta, alturaPlanta;
    private int diesMinCultiu,diesMaxCultiu;
    Formating format=new Formating();
    private String color1="-";
    private String color2="-";
    public CaracteristiquesPebrot(String scoville, String anchoPlanta, String colorFlor, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha) {

        this.alturaPlanta= format.getFloatFromStringWithNumberAndText(alturaPlanta);
        this.anchoPlanta= format.getFloatFromStringWithNumberAndText(anchoPlanta);
        this.rendimiento=rendimiento;
        format.setMaxAndMinScoville(scoville,maxScoville,minScoville);
        format.setMaxAndMinHarvestTime(tiempoMinimoCosecha,diesMinCultiu,diesMaxCultiu);
        format.setColorsOrColor(colorFlor,color1,color2);

    }
}
