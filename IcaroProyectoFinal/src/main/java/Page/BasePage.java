package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void sendKeysById(String texto, String idElement){
        WebElement webElement = this.driver.findElement(By.id(idElement));
        webElement.sendKeys(texto);

    }
    public void clicById(String idElement){
        WebElement webElement = this.driver.findElement(By.id(idElement));
        webElement.click();
    }

    public String getTextById(String idElement){
        WebElement elemento = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idElement)));
        return elemento.getText();

    }
}
