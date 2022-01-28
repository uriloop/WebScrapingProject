package file.acces;

import enciclopedia.BibliotecaPebrots;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MyJAXB {

    private BibliotecaPebrots biblioteca;

    public MyJAXB() {
    }

    public void generateXML(BibliotecaPebrots enciclopedia, File file) {
        biblioteca = enciclopedia;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BibliotecaPebrots.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(biblioteca, file);
            jaxbMarshaller.marshal(biblioteca, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

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
