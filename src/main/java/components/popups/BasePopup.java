package components.popups;

import annotations.Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import waiters.Waiter;


public abstract class BasePopup<T> implements IPopup<T> {

    protected WebDriver driver;
    protected Waiter waiter;

    public  BasePopup(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    private String getComponentAnnotationData(){
        Class<? extends BasePopup> clazz = this.getClass();
        if (clazz.isAnnotationPresent(Popup.class)) {
            Popup component = clazz.getDeclaredAnnotation(Popup.class);
            return component.value();
        }
        return "";
    }

    protected By getLocatorComponent(){
        String data = getComponentAnnotationData();
        return data.startsWith("/") ? By.xpath(data) : By.cssSelector(data);
    }


    @Override
    public T popupNotVisible() {
        WebElement popup = driver.findElement(getLocatorComponent());
        Assert.assertTrue(waiter.waiter(ExpectedConditions.invisibilityOf(popup)));
        return (T) this;
    }

    @Override
    public T popupVisible() {
        WebElement popup = driver.findElement(getLocatorComponent());
        Assert.assertTrue(waiter.waiter(ExpectedConditions.visibilityOf(popup)));
        return (T) this;
    }

}
