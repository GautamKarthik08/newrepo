package com.rs.test.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.rs.test.pages.acrossPages;
import com.rs.test.pages.PageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;



public class acrossPageStepDefs {
	private final WebDriver webDriver;
	private final acrossPages AcrossPages;

	private final PageObject pageObject;
	
	

	private String Cardnumber;
	private String pin;
	
	
//	public String screenToLoad;

	@Inject
	public acrossPageStepDefs(WebDriver webDriver, acrossPages AcrossPages,PageObject pageObject) {
		this.webDriver = webDriver;
		this.AcrossPages = AcrossPages;
		this.pageObject = pageObject;
	}
	
@Given("^a customer I go to \"([^\"]*)\"$")
	public void acustomerIgoto(String arg1) throws InterruptedException{
		AcrossPages.openHomePage(arg1);
		Thread.sleep(1000L);
		AcrossPages.cookieConsent();
	}
@And ("^I validate date and time$")
public void ivalidatedateandtime(){
	AcrossPages.validatedateandtime();
}
@Then ("^I navigate to sports menu$")
public void inavigatetosportsmenu(){
	AcrossPages.validatenavigatetosportsmenu();
}
@And ("^I validate menu colour$")
public void ivalidatemenucolour(){
	AcrossPages.validateMenuColour();
}

@Then ("^I click on Football$")
public void iclickonfootball(){
	AcrossPages.iclickonfootball();
}

@Then ("^I get the standing of \"([^\"]*)\"$")
public void igetthestanding(String arg1) throws IOException{
	AcrossPages.getstanding(arg1);
}

@And ("^I click on first article$")
public void iclickonfirstarticle(){
	AcrossPages.iclickonfirstlink();
}

@And ("^I open the galary$")
public void iopenthegalary() throws InterruptedException{
	AcrossPages.iopenthegalary();
}

@Then ("^I click on left and right$")
public void iclickonleftandright(){
	AcrossPages.iclickonleftandright();
}

@And ("^I click on fb share$")
public void iclickonfbshare() throws InterruptedException{
	AcrossPages.iclickonfbshare();
}

@Then ("^I click on video max$")
public void iclickonvideomax() throws InterruptedException{
	AcrossPages.iclickonvideo();
	
}
@Then("^I search for the product \"([^\"]*)\"$")
	public void isearchfortheproduct(String arg1) throws InterruptedException{
		AcrossPages.searchfortheproduct(arg1);
		Thread.sleep(1000L);
		AcrossPages.clicksearch();
	}
@Then("^I select the brand \"([^\"]*)\"$")
public void iselectthebrand(String arg1) throws InterruptedException{
	AcrossPages.selectAbrand(arg1);
}
@Then("^I select the Single Number Rating SNR \"([^\"]*)\"$")
public void iselectthesnr(String arg1) throws InterruptedException{
	AcrossPages.iselectsnr(arg1);
}
@Then("^I select the category$")
public void iselectthecategory() throws InterruptedException{
	AcrossPages.selectCategory();
}


@Then("^I select glovematerial \"([^\"]*)\" colour \"([^\"]*)\" and glove type \"([^\"]*)\"$")
public void iselectglovematerialcolourandtype(String arg1, String arg2, String arg3) throws InterruptedException{
	AcrossPages.selectmaterialcolourandtype(arg1,arg2,arg3);
	
}
@Then("^I validate filter close$")
public void ivalidatefilterclose() throws InterruptedException{
	AcrossPages.filterclose();
}
@Then("^I validate Clear$")
public void ivalidateclear() throws InterruptedException{
	AcrossPages.validateclear();
}
@Then("^I validate clearAll$")
public void ivalidateclearall() throws InterruptedException{
	AcrossPages.validateclearall();
}
@Then("^I select one brand$")
public void iselectonebrand(){
	AcrossPages.selectBrand();
}
@Then("^I pick the product to add$")
	public void ipicktheproducttoadd() throws InterruptedException{
		AcrossPages.pickproducttoadd();
	}
@When("^I click on apply filters$")
public void i_click_on_apply_filter(){
	AcrossPages.applyfilters();
}
@Then("^I validate product count and displayed product$")
public void i_validateproductcount_and_displayedproduct(){
	AcrossPages.validateproductcount();
}
@Then("^I go to basket page and validate basket value$")
	public void igotobasketpage() throws InterruptedException{
		AcrossPages.gotobasketpage();
	}

@Then("^I checkout the product as guest$")
	public void icheckouttheproductasguest(){
		AcrossPages.checkout();
	}
@Then("^I checkout as returning customer$")
public void icheckoutasreturningcustomer() throws InterruptedException{
	AcrossPages.selectioncollectionpoint();
	Thread.sleep(1000L);
	AcrossPages.checkoutreturningcustomer();
}
@Then("^I authenticate login with user \"([^\"]*)\" and password \"([^\"]*)\"$")
public void iauthlogin(String user,String password){
	AcrossPages.authlogin(user,password);
}
@And("^I checkout securely$")
public void icheckoutsecurely() throws InterruptedException, FileNotFoundException, IOException, ParseException{
	AcrossPages.checkoutsecurely();
}

@And ("^I enter the delivery information$")
	public void deliverydetails() throws FileNotFoundException, IOException, ParseException{
		AcrossPages.deliverydetails();
	}

@Then ("^I click on Delivery$")
	public void iclickondelivery(){
		AcrossPages.delivery();
	}
}


