package demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendars {
	
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		
		driver.get("https://www.freecrm.com/index.html");
		
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
		
		WebElement cal=driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[2]/a"));
		
		cal.click();
		
		Thread.sleep(2000);
		
		String date="25-October-2015";
		
		String dateArr[]=date.split("-");
		
		String day=dateArr[0];
		
		String month=dateArr[1];
		
		String year=dateArr[2];
		
		String ox1=".//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		
		String nx1="]/td[";
		
		Select select=new Select(driver.findElement(By.name("slctMonth")));
		
		select.selectByVisibleText(month);
		
		Select select1=new Select(driver.findElement(By.name("slctYear")));
		
		select1.selectByVisibleText(year);
		
		
		int totalweekdays=7;
		
		boolean flag=false;
		
		for(int rownum=2;rownum<=7;rownum++){
			
			for(int colnum=1;colnum<=totalweekdays;colnum++){
				
				String dayval=driver.findElement(By.xpath(ox1+rownum+nx1+colnum+"]")).getText();
				
				if(dayval.equalsIgnoreCase(day)){
					
					driver.findElement(By.xpath(ox1+rownum+nx1+colnum+"]")).click();
					
					flag=true;
					
					break;
				}
			}
		
		
		if(flag){
			
			break;
		}
		}
		
		
		
	}

}
