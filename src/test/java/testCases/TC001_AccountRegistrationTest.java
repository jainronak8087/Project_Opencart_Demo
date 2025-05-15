 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test (groups= {"Regression","Master"})
	public void verify_account_registration() throws InterruptedException 
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		try {
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		Thread.sleep(5000);
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");

		Thread.sleep(5000);
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
			
		String password=randomeAlphaNumberic();
			
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message..");
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		
		else {
			logger.error("Test failed:");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
		} 
	
	catch (Exception e)
	{
		logger.error("Test failed:");
		logger.debug("Debug logs");
		Assert.fail("Test failed:");
	} 

		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	
	}
	
}
	
	

