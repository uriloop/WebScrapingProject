package enciclopedia;

import utils.FormatingPebrots;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Classe amb les dades que es refereixen al cultiu de un pebrot.
 */
@XmlRootElement
public class CultiuPebrot {


    private float profSemilla;
    private int distanciaEntrePlantes,  tempCrecimientoMax , tempCrecimientoMin;
    private int tempGerminacionMin, tempGerminacionMax, distanciaEntreSemillas;
    private String luz;

    FormatingPebrots format= new FormatingPebrots();

    /**
     * constructor amb totes les dades del cultiu passades per parametre
     * @param profSemilla String amb la profunditat a la que plantar la llavor
     * @param distanciaEntrePlantas String amb la distancia max i min entre pllantes
     * @param distanciaEntreSemillas String amb la distancia max i min entre llavors
     * @param tempCrecimiento String amb les temperatures optimes pel creixement
     * @param luz String amb la llum que requereix
     * @param tempGerminacion String amb les temperatures optimes per germinar
     */
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
        // revisat
    }

    /**
     * constructor buit
     */
    public CultiuPebrot() {
    }

    /**metode to string sobreescrit
     * @return string amb totes les dades de cultiu del pebrot
     */
    @Override
    public String toString() {
        return "\nenciclopedia.CultiuPebrot{\n" +
                "profSemilla=" + profSemilla +
                "\n, distanciaEntrePlantes=" + distanciaEntrePlantes +
                "\n, tempCrecimientoMax=" + tempCrecimientoMax +
                "\n, tempCrecimientoMin=" + tempCrecimientoMin +
                "\n, tempGerminacionMin=" + tempGerminacionMin +
                "\n, tempGerminacionMax=" + tempGerminacionMax +
                "\n, distanciaEntreSemillas=" + distanciaEntreSemillas +
                "\n, luz='" + luz +
                "\n}";
    }

    /**getter de datos
     * @return prof semilla
     */
    public float getProfSemilla() {
        return profSemilla;
    }

    /**getter de datos
     * @return dist plantes
     */
    public int getDistanciaEntrePlantes() {
        return distanciaEntrePlantes;
    }

    /**getter de datos
     * @return temp creixement
     */
    public int getTempCrecimientoMax() {
        return tempCrecimientoMax;
    }

    /**getter de datos
     * @return  temp creixement
     */
    public int getTempCrecimientoMin() {
        return tempCrecimientoMin;
    }

    /**getter de datos
     * @return temp germinacio
     */
    public int getTempGerminacionMin() {
        return tempGerminacionMin;
    }

    /**getter de datos
     * @return temp germinacio
     */
    public int getTempGerminacionMax() {
        return tempGerminacionMax;
    }

    /**getter de datos
     * @return dist semillas
     */
    public int getDistanciaEntreSemillas() {
        return distanciaEntreSemillas;
    }

    /**getter de datos
     * @return luz
     */
    public String getLuz() {
        return luz;
    }

    /// Setters

    /**setter para el JAXB
     * @param profSemilla parametre
     */
    @XmlElement
    public void setProfSemilla(float profSemilla) {
        this.profSemilla = profSemilla;
    }

    /**setter para el JAXB
     * @param distanciaEntrePlantes parametre
     */
    @XmlElement
    public void setDistanciaEntrePlantes(int distanciaEntrePlantes) {
        this.distanciaEntrePlantes = distanciaEntrePlantes;
    }

    /**setter para el JAXB
     * @param tempCrecimientoMax  parametre
     */
    @XmlElement
    public void setTempCrecimientoMax(int tempCrecimientoMax) {
        this.tempCrecimientoMax = tempCrecimientoMax;
    }

    /**setter para el JAXB
     * @param tempCrecimientoMin parametre
     */
    @XmlElement
    public void setTempCrecimientoMin(int tempCrecimientoMin) {
        this.tempCrecimientoMin = tempCrecimientoMin;
    }

    /**setter para el JAXB
     * @param tempGerminacionMin parametre
     */
    @XmlElement
    public void setTempGerminacionMin(int tempGerminacionMin) {
        this.tempGerminacionMin = tempGerminacionMin;
    }

    /**setter para el JAXB
     * @param tempGerminacionMax parametre
     */
    @XmlElement
    public void setTempGerminacionMax(int tempGerminacionMax) {
        this.tempGerminacionMax = tempGerminacionMax;
    }

    /**setter para el JAXB
     * @param distanciaEntreSemillas parametre
     */
    @XmlElement
    public void setDistanciaEntreSemillas(int distanciaEntreSemillas) {
        this.distanciaEntreSemillas = distanciaEntreSemillas;
    }

    /**setter para el JAXB
     * @param luz parametre
     */
    @XmlElement
    public void setLuz(String luz) {
        this.luz = luz;
    }
}
