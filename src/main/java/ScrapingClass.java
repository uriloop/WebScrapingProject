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

    public String translateToEnglish3(String word) {


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

    public String translateToEnglish(String word) {


        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Declarem la url de la web on descarregarem les dades. Posem el driver a treballar a la web que posem
        String word2 = "";
        driver.get("https://www.google.com/search?q=espa%C3%B1ol+ingl%C3%A9s&spell=1&sa=X&ved=2ahUKEwi35rL_89H1AhUNzoUKHVCFBOkQBSgAegQIARAz&biw=1222&bih=640&dpr=1.25"); // aki posar la nova web.
        WebElement acceptButton = driver.findElement(new By.ByXPath("//*[@id=\"L2AGLb\"]"));
        acceptButton.click();
        WebElement textArea = driver.findElement(new By.ByXPath("//*[@id=\"tw-source-text-ta\"]"));
        textArea.sendKeys(word);
        WebElement result;
        result = driver.findElement(new By.ByXPath("//*[@id=\"tw-target-text\"]/span"));
        word2 = result.getText();
        while (word2.equals("Traducción")||word2.equals("Traduciendo...")) {
            word2 = result.getText();
        }
        driver.close();
        return word2;
    }

    public String translateToEnglish2(String word) {


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

            StringBuilder dadesS = new StringBuilder();

            for (WebElement column :
                    dadesColumn) {
                dadesS.append("\n" + column.getText());
                /*dades.add(column.getText());*/
            }

            String str = dadesS.toString();
            String[] linies = str.split("\n");
            List<String> data = new ArrayList<>();

            for (String linia :
                    linies) {
                try {
                    String[] a = linia.split(": ");
                    data.add(a[1]);
                } catch (Exception e) {/*hi ha linies en blanc i les trec*/}
            }

            //guardem cada un de les dades a la seva variable
            origen = data.get(0);
            System.out.println("Origen= " + origen);
            distanciaEntrePlantas = data.get(1);
            distanciaEntreSemillas = data.get(2);
            scoville = data.get(3);
            anchoPlanta = data.get(4);
            familia = data.get(5);
            colorFlor = data.get(6);
            tempCrecimiento = data.get(7);
            luz = data.get(8);
            alturaPlanta = data.get(9);
            rendimiento = data.get(10);
            tiempoMinimoCosecha = data.get(11);
            profSemilla = data.get(12);
            tempGerminacion = data.get(13);
            System.out.println("Temp germinacion= " + tempGerminacion);


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

        driver.close();
    }


}
