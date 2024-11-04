package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcellUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class Category 
{
	WebDriver driver;
	ExcellUtilities eu = new ExcellUtilities();
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();

	public Category(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	WebElement subCatNametoEdit;
	@FindBy(xpath = "//tbody//tr[1]//td[2]")
	WebElement CatNametoEdit;
	@FindBy(xpath = "//tbody//tr[1]//i[@class='fas fa-edit']")
	WebElement editIcon;
	@FindBy(id = "main_img")
	WebElement importImage;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateCatAlert;
	@FindBy(id="category")
	WebElement category;
	

	
	public String readcategoryTableElement(int row, int column) 
	{
		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return element.getText();
	}
	public boolean categoryEdit() 
	{
		editIcon.click();
		category.clear();
		category.sendKeys("Apple");		
		importImage.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\Images\\SubCatImage.jpg");
		gu.scroll(driver);
		wu.explicitWaitForElementtobeClickable(driver, updateButton);
		updateButton.click();		
		boolean alert=updateCatAlert.getText().contains("Category Updated Successfully");
		return alert;
	}

}
