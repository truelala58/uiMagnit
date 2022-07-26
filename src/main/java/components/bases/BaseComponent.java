package components.bases;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import waiters.Waiter;


public abstract class BaseComponent<T> {

    {
        validate();
    }

    protected WebDriver driver;
    protected Waiter waiter;

    public  BaseComponent(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    private String getComponentAnnotationData(){
        Class<? extends BaseComponent> clazz = this.getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component component = clazz.getDeclaredAnnotation(Component.class);
            return component.value();
        }
        return "";
    }

    protected By getLocatorComponent(){
        String data = getComponentAnnotationData();
        return data.startsWith("/") ? By.xpath(data) : By.cssSelector(data);
    }

    public void validate(){
        Assert.assertTrue(waiter.waiter(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(getLocatorComponent()),
                ExpectedConditions.visibilityOf(driver.findElement(getLocatorComponent())))));
    }

}
