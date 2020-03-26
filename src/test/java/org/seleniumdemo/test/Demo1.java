package org.seleniumdemo.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import java.util.Objects;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo1 {

    private static WebDriver driver = null;

    @BeforeClass
    public static void iniciar() {
//        FirefoxDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        ChromeDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        EdgeDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        Objects.requireNonNull(driver);
    }

    @Test
    public void testDemo() throws InterruptedException {

        driver.get("https://www.google.com.pe/");

        Thread.sleep(1000);

        WebElement usuario = driver.findElement(By.id("lst-ib"));
        usuario.sendKeys("jcondori");

        Thread.sleep(1000);

        WebElement boton = driver.findElement(By.name("btnK"));
        boton.click();

        Thread.sleep(1000);

        WebDriverWait espera = new WebDriverWait(driver, 5);

        WebElement pagina = driver.findElement(By.className("iUh30"));

        espera.until(ExpectedConditions.visibilityOf(pagina));

        Assert.assertTrue("Correcto", pagina.isDisplayed());

    }

    @AfterClass
    public static void finalizar() {
        driver.close();
    }

}
