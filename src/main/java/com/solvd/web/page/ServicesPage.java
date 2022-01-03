package com.solvd.web.page;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.solvd.web.page.components.RegionDropdownMenu;
import com.solvd.web.page.components.ServiceOffer;

import java.util.List;

public class ServicesPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'input-style__real')]")
    private ExtendedWebElement regionSelectLine;

    @FindBy(xpath = "//*[contains(@class, 'dropdown-style__columns')]")
    private RegionDropdownMenu regionDropdown;

    @FindBy(xpath = "//*[@class='service-offers__flex']")
    private List<ServiceOffer> serviceOffers;

    public ServicesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("services_url") + "/tasks");
    }

    public ExtendedWebElement getRegionSelectLine() {
        return this.regionSelectLine;
    }

    public RegionDropdownMenu getRegionDropdown() {
        return this.regionDropdown;
    }

    public void regionSelectLineClick() {
        this.regionSelectLine.click();
    }

    public List<ServiceOffer> getServiceOffers() {
        return this.serviceOffers;
    }

}
