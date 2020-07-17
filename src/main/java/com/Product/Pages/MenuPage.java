package com.Product.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
WebDriver driver;
	
	public MenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="About Us")
	WebElement about;
	
	public void clickAboutUS(){
		about.click();
		
	}
	
	public String geturl(){
		return driver.getCurrentUrl();
		
	}

}
