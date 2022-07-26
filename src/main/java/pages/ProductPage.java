package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage<ProductPage>{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".action__title")
    private WebElement productTarget;

    public String getTitle(){
        return productTarget.getText();
    }
}
