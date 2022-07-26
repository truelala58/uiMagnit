package components.bases;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Component(".js-cards-slider0 .card-sale__title p")
public class NearHomeComponent extends BaseComponent<NearHomeComponent> {

    public NearHomeComponent(WebDriver driver){
        super(driver);
    }

//    @Override
//    public void validate(){
//        Assert.assertTrue(waiter.waiter(ExpectedConditions.and(
//                ExpectedConditions.presenceOfElementLocated(getLocatorComponent()),
//                ExpectedConditions.visibilityOf(driver.findElement(getLocatorComponent())))));
//    }
}


