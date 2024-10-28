package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcellUtilities;
import utilities.GeneralUtilities;

public class ManageContacts {
	WebDriver driver;
	ExcellUtilities eu = new ExcellUtilities();
	GeneralUtilities gu = new GeneralUtilities();

	public ManageContacts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
}
