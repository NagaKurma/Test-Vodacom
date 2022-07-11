package Vodacom_Page_Objects;

import BaseFramework.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static Reports.ExtentList.test;

public class Order_Summary_Page extends BaseClass {

    static By DeviceName = By.xpath("//p[@ng-repeat=\"deviceItem in dealdetails.devices.details\"]");
    static By PlanDetails = By.xpath("//div[@ng-hide=\"dealdetails.overrideDataIncluded || dealdetails.extraDataIncluded\"]");
    static By ContractCover = By.xpath("(//div[@class=\"details_cell\"])[4]");


    public static void Validate_Device_Name_is_Displayed() {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"insurance-block\"]/div[1]/div/div/div/div/div[1]/p[1]")));
        actions.perform();
        Boolean Device_Name = driver.findElement(DeviceName).isDisplayed();
        if (Device_Name) {
            test.log(Status.PASS, "Validated If Device Name is Displayed");
        }
    }
    public static void Validate_Plan_Details_are_Displayed(){
        Boolean Plan_Details = driver.findElement(PlanDetails).isDisplayed();
        if (Plan_Details) {
            test.log(Status.PASS, "Validated, Plan Details are Displayed");
        }
    }

    public static void Validate_Contract_Cover_is_added(){
        Boolean Contractcover = driver.findElement(ContractCover).isDisplayed();
        if (Contractcover) {
            test.log(Status.PASS, "Validated, Contract Cover has been added");
        }

    }
}
