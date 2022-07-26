package components.bases;

import annotations.Component;
import org.openqa.selenium.WebDriver;

@Component(".js-cards-slider1")
public class FamilyComponent extends BaseComponent<FamilyComponent>{

    public FamilyComponent(WebDriver driver){
        super(driver);
    }

}
