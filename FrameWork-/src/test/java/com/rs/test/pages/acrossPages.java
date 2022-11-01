

package com.rs.test.pages;

import static com.jayway.restassured.RestAssured.given;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.jayway.restassured.response.Response;
import com.rs.test.config.Configuration;

import com.sun.codemodel.JCodeModel;

import io.restassured.RestAssured;
//import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class acrossPages extends PageObject {


	private final static String FIRSTNAMENEW = "RS.FIRSTNAMENEW";
	private final static String LASTNAME = "LASTNAME";
	private final static String GETPOSTCODERETURN = "RS.GETPOSTCODERETURN";
	private final static String GETCONTINUEPAYMENT = "RS.GETCONTINUEPAYMENT";
	private final static String GETCITYRETURN = "RS.GETCITYRETURN";
	private final static String EMAIL = "EMAIL";
	private final static String COMPANYNAME = "COMPANYNAME";
	private final static String STREETNAME = "STREETNAME";
	private final static String CITY = "CITY";
	private final static String POSTCODE = "POSTCODE";
	private final static String GETCOMPANYNAMERETURN = "RS.GETCOMPANYNAMERETURN";
	private final static String GETSTREETNAMERETURN = "RS.GETSTREETNAMERETURN";
	private final static String SEARCHBAR = "SEARCH_BAR";
	private final static String APPLYFILTERS = "APPLY_FILTERS";
	private final static String SEARCHICON = "SEARCH_ICON";
	private final static String ADDBUTTON = "ADD_BUTTON";
	private final static String SELECTCATEGORY = "SELECT_CATEGORY";
	private final static String TABLECOUNT = "COLUMN_SIZE";
	private final static String GETBRAND = "GETBRAND";
	private final static String GETSNRVALUE = "GETSNRVALUE";
	private final static String GETMATERIALVALUE = "GETMATERIALVALUE";
	private final static String GETCOLOURVALUE = "GETCOLOURVALUE";
	private final static String GETTYPEVALUE = "GETTYPEVALUE";
	private final static String APPLYFILTER = "APPLYFILTER";
	private final static String FILTERCLOSE = "FILTERCLOSE";
	private final static String GETCLEAR = "GETCLEAR";
	private final static String GETCLEARALL = "GETCLEARALL";
	private final static String SELECTBRAND = "SELECT_BRAND";
	private final static String GETSNR = "SELECTSNR";
	private final static String GETMATERIAL = "SELECTMATERIAL";
	private final static String GETCOLOUR = "GETCOLOUR";
	private final static String GETTYPE = "GETTYPE";
	private final static String DISPLAYCOUNT = "DISPLAYCOUNT";
	private final static String SELECTFIRSTBRAND = "SELECT_FIRSTBRAND";
	private final static String GETBASKET = "GET_BASKET";
	private final static String GETPRODUCTVALUEBASKET = "GETPRODUCT_BASKET";
	private final static String GETGUESTCHECKOUT = "GET_GUESTCHECKOUT";
	private final static String GETRETUENCUSTOMER = "GETRETURNCUSTOMER";
	private final static String GETBASKETAMNT = "GETBASKET_AMNT";
	private final static String GETCOLLECTIONCENTER = "GETCOLLECTIONCENTER"; 
	private final static String SELECTDELIVERYCENTER = "GETDELIVERYCENTER";
	private final static String FEEDBACK = "RS.FEEDBACK";
	private final static String FEEDBACKCLOSE = "FEEDBACKCLOSE";
	private final static String GETDELIVERY = "RS.DELIVERY";
	private final static String TITLE = "RS.TITLE";
	private final static String CONSENTCOOKIE = "CONSENTCOOKIE";
	private final static String DATEANDTIME = "DATEANDTIME";
	private final static String STANDINGTABLE = "STANDINGTABLE";
	private final static String GETPOINTS = "GETPOINTS";
	private final static String SPORTSMENU = "SPORTSMENU";
	private final static String FOOTBALL = "FOOTBALL";
	private final static String FIRSTARTICLE = "FIRSTARTICLE";
	private final static String CLICKNEXT = "CLICKNEXT";
	private final static String CLICKCLOSE = "CLICKCLOSE";
	private final static String CLICKONSHARE = "CLICKONSHARE";
	private final static String CLICKFBSHARE = "CLICKFBSHARE";
	private final static String clicktomax = "clicktomax";
	private final static String CLICKPREVIOUS = "CLICKPREVIOUS";
	private final static String OPENGALARY = "OPENGALARY";
	private final static String SPORTSMENUCLICKED = "SPORTSMENUCLICKED";
	private final static String SUBMENUCOLOUR = "SUBMENU";
	private final static String GETUSERNAME = "RS.GETUSERNAME";
	private final static String GETLOGIN = "RS.GETLOGIN";
	private final static String GETPASSWORD = "RS.GETPASSWORD";
	private final static String CHECKOUTSECURELY = "RS.CHECKOUTSECURELY";
	
	
	


		
	private final WebDriver webDriver;
	private final Configuration configuration;
	

	@Inject
	public acrossPages(WebDriver webDriver, Configuration configuration) {
		super(webDriver);
		this.webDriver = webDriver;
		this.configuration = configuration;
	

	}

	private WebElement getconsentCookie(){
		return actionsnew().getElement(CONSENTCOOKIE);
	}
