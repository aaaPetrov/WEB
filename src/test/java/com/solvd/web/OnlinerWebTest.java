package com.solvd.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.solvd.web.page.*;
import com.solvd.web.page.components.NewsDropdownMenu;
import com.solvd.web.page.components.*;
import com.solvd.web.service.AbstractService;
import com.solvd.web.service.SearchModalService;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class OnlinerWebTest implements IAbstractTest {

    @Test
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

        AbstractService abstractService = new AbstractService(getDriver());
        abstractService.waitStateAnimation(10);

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

        SearchModalService searchModalService = new SearchModalService(getDriver());
        searchModalService.switchAndWait(5);

        List<SearchedItem> searchedItems = searchModalService.getSearchedItems();
        Assert.assertFalse(searchedItems.isEmpty(), "No search result found.");

        SoftAssert softAssert = new SoftAssert();
        searchedItems.forEach(searchedItem -> softAssert.assertTrue(searchedItem.getItemTitleText().toLowerCase(Locale.ROOT).contains("blackview")));
        softAssert.assertAll();
    }

    @DataProvider(name = "giftProductItemNames")
    public Object[][] itemNames() {
        return new Object[][]{{List.of(
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
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.giftCatalogLinkClick();

        AbstractService abstractService = new AbstractService(getDriver());
        abstractService.waitStateAnimation(5);

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
        return new Object[][]{{"Минск"}, {"Брест"}, {"Витебск"}, {"Гомель"}, {"Гродно"}, {"Могилев"}};
    }

    @Test(dataProvider = "serviceOfferRegionNames")
    public void verifyServicesRegionTest(String region) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeader().getTopMenu().clickMenuItem("Услуги");

        AbstractService abstractService = new AbstractService(getDriver());
        abstractService.waitStateAnimation(5);

        ServicesPage servicesPage = new ServicesPage(getDriver());
        Assert.assertTrue(servicesPage.getRegionSelectLine().isPresent());
        servicesPage.regionSelectLineClick();
        Assert.assertTrue(servicesPage.getRegionDropdown().isUIObjectPresent());

        servicesPage.getRegionDropdown().regionItemCheckBoxClock(region);
        abstractService.waitStateAnimation(5);
        List<ServiceOffer> serviceOffers = servicesPage.getServiceOffers();

        SoftAssert softAssert = new SoftAssert();
        serviceOffers.forEach(serviceOffer -> softAssert.assertTrue(region.toLowerCase(Locale.ROOT).equals(serviceOffer.regionSpanText().toLowerCase(Locale.ROOT))));
        softAssert.assertAll();
    }


}
