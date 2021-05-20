package week2.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactLead {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        //System.out.println(System.getProperty("webdriver.chrome.driver"));//to check path of driver
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        WebElement user = driver.findElementByXPath("//input[@id='username']");
        user.sendKeys("DemoSalesManager");
        driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
        driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
        driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
        driver.findElementByXPath("//a[text()='Contacts']").click();
        driver.findElementByXPath("//a[text()='Create Contact']").click();
        driver.findElementByXPath("//input[@id='firstNameField']").sendKeys("xyzz");
        driver.findElementByXPath("//input[@id='lastNameField']").sendKeys("jyur");
        driver.findElementById("createContactForm_firstNameLocal").sendKeys("ture");
        driver.findElementById("createContactForm_lastNameLocal").sendKeys("yre");
        driver.findElementById("createContactForm_departmentName").sendKeys("cse");
        driver.findElementByXPath("//textarea[@id='createContactForm_description']").sendKeys("this is description box");
        Thread.sleep(2000);
        driver.findElementByXPath("//input[@id='createContactForm_primaryEmail']").sendKeys("ru@gmail.com");
        driver.findElementByClassName("smallSubmit").click();
        driver.findElementByLinkText("Edit").click();
        driver.findElementById("updateContactForm_description").clear();
        driver.findElementByXPath("//textarea[@id='updateContactForm_importantNote']").sendKeys("this is for important note");
        driver.findElementByXPath("//input[@class='smallSubmit']").click();
        System.out.println(driver.getTitle());


    }
}
