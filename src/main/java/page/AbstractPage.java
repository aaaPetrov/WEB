package page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import page.components.NewsDropdownMenu;

public class AbstractPage extends com.qaprosoft.carina.core.gui.AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'state_animated')")
    private ExtendedWebElement stateAnimation;

    @FindBy(xpath = "//*[@class='b-main-navigation']//li[2]//*[contains(@class, 'dropdown-grid')]")
    private NewsDropdownMenu newsDropdownMenu;

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getStateAnimation() {
        return this.stateAnimation;
    }

    public NewsDropdownMenu getNewsDropdownMenu() {
        return this.newsDropdownMenu;
    }

}
