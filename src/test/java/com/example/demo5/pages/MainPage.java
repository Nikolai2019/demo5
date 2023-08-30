package com.example.demo5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// https://www.bing.com/
public class MainPage {
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = "h2 > a[href]")
    private WebElement urlField;

    public void sendText(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        System.out.println("Введен текст: " + text);
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void waitForUrl(WebDriver driver, int sec, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.attributeContains(urlField, attribute, value),
                ExpectedConditions.elementToBeClickable(urlField)
        ));
        System.out.println("Произошло ожидание в течение " + sec + " секунд");
    }

}
