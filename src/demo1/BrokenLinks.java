package demo1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks {
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    WebDriverWait wait=new WebDriverWait(driver,60);
	    
	    driver.get("https://www.freecrm.com/");
	    
	    System.out.println(driver.getCurrentUrl());
	    
	    System.out.println(driver.getTitle());
	    
	    WebElement uname=driver.findElement(By.xpath(".//*[@type='text']"));
	    
	    WebElement pwd=driver.findElement(By.xpath(".//*[@type='password']"));
	    
	    WebElement login=driver.findElement(By.xpath(".//input[@type='submit']"));
	    
	    uname.clear();
	    
	    uname.sendKeys("naveenk");
	    
	    pwd.clear();
	    
	    pwd.sendKeys("test@123");
	    
	    login.click();
	    
	    Thread.sleep(2000);
	    
	    driver.switchTo().frame("mainpanel");
	    
	    List<WebElement>links=driver.findElements(By.tagName("a"));
	    
	    links.addAll(driver.findElements(By.tagName("img")));
	    
	    System.out.println(links.size());
	    
	    List<WebElement>activelinks=new ArrayList ();
	    
	    for(int i=0;i<links.size();i++){
	    	
	    	if(links.get(i).getAttribute("href")!=null && !links.get(i).getAttribute("href").contains("javascript")){
	    		
	    		activelinks.add(links.get(i));
	    	}
	    }
	    
	    for(int j=0;j<activelinks.size();j++){
	    	
	    	HttpURLConnection connection=(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
	    	
	    	connection.connect();
	    	
	    	String response=connection.getResponseMessage();
	    	
	    	connection.disconnect();
	    	
	    	System.out.println(activelinks.get(j).getAttribute("href")+"<........>"+response);
	    	
	    }
	    
	    
	}

}
