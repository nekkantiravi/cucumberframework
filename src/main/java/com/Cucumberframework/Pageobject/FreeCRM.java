package com.Cucumberframework.Pageobject;

import com.Cucumberframework.Bean.CrmConstants;
import com.Cucumberframework.JsonReader.Jasonreader;
import com.Cucumberframework.Resourcehelper.Resourcehelper;
import com.Cucumberframework.SelectHelper.SelectDropDown;
import com.Cucumberframework.VerificationHelper.VerificationHelper;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FreeCRM {

	private WebDriver driver;
	SelectDropDown select = new SelectDropDown(driver);

	VerificationHelper verificationhelper = new VerificationHelper(driver);

	File file = new File(Resourcehelper.getResourcePath("/src/test/resources/Data/Genericdetails.json"));
	CrmConstants crm = Jasonreader.convertJasonToJava(file, CrmConstants.class);

	String crmFirstname = crm.getFirstname();
	String crmLastname = crm.getLastname();
	String crmEmail = crm.getEmail();
	String crmConfirmEmail = crm.getConfirmemail();
	String crmuserName = crm.getUsername();
	String crmPassword = crm.getPassword();
	String crmConfirmPassword = crm.getConfirmpassword();

	@FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[2]/a")
	WebElement Signuplink;

	@FindBy(xpath = "//*[@id='editionText']")
	WebElement registrationPage;

	@FindBy(xpath = "//select[@name='payment_plan_id']")
	WebElement Editiondropdown;

	@FindBy(xpath = "//form[@id='multipleForm']/div[3]/input")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='email_confirm']")
	WebElement confirmemail;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='password' and @name='passwordconfirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agreeTerms']")
	WebElement agreeTerms;

	@FindBy(xpath = "//button[@id='submitButton']")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='text_orange']")
	WebElement profilepage;

	public FreeCRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickOnSignUpLink() {
		
		Signuplink.sendKeys(Keys.ENTER);

	}

	public void landingOnRegistrationPage() {

		Assert.assertTrue(verificationhelper.isDisplayed(registrationPage));
	}

	public void selectEditionDropDown() {	

		select.selectByIndexes(Editiondropdown, 1);
	}

	public void cFirstName() {

		firstname.sendKeys(crmFirstname);

	}

	public void cLastName() {

		firstname.sendKeys(crmLastname);
	}

	public void enterEmail() {

		email.sendKeys(crmEmail);
	}

	public void confirmEmail() {

		confirmemail.sendKeys(crmConfirmEmail);
	}

	public void enterUserName() {

		username.sendKeys(crmuserName);
	}

	public void enterPassword() {

		password.sendKeys(crmPassword);
	}

	public void confirmPassword() {

		confirmPassword.sendKeys(crmConfirmPassword);
	}

	public void checkForAgreeTerms() {

		agreeTerms.click();
	}

	public void profilePage() {

		Assert.assertTrue(verificationhelper.isDisplayed(profilepage));
		profilepage.isDisplayed();
	}

	public void clickOnSubmitButton() {

		submitButton.click();
	}
}