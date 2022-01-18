import java.sql.Time;

public class CaracteristiquesPebrot {

    private String rendimiento,hexColor1, hexColor2;
    private int minScoville, maxScoville;
    private int anchoPlantaMax,anchoPlantaMin, alturaPlantaMax, alturaPlantaMin;
    private int diesMinCultiu,diesMaxCultiu;
    Formating format=new Formating();
    ScrapingClass sc= new ScrapingClass();
    private String color1;
    private String color2=null;
    public CaracteristiquesPebrot(String scoville, String anchoPlanta, String colorFlor, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha) {

        int[] altura=format.getIntsFromStringWithNumberAndText(alturaPlanta);
        this.alturaPlantaMax=altura[1];
        this.alturaPlantaMin=altura[0];
        int[] ample= format.getIntsFromStringWithNumberAndText(anchoPlanta);
        this.anchoPlantaMax=ample[1];
        this.anchoPlantaMin=ample[0];
        this.rendimiento=rendimiento;
        int[] maxminScoville=format.setMaxAndMinScoville(scoville);
        this.maxScoville=maxminScoville[1];
        this.minScoville=maxminScoville[0];
        int[] harvest= format.setMaxAndMinHarvestTime(tiempoMinimoCosecha);
        this.diesMaxCultiu= harvest[1];
        this.diesMinCultiu= harvest[0];
        String[] colors= format.setColorsOrColor(colorFlor);
        this.color1=colors[0];
        this.color2=colors[1];
        this.hexColor1= sc.getHtmlColorFromName(sc.translateToEnglish(color1));
        if(!color2.equals("NULL")) this.hexColor2= sc.getHtmlColorFromName(sc.translateToEnglish(color2));

        /// constructor revisat
    }
}
