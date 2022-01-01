package com.solvd.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;
import page.components.SearchModal;
import page.components.NewsDropdownMenu;
import page.components.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class OnlinerWebTest implements IAbstractTest {

    @Test(groups = "toNotBeforeMethods")
    public void checkManufactureFilterTest() {
        HeadphonesProductPage headphonesProductPage = new HeadphonesProductPage(getDriver());
        headphonesProductPage.open();
        FilterBlock filterBlock = headphonesProductPage.getFilterBlock();
        Assert.assertTrue(filterBlock.isUIObjectPresent());

        filterBlock.getManufacturerItems().stream()
                .filter(manufacturerItem -> "Sony".equals(manufacturerItem.getLabelText()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no manufacturer label named 'Sony'"))
                .clickCheckBox();

        AbstractPage abstractPage = new AbstractPage(getDriver());
        ExtendedWebElement webElement = abstractPage.getStateAnimation();
        webElement.waitUntilElementDisappear(10);

        List<ProductBlock> productBlocks = headphonesProductPage.getProductBlocks();

        SoftAssert searchAssert = new SoftAssert();
        productBlocks.forEach(productBlock -> {
            searchAssert.assertTrue(productBlock.getTitleBlockText().toLowerCase(Locale.ROOT).contains("sony"));
        });
        searchAssert.assertAll();
    }

    @DataProvider(name = "dropdownNewsCategories")
    public Object[][] newsCategories() {
        return new Object[][]{{"новости", List.of("кошелек", "авто", "технологии", "недвижимость")}};
    }

    @Test(dataProvider = "dropdownNewsCategories")
    public void verifyNewsMenuCategoryTest(String topMenuItemName, List<String> newsCategories) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeader().getTopMenu().hoverMenuItem(topMenuItemName);

        AbstractPage abstractPage = new AbstractPage(getDriver());
        NewsDropdownMenu newsDropdownMenu = abstractPage.getNewsDropdownMenu();
        Assert.assertTrue(newsDropdownMenu.isUIObjectPresent());

        SoftAssert softAssert = new SoftAssert();
        IntStream.range(0, newsDropdownMenu.getNewsCategories().size()).boxed().forEach(index -> {
            softAssert.assertEquals(newsDropdownMenu.getNewsCategories().get(index).text().toLowerCase(Locale.ROOT),
                    newsCategories.get(index).toLowerCase(Locale.ROOT));
        });
        softAssert.assertAll();
    }

    @Test
    public void checkSearchLineTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeader().writeInSearchLine("blackview");

        SearchModal searchModal = new SearchModal(getDriver());
        getDriver().switchTo().frame(searchModal.getRootElement());
        Wait<WebDriver> webDriverWait = new WebDriverWait(getDriver(), 5);
        webDriverWait.until(webDriver -> !searchModal.getSearchedItems().isEmpty());

        List<SearchedItem> searchedItems = searchModal.getSearchedItems();
        Assert.assertFalse(searchedItems.isEmpty(), "No search result found.");
        SoftAssert softAssert = new SoftAssert();
        searchedItems.forEach(searchedItem -> softAssert.assertTrue(searchedItem.getItemTitleText().toLowerCase(Locale.ROOT).contains("blackview")));
        softAssert.assertAll();
    }

    @DataProvider(name = "giftProductItemNames")
    public Object[][] itemNames() {
        return new Object[][]{{ List.of(
                "электроника",
                "компьютеры и сети",
                "бытовая техника",
                "стройка и ремонт",
                "дом и сад",
                "авто и мото",
                "красота и спорт",
                "детям и мамам"
        )}};
    }

    @Test(dataProvider = "giftProductItemNames")
    public void checkGiftCatalogTest(List<String> giftProductItemNames) {
        HomePage homePage  = new HomePage(getDriver());
        homePage.open();
        homePage.giftCatalogLinkClick();

        AbstractPage abstractPage = new AbstractPage(getDriver());
        ExtendedWebElement webElement = abstractPage.getStateAnimation();
        webElement.waitUntilElementDisappear(5);

        GiftProductPage giftProductPage = new GiftProductPage(getDriver());
        Assert.assertTrue(giftProductPage.getSuperPricesSlider().isUIObjectPresent());

        List<SuperPriceItem> superPriceItems = giftProductPage.getSuperPricesSlider().getSuperPriceItems();

        SoftAssert softAssert = new SoftAssert();
        IntStream.range(0, giftProductItemNames.size()).boxed()
                .forEach(index -> softAssert.assertTrue(giftProductItemNames.get(index).equals(
                        superPriceItems.get(index).getItemNameText().toLowerCase(Locale.ROOT))));
        softAssert.assertAll();
    }

    @DataProvider(name = "serviceOfferRegionNames")
    public Object[][] regionNames() {
        return new Object[][] {{"Минск"}, {"Брест"}, {"Витебск"}, {"Гомель"}, {"Гродно"}, {"Могилев"}};
    }

    @Test(dataProvider = "serviceOfferRegionNames")
    public void verifyServicesRegionTest(String region) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeader().getTopMenu().clickMenuItem("Услуги");

        AbstractPage abstractPage = new AbstractPage(getDriver());
        ExtendedWebElement webElement = abstractPage.getStateAnimation();
        webElement.waitUntilElementDisappear(5);

        ServicesPage servicesPage = new ServicesPage(getDriver());
        Assert.assertTrue(servicesPage.getRegionSelectLine().isPresent());
        servicesPage.regionSelectLineClick();
        Assert.assertTrue(servicesPage.getRegionDropdown().isUIObjectPresent());

        servicesPage.getRegionDropdown().regionItemCheckBoxClock(region);
        webElement.waitUntilElementDisappear(5);
        List<ServiceOffer> serviceOffers = servicesPage.getServiceOffers();

        SoftAssert softAssert = new SoftAssert();
        serviceOffers.forEach(serviceOffer -> softAssert.assertTrue(region.toLowerCase(Locale.ROOT).equals(serviceOffer.regionSpanText().toLowerCase(Locale.ROOT))));
        softAssert.assertAll();
    }


}
