package enciclopedia;

import enciclopedia.CaracteristiquesPebrot;
import enciclopedia.CultiuPebrot;
import enciclopedia.InfoPebrot;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

/**
 * Cadascun dels pebrots amb tota la seva informació i subclasses
 */
@XmlRootElement
public class Pebrot {


    private String nombre,img;


    private CultiuPebrot cultiuPebrot;
    private CaracteristiquesPebrot caracteristiquesPebrot;
    private InfoPebrot infoPebrot;

    /**Constructor amb tots els parametres per construir-lo
     * @param nombre
     * @param description
     * @param origen
     * @param distanciaEntrePlantas
     * @param distanciaEntreSemillas
     * @param scoville
     * @param anchoPlanta
     * @param familia
     * @param colorFlor
     * @param tempCrecimiento
     * @param luz
     * @param alturaPlanta
     * @param rendimiento
     * @param tiempoMinimoCosecha
     * @param profSemilla
     * @param tempGerminacion
     * @param img
     */
    public Pebrot(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {
        this.nombre=nombre;
        this.img = img;
        cultiuPebrot=new CultiuPebrot(profSemilla,distanciaEntrePlantas,distanciaEntreSemillas,tempCrecimiento,luz,tempGerminacion);
        caracteristiquesPebrot= new CaracteristiquesPebrot(scoville,anchoPlanta,colorFlor,alturaPlanta,rendimiento,tiempoMinimoCosecha);
        infoPebrot= new InfoPebrot(nombre,description,origen,familia);

    }

    /**
     * Constructor buit
     */
    public Pebrot() {
    }

    /**Constructor amb els parametres en array
     * @param pebrot array amb tots els parametres
     */
    public Pebrot(String[] pebrot) {
        this.nombre=pebrot[0];
        this.img = pebrot[pebrot.length-1];
        cultiuPebrot=new CultiuPebrot(pebrot[14],pebrot[3],pebrot[4],pebrot[9],pebrot[10],pebrot[pebrot.length-2]);
        caracteristiquesPebrot= new CaracteristiquesPebrot(pebrot[5],pebrot[6],pebrot[8],pebrot[11], pebrot[12],pebrot[13]);
        infoPebrot= new InfoPebrot(pebrot[0],pebrot[1],pebrot[2],pebrot[7]);
    }


    /**Retorna un string amb les dades del pebrot requerit
     * @param i index del pebrot a mostrar
     * @return String amb el pebrot de l'index concretat
     */
    public String toString(int i) {
        return "\nenciclopedia.Pebrot "+i+" {\n" +
                " nombre=" + nombre + '\n' +
                " img=" + img + '\n' +
                " cultiuPebrot=\n"+
                cultiuPebrot.toString() +
                " caracteristiquesPebrot=\n" +
                caracteristiquesPebrot.toString() +
                " infoPebrot=\n" +
                infoPebrot.toString() +
                "}";
    }

    /**getter de info Pebrot
     * @return l'objecte info pebrot
     */
    public InfoPebrot getInfoPebrot() {
        return infoPebrot;
    }

    /**getter del nom del pebrot
     * @return nom pebrot
     */
    public String getNombre() {
        return nombre;
    }

    /**getter de la imagen
     * @return enllaç imatge
     */
    public String getImg() {
        return img;
    }

    /**getter de l'objecte cultiu pebrot
     * @return l'objecte cultiu pebrot del pebrot actual
     */
    public CultiuPebrot getCultiuPebrot() {
        return cultiuPebrot;
    }

    /**getter de les característiques del pebrot
     * @return objecte caracteristiques pebrot
     */
    public CaracteristiquesPebrot getCaracteristiquesPebrot() {
        return caracteristiquesPebrot;
    }

    /**setter preparat per l'xml
     * @param nombre String del nom
     */
    // setters
    @XmlAttribute(name="nom")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**setter preparat per l'xml
     * @param img l'enllaç a la imatge
     */
    @XmlAttribute(name="img")
    public void setImg(String img) {
        this.img = img;
    }

    /**setter preparat per l'xml
     * @param cultiuPebrot objecte cultiu pebrot
     */
    @XmlElement
    public void setCultiuPebrot(CultiuPebrot cultiuPebrot) {
        this.cultiuPebrot = cultiuPebrot;
    }

    /**setter preparat per l'xml
     * @param caracteristiquesPebrot objecte característiques pebrot
     */
    @XmlElement
    public void setCaracteristiquesPebrot(CaracteristiquesPebrot caracteristiquesPebrot) {
        this.caracteristiquesPebrot = caracteristiquesPebrot;
    }

    /**setter preparat per l'xml
     * @param infoPebrot objecte infoPebrot
     */
    @XmlElement
    public void setInfoPebrot(InfoPebrot infoPebrot) {
        this.infoPebrot = infoPebrot;
    }
}
