package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Driver {
    private Driver(){
        // default olan constructor'i private yaparak baska package altinda  bu class'tan obje olusturmasını engelliyoruz. Singleton pattern
        /*
       Driver class'indan obje olusturmanin onunce gecebilmek icin
       default constructor'i private yaparak bunu engellemis oluruz. Bu kaliba da Singleton patter denir */
    }

    static WebDriver driver;

    /*
  POM(Page Object Model)
         Test seneryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
     olanak sağlayan yazılım test yöntemidir. TestNG ve Cucumber frameworklerinde POM kalıbı kullanılır.
   */
    public static WebDriver getDriver() {
        //method olusturduk

        /*
.properties dosyasına key olarak browser ve değerini aşağıda oluşturduğumuz switch case lerden birini seçeriz
ve sectiğimiz driver çalışır
 */

        if (driver == null) { //---Driver 'a deger atamamıssa

            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { //-->Driver'a deger atanmıssa,bos degise
            driver.close();
            driver = null; //Driver i kapattıktan sonra Driver 'ı bosalt
        }


    }


    public static void quitDriver() {
        if (driver != null) { //-->Driver'a deger atanmıssa,bos degise
            driver.quit();
            driver = null; //Driver i kapattıktan sonra Driver 'ı bosalt
        }
    }
}