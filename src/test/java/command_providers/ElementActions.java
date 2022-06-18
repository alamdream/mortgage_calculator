package command_providers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class ElementActions {
    private By locator;
    private WebDriver driver;

    public ElementActions(WebDriver driver, By locator){
        this.driver = driver;
        this.locator =  locator;
    }

    public WebElement getElement() {
        WebElement element = null;
        try {
            element = driver.findElement((locator));
        } catch (Exception e) {
//            Logger.error("Element exception for the locator: " + locator + "The exception is : " + e.getMessage());
        }
        return element;
    }

    public ElementActions click(){
        getElement().click();
        return this;
    }
    public ElementActions setValue(String value){
        getElement().clear();
        getElement().sendKeys();
        return this;
    }
    public ElementActions selectValue(String value){
        Select select = new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }
    public ElementActions mouseHover() {
//        Action action = new Action(driver);
//        action.movetoElement(getElement()).perform();
       return this;

    }

}
