package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.sql.SQLOutput;

public class C03_SoftAssert extends TestBase {

    // "https://amazon.com" sayfasına gidiniz
    // Title'in "Amazon" icerdigini test edin
    // Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    // Sonuc yazısının gorunur oldugunu test edin
    // Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin


    @Test
    public void test01() {
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");

        // Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        //softAssert instance oldugu icin ilk once obje olusturulur.

       String amazonTitle =  driver.getTitle();
       softAssert.assertTrue(amazonTitle.contains("Amazon"),"Title Amazon Icermiyor");

        // Arama kutusunun erisilebilir oldugunu test edin
       WebElement aramaKutusu =  driver.findElement(By.id("twotabsearchtextbox"));
       softAssert.assertTrue(aramaKutusu.isEnabled(),"Arama kutusuna Erisilemiyor");

        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(),"Sonuc Yazisi Gorunmuyor");

        // Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"Sonuc Yazisi Nutella Icermiyor");

        softAssert.assertAll();
        //assertAll() yazip tum hatalari listelemesini istemeliyiz. Aksi halde hata vermez.

        System.out.println("ENVER");

        /*
        Junitte assert kullandigimizda Assert Faild oldugu anda test calismayi durduruyordu.
        Ve geri kalani calistirmiyordu.

        TestNG'de hem Assert, hem softAssert yapilari var.
        test sonuna kadar calissin, testin sonunda tum hatalari listelesin istiyorsak softAssert kullaniriz.

        softAssert'un hata bulsa bile calismaya devam etme ozelligi softAssert.assertAll()'a kadardir.
        eger softAssert.assertAll()'da hata bulunursa calisma durur.
        Ve class'in kalan kismi calismaz.
         */
    }
}
