package testValidation;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunction.setUp;

public class test extends setUp{
	String HomePageTitle, UserPageTitle;
	String WomenPageTitle, DressesPageTitle, TshirtsPageTitle;
	String TshirtsSubPageTitle,EveningDressesPageTitle,SummerDressesPageTitle;
	
	public void homePage()
	{
	 String baseUrl = prop.getProperty("websiteUrl");
	 driver.get(baseUrl);
	 HomePageTitle = driver.getTitle();
	 PageFactory.initElements(driver,pageObject.homePage.class);
	 pageObject.homePage.Signbtn.click();
	}
	public void loginPage() 
	{
		PageFactory.initElements(driver,pageObject.loginPage.class);
		pageObject.loginPage.email.sendKeys(prop.getProperty("userName"));
		pageObject.loginPage.password.sendKeys(prop.getProperty("password"));
		pageObject.loginPage.submitbtn.click();
		UserPageTitle = driver.getTitle();
	}
	public void browsePage()
	{
		PageFactory.initElements(driver,pageObject.browsePage.class);
		Actions action = new Actions(driver);
		//Category = Women
		pageObject.browsePage.womenCategory.click();
		WomenPageTitle = driver.getTitle();
		System.out.println(WomenPageTitle);
		//Sub Category = T-Shirts
		action.moveToElement(pageObject.browsePage.womenCategory).perform();
		pageObject.browsePage.tshirtsSubCategory.click();
		TshirtsSubPageTitle = driver.getTitle();
		System.out.println(TshirtsSubPageTitle);
		//Sub Category = Evening Dresses
		action.moveToElement(pageObject.browsePage.womenCategory).perform();
		pageObject.browsePage.eveningDressesSubCategory.click();
		EveningDressesPageTitle = driver.getTitle();
		System.out.println(EveningDressesPageTitle);
		//Category = Dress
		pageObject.browsePage.dressesCategory.click();
		DressesPageTitle=driver.getTitle();
		System.out.println(DressesPageTitle);
		//Sub Category = Summer Dresses
		action.moveToElement(pageObject.browsePage.dressesCategory).perform();
		pageObject.browsePage.summerDressesSubCategory.click();
		SummerDressesPageTitle = driver.getTitle();
		System.out.println(SummerDressesPageTitle);
		//Category = T-Shirts
		pageObject.browsePage.tshirtsCategory.click();
		TshirtsPageTitle = driver.getTitle();
		System.out.println(TshirtsPageTitle);
		
	}
	public void writeData()
	{
		output.setProperty("Category Women Page Title", WomenPageTitle);
		output.setProperty("Sub Category T-shirt page", TshirtsSubPageTitle);
		output.setProperty("Sub Category Evening Page", EveningDressesPageTitle);
		output.setProperty("Category Dress Page Title", DressesPageTitle);
		output.setProperty("Sub Category Summer Page", SummerDressesPageTitle);
		output.setProperty("Category T-shirt Page Title", TshirtsPageTitle);
	}

	@Test
	public void validation_1()
	{
		homePage();
		loginPage();
		Assert.assertNotEquals(HomePageTitle, UserPageTitle);
	}
	
	@Test
	public void validation_2()
	{
		browsePage();
		writeData();
	}
}
