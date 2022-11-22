package com.questyAutomation.testcases;

import static org.testng.Assert.assertEquals;

//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Sampletest {

	
	String username = "setutalati1";
    String accesskey = "9V3gy6bsaloFNA9Fw1eSPug5BSHzQzrgK31awLoKmQktsLOSBX";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    String usermsg = "Welcome to LambdaTest";
    boolean status = false;
    public static void main(String[] args) {
		
		 new Sampletest().test(); new Sampletest().test2(); new Sampletest().test3();
		 
    }
  
    @Test
    
    public void test() {
        // To Setup driver
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
            }catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                tearDown();
            }
    }
 
    
    @Test
    
    public void test3() {
        // To Setup driver
        
        try {
              //Change it to production page
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
              //Let's mark done first two items in the list.
              driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[5]/a")).click();
           
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys("setu sharaf");
            driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("setusharaf@gmail.com");
            driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("setu88riya");
            driver.findElement(By.id("company")).sendKeys("promact infotech");
            driver.findElement(By.name("website")).sendKeys("https://promactinfo.com/");
            Thread.sleep(2000);
            Select drpCountry = new Select(driver.findElement(By.name("country")));
    		drpCountry.selectByVisibleText("United States");
            driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("vadodara");
            driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("B-42, Ashirwad Society, Warasia- ring Road");
            driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("B-42, Ashirwad Society");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Gujarat");
            driver.findElement(By.id("inputZip")).sendKeys("390022");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
            String confirmtext = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us, we will get back to you ')]")).getText();
            String expectedtext = "Thanks for contacting us, we will get back to you shortly.";
            Assert.assertEquals(confirmtext, expectedtext);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tearDown();
        }
    }
    
    @BeforeMethod
    @Parameters(value={"browser","version","platform"})
    public void setUp(String browser, String version, String platform) {
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

	
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }

}
