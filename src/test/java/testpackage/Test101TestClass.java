package testpackage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageClasses.Test101;
import Util.BrowserFactory;

public class Test101TestClass {
	WebDriver driver;

	@Test
	public void checkboxtest() {
		driver = BrowserFactory.init();

		Test101 test = PageFactory.initElements(driver, Test101.class);
		test.toggleallcheckbox__listitems_CHECKEDON();
		test.singleCheckboxSelect();
		
	    test.removeAllSelectItem();
	    BrowserFactory.tearDown();
		
	}
	
}
