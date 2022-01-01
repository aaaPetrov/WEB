package com.solvd.web.page;

import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;
import com.solvd.web.page.components.SuperPricesSlider;

public class GiftProductPage extends AbstractPage {

    @FindBy(id = "super-prices-slider")
    private SuperPricesSlider superPricesSlider;

    public GiftProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("product_url") + "/superprice");
    }

    public SuperPricesSlider getSuperPricesSlider() {
        return this.superPricesSlider;
    }

}
