package com.solvd.web.page;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.solvd.web.page.components.Header;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header[@class='g-top']")
    private Header header;

    @FindBy(xpath = "//*[contains(@class, 'grid-6')]/header/a[contains(@href, 'superprice')]")
    private ExtendedWebElement giftCatalogLink;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public Header getHeader() {
        return this.header;
    }

    public ExtendedWebElement getGiftCatalogLink() {
        return this.giftCatalogLink;
    }

    public void giftCatalogLinkClick() {
        this.giftCatalogLink.click();
    }

}
