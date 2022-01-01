package page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegionItem extends AbstractUIObject {

    @FindBy(xpath = ".//input")
    private ExtendedWebElement checkBox;

    @FindBy(xpath = ".//label")
    private ExtendedWebElement label;

    public RegionItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCheckBox() {
        return this.checkBox;
    }

    public ExtendedWebElement getLabel() {
        return this.label;
    }

    public void checkBoxClick() {
        this.checkBox.check();
    }

    public String labelText() {
        return this.label.getText();
    }

}
