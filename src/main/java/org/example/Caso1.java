package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Caso1 {
    public static void main(String[] args) throws InterruptedException {

        String user = "test01";
        String pass = "Test2023*";
        String userRegister = "User Register Successfully.";
        String deleteUser = "User Deleted.";

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("newUser")).click();

        driver.findElement(By.id("firstname")).sendKeys("Test01");
        driver.findElement(By.id("lastname")).sendKeys("Test01");
        driver.findElement(By.id("userName")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        js.executeScript("window.scrollBy(0,300)");
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        //driver.findElement(By.id("recaptcha-anchor")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor")));
        element.click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
        driver.findElement(By.id("register")).click();
        Thread.sleep(5000);
        String usuarioAgregado = driver.switchTo().alert().getText();
        System.out.println(usuarioAgregado);
        Assert.assertEquals(userRegister,usuarioAgregado);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[6]/div/ul/li[1]")).click();
        driver.findElement(By.id("userName")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.cssSelector(".text-center.button")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        String usuarioEliminado = driver.switchTo().alert().getText();
        System.out.println(usuarioEliminado);
        Assert.assertEquals(deleteUser, usuarioEliminado);
        driver.switchTo().alert().accept();



    }

}
