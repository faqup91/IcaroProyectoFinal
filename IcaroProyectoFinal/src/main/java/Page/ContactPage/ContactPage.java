package Page.ContactPage;

import Page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {


    private String inputFullname = "name";
    private String inputEmailaddress = "email";
    private String inputPhonenumber = "phone";
    private String inputMessage = "message";
    private String clicBtnSubmit = "submitButton";
    private String verLblSubmit = "message";

    public ContactPage(WebDriver driver) {
            super(driver);
    }

    public void enviarFullname(String nombre) {
        sendKeysById(nombre,inputFullname);
    }

    public void enviarEmailaddress(String email) {
        sendKeysById(email,inputEmailaddress);
    }

    public void enviarPhonenumber(String phone) {
        sendKeysById(phone,inputPhonenumber);
    }

    public void enviarMessage(String message) {
        sendKeysById(message,inputMessage);
    }

    public void clicBtnSubmit() {
        clicById(clicBtnSubmit);
    }

    public String verLblSubmit() {
        return getTextById(verLblSubmit);
    }

    public String validarMsj() {
        WebElement elemento = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.verLblSubmit)));
        return elemento.getText();
    }
}
