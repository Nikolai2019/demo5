package com.example.demo5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage {
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = "h2 > a[href]")
    private List<WebElement> results;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickElement(int num) {
        results.get(num).click();
        System.out.println("Нажатие на результат под номером: " + num);
    }

    public String getTextFromSearchField() {
        String val = searchField.getAttribute("value");
        System.out.println("В строке поиск текст: " + val);
        return val;
    }

    public void switchToTab(WebDriver driver, int num) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num));
        System.out.println("Перешли на вкладку №" + (num + 1));
    }

}
