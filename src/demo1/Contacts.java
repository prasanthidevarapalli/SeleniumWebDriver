package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts {
	
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
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
		
		WebElement con=driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/a"));
		
		con.click();
		
		Thread.sleep(2000);
		
		String ox=".//*[@id='vContactsForm']/table/tbody/tr[";
		
		String nx="]/td[2]";
		
		List<WebElement>rows=driver.findElements(By.xpath(".//*[@id='vContactsForm']/table/tbody/tr"));
		
		System.out.println(rows.size()-4);
		
		for(WebElement elr:rows){
			
			System.out.println(elr.getText());
		}
		for(int i=4;i<=21;i++){
			
			String cname=driver.findElement(By.xpath(ox+i+nx)).getText();
			
			System.out.println(cname);
			
			if(cname.contains("abc xyz")){
				
				driver.findElement(By.xpath(".//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
				
				break;
			}
		}
		
	}

}
