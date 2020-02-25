package com.pagefactory.Page_Object;

import com.pagefactory.Drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage extends DriverManager {
    @FindBy(css = "select[class='ProductCard__quantitySelect__2y1R3']")
    WebElement increaseProduct;
    @FindBy(xpath = "//div[contains(text(),'unit price')]/span")
    WebElement singleProductPrice;
    public void selectDropDown(int increase) throws InterruptedException {
        Select increase1=new Select(increaseProduct);
        increase1.selectByIndex(increase);
        sleep(3000);
    }
    public  double priceCheckSingle ()
    {
        String price= singleProductPrice.getText();
        System.out.println(price);
        // price.substring()
        String convert=price.replaceAll("£"," ");
        double d= Double.parseDouble(convert);
        System.out.println(d);
        double expected=(d*2);
        System.out.println(expected);
        return expected;
    }
    
    
}
