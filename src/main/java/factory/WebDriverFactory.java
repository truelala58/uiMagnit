package factory;

import data.BrowserData;
import examptions.BrowserNotFoundException;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

import static data.BrowserData.UNDEFINED;

public class WebDriverFactory {

   private final String browserName = System.getProperty("browser.name","chrome").toUpperCase(Locale.ROOT);

    private BrowserData getBrowserData(){
        for (BrowserData browserData: BrowserData.values()) {
            if (browserData.name().equals(browserName)) {
                return BrowserData.valueOf(browserName);
            }
        }
        return UNDEFINED;
    }

    public WebDriver getDriver() throws BrowserNotFoundException {
        BrowserData browser = getBrowserData();

        switch (browser) {
            case CHROME: {
                return new ChromeDriver();
            }
            default: {
                throw new BrowserNotFoundException(browser);
            }
        }
    }
    public void downloadDriver() throws BrowserNotFoundException {
        BrowserData browser = getBrowserData();

        switch (browser) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                break;
            }
            default: {
                throw new BrowserNotFoundException(browser);
            }
        }
    }
}
