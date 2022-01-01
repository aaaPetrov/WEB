package com.solvd.web.service;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.solvd.web.page.components.SearchModal;
import com.solvd.web.page.components.SearchedItem;

import java.util.List;

public class SearchModalService implements IAbstractTest {

    private final SearchModal searchModal;

    public SearchModalService(WebDriver webDriver) {
        this.searchModal = new SearchModal(webDriver);
    }

    public void switchAndWait(int seconds) {
        getDriver().switchTo().frame(this.searchModal.getRootElement());
        Wait<WebDriver> webDriverWait = new WebDriverWait(getDriver(), seconds);
        webDriverWait.until(webDriver -> !this.searchModal.getSearchedItems().isEmpty());
    }

    public List<SearchedItem> getSearchedItems() {
        return this.searchModal.getSearchedItems();
    }

}
