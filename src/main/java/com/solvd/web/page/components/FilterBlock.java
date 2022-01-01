package com.solvd.web.page.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterBlock extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'checkbox-item')]")
    private List<ManufacturerItem> manufacturerItems;

    public FilterBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ManufacturerItem> getManufacturerItems() {
        return this.manufacturerItems;
    }

}
