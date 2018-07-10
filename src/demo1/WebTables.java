package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTables {
	
	public static void main(String[] args){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		List<WebElement>headers=driver.findElements(By.xpath(".//*[@class='dataTable']/thead/tr[1]/th"));
		
		System.out.println(headers.size());
		
		for(WebElement elh:headers){
			
			System.out.println(elh.getText());
		}
		
		List<WebElement>rows=driver.findElements(By.xpath(".//*[@class='dataTable']/tbody/tr"));
		
		System.out.println(rows.size()-1);
		
		for(WebElement elr:rows){
			
			System.out.println(elr.getText());
		}
		
		for(int i=2;i<=rows.size();i++){
		
		List<WebElement>colrow=driver.findElements(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td"));
		
		System.out.println("no.of columns in"+(i-1)+"row is"+colrow.size());
		
		}
		
		//current price and percentage change for vijayabank
		
		for(int i=2;i<=rows.size();i++){
			
			WebElement bname=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[1]"));
			
			if(bname.getText().toLowerCase().equalsIgnoreCase("Vijaya Bank")){
				
				WebElement prices=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[4]"));
				
				WebElement per=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[5]"));
				
				System.out.println("prices and percentage change for vijayabank are"+prices.getText() + per.getText());
				
			}
		}
		
		//which bank has the current price 552.60
		
		for(int i=2;i<=rows.size();i++){
			
			WebElement cprice=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[4]"));
			
			if(cprice.getText().equals("552.60")){
				
				WebElement banknames=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[1]"));
				
				WebElement changes=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[5]"));
				
				System.out.println("current price 552.60 has bank name and changes are"+banknames.getText() + changes.getText());
			}
		}
		
		//third row second column data
		
		for(int i=2;i<=rows.size();i++){
		
		WebElement thirdrow=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[1]"));
		
		if(thirdrow.getText().equalsIgnoreCase("IDBI Bank Ltd")){
			
			WebElement secondcol=driver.findElement(By.xpath(".//*[@class='dataTable']/tbody/tr["+i+"]/td[2]"));
			
			System.out.println(secondcol.getText());
			
		}
		}
		
		
	}

}
