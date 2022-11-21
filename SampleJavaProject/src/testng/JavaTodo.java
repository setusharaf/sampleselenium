package testng;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class JavaTodo {
    String username = "setusharaf";
    String accesskey = "LMMriwi7EQwnpHCh6Nlxj4ttblolpchD4KJRSIixdzN2byjjBj";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    String usermsg = "Welcome to LambdaTest";
    boolean status = false;
    public static void main(String[] args) {
		/*
		 * new JavaTodo().test(); new JavaTodo().test2(); new JavaTodo().test3();
		 */
    }
  
    @Test
    
    public void test() {
        // To Setup driver
        
        try {
              //Change it to production page
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
              //Let's mark done first two items in the list.
              driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
              String currenturl = driver.getCurrentUrl();
             if( currenturl.contains("simple-form-demo"))
             {
            	 status = true;
             }
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.id("user-message")).sendKeys(usermsg);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//button[contains(text(), 'Get Checked value')]")).click();
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String ele = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
            ele.contains(usermsg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tearDown();
        }
    }
    @Test
    public void test2()
    {
    	
    	  try {
              //Change it to production page
            driver.get("https://www.lambdatest.com/selenium-playground/");
           
            JavascriptExecutor js = (JavascriptExecutor) driver;
				
            WebElement Element = driver.findElement(By.linkText("Drag & Drop Sliders"));

            // Scrolling down the page till the element is found		
            js.executeScript("arguments[0].scrollIntoView();", Element);
            js.executeScript("arguments[0].click();", Element);
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         //   driver.switchTo().frame("AWIN_CDT"); 
            Thread.sleep(2000);
            for(int i=0; i<=2;i++) {
    			try {
    				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    				 WebElement slider = driver.findElement(By.xpath("//div[@class='sp__range sp__range-success']//input[@class='sp__range']"));
    				 Actions action= new Actions(driver);
    				    action.click(slider).build().perform();
    				    Thread.sleep(1000);
    				    for (int j = 0; j < 45; j++) 
    				    {
    				        action.sendKeys(Keys.ARROW_RIGHT).build().perform();
    				       
    				    }
    				break;
    			}
    			catch(StaleElementReferenceException e) {
    				System.out.println(e.getMessage());
    			}
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    			WebElement slidercounter  = driver.findElement(By.xpath("//*[@id=\"rangeSuccess\"]"));
    			String counter = slidercounter.getText();
    			String expectedcounter = "95";
    			Assert.assertEquals(counter, expectedcounter);
    			
    		}
         
              //Let's mark done first two items in the list.
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
  
    
    @BeforeMethod
    @Parameters(value={"browser","version","platform"})
    private void setUp(String browser, String version, String platform) {
    //	ChromeOptions browserOptions = new ChromeOptions();
    	  DesiredCapabilities capabilities = new DesiredCapabilities();
    	     capabilities.setCapability("browserName", browser);
    	     capabilities.setCapability("version", version);
    	     capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
    	     capabilities.setCapability("build", "ParallelTestNG");
    	     capabilities.setCapability("name", "ParallelTestNG");
    	     capabilities.setCapability("network", true); // To enable network logs
    	     capabilities.setCapability("visual", true); // To enable step by step screenshot
    	     capabilities.setCapability("video", true); // To enable video recording
    	     capabilities.setCapability("console", true); 
				/*
				 * browserOptions.setPlatformName("Windows 10");
				 * browserOptions.setBrowserVersion("107.0"); HashMap<String, Object> ltOptions
				 * = new HashMap<String, Object>(); ltOptions.put("username", "setusharaf");
				 * ltOptions.put("accessKey",
				 * "LMMriwi7EQwnpHCh6Nlxj4ttblolpchD4KJRSIixdzN2byjjBj");
				 * ltOptions.put("visual", true); ltOptions.put("video", true);
				 * ltOptions.put("project", "Untitled"); ltOptions.put("w3c", true);
				 * ltOptions.put("plugin", "java-testNG");
				 * browserOptions.setCapability("LT:Options", ltOptions);
				 */
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	/*
	 * private void setUp2() { FirefoxOptions browserOptions = new FirefoxOptions();
	 * browserOptions.setPlatformName("Windows 10");
	 * browserOptions.setBrowserVersion("105.0"); HashMap<String, Object> ltOptions
	 * = new HashMap<String, Object>(); ltOptions.put("username", "setusharaf");
	 * ltOptions.put("accessKey",
	 * "LMMriwi7EQwnpHCh6Nlxj4ttblolpchD4KJRSIixdzN2byjjBj");
	 * ltOptions.put("visual", true); ltOptions.put("video", true);
	 * ltOptions.put("project", "Untitled"); ltOptions.put("selenium_version",
	 * "4.1.2"); ltOptions.put("w3c", true); ltOptions.put("plugin", "java-testNG");
	 * browserOptions.setCapability("LT:Options", ltOptions); try { driver = new
	 * RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL),
	 * browserOptions); } catch (MalformedURLException e) {
	 * System.out.println("Invalid grid URL"); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } }
	 * 
	 * private void setUp3() { SafariOptions browserOptions = new SafariOptions();
	 * browserOptions.setPlatformName("MacOS Monterey");
	 * browserOptions.setBrowserVersion("15.0"); HashMap<String, Object> ltOptions =
	 * new HashMap<String, Object>(); ltOptions.put("username", "setusharaf");
	 * ltOptions.put("accessKey",
	 * "LMMriwi7EQwnpHCh6Nlxj4ttblolpchD4KJRSIixdzN2byjjBj");
	 * ltOptions.put("visual", true); ltOptions.put("video", true);
	 * ltOptions.put("project", "Untitled"); ltOptions.put("selenium_version",
	 * "4.1.2"); ltOptions.put("driver_version", "15"); ltOptions.put("w3c", true);
	 * browserOptions.setCapability("LT:Options", ltOptions); try { driver = new
	 * RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL),
	 * browserOptions); } catch (MalformedURLException e) {
	 * System.out.println("Invalid grid URL"); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } }
	 */
    @AfterMethod
    private void tearDown() {
        if (driver != null) {
            //((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }
}