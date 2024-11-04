package testCase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsTab;

public class ManageNewsTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ManageNewsTab mn;

	@Test(enabled = false)
	public void verifyNewNewsCreation() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		mn = hp.clickmanageNewsTab();
		Assert.assertEquals(mn.addNewNews(), true, Constant.map_ManageNews);
	}

	@Test
	public void verifyDeleteNews() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		mn = hp.clickmanageNewsTab();
		Assert.assertEquals(mn.deleteNews(), true, Constant.map_deletenews);
	}
}
