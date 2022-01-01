package com.solvd.web.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ServiceOffer extends AbstractUIObject {

    @FindBy(xpath = ".//span[contains(@class, 'map')]")
    private ExtendedWebElement regionSpan;

    public ServiceOffer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getRegionSpan() {
        return this.regionSpan;
    }

    public String regionSpanText() {
        return this.regionSpan.getText();
    }

}
