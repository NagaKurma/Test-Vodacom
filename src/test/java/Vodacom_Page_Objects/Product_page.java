package Vodacom_Page_Objects;

import BaseFramework.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Reports.ExtentList.test;

public class Product_page extends BaseClass {

    static By SelectedDeviceDescrption = By.xpath("//div[@id='__next']/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]");
    static By Deal_Price = By.xpath("(//div[contains(@class,'mx-0 DealDetailFooterTop_details-section-row__3ohey')]//div)[2]");
    static By Contract_Duration = By.xpath("//*[@id=\"product-fbt-tabpane-DESC\"]/div/div[2]/div[2]");
    static By Available_Online = By.xpath("//*[@id=\"product-fbt-tabpane-DESC\"]/div/div[3]/div[2]");
    static By GetThisDeal_Btn = By.xpath("//button[contains(@class,'mb-xs DealSpecifications_addToCartBtn__3bd9D')]");
    public static void ValidateCorrectProductLoaded(){

        String Actual = driver.findElement(SelectedDeviceDescrption).getText();
        Boolean B = Actual.contains("Galaxy A73");
        if(B){
            test.log(Status.PASS,"Correct Device Deal Loded");
        }
        if(!B){
            test.log(Status.INFO,"Device Deal is not Matched with Input Details");
        }
    }
    public static void ValidateDealPrice() throws InterruptedException {

        String DisplayedPrice = driver.findElement(Deal_Price).getText();
        String price = "R358 PM";
        Assert.assertEquals(DisplayedPrice, price);
        test.log(Status.PASS,"Validated Deal Price");
    }

    public static void ValidateContract_Duration(){
        String DisplayedTenure = driver.findElement(Contract_Duration).getText();
        String Tenure = "36 months";
        Assert.assertEquals(DisplayedTenure, Tenure);
        test.log(Status.PASS,"Validated Deal Tenure");
    }

    public static void ValidateOnlineAvailablity(){
        String DisplayedAvailablity = driver.findElement(Available_Online).getText();
        String Availablity = "Yes";
        Assert.assertEquals(DisplayedAvailablity, Availablity);
        test.log(Status.PASS,"Validated Deal Online Available");
    }

    public static void ClickGetThisDealButton() throws InterruptedException {
        driver.findElement(GetThisDeal_Btn).click();
        Thread.sleep(7000);
        test.log(Status.PASS, "Get This Deal Button Clicked");
    }
}


