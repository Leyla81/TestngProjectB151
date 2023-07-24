package tests.US01;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01_AramaKutusuTesti {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Page page =new Page();
        page.aramakutusu.sendKeys("iphone", Keys.ENTER);
        Driver.closeDriver();

    }
}
