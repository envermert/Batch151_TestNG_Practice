package tests.day03;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {

    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi = {{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};

        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    //DataProvider = veri saglayicisi demektir.
    //Arayacagimiz kelimeleri bir liste gibi tutup bana yollayacak bir veri saglayicisi olusturduk.

    public void test01(String arananKelime) {
        //Amazon sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalim
        AmazonPage amazonPage =new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);



        //Sonuclarin aradigimiz kelime icerdigini test edelim.
        String expectedKelime = arananKelime;
        String actualSonucYazisi = amazonPage.sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


        //Sayfayi kapatalim
        Driver.closeDriver();

    }
}
