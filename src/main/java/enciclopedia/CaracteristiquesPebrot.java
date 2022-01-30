package enciclopedia;

import file.acces.Csv;
import utils.FormatingPebrots;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import web.scraping.ScrapingClass;

import java.io.File;
import java.util.Arrays;

/**
 * Un grup d'informació que engloba característiques per cada pebrot tenim un grup de característiques
 *
 */
@XmlRootElement
public class CaracteristiquesPebrot {


    private String rendimiento;
    private String[] hexColors;
    private int minScoville, maxScoville;
    private int anchoPlantaMax, anchoPlantaMin, alturaPlantaMax, alturaPlantaMin;
    private int diesMinCultiu, diesMaxCultiu;
    FormatingPebrots format;
    ScrapingClass sc;
    Csv csv;

    /**
     * El constructor de la classe rep varios parametres amb la informació del pebrot
     *
     * @param scoville  String Picant del pebrot. exmp: "100.000 hasta 200.000 scoville"
     * @param anchoPlanta String exmppl: "40 - 50 cm"
     * @param colorFlor String exmp: "blanco/amarillo"
     * @param alturaPlanta String exmpl: "40 - 50 cm"
     * @param rendimiento String exmpl: "Bueno"
     * @param tiempoMinimoCosecha  String exmpl: 60 - 90 dias"
     */
    public CaracteristiquesPebrot(String scoville, String anchoPlanta, String colorFlor, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha) {
        format = new FormatingPebrots();
        sc = new ScrapingClass();
        csv= new Csv(new File("src/dades/colorChart.csv"));


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
            hexColors[i] = csv.getHtmlColorFromCSVChart(colors[i]);
        }

        /// constructor revisat
    }

    /**
     * Constructor buit
     */
    public CaracteristiquesPebrot() {
    }

    /**
     * @return retorna l'string amb les característiques ja tractades
     */
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

    /**getter de rendiment
     * @return String rendimiento
     */
    public String getRendimiento() {
        return rendimiento;
    }

    /**getter dels colors en format hex
     * @return String[] de colors html
     */
    public String[] getHexColors() {
        return hexColors;
    }

    /**getter scoville min
     * @return int del min scoville
     */
    public int getMinScoville() {
        return minScoville;
    }

    /**getter de max scoville
     * @return int max scoville
     */
    public int getMaxScoville() {
        return maxScoville;
    }

    /**getter de ancho planta maximo
     * @return int ancho planta max
     */
    public int getAnchoPlantaMax() {
        return anchoPlantaMax;
    }

    /**getter del ancho planta minimo
     * @return int ancho planta minimo
     */
    public int getAnchoPlantaMin() {
        return anchoPlantaMin;
    }

    /**getter
     * @return int altura planta max
     */
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
