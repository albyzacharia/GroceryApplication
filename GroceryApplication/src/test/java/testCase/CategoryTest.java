package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Category;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class CategoryTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	Category cg;
  @Test
  public void varifyCategoryEdit() throws IOException {
	  lp = new LoginPage(driver);
		hp=lp.loginToApplication();
		cg=hp.clickCategoryTab();		
		Assert.assertEquals(cg.categoryEdit(), true, Constant.map_varifyCategoryEdit);		
		String actual=cg.readcategoryTableElement(1, 1);
		Assert.assertEquals(actual, "Apple", Constant.map_varifyCategoryEdit);
  }
}
