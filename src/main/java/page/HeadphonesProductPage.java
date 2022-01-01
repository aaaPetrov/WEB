package page;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import page.components.FilterBlock;
import page.components.ProductBlock;

import java.util.List;

public class HeadphonesProductPage extends AbstractPage {

    @FindBy(id = "schema-filter")
    private FilterBlock filterBlock;

    @FindBy(xpath = "//*[@id='schema-products']//*[contains(@class, 'group')]//*[substring-after(string(@class), 'schema-product__part schema-product__part_') = 4]")
    private List<ProductBlock> productBlocks;

    public HeadphonesProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("product_url") + "/headphones");
    }

    public FilterBlock getFilterBlock() {
        return this.filterBlock;
    }

    public List<ProductBlock> getProductBlocks() {
        return this.productBlocks;
    }

}
