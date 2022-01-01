package page.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import page.components.SearchedItem;

import java.util.List;

public class SearchModal extends AbstractUIObject {

    private final By rootElement = By.xpath("//*[@class='modal-iframe']");

    @FindBy(xpath = "//*[@id='search-page']//li[contains(@class, 'search__result')]")
    private List<SearchedItem> searchedItems;

    public SearchModal(WebDriver driver) {
        super(driver);
        setRootElement(driver.findElement(this.rootElement));
    }

    public List<SearchedItem> getSearchedItems() {
        return this.searchedItems;
    }

}
