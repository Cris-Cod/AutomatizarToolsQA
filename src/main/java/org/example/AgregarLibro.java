package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AgregarLibro {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[6]/div/ul/li[2]")).click();


        List<WebElement> books = driver.findElements(By.cssSelector("div[class='rt-td'] div"));

        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getText().equalsIgnoreCase("Programming JavaScript Applications")){
                js.executeScript("window.scrollBy(0,400)");
                driver.findElements(By.cssSelector("div[class='rt-td'] div")).get(i).click();
                break;
            }
        }

    }
}
