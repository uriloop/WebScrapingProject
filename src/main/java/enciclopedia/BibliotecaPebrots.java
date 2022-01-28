package enciclopedia;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="Biblioteca")
public class BibliotecaPebrots {


    private List<Pebrot> pebrotsList;

    public BibliotecaPebrots(List<Pebrot> pebrotsList) {
        this.pebrotsList = pebrotsList;
    }



    public BibliotecaPebrots() {
    }

    public List<Pebrot> getPebrotsList() {
        return pebrotsList;
    }

    @XmlElement
    public void setPebrotsList(List<Pebrot> pebrotsList) {
        this.pebrotsList = pebrotsList;
    }

    public void removeAllData() {
        pebrotsList.clear();
    }

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
