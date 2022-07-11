package BaseFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    static File file;
    static Properties prop;
    static FileInputStream fip;

    //To initiate the browser
    @BeforeClass
    public static void launchBrowser() throws Exception {
        String Browser = getProperty("BROWSER");
        String URL = getProperty("VURL");
        if (Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser, Please provide a Valid browser name");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get(URL);
        Thread.sleep(3000);

    }

    //To close the browser
    @AfterClass
    public static void closeBrowser() throws Exception {
        driver.close();
    }

    //To creare Date and time as String
    public static String DateNTime() {
        // Current System Date and time is assigned to objDate
        Date objDate = new Date();
        //Date format is Specified
        String strDateFormat = "hh:mm:ssadd-MMM-yyyy";
        //Date format string is passed as an argument to the Date format object
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        //Date formatting is applied to the current date
        return objSDF.format(objDate).toString();
    }

    //To read the data in prperties file
    public static String getProperty(String Key) throws Exception {
        prop = new Properties();
        fip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Config\\Config.properties");
        prop.load(fip);
        return prop.getProperty(Key.toUpperCase());

    }

    //To Access the data in excel sheet
    public static String getExcelData(int rownum, int cellnum, String filepath) throws IOException {
        fip = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fip);
        XSSFSheet sheet = workbook.getSheetAt(0);

        return sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
    }

    // To Capture the screen shot
    public static String getScreenshot(WebDriver webdriver) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("dd.MM.yyyy_hh_mm_ss").format(new Date());
        //Move image file to new destination
        File DestFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + timestamp + "_Screenshot" + ".jpg");
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        return DestFile.getAbsolutePath();

    }

    // To Genarate Random string
    public static String getrandomString(int length){
        return RandomStringUtils.random(length,"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
}
