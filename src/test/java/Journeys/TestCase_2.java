package Journeys;

import BaseFramework.BaseClass;
import Page_Objects.H_Page;
import Page_Objects.Order_Summary_Page;
import Page_Objects.Product_page;
import org.testng.annotations.Test;

public class TestCase_2 extends BaseClass {
    @Test
    public void TestScenario2() throws InterruptedException {
        H_Page.ClickAcceptCookies();
        H_Page.ClickBuyButton(" Galaxy A53 + Galaxy Buds Live ");
        Product_page.ValidateCorrectProductLoaded();
        Product_page.ValidateDealPrice();
        Product_page.ValidateContract_Duration();
        Product_page.ValidateOnlineAvailablity();
        Product_page.ClickGetThisDealButton();
        Order_Summary_Page.Validate_Device_Name_is_Displayed();
        Order_Summary_Page.Validate_Plan_Details_are_Displayed();
        Order_Summary_Page.Validate_Contract_Cover_is_added();

    }
}
