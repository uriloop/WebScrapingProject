import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ScrapingClass {

    File file;
    String[] pimientos;

    public ScrapingClass(File file) {
        this.file = file;
    }

    public ScrapingClass() {

    }

    public String getHtmlColorFromName(String colorName) {

        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);


        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem

        driver.get("https://www.colorhexa.com/");
        WebElement searchInput = driver.findElement(new By.ByXPath("//*[@id=\"search-input\"]"));
        driver.getCurrentUrl();
        searchInput.sendKeys(colorName/*translateToEnglish(colorName)   Aixó ha d'anar encapsulat. No enllaçar els mètodes !!!!*/);
        WebElement searchButton = driver.findElement(new By.ByXPath("//*[@id=\"search-submit\"]"));
        searchButton.click();
        driver.getCurrentUrl();
        searchInput = driver.findElement(new By.ByXPath("//*[@id=\"search-input\"]"));
        String colorHtml = searchInput.getAttribute("value");
        driver.close();
        return colorHtml;
    }

    public String translateToEnglish(String word) {


        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);


        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem
        String word2="";

        try {

            driver.get("https://www.politraductor.com/traductor-espanol-ingles/"); // aki posar la nova web.

//
            WebElement textArea = driver.findElement(new By.ByXPath("//*[@id=\"texto\"]"));

            textArea.sendKeys(word);
            /*textArea.submit();*/


            WebElement acceptButton = driver.findElement(new By.ByXPath("//*[@id=\"boton_traducir\"]"));
            acceptButton.click();
            WebDriverWait wdw= new WebDriverWait(driver,Duration.ofSeconds(20));
/*
            wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultado-traduccion\"]//*")));
*/
            Thread.sleep(1000);
            WebElement result= driver.findElement(new By.ByXPath("//*[@id=\"resultado-traduccion\"]"));
            word2 = result.getText();
            System.out.println(word);
            System.out.println(word2);
        } catch (Exception e) {
        }
        driver.close();
        return word2;
    }


    public void getPimientosURL() {

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

    }

    public void getPimientosInfo() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        for (String pimiento :
                pimientos) {

            String nombre, img, description = "", origen, distanciaEntrePlantas, distanciaEntreSemillas, scoville, anchoPlanta, familia, colorFlor,
                    tempCrecimiento, luz, alturaPlanta, rendimiento, tiempoMinimoCosecha, profSemilla, tempGerminacion;
            // anem a cadascuna de les paginesde pimientos   fer amb forkJoins?
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get(pimiento);


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
            // Cambiar a el que és més gran per si les mosques de moment funciona i així es queda.
            StringBuilder dadesS = new StringBuilder();

            for (WebElement column :
                    dadesColumn) {
                dadesS.append("\n" + column.getText());
                /*dades.add(column.getText());*/
            }

            String str = dadesS.toString();
            String[] linies = str.split("\n");


            for (String linia :
                    linies) {
                try {
                    String[] a = linia.split(": ");
                    linia = a[1];
                } catch (Exception e) {/*hi ha linies en blanc i les trec*/}
            }

            //guardem cada un de les dades a la seva variable
            origen = linies[0];
            distanciaEntrePlantas = linies[1];
            distanciaEntreSemillas = linies[2];
            scoville = linies[3];
            anchoPlanta = linies[4];
            familia = linies[5];
            colorFlor = linies[6];
            tempCrecimiento = linies[7];
            luz = linies[8];
            alturaPlanta = linies[9];
            rendimiento = linies[10];
            tiempoMinimoCosecha = linies[11];
            profSemilla = linies[12];
            tempGerminacion = linies[13];


            // Iniciem la classe csv

            Csv csv = new Csv(file);

            // Li passem la informació a la classe encarregada d'escrriure el csv juntament amb tots els paràmetres
            csv.newPimientoToCSV(nombre, description, origen, distanciaEntrePlantas, distanciaEntreSemillas, scoville, anchoPlanta, familia, colorFlor,
                    tempCrecimiento, luz, alturaPlanta, rendimiento, tiempoMinimoCosecha, profSemilla, tempGerminacion, img);

            // Avisem per terminal de quin pebrot hem descarregat  i la url d'on s'han descarregat les dades
            System.out.println("-----------------");
            System.out.println("-----------------> variables guardadas de " + nombre + "  --  " + driver.getCurrentUrl());
            System.out.println("-----------------");



        }

    }


}
