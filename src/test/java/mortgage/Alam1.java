package mortgage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alam1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        Select select;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=1209600&osid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("alamdream@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        Thread.sleep(4000);
        driver.navigate().to("https://www.amazon.com/dp/B07SYV3W6Z/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cat food");
        driver.findElement(By.id("nav-search-submit-button")).click();
        select = new Select(driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]")));
        driver.close();



    }

}
