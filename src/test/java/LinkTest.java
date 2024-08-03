import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

class LinkTest {

    WebDriver driver;

    public static void main(String[] args) {
        LinkTest linkTest = new LinkTest();
        linkTest.beforeTest();
        linkTest.linkTest();
    }

    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    public void linkTest() {
        // 01 Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        // 02 Find my destination
        WebElement destinationTest = driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String destination = destinationTest.getAttribute("href");
        System.out.print("Find my destination " + destination);

        // 03 Am I broken link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if (title.contains("404"))
            System.out.println("This is broken link");
        else
            System.out.println("This is NOT broken link");

        driver.navigate().back();

        // 04 Duplicate Link
        WebElement homeLinkDup = driver.findElement(By.linkText("Go to Dashboard"));
        homeLinkDup.click();
        driver.navigate().back();

        // 05 Count Links
        List<WebElement> urlList= driver.findElements(By.tagName("a"));
        System.out.println("link count in page: "+urlList.size());


        // 06 Count Layout Links
        WebElement urlListSection= driver.findElement( By.className("layout-main-content"));
        List<WebElement> urlListSectionList= urlListSection.findElements( By.tagName("a"));
        System.out.println("link count in page: "+urlListSectionList.size());


        driver.quit();
    }
}