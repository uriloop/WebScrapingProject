package file.acces;

import enciclopedia.BibliotecaPebrots;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe encaarregada de llegir i escriure amb JAXB
 */
public class MyJAXB {

    private BibliotecaPebrots biblioteca;

    /**
     * Classe encarregada de escriure i llegir arxius XML
     */
    public MyJAXB() {
    }

    /**genera un arxiu xml a partir de la classe BibliotecaPebrots
     * @param enciclopedia la biblioteca de pebrots a introduir
     * @param file l'arxiu on treballar
     */
    public void generateXML(BibliotecaPebrots enciclopedia, File file) {
        biblioteca = enciclopedia;
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(biblioteca.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(biblioteca, new File("src/dades/pebrotsXML.xml"));
            jaxbMarshaller.marshal(biblioteca, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    /**Carrega la classe biblioteca pebrots a partir d'un arxiu xml
     * @param enciclopedia l'objecte biblioteca a carregar
     * @param file l'arxiu d'on extreyure les dades
     */
    public void generateObjectsFromXML(BibliotecaPebrots enciclopedia, File file) {
        biblioteca=enciclopedia;
        try {
            JAXBContext context = JAXBContext.newInstance(BibliotecaPebrots.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Akí carreguem la informació del xml a l'objecte biblioteca
            biblioteca=(BibliotecaPebrots) unmarshaller.unmarshal(new FileReader(file));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**Imprimeix per pantalla l'xml
     * @param enciclopedia La classe on carregar els objectes
     * @param file l'arxiu on es troba l'xml
     */
    public void printFromXML(BibliotecaPebrots enciclopedia,File file) {
        biblioteca=enciclopedia;
        try {
            JAXBContext context = JAXBContext.newInstance(BibliotecaPebrots.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Akí carreguem la informació del xml a l'objecte biblioteca
            biblioteca=(BibliotecaPebrots) unmarshaller.unmarshal(new FileReader(file));

            System.out.println(biblioteca.toString());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
