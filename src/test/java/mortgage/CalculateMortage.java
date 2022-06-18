package mortgage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ReadConfigFiles;

public class CalculateMortage {

    private final By HOMEVALUE = By.id("homeval");
    private final By DOWNPAYMENTINDOLLER = By.name("param[downpayment_type]");
    private final By DOWNPAYMENT = By.id("downpayment");
    private final By INTERESTRATE = By.id("intrstsrate");
    private final By LOANTERM = By.id("loanterm");
    private final By STARTMONTH = By.name("param[start_month]");
    private final By STARTDATE = By.id("start_year");
    private final By PROPERTYTAX = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HOMEINSURANCE = By.id("hoi");
    private final By HOAFEES = By.id("hoa");
    private final By LOANTYPE = By.name("param[milserve]");
    private final By BUYORREFI = By.name("param[refiorbuy]");
    private final By CALCULATE = By.name("cal");
    private final By TOTALMONTHLYPAYMENT = By.cssSelector("section.content-container:nth-child(2) section.content-container section.content-area div.wrapper div.content-right.main-block div.calculation-container:nth-child(1) div.calculation-box div.cal-block:nth-child(2) div.cal-content:nth-child(6) div.cal-right-box:nth-child(3) div.repayment-block:nth-child(2) div.rw-box:nth-child(1) div.left-cell > h3:nth-child(1)");

    WebDriver driver;
    Select select;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void enterdata(){
        // Home Value 300000
        driver.findElement(HOMEVALUE).clear();
        driver.findElement(HOMEVALUE).sendKeys("300000");

        // Click on the $ radio button
        driver.findElement(DOWNPAYMENTINDOLLER).click();

        // Down payment 60000
        driver.findElement(DOWNPAYMENT).clear();
        driver.findElement(DOWNPAYMENT).sendKeys("60000");

        // Interest rate 3.0
        driver.findElement(INTERESTRATE).clear();
        driver.findElement(INTERESTRATE).sendKeys("3.0");

        // Typing the loan Term 30 years
        driver.findElement(LOANTERM).clear();
        driver.findElement(LOANTERM).sendKeys("30");

        // selecting value from start date month dropdown
        select  = new Select(driver.findElement(STARTMONTH));
        select.selectByVisibleText("Apr");

        // Typing the start date of the year 2022
        driver.findElement(STARTDATE).clear();
        driver.findElement(STARTDATE).sendKeys("2022");

        // select the property tax 5000
        driver.findElement(PROPERTYTAX).clear();
        driver.findElement(PROPERTYTAX).sendKeys("5000");

        // typing the Pmi value 0.5
        driver.findElement(PMI).clear();
        driver.findElement(PMI).sendKeys("0.5");

        // typing the home ins value 1000
        driver.findElement(HOMEINSURANCE).clear();
        driver.findElement(HOMEINSURANCE).sendKeys("1000");

        // Typing monthly HOA 100
        driver.findElement(HOAFEES).clear();
        driver.findElement(HOAFEES).sendKeys("100");

        //Typing the loan type FHA
        select = new Select(driver.findElement(LOANTYPE));
        select.selectByVisibleText("FHA");

        // Select the option Buy
        select = new Select(driver.findElement(BUYORREFI));
        select.selectByVisibleText("Buy");

    }

    @Test
        public void calculateMonthlyPayment(){

        enterdata();

        // Click on calculate
        driver.findElement(CALCULATE).click();

        boolean totalmonthlypyment = driver.findElement(TOTALMONTHLYPAYMENT).isDisplayed();
        Assert.assertTrue(totalmonthlypyment);

    }

    @Test
    public void test(){
        System.out.println(ReadConfigFiles.getPropertyValues("DbUser"));
    }

    @AfterMethod
        public void closeBrowser(){
        driver.quit();
    }



}
