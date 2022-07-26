package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private WebDriverWait webDriverWait;

    public Waiter (WebDriver driver){
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean waiter(ExpectedCondition expectedCondition){
        try {
            webDriverWait.until(expectedCondition);
            return true;
        } catch (Exception exp) {
            return false;
        }
    }
}
