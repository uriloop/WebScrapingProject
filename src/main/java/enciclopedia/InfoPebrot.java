package enciclopedia;

import utils.FormatingPebrots;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Arrays;
@XmlRootElement
public class InfoPebrot {

    private String nombre, descripcion,familia;

    private String[] origen;

    FormatingPebrots format;
    public InfoPebrot(String nombre, String description, String origen, String familia) {
        format= new FormatingPebrots();
        this.nombre= nombre;
        this.descripcion=description;
        this.familia=format.familyFilter(familia);
        this.origen= format.getValuesFromOrigen(origen);   /// En aquest cas guardaré com array per a probar. Després hauré de fer getters més concrets

        // constructor revisat

    }

    public InfoPebrot() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public String getOrigen() {
        String data= origen[0];
        if (origen.length==2) data+=", "+origen[1];
        return data;
    }

    @Override
    public String toString() {
        return "\nenciclopedia.InfoPebrot{\n" +
                "nombre='" + nombre + '\n' +
                ", descripcion='" + descripcion + '\n' +
                ", familia='" + familia + '\n' +
                ", origen=" + Arrays.toString(origen) +
                "\n}";
    }

    // setters

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @XmlElement
    public void setFamilia(String familia) {
        this.familia = familia;
    }
    @XmlElement
    public void setOrigen(String[] origen) {
        this.origen = origen;
    }
}