private WebElement getdateandtime(){
	return actionsnew().getElement(DATEANDTIME);
}
private List <WebElement> getstandingtable(){
	return actionsnew().getElements(STANDINGTABLE);
}
private List <WebElement> getpoints(){
	return actionsnew().getElements(GETPOINTS);
}
private WebElement getsportmenu(){
	return actionsnew().getElement(SPORTSMENU);
}
private WebElement getfootball(){
	return actionsnew().getElement(FOOTBALL);
}

private WebElement getfirstarticle(){
	return actionsnew().getElement(FIRSTARTICLE);
}
private WebElement clickonnext(){
	return actionsnew().getElement(CLICKNEXT);
}

private WebElement clickclose(){
	return actionsnew().getElement(CLICKCLOSE);
}
private List <WebElement> clickonshare(){
	return actionsnew().getElements(CLICKONSHARE);
}
private List <WebElement> clickonfbshare(){
	return actionsnew().getElements(CLICKFBSHARE);
}
private WebElement clicktomax(){
	return actionsnew().getElement(clicktomax);
}
private WebElement clickonprevious(){
	return actionsnew().getElement(CLICKPREVIOUS);
}
private WebElement getopengalarybutton(){
	return actionsnew().getElement(OPENGALARY);
}
private WebElement getSportsmenuclicked(){
	return actionsnew().getElement(SPORTSMENUCLICKED);
}
private WebElement getsubmenucolour(){
	return actionsnew().getElement (SUBMENUCOLOUR);
}
private WebElement getsearchicon(){
		return actionsnew().getElement(SEARCHICON);


}


private WebElement getsearchBar(){
		return actionsnew().getElement(SEARCHBAR);
	}

private WebElement getApplyFilters(){
	return actionsnew().getElement(APPLYFILTERS);
}
private WebElement getAddButton(){
		return actionsnew().getElement(ADDBUTTON);
	}

private WebElement getonecategory(){
	return actionsnew().getElement(SELECTCATEGORY);
}
private List<WebElement> getdisplaytable(){
	return actionsnew().getElements(TABLECOUNT);
}
private List<WebElement> getBrand(){
	return actionsnew().getElements(GETBRAND);
}
private List<WebElement> getsnrvalue(){
	return actionsnew().getElements(GETSNRVALUE);
}
private List<WebElement> getmaterialvalue(){
	return actionsnew().getElements(GETMATERIALVALUE);
}
private List<WebElement> getcolourvalue(){
	return actionsnew().getElements(GETCOLOURVALUE);
}
private List<WebElement> gettypevalue(){
	return actionsnew().getElements(GETTYPEVALUE);
}
private WebElement getApplyfilter(){
	return actionsnew().getElement(APPLYFILTER);
}
private WebElement getfilterclose(){
	return actionsnew().getElement(FILTERCLOSE);
}
private WebElement getclearall(){
	return actionsnew().getElement(GETCLEARALL);
}
private WebElement getclear(){
	return actionsnew().getElement(GETCLEAR);
}
private WebElement getonebrand(){
	return actionsnew().getElement(SELECTBRAND);
}
private WebElement getsnr(){
	return actionsnew().getElement(GETSNR);
}
private WebElement getmaterial(){
	return actionsnew().getElement(GETMATERIAL);
	}
