package week2.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DeleteLead {
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
        driver.findElementByLinkText("Phone").click();
        Thread.sleep(2000);
        driver.findElementByName("phoneCountryCode").clear();
        driver.findElementByName("phoneCountryCode").sendKeys("91");
        driver.findElementByName("phoneAreaCode").sendKeys("53422");
        driver.findElementByName("phoneNumber").sendKeys("9617229821");
        Thread.sleep(2000);
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
        String str = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
        String capturedstr = str.replaceAll("[A-Za-z()]", "").trim();
        Thread.sleep(3000);
        driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
        driver.findElementByXPath("//a[text()='Find Leads']").click();
        driver.findElementByXPath("//input[@name='id']").sendKeys(capturedstr);
        Thread.sleep(3000);
        driver.findElementByXPath("//td[@class='x-btn-center']/em/button[text()='Find Leads']").click();
        Thread.sleep(5000);
        String deltextofrecrd = driver.findElementByXPath("//div[text()='No records to display']").getText();
        Thread.sleep(2000);
        Assert.assertEquals("No records to display", deltextofrecrd);
        driver.close();


    }
}
