package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiters.Waiter;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage<MainPage>{


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".js-cards-slider0 .card-sale__title p")
    private List<WebElement> productNearHome;

    @FindBy(css = ".js-cards-slider1 .swiper-slide")
    private List<WebElement> productFamily;

    @FindBy(css = ".js-cards-slider1 ~ .cards-slider__prev")
    private WebElement sliderPrev;

    @FindBy(css = ".js-cards-slider1 ~ .cards-slider__next")
    private WebElement sliderNext;

    @FindBy(css = ".js-cards-slider1 .swiper-slide-active")
    private WebElement activeProduct;

    @FindBy(css = ".js-cards-slider1 .swiper-slide-prev")
    private WebElement prevProduct;

    @FindBy(css = ".js-cards-slider1 .swiper-slide-next")
    private WebElement nextProduct;


    public ProductPage clickProductNearHome(int index){
      productNearHome.get(index).click();
      return new ProductPage(driver);
    }

    public String getProductNearHomeName(int index){
        return productNearHome.get(index).getText();
    }

    public String checkSliderPrevState(){
        return sliderPrev.getAttribute("aria-disabled");
    //    return waiter.waiter(ExpectedConditions.attributeContains(sliderPrev,"aria-disabled","true"));
    }

    public String checkSliderNextState(){
        return sliderNext.getAttribute("aria-disabled");
    }

    public boolean checkProductPrevState(int index){
        return waiter.waiter(ExpectedConditions.attributeContains(productFamily.get(index),"class","swiper-slide-prev"));
    }

    public boolean checkProductNextState(int index){
        return waiter.waiter(ExpectedConditions.attributeContains(productFamily.get(index),"class","swiper-slide-next"));
    }

    public boolean checkProductActiveState(int index){

        return waiter.waiter(ExpectedConditions.attributeContains(productFamily.get(index),"class","swiper-slide-active"));
    }

    public void clickSliderPrev(){
        sliderPrev.click();
    }

    public void clickSliderNext(){
        sliderNext.click();
    }

//    public int sizeProductFamilyList(){
//        return productFamily.size();
//    }
//
//    public int clickProductFamily() {
//        ArrayList<WebElement> productFamilyCount = new ArrayList<>();
//        String sliderPrevAttribute = sliderPrev.getAttribute("aria-disabled");
//        String sliderNextAttribute = sliderNext.getAttribute("aria-disabled");
//        if (sliderPrevAttribute.equals("true") & sliderNextAttribute.equals("false")) {
//            for (WebElement p : productFamily) {
//                if (p.isDisplayed()) {
//                    productFamilyCount.add(p);
//                } else {
//                        clickSliderNext();
//                        productFamilyCount.add(p);
//                }
//            }
//        }
//        else if (sliderPrevAttribute.equals("false") & sliderNextAttribute.equals("true")) {
//            for (WebElement p : productFamily) {
//                if (p.isDisplayed()) {
//                    productFamilyCount.add(p);
//                } else {
//                        clickSliderPrev();
//                        productFamilyCount.add(p);
//                }
//            }
//        }
//        else if (sliderPrevAttribute.equals("false") & sliderNextAttribute.equals("false")) {
//           while (sliderPrevAttribute.equals("false")){
//               clickSliderPrev();
//           }
//            for (WebElement p : productFamily) {
//                if (p.isDisplayed()) {
//                    productFamilyCount.add(p);
//                } else {
//                        clickSliderNext();
//                        productFamilyCount.add(p);
//                }
//            }
//        }
//        else {
//            for (WebElement p : productFamily) {
//                if (p.isDisplayed()) {
//                    productFamilyCount.add(p); //не проверить слайдер - размер окна?
//                }
//            }
//        }
//            return productFamilyCount.size();
//        }

}
