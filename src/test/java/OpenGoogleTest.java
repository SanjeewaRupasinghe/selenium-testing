import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;

class OpenGoogleTest{

    public static void main(String[] args) {
        OpenGoogleTest openGoogleTest=new OpenGoogleTest();
        openGoogleTest.googleTest();
    }

    @Test
    public void googleTest(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium"+ Keys.ENTER);
    }
}