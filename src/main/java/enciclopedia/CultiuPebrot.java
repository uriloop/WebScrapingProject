package enciclopedia;

import utils.FormatingPebrots;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
        // revisat
    }

    public CultiuPebrot() {
    }

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