private WebElement getcolour(){
	return actionsnew().getElement(GETCOLOUR);
}
private WebElement gettype(){
	return actionsnew().getElement(GETTYPE);
}
private WebElement getproductdisplaycount(){
	return actionsnew().getElement(DISPLAYCOUNT);
}
private WebElement selectfirstbrand(){
	return actionsnew().getElement(SELECTFIRSTBRAND);
}
private WebElement getBasketAmnt(){
		return actionsnew().getElement(GETBASKETAMNT);
	}

private WebElement getBasket(){
		return actionsnew().getElement(GETBASKET);
	}
	private WebElement getproductValueinbasket(){
		return actionsnew().getElement(GETPRODUCTVALUEBASKET);
	}

private WebElement getfeedback(){
		return actionsnew().getElement(FEEDBACK);
	}

private WebElement getFeedbackclose(){
		return actionsnew().getElement(FEEDBACKCLOSE);
	}

private WebElement getGuestCheckout(){
		return actionsnew().getElement(GETGUESTCHECKOUT);
	}
private WebElement getreturningcustomer(){
	return actionsnew().getElement(GETRETUENCUSTOMER);
}
private WebElement getusername(){
	return actionsnew().getElement(GETUSERNAME);
}
private WebElement getlogin(){
	return actionsnew().getElement(GETLOGIN);
}
private WebElement getpassword(){
	return actionsnew().getElement(GETPASSWORD);
}
private WebElement getcheckoutsecurely(){
	return actionsnew().getElement(CHECKOUTSECURELY);
}
private WebElement getcollection(){
	return actionsnew().getElement(GETCOLLECTIONCENTER);
}
private WebElement selectdeliverycenter(){
	return actionsnew().getElement(SELECTDELIVERYCENTER);
}
private WebElement getfirstname(){
		return actionsnew().getElement(FIRSTNAMENEW);
	}
private WebElement getcompanynamereturncustomer(){
	return actionsnew().getElement(GETCOMPANYNAMERETURN);
}
private WebElement getstreenamereturncustomer(){
	return actionsnew().getElement(GETSTREETNAMERETURN);
}
	private WebElement getlastname(){
		return actionsnew().getElement(LASTNAME);
	}
	private WebElement getcityreturncustomer(){
		return actionsnew().getElement(GETCITYRETURN);
	}
	private WebElement getpostcodereturncustomer(){
		return actionsnew().getElement(GETPOSTCODERETURN);
	}
	private WebElement getcontinuetopayment(){
		return actionsnew().getElement(GETCONTINUEPAYMENT);
	}
	private WebElement getemail(){
		return actionsnew().getElement(EMAIL);
	}
	private WebElement getcompanyname(){
		return actionsnew().getElement(COMPANYNAME);
	}
	private WebElement getstreetname(){
		return actionsnew().getElement(STREETNAME);
	}
	private WebElement getcity(){
		return actionsnew().getElement(CITY);
	}
	private WebElement getpostcode(){
		return actionsnew().getElement(POSTCODE);
	}
	private WebElement getdelivery(){
		return actionsnew().getElement(GETDELIVERY);
	}
	
	




public void openHomePage(String arg1) throws InterruptedException {
		String URL = "";
		arg1 = arg1.toLowerCase();
		if (arg1.equals("dailymail")) {
			URL = configuration.getStringProperty("dailymail");
		}
		open(URL);
	}

public void getstanding(String arg1) throws IOException{
	
	for (int num= 0; num < getstandingtable().size(); num++ ){
		String test = (getstandingtable().get(num).getText());
		if(test == arg1){
			File resultFile;
			Writer fileWriter;
			resultFile = new File("Results.html");
			// if file doesn't exists, then create it...
			if (!resultFile.exists()) {
			    resultFile.createNewFile();
			}

			fileWriter = new FileWriter(resultFile.getAbsoluteFile());

			fileWriter.write("<html><title>Test result</title><body>");
			fileWriter.write("<table>");
			fileWriter.write("<tr>");
			fileWriter.write("<td>"+arg1+"</td>");
			fileWriter.write("<td>"+(getpoints().get(num).getText())+"</td>");
			fileWriter.write("</body></html>");
			fileWriter.close();
	}
	}
}

