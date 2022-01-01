package com.solvd.web.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id='fast-search']//input[@type='text']")
    private ExtendedWebElement searchLine;

    @FindBy(xpath = ".//*[@class='b-top-navigation']")
    private TopMenu topMenu;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchLine() {
        return this.searchLine;
    }

    public void writeInSearchLine(String string) {
        this.searchLine.type(string);
    }

    public TopMenu getTopMenu() {
        return this.topMenu;
    }

}
