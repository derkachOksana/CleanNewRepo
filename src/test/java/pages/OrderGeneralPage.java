package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderGeneralPage {

   private final WebDriver driver;
   public OrderGeneralPage(WebDriver driver) {
       PageFactory.initElements(driver, this);
       this.driver = driver;
   }

   @FindBy(xpath = "//button[@aria-label='Add to cart']")
   private List<WebElement> setOfAddToCartBtn;

   @FindBy(xpath = "//span[contains(text(), 'Submit order')]")
   private WebElement submitOrderTab;

   @FindBy(xpath = "//span[contains(text(), 'Cancel')]")
   private WebElement cancelOrderConfirmationTab;

   @FindBy(xpath = "//*[text()='Submit']")
   private WebElement submitOrderConfirmationTab;

   @FindBy(xpath = "//div//label[contains(text(),'Time picker')]/ancestor::div[1]//input")
   private WebElement timePickerTab;

   @FindBy(xpath = "//div//label[contains(text(),'Date picker')]/ancestor::div[1]//input")
   private WebElement datePickerTab;

   @FindBy(xpath = "//tbody//button[@aria-label = 'Remove item']")
   private List <WebElement> removeItemOrderConfirmationBtns;

   public void removeItemOrderBtnAccessByIndex (int index) throws IllegalArgumentException {

       int size = removeItemOrderConfirmationBtns.size();

       if(index >= size) {
           throw new IllegalArgumentException("Unexpected index [" + index + "]. Expect index should not be grater then " + size);
       }

       removeItemOrderConfirmationBtns.get(index).click();
    }
    public String datePickerGetText() {
        return datePickerTab.getText();
    }

   public String timePickerGetText() {
       return timePickerTab.getText();
   }

   public void submitOrderConfirmationAccessTab() {
       submitOrderTab.click();
   }

   public void setCancelOrderConfirmationAccess() {
       cancelOrderConfirmationTab.click();
   }

   public void submitOrderAccessTab(){
       submitOrderTab.click();
   }

   public void addToCartBtnAccessByIndex (int index) {

        int size = setOfAddToCartBtn.size();

        if(index >= size) {
           throw new IllegalArgumentException("Unexpected index [" + index + "]. Expect index should not be grater then " + size);
        }

        setOfAddToCartBtn.get(index).click();
   }
}