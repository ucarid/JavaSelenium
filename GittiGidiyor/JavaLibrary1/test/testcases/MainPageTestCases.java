/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcases;

import base.baseParameters;
import common.BaseMethods;
import componentpages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


public class MainPageTestCases extends baseParameters {
    
    
    componentpages.MainPage mainPage;
    common.BaseMethods baseMethods;
        public static void main(String[] args) {

    }
    @Before
    public void setUp() 
    {
        super.beforeMethod();
        
        mainPage=PageFactory.initElements(driver, componentpages.MainPage.class);
    }
    
    @Test
    public void SearchWithWord(){

       mainPage.searchProcess("bilgisayar") ;

       mainPage.click_secondPage();
        try {
            Assert.assertEquals(baseMethods.getURL(), "https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2");
        } catch (Exception e) {
            System.out.println("Hata:" + e.toString());
        }
        BaseMethods.methodSleep(5000);
        mainPage.click_ithProduct();

       /*baseMethods.writeData(mainPage.lblProductName.getText(),mainPage.lblProductPrice.getText());*/

        mainPage.btnAddToBasket.click();
    }


    
    @After
    public void tearDown() 
    {
        super.afterMethod();
    }
}
