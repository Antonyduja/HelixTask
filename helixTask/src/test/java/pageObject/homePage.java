package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	
		@FindBy(xpath = "//a[contains(text(),'Sign in')]") 
		public static WebElement Signbtn;
		
}
