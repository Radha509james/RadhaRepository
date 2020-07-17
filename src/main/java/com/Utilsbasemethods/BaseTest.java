package com.Utilsbasemethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.Product.Pages.MenuPage;
import com.ProductTests.Dataprovider;

public class BaseTest {
	
public WebDriver driver;
public MenuPage menupageobj;
public Dataprovider dataproviderobj;
	
	@BeforeClass
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\cheru\\Desktop\\chromedriver.exe");
		 driver = new ChromeDriver();
		//driver.get("http://localhost/product/");
		driver.get("http://localhost/product/register.php");
		menupageobj= new MenuPage(driver);
		dataproviderobj= new Dataprovider();
		
		
	
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}
	

}
