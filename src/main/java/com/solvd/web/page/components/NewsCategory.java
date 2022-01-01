package com.solvd.web.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsCategory extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class, 'title-link')]")
    private ExtendedWebElement titleLink;

    public NewsCategory(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTitleLink() {
        return this.titleLink;
    }

    public String text() {
        return this.titleLink.getText();
    }

}
