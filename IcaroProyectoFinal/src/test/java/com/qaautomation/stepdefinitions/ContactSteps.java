package com.qaautomation.stepdefinitions;


import Page.ContactPage.ContactPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ContactSteps {
    private WebDriver driver;
    private ContactPage contactPage;


    @Given("el usuario se encuentra en Contacto de Contact")
    public void elUsuarioSeEncuentraEnContactoDeContact() {
        ChromeOptions options = new ChromeOptions();

        String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe";
        System.out.println("[Info]Ruta driver " + pathChromeDriver);
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        driver = new ChromeDriver(options);
        driver.get("https://www.fgzelaya.com.ar/contact.html");
        this.contactPage = new ContactPage(driver);


    }


    @When("el usuario ingres Full Name {string}")
    public void elUsuarioIngresFullName(String nombre) {
        this.contactPage.enviarFullname(nombre);
    }

    @And("el usuario indres Email address {string}")
    public void elUsuarioIndresEmailAddress(String email) {
        this.contactPage.enviarEmailaddress (email);
    }

    @And("el usuario ingres Phone number  {string}")
    public void elUsuarioIngresPhoneNumber(String phone) {
        this.contactPage.enviarPhonenumber(phone);
    }

    @And("el usuario ingres Message    {string}")
    public void elUsuarioIngresMessage(String message) {
        this.contactPage.enviarMessage(message);
    }

    @And("el usuario hace clic boton Submit")
    public void elUsuarioHaceClicBotonSubmit() {
        this.contactPage.clicBtnSubmit();
    }

    @Then("el usuario visualiza el mensaje {string}")
    public void elUsuarioVisualizaElMensaje(String msj) {
        this.contactPage.validarMsj();

    }

    @After
    public void tearDown() {
        // Cerrar el navegador
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
