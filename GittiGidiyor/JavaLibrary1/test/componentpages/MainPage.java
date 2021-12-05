/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentpages;

import base.baseParameters;
import static org.openqa.selenium.By.name;

import common.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class MainPage extends baseParameters {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, baseParameters.driver);
    }

    /*Search textbox*/
    @FindBy(xpath = "//input[@placeholder='Keşfetmeye Bak']")
    private WebElement txtSearch;

    /*Search button*/
    @FindBy(xpath = "//span[contains(text(),'BUL')]")
    private WebElement btnSearch;

    /*2. page link */
    @FindBy(xpath = "//a[@title='2. sayfa']")
    private WebElement lnkSecondPage;

    /*Product Name in Detailed Page */
    @FindBy(xpath="//h1[@id='sp-title']")
    public  WebElement lblProductName;

    /*Product Price in Detailed Page */
    @FindBy(xpath="//div[@id='sp-price-lowPrice']")
    public  WebElement lblProductPrice;

    /*Add to Basket in Detailed Page */
    @FindBy(xpath="//div[@id='sp-price-lowPrice']")
    public  WebElement btnAddToBasket;

    /*Method which writes text to Search txtbox*/
    public void type_txtSearch(String text) {
        txtSearch.clear();
        txtSearch.sendKeys(text);

    }

    /*Method which searches after writing text*/
    public void searchProcess(String text) {
        type_txtSearch(text);
        btnSearch.click();
        BaseMethods.methodSleep(5000);
    }

    public void scrollvertical(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void click_secondPage() {
        scrollvertical(lnkSecondPage);

        lnkSecondPage.click();

        BaseMethods.methodSleep(10000);
    }

    public int randomForSelectProductInPage() {
        Random random = new Random();
        int r = random.nextInt(32 - 1 + 1) + 1;
        return r;
    }

    public void click_ithProduct() {
        BaseMethods.methodSleep(5000);

        scrollvertical(lnkSecondPage);

        BaseMethods.methodSleep(5000);

        String randomProduct=String.valueOf(randomForSelectProductInPage());
        driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/ul[1]/li[" + randomProduct + "]/article[1]/div[2]/a[1]")).click();
    }


}
