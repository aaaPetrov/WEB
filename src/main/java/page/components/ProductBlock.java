package page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class='schema-product__title']//span")
    private ExtendedWebElement titleBlock;

    public ProductBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTitleBlock() {
        return this.titleBlock;
    }

    public String getTitleBlockText() {
        return this.titleBlock.getText();
    }

}
