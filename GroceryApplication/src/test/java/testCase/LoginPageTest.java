package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	// SoftAssert softAssert = new SoftAssert();

	@Test(groups = "smoke")
	public void verifyLoginWithValidData() throws IOException {
		lp = new LoginPage(driver);		
		hp = lp.loginToApplication();
		String actual = hp.getHomepageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);
		// softAssert.assertEquals(actual, expected,
		// Constant.lp_verifyLoginWithValidData);

	}

	@Test(enabled = false, dataProvider = "data-provider")
	public void verifyLoginWithInValidData(String userName, String password) {
		lp = new LoginPage(driver);
		lp.sendLoginDetails(userName, password);
		String actual = lp.getWarningMessageText();
		String expected = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actual, expected, "Alert text not as expected");

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admrtin", "admin" }, { "admin", "ffg" }, { "erf", "ff" } };
	}

}
