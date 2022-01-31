package file.acces;

import enciclopedia.BibliotecaPebrots;
import enciclopedia.Pebrot;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Classe que s'encarrega de llegir i escriure en xml amb la llibreria DOM
 */
public class CreateXML {

    /**Escriu la biblioteca de pebrots en format xml
     * @param biblioteca la biblioteca per agafar les dades
     * @param file  l'arxiu on treballarem
     */
    public void write(BibliotecaPebrots biblioteca, File file) {
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Root element
            Element rootElement = document.createElement("biblioteca");


            // grau element

            Element pebrotsList = document.createElement("pebrots");


            int i = 0;
            for (Pebrot pebrot :
                    biblioteca.getPebrotsList()) {
                i++;
                Element pebr = document.createElement("pebrot");
                pebr.setAttribute("id",String.valueOf(i));
                pebr.setAttribute("img", pebrot.getImg());

                // creo els elements principals
                Element info = document.createElement("informacio");
                Element carac = document.createElement("caracteristiques");
                Element cultiu= document.createElement("cultiu");


                // info

                Element dato = document.createElement("nom");
                dato.setTextContent(pebrot.getInfoPebrot().getNombre());
                info.appendChild(dato);

                dato = document.createElement("descripcion");
                dato.setTextContent(pebrot.getInfoPebrot().getDescripcion());
                info.appendChild(dato);

                dato = document.createElement("familia");
                dato.setTextContent(pebrot.getInfoPebrot().getFamilia());
                info.appendChild(dato);

                dato = document.createElement("origen");

                for (String origen:
                     pebrot.getInfoPebrot().getOrigen()) {
                    Element origenEle= document.createElement("origen");
                    origenEle.setTextContent(origen);
                    dato.appendChild(origenEle);
                }
                info.appendChild(dato);

                pebr.appendChild(info);

                // caracteristiques

                dato = document.createElement("anchoPlanta");
                Element subDato= document.createElement("max");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getAnchoPlantaMax()));
                dato.appendChild(subDato);
                subDato= document.createElement("min");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getAnchoPlantaMin()));
                dato.appendChild(subDato);
                carac.appendChild(dato);

                dato = document.createElement("alturPlanta");
                subDato= document.createElement("max");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getAlturaPlantaMax()));
                dato.appendChild(subDato);
                subDato= document.createElement("min");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getAlturaPlantaMin()));
                dato.appendChild(subDato);
                carac.appendChild(dato);

                dato = document.createElement("diesCultiu");
                subDato= document.createElement("max");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getDiesMaxCultiu()));
                dato.appendChild(subDato);
                subDato= document.createElement("min");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getDiesMinCultiu()));
                dato.appendChild(subDato);
                carac.appendChild(dato);

                dato = document.createElement("hexColors");
                for (String color :
                        pebrot.getCaracteristiquesPebrot().getHexColors()) {
                    Element hex = document.createElement("color");
                    hex.setTextContent(color);
                    dato.appendChild(hex);
                }
                carac.appendChild(dato);

                dato = document.createElement("rendimiento");
                dato.setTextContent(pebrot.getCaracteristiquesPebrot().getRendimiento());
                carac.appendChild(dato);


                dato = document.createElement("scoville");
                subDato= document.createElement("max");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getMaxScoville()));
                dato.appendChild(subDato);
                subDato= document.createElement("min");
                subDato.setTextContent(String.valueOf(pebrot.getCaracteristiquesPebrot().getMinScoville()));
                dato.appendChild(subDato);
                carac.appendChild(dato);

                pebr.appendChild(carac);

                // cultiu

                dato= document.createElement("profLlavor");
                dato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getProfSemilla()));
                dato.setAttribute("mesura","cm");
                cultiu.appendChild(dato);
                dato= document.createElement("distLlavors");
                dato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getDistanciaEntreSemillas()));
                dato.setAttribute("mesura","cm");
                cultiu.appendChild(dato);
                dato= document.createElement("distPlantes");
                dato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getDistanciaEntrePlantes()));
                dato.setAttribute("mesura","cm");
                cultiu.appendChild(dato);
                dato= document.createElement("llum");
                dato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getLuz()));
                cultiu.appendChild(dato);

                dato = document.createElement("tempGerminacio");
                dato.setAttribute("mesura","ºC");
                subDato= document.createElement("max");
                subDato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getTempGerminacionMax()));
                dato.appendChild(subDato);
                subDato= document.createElement("min");
                subDato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getTempGerminacionMin()));
                dato.appendChild(subDato);
                carac.appendChild(dato);

                dato = document.createElement("tempCreixement");
                dato.setAttribute("mesura","ºC");
                subDato= document.createElement("max");
                subDato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getTempCrecimientoMax()));
                dato.appendChild(subDato);
                subDato= document.createElement("min");
                subDato.setTextContent(String.valueOf(pebrot.getCultiuPebrot().getTempCrecimientoMin()));
                dato.appendChild(subDato);
                carac.appendChild(dato);


                pebr.appendChild(cultiu);

                pebrotsList.appendChild(pebr);

            }
            rootElement.appendChild(pebrotsList);

            document.appendChild(rootElement);

            // Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);

            // Output to console (testing)
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
