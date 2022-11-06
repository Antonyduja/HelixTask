package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	@FindBy(xpath="//input[@id='email']")
	public static WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	public static WebElement password;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	public static WebElement submitbtn;

}
