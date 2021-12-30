package com.crm.qa.base;

import com.crm.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.crm.qa.util.TestUtil.IMPLICIT_WAIT;
import static com.crm.qa.util.TestUtil.PAGE_LOAD_TIME_OUT;

public class TestBase {

    //https://github.com/naveenanimation20/PageObjectModel
    //https://www.youtube.com/watch?v=GQeZggZFhhk&list=RDCMUCXJKOPxx4O1f63nnfsoiEug&start_radio=1 -TestNG
    //https://www.youtube.com/playlist?list=PLFGoYjJG_fqq6cHeqfsDes3pdVh3kpl74 -- Framework
    //https://www.youtube.com/watch?v=DFvuORfibac -- Generics
    //https://www.youtube.com/watch?v=PmijECRKeII -- Best Practices for Page Object Model - UI Automation (Mobile & Web) - Whiteboard Learning
    //How To Explain Test Automation Framework In Interviews For Selenium -- https://www.youtube.com/watch?v=28mX8Xn_Big&t=104s
    //https://www.youtube.com/watch?v=Lx6ZTEUD4_E -- How To Explain Project, Roles & Experience Summary In Interview

    //https://www.youtube.com/watch?v=0Gew2XOuum8 -- TestNG Framework- Selenium Tutorial Part-1
    //https://www.seleniumeasy.com/selenium-tutorials/using-chrome-options-for-webdriver-tests
    //https://rajeevtechblog.wordpress.com/2018/09/21/how-to-generate-testng-report-in-intellij/ -- TestNG Report
    //https://chromedriver.chromium.org/capabilities
    public static WebDriver driver;
    public  static Properties prop;
    public static WebDriverWait wait;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try {
             prop = new Properties();
            System.out.println(System.getProperty("user.dir"));
            FileInputStream config = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
            prop.load(config);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initialize(){

        if(prop.getProperty("browser").equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("--headless");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER); //https://stackoverflow.com/questions/48450594/selenium-timed-out-receiving-message-from-renderer
            options.setAcceptInsecureCerts(true); //https://www.toolsqa.com/selenium-webdriver/ssl-certificate-in-selenium/
            //https://chromedriver.chromium.org/capabilities
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Chromedriver.exe");
            driver = new ChromeDriver(options);

            e_driver = new EventFiringWebDriver(driver);
            eventListener = new WebEventListener();
            e_driver.register(eventListener);
            driver = e_driver;

            wait = new WebDriverWait(driver,30);
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
            System.out.println("test");
        }

    }


}
