package enciclopedia;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * És la classe encarregada de guardar la llista de pebrots
 */
@XmlRootElement(name="Biblioteca")
public class BibliotecaPebrots {


    private List<Pebrot> pebrotsList;

    /**
     * El constructor de la classe rep com a paràmetre  una llista de pebrots
     *
     * @param pebrotsList llista de pebrots que li passem al constructor
     */
    public BibliotecaPebrots(List<Pebrot> pebrotsList) {
        this.pebrotsList = pebrotsList;
    }


    /**
     * Constructor buit
     */
    public BibliotecaPebrots() {
    }

    /**Getter de la llista de pebrots
     *
     * @return Retorna la llista de pebrots
     */
    public List<Pebrot> getPebrotsList() {
        return pebrotsList;
    }


    /**Rep per pàrametre una llista de pebrots per construir una nova llista de pebrots carregant-la desde l'XML
     * @param pebrotsList   La llista que rep de l'XML
     */
    @XmlElement(name="pebrot")
    public void setPebrotsList(List<Pebrot> pebrotsList) {
        this.pebrotsList = pebrotsList;
    }

    /**
     * Destrueix la llista de pebrots
     */
    public void removeAllData() {
        pebrotsList.clear();
    }

    /**
     * to String de tota la biblioteca
     *
     * @return retorna un String amb la biblioteca de pebrots al complet
     */
    @Override
    public String toString() {
        String result = "\nenciclopedia.BibliotecaPebrots{\n" +
                "\n   pebrotsList{\n";
        int i=1;
        for (Pebrot pebrot:
             pebrotsList) {
            result+=pebrot.toString(i)+"\n";
            i++;
        }
        result += "\n}";


        return result;
    }

}
