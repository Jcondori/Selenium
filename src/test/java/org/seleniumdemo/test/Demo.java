package org.seleniumdemo.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.Objects;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    private static WebDriver driver = null;

    @BeforeClass
    public static void iniciar() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Objects.requireNonNull(driver);
    }

    @Test
    public void testDemo() throws InterruptedException {

        driver.get("http://sistemas.vallegrande.edu.pe/Asistencias/");
        
        Thread.sleep(2000);

        WebElement usuario = driver.findElement(By.id("form:user"));
        usuario.sendKeys("70335059");

        WebElement password = driver.findElement(By.id("form:pass"));
        password.sendKeys("demo");

        WebElement boton = driver.findElement(By.name("form:btnlogin"));
        boton.click();

//        WebDriverWait espera = new WebDriverWait(driver, 5);

//        WebElement mensaje = driver.findElement(By.className("ui-growl-title"));

//        espera.until(ExpectedConditions.visibilityOf(mensaje));

//        Assert.assertTrue("Correcto", mensaje.getText() != null);

    }

    @AfterClass
    public static void finalizar() {
//        driver.close();
    }

}
