package testCase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategory;

public class SubCategoryTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	SubCategory sc;

	@Test(enabled = false)
	public void verifyNewSubcategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		sc = hp.clickOnSubcategoryButton();
		sc.addNewSubcategory();
		String subCatName = sc.enterSubCategoryName();
		sc.saveSubCategory();
		sc.isAlertDisplayed();
		String actual = sc.gettextalert();
		System.out.println(actual);
		String expected = "�\n" + "Alert!\n" + "Sub Category Created Successfully";
		Assert.assertEquals(actual, expected, "SubCategory Creation is not as expected");// hard assertion
		hp.clickOnSubcategoryButton();
		String actualSubCategoryName = sc.readSubcategoryTableElement(1, 1);
		String expectedSubcategoryName = subCatName;
		Assert.assertEquals(actualSubCategoryName, expectedSubcategoryName, "SubCategory not added to the table");

	}

	@Test(enabled = false)
	public void verifyEditSubcategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		sc = hp.clickOnSubcategoryButton();
		String editcatName = sc.categoryNametoEditCat();
		String editsubcatname = sc.subCategoryNametoEdit();
		sc.clickSubCategoryEditButton();
		sc.clearenterSubCategoryName();
		String newSubcat = sc.enterSubCategoryName();
		sc.updateEditSubCategory();
		boolean actualAlertmessage = sc.updateAlertDisplated();
		System.out.println(actualAlertmessage);
		Assert.assertEquals(actualAlertmessage, true);
		String actualnewSubCategoryName = sc.readSubcategoryTableElement(1, 1);
		String expectednewSubcategoryName = newSubcat;
		Assert.assertEquals(actualnewSubCategoryName, expectednewSubcategoryName,
				"SubCategory not edited to the table");
		sc.confirmSubCatSearch(editsubcatname, editcatName);
		boolean searchResult = sc.resultNotFouncSearchMsg();
		Assert.assertEquals(searchResult, true);

	}

	@Test
	public void verifyDeleteSubcategory() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sc = new SubCategory(driver);
		// lp.sendLoginDetails("admin", "admin");
		lp.loginToApplication();
		hp.clickOnSubcategoryButton();
		String editcatName = sc.categoryNametoEditCat();
		String editsubcatname = sc.subCategoryNametoEdit();
		boolean msgdelete = sc.deleteSubCategory();
		Assert.assertEquals(msgdelete, true);
		sc.confirmSubCatSearch(editsubcatname, editcatName);
		boolean searchResult = sc.resultNotFouncSearchMsg();
		Assert.assertEquals(searchResult, true);

	}
}
