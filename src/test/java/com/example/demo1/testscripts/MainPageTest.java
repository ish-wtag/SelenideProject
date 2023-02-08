package com.example.demo1.testscripts;

import com.codeborne.selenide.Selenide;
import com.example.demo1.pages.MainPage;
import com.example.demo1.resources.base;
import org.testng.annotations.*;
import java.io.IOException;
import static org.testng.Assert.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest extends base {
    MainPage mainPage = new MainPage();

    @BeforeTest
    public void setUp() throws IOException {
        base.setUpAll();
        open(prop.getProperty("url"));
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        $("[data-test='search-input']").sendKeys("Selenium");
        $("button[data-test='full-search-button']").click();

        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
    }
    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
    }
}
