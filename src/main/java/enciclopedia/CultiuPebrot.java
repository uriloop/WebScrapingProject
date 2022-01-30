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

    /// Setters

    @XmlElement
    public void setProfSemilla(float profSemilla) {
        this.profSemilla = profSemilla;
    }
    @XmlElement
    public void setDistanciaEntrePlantes(int distanciaEntrePlantes) {
        this.distanciaEntrePlantes = distanciaEntrePlantes;
    }
    @XmlElement
    public void setTempCrecimientoMax(int tempCrecimientoMax) {
        this.tempCrecimientoMax = tempCrecimientoMax;
    }
    @XmlElement
    public void setTempCrecimientoMin(int tempCrecimientoMin) {
        this.tempCrecimientoMin = tempCrecimientoMin;
    }
    @XmlElement
    public void setTempGerminacionMin(int tempGerminacionMin) {
        this.tempGerminacionMin = tempGerminacionMin;
    }
    @XmlElement
    public void setTempGerminacionMax(int tempGerminacionMax) {
        this.tempGerminacionMax = tempGerminacionMax;
    }
    @XmlElement
    public void setDistanciaEntreSemillas(int distanciaEntreSemillas) {
        this.distanciaEntreSemillas = distanciaEntreSemillas;
    }
    @XmlElement
    public void setLuz(String luz) {
        this.luz = luz;
    }
}
