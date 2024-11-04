package elementRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class SubCategory 
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public SubCategory(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize page factory-static method of page factory
	}
	

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newSubcategoryButton;
	@FindBy(id = "cat_id")
	WebElement subCategoryDropdown;
	@FindBy(id = "subcategory")
	WebElement subCategoryNameField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement subCategorySaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement subCatAlert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> subCategoryTableSize;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-edit']")
	WebElement subCategoryEdit;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement subCatNametoEdit;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]")
	WebElement categorynameofSubCat;
	@FindBy(xpath="//button[text()='Update']")
	WebElement catogoryUpdateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement subCatUpdateAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement subCatSearchButton;
	@FindBy(xpath="//select[@id='un']")
	WebElement searchCategory;
	@FindBy(name="ut")
	WebElement searchSubCategory;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchConfirmButton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFoundMesg;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-trash-alt']")
	WebElement subCategoryDeleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement subCatDeleteSuccessMsg;

	public void addNewSubcategory()
	{
		newSubcategoryButton.click();
		gu.selectDropdownWithVisibleText(subCategoryDropdown, "Apple");
	}
	public String enterSubCategoryName()
	{
		String subCatName = "Pink Lady" + gu.generateCurrentDateAndTime();
		subCategoryNameField.sendKeys(subCatName);
		return subCatName;
	}
	public void saveSubCategory() 
	{
		subCategorySaveButton.click();
	}
	public void isAlertDisplayed()
	{
		subCatAlert.isDisplayed();
	}
	public String gettextalert() 
	{
		return subCatAlert.getText();
	}

	public String readSubcategoryTableElement(int row, int column) 
	{
		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return element.getText();
	}

	public void clickSubCategoryEditButton() 
	{
		subCategoryEdit.click();
	}

	public String subCategoryNametoEdit() 
	{
		return subCatNametoEdit.getText();
	}

	public String categoryNametoEditCat() 
	{
		return categorynameofSubCat.getText();
	}
	public void clearenterSubCategoryName() 
	{
		
		subCategoryNameField.clear();
	}
	public void updateEditSubCategory()
	{
		catogoryUpdateButton.click();
	}
	public boolean updateAlertDisplated()
	{
		subCatUpdateAlert.isDisplayed();
		String message=subCatUpdateAlert.getText();
		boolean msg=message.contains("Sub Category Updated Successfully");
		return msg;
	}
	public void confirmSubCatSearch(String subCatEdited,String catogoryOfSubCat)
	{
		subCatSearchButton.click();	
		gu.selectDropdownWithVisibleText(searchCategory, catogoryOfSubCat);
		searchSubCategory.sendKeys(subCatEdited);
		searchConfirmButton.click();		
	}
	public boolean resultNotFouncSearchMsg()
	{
		resultNotFoundMesg.isDisplayed();
		boolean msg=resultNotFoundMesg.getText().contains("RESULT NOT FOUND");
		return msg;
	}
	public boolean deleteSubCategory()
	{
		subCategoryDeleteButton.click();		
		gu.acceptAlert(driver);
		subCatDeleteSuccessMsg.isDisplayed();
		boolean deleteMsg=subCatDeleteSuccessMsg.getText().contains("Sub Category Deleted Successfully");
		return deleteMsg;
	}

}
