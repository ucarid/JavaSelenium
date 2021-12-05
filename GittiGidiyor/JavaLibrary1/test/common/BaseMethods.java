/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import base.baseParameters;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class BaseMethods extends baseParameters {
        
    public static void methodSleep(int timeValue) {
        try {
            driver.manage().timeouts().implicitlyWait(timeValue, TimeUnit.SECONDS);
        } catch (Exception e) 
        {
        }
    }

    public static boolean exists(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

    public static String getURL()
    {
        String url=null;
        return url = driver.getCurrentUrl();

    }

    public void writeData(String productName, String productPrice){

        try {
            if(productName!=null||productPrice!=null) {
                FileWriter file = new FileWriter("product.txt");
                PrintWriter print = new PrintWriter(file);
                print.println(productName);
                print.println(productPrice);
                print.close();
            }

        } catch (IOException e) {
            System.out.println("HATA !!!");
        }
    }


}
