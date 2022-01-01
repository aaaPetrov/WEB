package com.solvd.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.solvd.web.page.AbstractPage;

public class AbstractService {

    private final AbstractPage abstractPage;

    public AbstractService(WebDriver webDriver) {
        this.abstractPage = new AbstractPage(webDriver);
    }

    public void waitStateAnimation(int seconds) {
        ExtendedWebElement extendedWebElement = this.abstractPage.getStateAnimation();
        extendedWebElement.waitUntilElementDisappear(seconds);
    }

}