public void validatedateandtime(){
	String date = getdateandtime().getText();
	String subdate = (date.substring(date.lastIndexOf(",") + 1));
	String newsdate = (subdate.substring(1,4))+'/'+subdate.substring(5,7)+'/'+subdate.substring(10,14);
	DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy");
	Date date1 = new Date();
	String date2= dateFormat.format(date1);	 
	Assert.assertEquals(newsdate, date2);
}
public void validatenavigatetosportsmenu(){
	getsportmenu().click();
}
public void validateMenuColour(){
	Assert.assertEquals(getSportsmenuclicked().getCssValue("background-color"), getsubmenucolour().getCssValue("background-color"));
}
public void iclickonfootball(){
	getfootball().click();
}

public void iclickonfirstlink(){
	getfirstarticle().click();
}
public void iopenthegalary() throws InterruptedException{
	
    getopengalarybutton().click();
}
public void iclickonleftandright(){
	clickonnext().click();
	clickonprevious().click();
	clickclose().click();
}

public void iclickonfbshare() throws InterruptedException{
	clickonshare().get(0).click();
	clickonfbshare().get(0).click();
	}

public void iclickonvideo() throws InterruptedException{
	clicktomax().click();
	Thread.sleep(6000);
	clicktomax().click();
	
}

public void cookieConsent(){
		WebElement consentCookie = getconsentCookie();
		if (consentCookie.isDisplayed()){
			consentCookie.click();
		}
}


public void searchfortheproduct(String product) throws InterruptedException{
		WebElement searchBar = getsearchBar();
		searchBar.sendKeys(product);
		Thread.sleep(500);		
	}
public void selectAbrand(String brand) throws InterruptedException{
	feedback();
	getonebrand().click();
	Thread.sleep(2000L);
	for (int i=0 ;i<=getBrand().size()-1;i++ ){
	if (getBrand().get(i).getText().contains(brand)){
		Thread.sleep(2000L);
		getBrand().get(i).click();
		Thread.sleep(2000L);
		getApplyfilter().click();
	}
	}
	//System.out.println(getBrand().get(1).getText());
	//System.out.println((getBrand().size()));
	//for (int i=1;i<=getBrand().size()-1;i++){
		//if (getBrand().get(i).getText().contentEquals(brand)){
			//System.out.println("fuck");
		//}
		
	
}
public void iselectsnr(String snr) throws InterruptedException{
	getsnr().click();
	Thread.sleep(2000L);
	for (int i=0 ; i<= getsnrvalue().size()-1;i++){
		if(getsnrvalue().get(i).getText().contains(snr)){
			Thread.sleep(2000L);
			getsnrvalue().get(i).click();
			Thread.sleep(2000L);
			getApplyfilter().click();
		}
	}
}

public void selectmaterialcolourandtype(String material,String colour, String type) throws InterruptedException{
	feedback();
	getmaterial().click();
	Thread.sleep(2000L);
	for (int i=0 ; i<= getmaterialvalue().size()-1;i++){
		if(getmaterialvalue().get(i).getText().contains(material)){
			Thread.sleep(2000L);
			getmaterialvalue().get(i).click();
			Thread.sleep(2000L);
			getApplyfilter().click();
		}
	}
	getcolour().click();
	Thread.sleep(2000L);
	for (int i=0 ; i<= getcolourvalue().size()-1;i++){
		if(getcolourvalue().get(i).getText().contains(colour)){
			Thread.sleep(2000L);
			getcolourvalue().get(i).click();
			Thread.sleep(2000L);
			getApplyfilter().click();
		}
	}
	gettype().click();
	Thread.sleep(2000L);
	for (int i=0 ; i<= gettypevalue().size()-1;i++){
		if(gettypevalue().get(i).getText().contains(type)){
			Thread.sleep(2000L);
			gettypevalue().get(i).click();
			Thread.sleep(2000L);
			getApplyfilter().click();
		}
	}
}
public void clicksearch() throws InterruptedException{
		getsearchicon().click();
		Thread.sleep(500);
	}

