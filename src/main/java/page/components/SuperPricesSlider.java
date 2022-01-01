package page.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SuperPricesSlider extends AbstractUIObject {

    @FindBy(xpath = ".//a")
    private List<SuperPriceItem> superPriceItems;

    public SuperPricesSlider(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<SuperPriceItem> getSuperPriceItems() {
        return this.superPriceItems;
    }

}
