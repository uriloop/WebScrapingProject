package enciclopedia;

import utils.FormatingPebrots;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import web.scraping.ScrapingClass;

import java.util.Arrays;

@XmlRootElement
public class CaracteristiquesPebrot {


    private String rendimiento;
    private String[] hexColors;
    private int minScoville, maxScoville;
    private int anchoPlantaMax, anchoPlantaMin, alturaPlantaMax, alturaPlantaMin;
    private int diesMinCultiu, diesMaxCultiu;
    FormatingPebrots format;
    ScrapingClass sc;

    public CaracteristiquesPebrot(String scoville, String anchoPlanta, String colorFlor, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha) {
        format = new FormatingPebrots();
        sc = new ScrapingClass();

        int[] altura = format.getIntsFromStringWithNumberAndText(alturaPlanta);
        this.alturaPlantaMax = altura[1];
        this.alturaPlantaMin = altura[0];
        int[] ample = format.getIntsFromStringWithNumberAndText(anchoPlanta);
        this.anchoPlantaMax = ample[1];
        this.anchoPlantaMin = ample[0];
        this.rendimiento = rendimiento;
        int[] maxminScoville = format.setMaxAndMinScoville(scoville);
        this.minScoville = maxminScoville[0];
        if (maxminScoville.length == 2) this.maxScoville = maxminScoville[1];
        int[] harvest = format.setMaxAndMinHarvestTime(tiempoMinimoCosecha);
        this.diesMaxCultiu = harvest[1];
        this.diesMinCultiu = harvest[0];
        String[] colors = format.setColorsOrColor(colorFlor);
        hexColors = new String[colors.length];
        for (int i = 0; i < hexColors.length; i++) {
            hexColors[i] = sc.getHtmlColorFromName(sc.translateToEnglish(colors[i]));
        }

        /// constructor revisat
    }

    public CaracteristiquesPebrot() {
    }

    @Override
    public String toString() {
        return "\nenciclopedia.CaracteristiquesPebrot{" +
                "\nrendimiento='" + rendimiento +
                "\n, hexColors=" + Arrays.toString(hexColors) +
                "\n, minScoville=" + minScoville +
                "\n, maxScoville=" + maxScoville +
                "\n, anchoPlantaMax=" + anchoPlantaMax +
                "\n, anchoPlantaMin=" + anchoPlantaMin +
                "\n, alturaPlantaMax=" + alturaPlantaMax +
                "\n, alturaPlantaMin=" + alturaPlantaMin +
                "\n, diesMinCultiu=" + diesMinCultiu +
                "\n, diesMaxCultiu=" + diesMaxCultiu +
                "\n}";
    }

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

    // setters


    @XmlElement
    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }
    @XmlElement
    public void setHexColors(String[] hexColors) {
        this.hexColors = hexColors;
    }
    @XmlElement
    public void setMinScoville(int minScoville) {
        this.minScoville = minScoville;
    }
    @XmlElement
    public void setMaxScoville(int maxScoville) {
        this.maxScoville = maxScoville;
    }
    @XmlElement
    public void setAnchoPlantaMax(int anchoPlantaMax) {
        this.anchoPlantaMax = anchoPlantaMax;
    }
    @XmlElement
    public void setAnchoPlantaMin(int anchoPlantaMin) {
        this.anchoPlantaMin = anchoPlantaMin;
    }
    @XmlElement
    public void setAlturaPlantaMax(int alturaPlantaMax) {
        this.alturaPlantaMax = alturaPlantaMax;
    }
    @XmlElement
    public void setAlturaPlantaMin(int alturaPlantaMin) {
        this.alturaPlantaMin = alturaPlantaMin;
    }
    @XmlElement
    public void setDiesMinCultiu(int diesMinCultiu) {
        this.diesMinCultiu = diesMinCultiu;
    }
    @XmlElement
    public void setDiesMaxCultiu(int diesMaxCultiu) {
        this.diesMaxCultiu = diesMaxCultiu;
    }
}
