package components.popups;

import annotations.Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



@Popup(".js-menu")
public class CatalogComponent extends BasePopup<CatalogComponent> {

    public CatalogComponent(WebDriver driver){
        super(driver);
    }

    public CatalogComponent openMenu(){
        driver.findElement(By.cssSelector(".js-menu-btn"))
                .click();
        return this;
    }

    @Override
    public CatalogComponent popupNotVisible(){
        WebElement popup = driver.findElement(getLocatorComponent());
        Assert.assertTrue(waiter.waiter(ExpectedConditions.not(ExpectedConditions.attributeContains(popup,"class","is-open"))));
        return this;
    }

    @Override
    public CatalogComponent popupVisible(){
        WebElement popup = driver.findElement(getLocatorComponent());
        Assert.assertTrue(waiter.waiter(ExpectedConditions.attributeContains(popup,"class","is-open")));
        return this;
    }

}