public void pickproducttoadd() throws InterruptedException{
		getAddButton().click();
		Thread.sleep(1000L);	
	}
public void applyfilters(){
	//feedback();
	getApplyFilters().click();
}
public void selectCategory() throws InterruptedException{
	getonecategory().click();
	Thread.sleep(1000L);
}
public void selectBrand(){
	feedback();
	getonebrand().click();
	selectfirstbrand().click();
}
public void filterclose() throws InterruptedException{
	String numberOnly= (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	getfilterclose().click();
	Thread.sleep(2000L);
	String numberonly1 = (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	Assert.assertNotEquals(numberOnly, numberonly1);
	
}
public void validateclear() throws InterruptedException{
	String numberOnly= (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	getclear().click();
	Thread.sleep(2000L);
	String numberonly1 = (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	Assert.assertNotEquals(numberOnly, numberonly1);
}
public void validateclearall() throws InterruptedException{
	String numberOnly= (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	getclearall().click();
	Thread.sleep(2000L);
	String numberonly1 = (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	Assert.assertNotEquals(numberOnly, numberonly1);
}

public void validateproductcount(){
	
	String numberOnly= (getproductdisplaycount().getText()).replaceAll("[^0-9]", "");
	int columnsize = (getdisplaytable().size())/2;
	String columnSize = String.valueOf(columnsize);
	Assert.assertEquals(numberOnly,columnSize);
}
public void gotobasketpage() throws InterruptedException{
		Thread.sleep(5000L);
		String basketAmnt = getBasketAmnt().getText();
		getBasket().click();
		Thread.sleep(1000L);
		String productValue = getproductValueinbasket().getText();
		Assert.assertEquals(basketAmnt, productValue);
	}
public void feedback(){
	WebElement feedback = getfeedback();
	if (feedback.isDisplayed()){
	WebElement feedbackclose = getFeedbackclose();
	feedbackclose.click();
	}
}
public void checkout(){
		feedback();
		getGuestCheckout().click();
	}

public void checkoutreturningcustomer(){
	
	getreturningcustomer().click();
	
}
public void authlogin(String user,String password){
	//feedback();
	getusername().sendKeys(user);
	getpassword().sendKeys(password);
	getlogin().click();
}
public void checkoutsecurely() throws InterruptedException, FileNotFoundException, IOException, ParseException{
	Thread.sleep(500L);
	getcheckoutsecurely().click();
	Thread.sleep(2000L);
	Object obj = new JSONParser().parse(new FileReader("src/test/resources/data.json"));
	JSONObject jo = (JSONObject)obj; 	
	String companyname = (String) jo.get("companyname");
	String streetname = (String) jo.get("streetname");
	String city = (String) jo.get("city");
	String postcode = (String) jo.get("postcode");
	getcompanynamereturncustomer().sendKeys(companyname);
	getstreenamereturncustomer().sendKeys(streetname);
	getcityreturncustomer().sendKeys(city);
	getpostcodereturncustomer().sendKeys(postcode);
	getcontinuetopayment().click();
}

public void selectioncollectionpoint(){
	feedback();
	getcollection().click();
	selectdeliverycenter().click();
}
public void deliverydetails() throws FileNotFoundException, IOException, ParseException{
		
		
	    Select drpTitle = new Select (webDriver.findElement(By.name("title")));
	    drpTitle.selectByIndex(1);
		
		Object obj = new JSONParser().parse(new FileReader("src/test/resources/data.json"));
		JSONObject jo = (JSONObject)obj; 	
		String lastname = (String) jo.get("lastname");
		String firstname = (String) jo.get("firstname");
		String email = (String) jo.get("email");
		String companyname = (String) jo.get("companyname");
		String streetname = (String) jo.get("streetname");
		String city = (String) jo.get("city");
		String postcode = (String) jo.get("postcode");
		getfirstname().sendKeys(firstname);
		getlastname().sendKeys(lastname);
		getemail().sendKeys(email);
		getcompanyname().sendKeys(companyname);
		getstreetname().sendKeys(streetname);
		getcity().sendKeys(city);
		getpostcode().sendKeys(postcode);		
	}

public void delivery(){
		WebElement delivery = getdelivery();
		delivery.click();
	}
}
