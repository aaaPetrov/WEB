package page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ManufacturerItem extends AbstractUIObject {

    @FindBy(xpath = ".//input[@type='checkbox']")
    private ExtendedWebElement checkBox;

    @FindBy(xpath = ".//*[contains(@class, 'checkbox-text')]")
    private ExtendedWebElement label;

    public ManufacturerItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCheckBox() {
        return this.checkBox;
    }

    public ExtendedWebElement getLabel() {
        return this.label;
    }

    public void clickCheckBox() {
        this.checkBox.check();
    }

    public String getLabelText() {
        return this.label.getText();
    }

}
