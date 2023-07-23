package tests.day02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor {


    @Test
    public void test01() {

        extentTest = extentReports.createTest("Batch151","Amazonu test edebilmeli");
        //extentTest'e testname ve description degerlerini atmaliyiz.


        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi");

        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        extentTest.info("Arama kutusuna Java yazip aratildi");


        // sonuc yazisinin "Java" icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Java"));
        extentTest.pass("Sonuc yazisinin Java icerdigi test edildi");

        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("kontrollu olarak yeni sayfa acildi ");


        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Kitap"+Keys.ENTER);
        extentTest.info("Yeni acılan sayfada Kitap aratıldi");


        // sonuc yazisinin Kitap icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Kitap"));
        extentTest.pass("Sonuc yazisinin Kitap icerdigi test edildi");

        // sayfayı kapatınız
        Driver.closeDriver();


    }
}
