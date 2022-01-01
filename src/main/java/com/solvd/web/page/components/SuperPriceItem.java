package com.solvd.web.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SuperPriceItem extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'description_alter')]")
    private ExtendedWebElement itemName;

    public SuperPriceItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItemName() {
        return this.itemName;
    }

    public String getItemNameText() {
        return this.itemName.getText();
    }

}
