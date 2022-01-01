package page.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class RegionDropdownMenu extends AbstractUIObject {

    @FindBy(xpath = ".//li")
    private List<RegionItem> regionItems;

    public RegionDropdownMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<RegionItem> getRegionItems() {
        return this.regionItems;
    }

    public void regionItemCheckBoxClock(String region) {
        this.regionItems.stream()
                .filter(regionItem -> regionItem.labelText().toLowerCase(Locale.ROOT).equals(region.toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no region '" + region + "' in dropdown menu."))
                .checkBoxClick();
    }

}
