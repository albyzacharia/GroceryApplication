package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageText;
	@FindBy(xpath="//li//p[text()='Sub Category']")
	WebElement subCategoryButton;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Manage Users']")
	WebElement manageUsersButton;
	@FindBy(xpath="//a//p[text()='Manage News']")
	WebElement manageNewsTab;
	@FindBy(xpath="//li[@class='nav-item']//p[text()='Category']")
	WebElement categoryTab;
	
	public String getHomepageText()
	{
		return homePageText.getText();
	}
	public SubCategory clickOnSubcategoryButton()
	{
		subCategoryButton.click();
		return new SubCategory(driver);
	}
	public ManageAdminUsers openManageAdminUser() {
		adminUsers.click();
		manageUsersButton.click();
		return new ManageAdminUsers(driver);
	}
	public ManageNewsTab clickmanageNewsTab()
	{
		manageNewsTab.click();
		return new ManageNewsTab(driver);	}
	public Category clickCategoryTab()
	{
		categoryTab.click();
		return new Category(driver);	}
	}



