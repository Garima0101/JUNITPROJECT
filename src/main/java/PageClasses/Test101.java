package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test101 {

	WebDriver driver;

	public Test101(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "allbox")
	WebElement CHECKBOX_TOGGLE_ALL;
//	@FindBy(how = How.NAME, using = "todo")
//	WebElement ALLCHECKBOXELEMENT;
	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement SINGLECHCKBOXELEMENT;
	@FindBy(how = How.NAME, using = "submit")
	WebElement REMOVE_ELEMENTs;

	public void toggleallcheckbox__listitems_CHECKEDON() {

		if (!CHECKBOX_TOGGLE_ALL.isSelected()) {
			CHECKBOX_TOGGLE_ALL.click();
		}

		if (CHECKBOX_TOGGLE_ALL.isSelected()) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_TOGGLE_ALL));
			CHECKBOX_TOGGLE_ALL.click();
		}

	}

	public void singleCheckboxSelect() {

		if (CHECKBOX_TOGGLE_ALL.isEnabled()) {
			SINGLECHCKBOXELEMENT.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(REMOVE_ELEMENTs));
			REMOVE_ELEMENTs.click();
		}
	}

	public void removeAllSelectItem() {

		if (!CHECKBOX_TOGGLE_ALL.isSelected() && CHECKBOX_TOGGLE_ALL.isDisplayed()) {
			CHECKBOX_TOGGLE_ALL.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(REMOVE_ELEMENTs));
			REMOVE_ELEMENTs.click();

		}
    
	}
}
