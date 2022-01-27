public class CaracteristiquesPebrot {


    private String rendimiento;
    String[] hexColors;
    private int minScoville, maxScoville;
    private int anchoPlantaMax,anchoPlantaMin, alturaPlantaMax, alturaPlantaMin;
    private int diesMinCultiu,diesMaxCultiu;
    FormatingPebrots format=new FormatingPebrots();
    ScrapingClass sc= new ScrapingClass();

    public String getRendimiento() {
        return rendimiento;
    }

    public String[] getHexColors() {
        return hexColors;
    }

    public int getMinScoville() {
        return minScoville;
    }

    public int getMaxScoville() {
        return maxScoville;
    }

    public int getAnchoPlantaMax() {
        return anchoPlantaMax;
    }

    public int getAnchoPlantaMin() {
        return anchoPlantaMin;
    }

    public int getAlturaPlantaMax() {
        return alturaPlantaMax;
    }

    public int getAlturaPlantaMin() {
        return alturaPlantaMin;
    }

    public int getDiesMinCultiu() {
        return diesMinCultiu;
    }

    public int getDiesMaxCultiu() {
        return diesMaxCultiu;
    }

    public CaracteristiquesPebrot(String scoville, String anchoPlanta, String colorFlor, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha) {


        int[] altura=format.getIntsFromStringWithNumberAndText(alturaPlanta);
        this.alturaPlantaMax=altura[1];
        this.alturaPlantaMin=altura[0];
        int[] ample= format.getIntsFromStringWithNumberAndText(anchoPlanta);
        this.anchoPlantaMax=ample[1];
        this.anchoPlantaMin=ample[0];
        this.rendimiento=rendimiento;
        int[] maxminScoville=format.setMaxAndMinScoville(scoville);
        this.minScoville=maxminScoville[0];
        if (maxminScoville.length==2)this.maxScoville=maxminScoville[1];
        int[] harvest= format.setMaxAndMinHarvestTime(tiempoMinimoCosecha);
        this.diesMaxCultiu= harvest[1];
        this.diesMinCultiu= harvest[0];
        String[] colors= format.setColorsOrColor(colorFlor);
        hexColors=new String[colors.length];
        for (int i = 0; i < hexColors.length; i++) {
            hexColors[i]=sc.getHtmlColorFromName(sc.translateToEnglish(colors[i]));
        }

        /// constructor revisat
    }
}
