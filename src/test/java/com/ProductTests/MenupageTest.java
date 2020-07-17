package com.ProductTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Utilsbasemethods.BaseTest;

public class MenupageTest extends BaseTest {
	
	
	@Test
	public void validateAboutus(){
		
		menupageobj.clickAboutUS();
		Assert.assertEquals(menupageobj.geturl(), "http://localhost/product/aboutus.php");
		
		
	}

}
