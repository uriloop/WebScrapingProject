package enciclopedia;

import enciclopedia.CaracteristiquesPebrot;
import enciclopedia.CultiuPebrot;
import enciclopedia.InfoPebrot;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Pebrot implements Serializable {


    private String nombre,img;
    private long id;

    private CultiuPebrot cultiuPebrot;
    private CaracteristiquesPebrot caracteristiquesPebrot;
    private InfoPebrot infoPebrot;

    public Pebrot(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {
        this.nombre=nombre;
        this.id=hashCode();
        this.img = img;
        cultiuPebrot=new CultiuPebrot(profSemilla,distanciaEntrePlantas,distanciaEntreSemillas,tempCrecimiento,luz,tempGerminacion);
        caracteristiquesPebrot= new CaracteristiquesPebrot(scoville,anchoPlanta,colorFlor,alturaPlanta,rendimiento,tiempoMinimoCosecha);
        infoPebrot= new InfoPebrot(nombre,description,origen,familia);

    }

    public Pebrot() {
    }

    public Pebrot(String[] pebrot) {
        this.nombre=pebrot[0];
        this.img = pebrot[pebrot.length-1];
        cultiuPebrot=new CultiuPebrot(pebrot[14],pebrot[3],pebrot[4],pebrot[9],pebrot[10],pebrot[pebrot.length-2]);
        caracteristiquesPebrot= new CaracteristiquesPebrot(pebrot[5],pebrot[6],pebrot[8],pebrot[11], pebrot[12],pebrot[13]);
        infoPebrot= new InfoPebrot(pebrot[0],pebrot[1],pebrot[2],pebrot[7]);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


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

    public InfoPebrot getInfoPebrot() {
        return infoPebrot;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImg() {
        return img;
    }

    public CultiuPebrot getCultiuPebrot() {
        return cultiuPebrot;
    }

    public CaracteristiquesPebrot getCaracteristiquesPebrot() {
        return caracteristiquesPebrot;
    }

    // setters
    @XmlAttribute(name="nom")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlAttribute(name="img")
    public void setImg(String img) {
        this.img = img;
    }
    @XmlID
    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }
    @XmlElement
    public void setCultiuPebrot(CultiuPebrot cultiuPebrot) {
        this.cultiuPebrot = cultiuPebrot;
    }
    @XmlElement
    public void setCaracteristiquesPebrot(CaracteristiquesPebrot caracteristiquesPebrot) {
        this.caracteristiquesPebrot = caracteristiquesPebrot;
    }
    @XmlElement
    public void setInfoPebrot(InfoPebrot infoPebrot) {
        this.infoPebrot = infoPebrot;
    }
}
