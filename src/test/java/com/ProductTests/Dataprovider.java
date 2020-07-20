package com.ProductTests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilsbasemethods.BaseTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Dataprovider extends BaseTest{
	
	
	
	
	
	@DataProvider(name = "DP1")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=getTableArray("C:\\Users\\cheru\\workspace\\RadhaMavenProject\\src\\main\\resources\\data1.xls",
                "Sheet1", "Register");
        return(retObjArr);
    }
	
	
	@Test(dataProvider="DP1")
	public void m1(String v1,String v2,String v3,String v4){
		
		System.out.println("The name :"+v1+"Email ID  " +v2+"Password   "+v3+"   Phone  "+v4);
		driver.findElement(By.id("name")).sendKeys(v1);
		driver.findElement(By.id("email")).sendKeys(v2);
		driver.findElement(By.id("password")).sendKeys(v3);
		driver.findElement(By.id("mobile")).sendKeys(v4);
		driver.findElement(By.name("submit")).click();
		
		
		
		String actual=driver.findElement(By.xpath("//div[@class='bill_row']/span[3]")).getText();
		String expected="Thanks for Registering. Use your Email id and password to Login and post your Deals!!";
		
		Assert.assertEquals(actual,"Thanks for Registering. Use your Email id and password to Login and post your Deals!!");
		
		
	}
	
	
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
        String[][] tabArray=null;
        
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName); 
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                    "startCol="+startCol+", endCol="+endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }
        

        return(tabArray);
    }
    
	
	
	
	
	
	

}


