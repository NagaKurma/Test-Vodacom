package Vodacom_Page_Objects;

import BaseFramework.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Reports.ExtentList.test;

public class H_Page extends BaseClass {

    static By Accept_All_Cookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    static By Buy_Now_Button = By.xpath("//h1[text()=' HP 15 Celeron + router ']/following-sibling::a");


    public static void ClickBuyButton(String DeviceName) throws InterruptedException {

        WebElement device = driver.findElement(By.xpath("//h1[contains(text(),'"+DeviceName+"')]/following-sibling::a"));
        Actions act = new Actions(driver);
        act.moveToElement(device);
        device.click();
        Thread.sleep(10000);
        test.log(Status.PASS,"Buy Button Clicked on "+DeviceName);
    }
    public static void ClickAcceptCookies() throws InterruptedException {
        driver.findElement(Accept_All_Cookies).click();
        Thread.sleep(2000);
        test.log(Status.PASS,"Coockies Accepted");
    }

}
