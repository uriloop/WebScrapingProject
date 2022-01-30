package web.scraping;

import java.io.File;

import file.acces.Csv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Classe encarregada dels diferents web scrapings que fem sobre diferents webs per obtenir dades. Utilitza el webdriver selenium.
 */
public class ScrapingClass {

    File file;
    String[] pimientos;

    /**constructor on s'especifica l'arxiu amb el que treballar
     * @param file L'arxiu on volem guardar les dades
     */
    public ScrapingClass(File file) {
        this.file = file;
    }

    /**
     * Constructor buit
     */
    public ScrapingClass() {

    }

    /** Comprova que la dada que li passem concorda amb la variable.
     * @param camp el tipus de dada
     * @param nomDades les dades amb el tipus de dada tot junt en un string
     * @return retorna 1 si concorda, 0 i -1 si falla
     */
    private int comprobarConcordancia(String camp, String nomDades) {
        try {
            if (camp.toLowerCase(Locale.ROOT).equals(nomDades.split(":")[0].toLowerCase(Locale.ROOT))) return 1;
            return 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    /** Fa scraping d'una taulaa de colors i la retorna en format List<String[]>
     * @return  retorna una taula de colors amb noms i format html
     */
    public List<String[]> getHtmlColorWebChart() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem

        driver.get("https://www.disfrutalasmatematicas.com/numeros/hexadecimales-colores-nombres.html"); // aki posar la nova web.
//        driver.switchTo().alert().accept();

////////////////////////////
        List<String[]> colorChart = new ArrayList<>();
        List<WebElement> taula = driver.findElements(new By.ByXPath("/html/body/article/table/tbody//tr"));
        for (WebElement element :
                taula) {
            List<WebElement> rowElements = element.findElements(new By.ByTagName("td"));
            String[] colorRow = new String[3];
            for (int i = 0; i < rowElements.size(); i++) {
                colorRow[i] = rowElements.get(i).getText();
            }
            colorChart.add(colorRow);
        }
        return colorChart;

    }

    /**Traduir de castellà a anglés
     * @param word paraula a traduir
     * @return paraula traduida
     */
    public String translateToEnglishCambridge(String word) {


        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem
        String word2 = "";


        driver.get("https://dictionary.cambridge.org/es/translate/"); // aki posar la nova web.

        driver.switchTo().alert().accept();
        WebElement popUp;  // manejar el pop up de cookies
        popUp = driver.findElement(new By.ById("onetrust-accept-btn-handler"));
        popUp.click();
        WebElement switchButton = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div[4]/form/div[2]/a/i"));
        switchButton.click();
        WebElement textArea = driver.findElement(new By.ByXPath("//*[@id=\"txtTrans\"]"));
        textArea.sendKeys(word);
        /// Hi ha un problema. El camp que vull agafar ja existeix, és a dir, vull agafar el valor d'un camp pero quan l'agafo encara no té el valor de la traducció
        WebElement acceptButton = driver.findElement(new By.ByXPath("//*[@id=\"button-submit\"]"));
        acceptButton.click();
        WebElement result;
        result = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[2]/div[4]/form/div[3]/div[2]/div/a"));
        word2 = result.getText();
        while (word2.equals("") || word2.equals(null)) {
            word2 = result.getText();
            System.out.println("(dins del while)Paraula 2: " + result);
        }
        System.out.println("La paraula a buscar: " + word);
        System.out.println("La traducció: " + word2);

        driver.close();
        return word2;
    }

    /** Traduir de castellà a anglés
     * @param word paraula a traduir
     * @return paraula traduida
     */
    public String translateToEnglish1(String word) {


        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem
        String word2 = "";
        driver.get("https://www.google.com/search?q=espa%C3%B1ol+ingl%C3%A9s&spell=1&sa=X&ved=2ahUKEwi35rL_89H1AhUNzoUKHVCFBOkQBSgAegQIARAz&biw=1222&bih=640&dpr=1.25"); // aki posar la nova web.
        driver.manage().window().minimize();
        WebElement acceptButton;
        driver.manage().deleteAllCookies();


        if ((acceptButton = driver.findElement(new By.ByXPath("//*[@id=\"L2AGLb\"]"))).isDisplayed()) {
            acceptButton.click();
        }
        WebElement textArea = driver.findElement(new By.ByXPath("//*[@id=\"tw-source-text-ta\"]"));
        textArea.sendKeys(word);
        WebElement result = driver.findElement(new By.ByXPath("//*[@id=\"tw-target-text\"]/span"));
        word2 = result.getText();
        while (word2.equals("Traducción") || word2.equals("Traduciendo...")) {
            word2 = result.getText();
        }
        driver.close();
        return word2;
    }

    /** Traduir de castellà a anglés
     * @param word paraula a traduir
     * @return paraula traduida
     */
    public String translateToEnglish(String word) {


        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem
        String word2 = "";


        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.politraductor.com/traductor-espanol-ingles/"); // aki posar la nova web.

        WebElement textArea;
        textArea = driver.findElement(new By.ByXPath("//*[@id=\"texto\"]"));
        textArea.sendKeys(word);
        /// Hi ha un problema. El camp que vull agafar ja existeix, és a dir, vull agafar el valor d'un camp pero quan l'agafo encara no té el valor de la traducció
        WebElement acceptButton = driver.findElement(new By.ByXPath("//*[@id=\"boton_traducir\"]"));
        acceptButton.click();
        WebElement result;
        result = driver.findElement(new By.ByXPath("//*[@id=\"resultado-traduccion\"]"));
        try {
            wdw.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        word2 = result.getText();
        while (word2.equals("") || word2.equals(null)) {
            word2 = result.getText();
            System.out.println("(dins del while)Paraula 2: " + result);
        }
        System.out.println("La paraula a buscar: " + word);
        System.out.println("La traducció: " + word2);

        driver.close();
        return word2;
    }


    /**Descarrega de la web el holandes picante, les urls dels pebrots que tenen a la enciclopedia de chiles picantes
     * @return un array amb les urls dels pebrots que scrapegem de la web el holandes picante
     */
    public String[] getPimientosURL() {

        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);


        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem

        driver.get("https://elholandespicante.com/enciclopedia-de-chiles/");

        // Ens quedem amb tots els tags o etiquetes <a> i els guardem a una llista de elements web

        List<WebElement> wesPimientos = driver.findElements(new By.ByXPath("//*[contains(@class, 'tw-column')]//li/a"));

        // Guardem cadascún dels href de cada <a> com un string a una llista i imprimim un asterisc per a cada pebrot mostrant al final el numero total de pebrots guardats

        int num = 0;
        pimientos = new String[wesPimientos.size()];
        System.out.print("Download domains    ");
        for (WebElement pimiento : wesPimientos
        ) {
            //guardem <href> en forma d'string
            pimientos[num] = pimiento.getAttribute("href");
            num++;
            // per cada href q ens guardem imprimim un asterisc, cada 50, canvi de linia
            if (num % 50 == 0) System.out.print("\n*");
            else System.out.print("*");
        }
        System.out.println("Total pimientos = " + num);

        driver.close();

        return pimientos;
    }

    /** descarrega un seguit de pebrots, si volem descarregar un utilitzar el mateix metode pero passarli només un string
     * @param urls Strings de les urls dels pebrots a buscar
     */
    public void getPimientosInfo(String[] urls) {


        for (String pimiento :
                urls) {
            getPimientosInfo(pimiento);

        }


    }


    /**Descrrega les dades d'un pebrot de la url corresponent
     * @param s url del pebrot que volem descarregar les dades
     */
    public void getPimientosInfo(String s) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        String nombre, img, description = "", origen = "Origen", distanciaEntrePlantas = "Distancia entre plantas", distanciaEntreSemillas = "Distancia entre semillas", scoville = "Scoville", anchoPlanta = "Ancho de la planta", familia = "Familia", colorFlor = "Color de la flor",
                tempCrecimiento = "Temperatura para crecer", luz = "Luz", alturaPlanta = "Altura de la planta", rendimiento = "Rendimiento", tiempoMinimoCosecha = "Tiempo mínimo para la cosecha", profSemilla = "Profundidad para sembrar", tempGerminacion = "Temperatura para la germinación";
        // anem a cadascuna de les paginesde pimientos   fer amb forkJoins?

        driver.get(s);


        WebElement we = driver.findElement(new By.ByClassName("postcontent"));
        nombre = we.findElement(new By.ByTagName("img")).getAttribute("alt");

        we.findElement(By.tagName("img")).getAttribute("src");
        img = we.findElement(new By.ByTagName("img")).getAttribute("src");

        List<WebElement> desc = we.findElements(new By.ByTagName("p"));
        for (WebElement p : desc
        ) {
            if (p.getText().length() > 20) {
                description = p.getText();

            }
        }
        List<WebElement> dadesColumn = we.findElements(new By.ByClassName("tw-column"));

        // Com no tots els pebrots tenen la descripció al mateix paragraf els agafo tots i em quedo amb el que és més gran de 20.

        StringBuilder dadesS = new StringBuilder();
        for (WebElement column :
                dadesColumn) {
            dadesS.append("\n").append(column.getText());
            /*dades.add(column.getText());*/
        }
        String[] linies = dadesS.toString().split("\n");
        for (int i = 1; i < linies.length; i++) {

            if (comprobarConcordancia(origen, linies[i]) > 0) {
                origen = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(distanciaEntrePlantas, linies[i]) > 0) {
                distanciaEntrePlantas = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(distanciaEntreSemillas, linies[i]) > 0) {
                distanciaEntreSemillas = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(scoville, linies[i]) > 0) {
                scoville = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(anchoPlanta, linies[i]) > 0) {
                anchoPlanta = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(familia, linies[i]) > 0) {
                try {
                    familia = linies[i].split(":")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    familia = "NotFound";
                }
            }
            if (comprobarConcordancia(colorFlor, linies[i]) > 0) {
                colorFlor = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(tempCrecimiento, linies[i]) > 0) {
                tempCrecimiento = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(luz, linies[i]) > 0) {
                luz = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(alturaPlanta, linies[i]) > 0) {
                alturaPlanta = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(rendimiento, linies[i]) > 0) {
                rendimiento = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(tiempoMinimoCosecha, linies[i]) > 0) {
                tiempoMinimoCosecha = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(profSemilla, linies[i]) > 0) {
                profSemilla = linies[i].split(":")[1];
            }
            if (comprobarConcordancia(tempGerminacion, linies[i]) > 0) {
                tempGerminacion = linies[i].split(":")[1];
            }
        }


        System.out.println("nombre= " + nombre);
        System.out.println("descripcion= " + description);
        System.out.println("Origen" + origen);
        System.out.println("distanciaEntrePlantas= " + distanciaEntrePlantas);
        System.out.println("distanciaEntreSemillas= " + distanciaEntreSemillas);
        System.out.println("Scoville= " + scoville);
        System.out.println("Ancho planta= " + anchoPlanta);
        System.out.println("familia= " + familia);
        System.out.println("color flor= " + colorFlor);
        System.out.println("Temp crecimiento= " + tempCrecimiento);
        System.out.println("luz= " + luz);
        System.out.println("altura= " + alturaPlanta);
        System.out.println("rendimiento= " + rendimiento);
        System.out.println("tiemp min cosecha= " + tiempoMinimoCosecha);
        System.out.println("prof semilla= " + profSemilla);
        System.out.println("Temp germinacion= " + tempGerminacion);
        System.out.println("img= " + img);

        // Iniciem la classe csv
        Csv csv = new Csv(file);
        // Li passem la informació a la classe encarregada d'escrriure el csv juntament amb tots els paràmetres
        csv.newPimientoToCSV(nombre, description, origen, distanciaEntrePlantas, distanciaEntreSemillas, scoville, anchoPlanta, familia, colorFlor,
                tempCrecimiento, luz, alturaPlanta, rendimiento, tiempoMinimoCosecha, profSemilla, tempGerminacion, img);

        // Avisem per terminal de quin pebrot hem descarregat  i la url d'on s'han descarregat les dades
        System.out.println("--------------------------");
        System.out.println("--> variables guardadas de " + nombre + "  --  " + driver.getCurrentUrl());
        System.out.println("--------------------------");
        driver.close();


    }

    /*public String getHtmlColorFromName(String colorName) {

        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);


        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem

        driver.get("https://www.colorhexa.com/");
        WebElement searchInput = driver.findElement(new By.ByXPath("//*[@id=\"search-input\"]"));
        driver.getCurrentUrl();
        searchInput.sendKeys(colorName*//*translateToEnglish(colorName)   Aixó ha d'anar encapsulat. No enllaçar els mètodes !!!!*//*);
        WebElement searchButton = driver.findElement(new By.ByXPath("//*[@id=\"search-submit\"]"));
        searchButton.click();
        driver.getCurrentUrl();
        searchInput = driver.findElement(new By.ByXPath("//*[@id=\"search-input\"]"));
        String colorHtml = searchInput.getAttribute("value");
        driver.close();
        return colorHtml;
    }*/
}
