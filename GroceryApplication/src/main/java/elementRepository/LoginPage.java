package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcellUtilities;

public class LoginPage 
{
	WebDriver driver;
	ExcellUtilities eu=new ExcellUtilities();
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize page factory-static method of page factory
	}
	
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signinButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;



public void sendLoginDetails(String userName,String passWord)
{
	userNameField.sendKeys(userName);
	password.sendKeys(passWord);
	signinButton.click();
}
public String getWarningMessageText()
{
return 	alertMessage.getText();
}
public HomePage loginToApplication() throws IOException
{		
	userNameField.sendKeys(ExcellUtilities.readStringData(0, 0));	
	password.sendKeys(ExcellUtilities.readStringData(0, 1));
	signinButton.click();
	return new HomePage(driver);	
}

}

