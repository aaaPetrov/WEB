package page.components;


import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import page.components.NewsCategory;

import java.util.List;

public class NewsDropdownMenu extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'dropdown-column')]")
    private List<NewsCategory> newsCategories;

    public NewsDropdownMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<NewsCategory> getNewsCategories() {
        return this.newsCategories;
    }

}
