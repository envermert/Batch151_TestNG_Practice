package tests.day03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HerokuapPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {


    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {
                {ConfigReader.getProperty("emailYanlis1"),ConfigReader.getProperty("passwordYanlis1")},
                {ConfigReader.getProperty("emailYanlis2"),ConfigReader.getProperty("passwordYanlis2")},
                {ConfigReader.getProperty("emailYanlis3"),ConfigReader.getProperty("passwordYanlis3")}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void NegatifLoginDataProvider(String email, String password) {

        //https://id.heroku.com/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuapUrl"));

        //yanlis email ve yanlis password giriniz
        //(NOT: birden fazla yanlis email ve password'u dataProvider kullanarak sirayla deneyin)

        HerokuapPage herokuapPage = new HerokuapPage();
        herokuapPage.email.sendKeys(email);
        herokuapPage.password.sendKeys(password);

        //login butonuna tiklayiniz
        herokuapPage.loginButonu.click();
        
        //"There was a problem with your login." yazisinin gorunur oldugunu test edin.
        Assert.assertTrue(herokuapPage.theWasaProblemYaziElementi.isDisplayed());
        

        //sayfayi kapatiniz.
        Driver.closeDriver();

    }
}
