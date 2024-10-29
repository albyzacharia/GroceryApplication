package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcellUtilities;
import utilities.GeneralUtilities;

public class ManageAdminUsers {
	WebDriver driver;
	ExcellUtilities eu = new ExcellUtilities();
	GeneralUtilities gu = new GeneralUtilities();

	public ManageAdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize page factory-static method of page factory
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerforUserCreation;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchConfirmButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement usersTableValue;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-edit']")
	WebElement editUser;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement editConfMessage;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFountTable;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement usernameToDelete;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-trash-alt']")
	WebElement deleteUser;

	public void clicknewbutton() {
		newButton.click();
	}

	public void newadminUserDetails() throws IOException {

		userName.sendKeys(ExcellUtilities.readStringData(1, 0));
		password.sendKeys(ExcellUtilities.readStringData(1, 1));
		gu.selectDropdownWithVisibleText(userType, "Admin");
		saveButton.click();
	}

	public boolean verifyalert() {
		boolean al = alerforUserCreation.getText().contains("User Created Successfully");
		return al;
	}

	public String searchUsername() throws IOException {
		searchButton.click();
		searchUserName.clear();
		String username = ExcellUtilities.readStringData(1, 0);
		searchUserName.sendKeys(username);
		searchConfirmButton.click();
		gu.scroll(driver);
		return username;

	}

	public String verifyUserName() {
		return usersTableValue.getText();

	}

	public String edituser() {
		editUser.click();
		String userNameedit = gu.generateCurrentDateAndTime();
		userName.sendKeys(userNameedit);

		updateButton.click();
		return userNameedit;

	}

	public boolean verifyEditconfirmMessage() {
		boolean flag = editConfMessage.getText().contains("User Updated Successfully");
		return flag;

	}

	public boolean resultNotFoundTable() {

		boolean isdisplayed = resultNotFountTable.isDisplayed();
		return isdisplayed;
	}
	
	public String deleteUser()
	{
		String delUser=usernameToDelete.getText();
		deleteUser.click();
		gu.acceptAlert(driver);
		return delUser; 
	}
	public void searchDeletedUsername(String user) 
	{
		searchButton.click();
		searchUserName.clear();
		searchUserName.sendKeys(user);
		searchConfirmButton.click();
		gu.scroll(driver);
		
	}
	public boolean verifyDeleteconfirmMessage() {
		boolean flag = editConfMessage.getText().contains("User Deleted Successfully");
		return flag;

	}
	

}
