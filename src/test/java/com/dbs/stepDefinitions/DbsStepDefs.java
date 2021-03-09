package com.dbs.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.dbs.pages.DBSCreditCardsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DbsStepDefs {
	public static WebDriver driver = BrowserConfig.driver;
	public DBSCreditCardsPage dBSCreditCardsPage;
	public DbsStepDefs() {
		dBSCreditCardsPage = new DBSCreditCardsPage(driver);
	}
	
	@Given("^I navigate to dbs credit cards page$")
	public void i_navigate_to_dbs_credit_cards_page() throws Throwable {
	    driver.get("https://www.dbs.com.sg/personal/default.page");
	    BrowserConfig.parentTest.createNode("Navigated to DBS home page");
	    dBSCreditCardsPage.navigateToCreditCardsPage();  
		
	}

	@When("^I select two cards \"([^\"]*)\" and \"([^\"]*)\" on credit cards page$")
	public void i_select_two_cards_DBS_Altitude_Visa_Signature_Card_and_DBS_Black_Visa_Card_on_credit_cards_page(String card1,String card2) throws Throwable {
		dBSCreditCardsPage.selectCardsAndClickOnCompare(card1,card2);
	}

	@Then("^Print the similarities and differences between the cards$")
	public void print_the_similarities_and_differences_between_the_cards() throws Throwable {
		dBSCreditCardsPage.compareBestFor();
		dBSCreditCardsPage.compareCardType();
		dBSCreditCardsPage.compareMinIncome();
		dBSCreditCardsPage.minIncomeForForeigners();
		dBSCreditCardsPage.AnnualFeeWavier();		
		dBSCreditCardsPage.cardBenefits();
		dBSCreditCardsPage.cardRewards();
		dBSCreditCardsPage.liftStylePrivileges();
		dBSCreditCardsPage.motoring();
		dBSCreditCardsPage.dining();
		dBSCreditCardsPage.movies();
		dBSCreditCardsPage.travel();
		dBSCreditCardsPage.healthCare();
	}
}
