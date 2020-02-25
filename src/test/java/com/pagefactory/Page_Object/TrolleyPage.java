package com.pagefactory.Page_Object;

import com.pagefactory.Drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrolleyPage extends DriverManager {
     @FindBy(css ="button[data-test='component-att-button']")
     WebElement addToTrolleyButton;
     @FindBy(css=".xs-row a[data-test='component-att-button-basket']")
     WebElement goToTrolleyButton;
     @FindBy(xpath = "//a[@class='Buttonstyles__Button-q93iwm-2 guHdak']")
     WebElement continueShoppingButton;
     @FindBy(css = ".ProductCard__content__9U9b1.xsHidden.lgFlex .ProductCard__titleLink__1PgaZ")
     WebElement getProductTrolley;
     public void addToTrolley()
     {
         addToTrolleyButton.click();
     }
     public void goToTrolley()
     {
         goToTrolleyButton.click();
     }

     public void setContinueShopping()
     {
         continueShoppingButton.click();
     }
     public String getProductInTrolley()
     {
         return getProductTrolley.getText();
     }

}
