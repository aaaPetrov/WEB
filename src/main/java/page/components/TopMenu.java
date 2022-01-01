package page.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class TopMenu extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class='b-main-navigation']//*[contains(@class,'b-main-navigation__item')]")
    private List<TopMenuItem> topMenuItems;

    public TopMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<TopMenuItem> getTopMenuItems() {
        return this.topMenuItems;
    }

    public void clickMenuItem(String name) {
        this.topMenuItems.stream()
                .filter(topMenuItem -> topMenuItem.getMenuItemText().getText().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT)))
                .findFirst()
                .map(topMenuItem -> topMenuItem.getMenuItemLink())
                .orElseThrow(() -> new RuntimeException("Can't find menu item element name '" + name + "'."))
                .click();
    }

    public void hoverMenuItem(String name) {
        this.topMenuItems.stream()
                .filter(topMenuItem -> topMenuItem.getMenuItemText().getText().toLowerCase(Locale.ROOT).equals(name))
                .findFirst()
                .map(topMenuItem -> topMenuItem.getMenuItemLink())
                .orElseThrow(() -> new RuntimeException("Can't find menu item element name '" + name + "'."))
                .hover();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
