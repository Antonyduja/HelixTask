package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class browsePage {

	@FindBy(xpath="//a[@title ='Women' and @class ='sf-with-ul']")
	public static WebElement womenCategory;
	
	@FindBy(xpath="(//a[@title ='Dresses' and @class ='sf-with-ul'])[2]")
	public static WebElement dressesCategory;
	
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	public static WebElement tshirtsCategory;
	
	@FindBy(xpath="//a[@title ='Women' and @class ='sf-with-ul']/parent::li/descendant::a[@title='T-shirts']")
	public static WebElement tshirtsSubCategory;
	
	@FindBy(xpath ="//a[@title ='Women' and @class ='sf-with-ul']/parent::li//a[@title='Evening Dresses']")
	public static WebElement eveningDressesSubCategory;
	
	@FindBy(xpath="(//a[@title ='Dresses' and @class ='sf-with-ul']/parent::li//a[@title='Summer Dresses'])[2]")
	public static WebElement summerDressesSubCategory;
		
	
}
