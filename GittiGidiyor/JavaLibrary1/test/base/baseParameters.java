package base;

import common.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class baseParameters {
    
    public final static String MAIN_PAGE_URL = "https://www.gittigidiyor.com/";

    public final static Integer Browser_Type = 1; // For Chrome, 1.
 
    public static   WebDriver driver = null;
    
     public void beforeMethod() {

        if (Browser_Type == 1)//Chrome
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\GittiGidiyor\\JavaLibrary1\\test\\driver\\chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            
            driver.get(MAIN_PAGE_URL);
            
            BaseMethods.methodSleep(5000);
        }
    }

    public void afterMethod() {

        driver.quit();

    }
}
