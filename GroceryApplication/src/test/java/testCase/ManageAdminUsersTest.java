package testCase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageAdminUsers;

public class ManageAdminUsersTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ManageAdminUsers map;

	@Test(priority = -2, enabled = false)
	public void verifyNewAdminUserCreation() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		map = hp.openManageAdminUser();
		map.clicknewbutton();
		map.newadminUserDetails();
		boolean actual = map.verifyalert();
		Assert.assertEquals(actual, true, Constant.map_verifyNewAdminUserCreation);
		Assert.assertEquals(map.searchUsername(), map.verifyUserName(), Constant.map_verifyNewAdminUserCreation);
	}

	@Test(priority = -1, enabled = false)
	public void editAdminUser() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		map = hp.openManageAdminUser();
		map.searchUsername();
		map.edituser();
		Assert.assertEquals(map.verifyEditconfirmMessage(), true, Constant.map_editAdminUser);
		map.searchUsername();
		Assert.assertEquals(map.resultNotFoundTable(), true, Constant.map_editAdminUser);

	}

	@Test
	public void deleteAdminUser() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginToApplication();
		map = hp.openManageAdminUser();
		String delUser = map.deleteUser();
		Assert.assertEquals(map.verifyDeleteconfirmMessage(), true, Constant.map_deleteAdminUser);
		map.searchDeletedUsername(delUser);
		Assert.assertEquals(map.resultNotFoundTable(), true, Constant.map_deleteAdminUser);

	}

}
