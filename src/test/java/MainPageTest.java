import components.bases.NearHomeComponent;
import components.popups.CatalogComponent;
import examptions.BrowserNotFoundException;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;


public class MainPageTest {

    private int numberOfProduct = 1;


    @BeforeClass
    static void setupClass() throws BrowserNotFoundException {
        new WebDriverFactory().downloadDriver();
    }

    private WebDriver driver;

    @BeforeMethod
    public void init() throws BrowserNotFoundException {
        driver = new WebDriverFactory().getDriver();
    }

    @AfterMethod
    public void close(){
        if(driver !=null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void productNearHomeTest(){
        MainPage mainPage = new MainPage(driver)
                .open();
        new NearHomeComponent(driver).validate();
        String productTargetName = mainPage.getProductNearHomeName(numberOfProduct);
        ProductPage productPage = mainPage.clickProductNearHome(numberOfProduct);
        String productTitle = productPage.getTitle();
        Assert.assertEquals(productTargetName,productTitle);
    }

    @Test
    public void productFamilySliderTest(){
        MainPage mainPage = new MainPage(driver)
                .open();
        Assert.assertEquals(mainPage.checkSliderPrevState(),"true");
        Assert.assertEquals(mainPage.checkSliderNextState(),"false");
        Assert.assertTrue(mainPage.checkProductActiveState(0));
        Assert.assertTrue(mainPage.checkProductNextState(1));
        mainPage.clickSliderNext();
        Assert.assertEquals(mainPage.checkSliderPrevState(),"false");
        Assert.assertTrue(mainPage.checkProductPrevState(0));
        Assert.assertTrue(mainPage.checkProductActiveState(1));
        Assert.assertTrue(mainPage.checkProductNextState(2));
        mainPage.clickSliderPrev();
        Assert.assertTrue(mainPage.checkProductNextState(1));
        Assert.assertTrue(mainPage.checkProductActiveState(0));


//        int sizeProductFamilyList = new MainPage(driver)
//                .open()
//                .sizeProductFamilyList();
//        int actualSizeProductFamilyList = new MainPage(driver).clickProductFamily();
//        Assert.assertEquals(sizeProductFamilyList,actualSizeProductFamilyList);
    }

    @Test
    public void catalogOpenTest(){
       new MainPage(driver).open();
       new CatalogComponent(driver).popupNotVisible()
               .openMenu()
               .popupVisible();
    }

}
