package week2.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DuplicateLead {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        WebElement user = driver.findElementByXPath("//input[@id='username']");
        user.sendKeys("DemoSalesManager");
        driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
        driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
        driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
        driver.findElementByLinkText("Leads").click();
        driver.findElementByLinkText("Find Leads").click();
        driver.findElementByLinkText("Email").click();
        driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("rupa@gmail.com");
        Thread.sleep(2000);
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        Thread.sleep(2000);
        String capname = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a)[1]").getText();

        driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a)[1]").click();
        Thread.sleep(3000);
        driver.findElementByXPath("(//div[@class='frameSectionExtra']/a)[1]").click();
        Assert.assertEquals("Duplicate Lead | opentaps CRM", driver.getTitle());
        Thread.sleep(3000);
        driver.findElementByXPath("//input[@value='Create Lead']").click();
        String dupcmpname = driver.findElementById("viewLead_companyName_sp").getText();
        String dup = dupcmpname.replaceAll("[0-9()]", "").trim();
        Assert.assertEquals(capname, dup);
        driver.close();
        driver.quit();


    }
}
