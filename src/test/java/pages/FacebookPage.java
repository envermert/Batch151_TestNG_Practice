package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailKutusu;


    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//*[@id='pass']")
    public WebElement sifreKutusu;



    // giris yap butonuna tıklayın
    @FindBy(xpath = "//*[@name='login']")
    public WebElement girisYapButonu;

    // baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin
    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement girdiginSifreYanlisYaziElementi;

    // sayfayı kapatın


}
