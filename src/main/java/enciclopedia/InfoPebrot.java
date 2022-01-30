package enciclopedia;

import utils.FormatingPebrots;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Arrays;

/**
 * Conté la informació general del pebrot
 */
@XmlRootElement
public class InfoPebrot {

    private String nombre, descripcion,familia;

    private String[] origen;

    FormatingPebrots format;

    /**Constructor amb tots els parametres a introduir
     * @param nombre nom del pebrot String
     * @param description descripció del pebrot
     * @param origen origen del pebrot
     * @param familia familia del pebrot
     */
    public InfoPebrot(String nombre, String description, String origen, String familia) {
        format= new FormatingPebrots();
        this.nombre= nombre;
        this.descripcion=description;
        this.familia=format.familyFilter(familia);
        this.origen= format.getValuesFromOrigen(origen);   /// En aquest cas guardaré com array per a probar. Després hauré de fer getters més concrets

        // constructor revisat

    }

    /**
     * Constructor buit
     */
    public InfoPebrot() {
    }

    /**getter del nom
     * @return nom en format String
     */
    public String getNombre() {
        return nombre;
    }

    /**getter de la descripció
     * @return descripcio del pebrot
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**getter de la familia
     * @return String familia
     */
    public String getFamilia() {
        return familia;
    }

    /**getter origen
     * @return String amb l'origen o origens
     */
    public String getOrigen() {
        String data= origen[0];
        if (origen.length==2) data+=", "+origen[1];
        return data;
    }

    /**el to string sobreescrit
     * @return la info del pebrot to String
     */
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

    /**setter preparat per l'xml
     * @param nombre String amb el nom
     */
    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**setter preparat per l'xml
     * @param descripcion String amb la descripció
     */
    @XmlElement
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**setter preparat per l'xml
     * @param familia String familia
     */
    @XmlElement
    public void setFamilia(String familia) {
        this.familia = familia;
    }

    /**setter preparat per l'xml
     * @param origen origen o origens en format string
     */
    @XmlElement
    public void setOrigen(String[] origen) {
        this.origen = origen;
    }
}
