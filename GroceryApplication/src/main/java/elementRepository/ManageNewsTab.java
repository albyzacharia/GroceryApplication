package elementRepository;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcellUtilities;
import utilities.GeneralUtilities;


public class ManageNewsTab
{
	WebDriver driver;
	ExcellUtilities eu=new ExcellUtilities();
	GeneralUtilities gu = new GeneralUtilities();
	public ManageNewsTab(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newNewsTab;
	@FindBy(id="news")
	WebElement newsTextArea;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveNews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement newsAlert;
	@FindBy(xpath="//tbody//tr[1]//i[@class='fas fa-trash-alt']")
	WebElement deleteNews;
	
	
	public boolean addNewNews() throws IOException
	{
		newNewsTab.click();
		newsTextArea.sendKeys(ExcellUtilities.readStringData(2, 0));
		saveNews.click();
		boolean alert=newsAlert.getText().contains("News Created Successfully");
		return alert;		
	}
	public boolean deleteNews() 
	{
		deleteNews.click();
		gu.acceptAlert(driver);
		boolean alert=newsAlert.getText().contains("News Deleted Successfully");
		return alert;
		
	}
}




