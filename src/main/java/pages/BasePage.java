package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiter;

public abstract class BasePage<T>{

    protected WebDriver driver;
    protected Waiter waiter;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    public T open(){
        driver.get("https://magnit.ru/");
        return (T)this;
    }
}
