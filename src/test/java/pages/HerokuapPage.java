package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.w3c.dom.xpath.XPathEvaluator;
import utilities.Driver;

public class HerokuapPage {

    public HerokuapPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }


    //yanlis email ve yanlis password giriniz
    //(NOT: birden fazla yanlis email ve password'u dataProvider kullanarak sirayla deneyin)

    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;

    @FindBy(xpath = " //*[@id='password']")
    public WebElement password;

    //login butonuna tiklayiniz
    @FindBy(xpath = " //*[@class='btn btn-primary btn-lg btn-block']")
    public WebElement loginButonu;

    //"There was a problem with your login." yazisinin gorunur oldugunu test edin.

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement theWasaProblemYaziElementi;


}
