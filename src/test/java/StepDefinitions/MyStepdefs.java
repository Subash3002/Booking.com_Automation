package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.HotelListingPage;
import PageObjects.HotelPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MyStepdefs {
    public WebDriver driver;
    public HomePage hp;
    public HotelListingPage hlp;
    public HotelPage hop;
    public SoftAssert softAssert;

    @Given("User Launch Chrome browser")
    public void userLaunchChromeBrowser() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        hp=new HomePage(driver);
        hlp=new HotelListingPage(driver);
        hop=new HotelPage(driver);
//        softAssert=new SoftAssert();
    }

    @When("User opens URL {string}")
    public void userOpensURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String homePageTitle) {
        WebDriverWait titleWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        titleWait.until(ExpectedConditions.titleIs(homePageTitle));
        Assert.assertEquals("Title not matching",driver.getTitle(),homePageTitle);
    }

    @When("User Types the destination {string}")
    public void userTypesTheDestination(String destination) throws InterruptedException {
        hp.closePopup();
        hp.setDestinationInput(destination);
        Thread.sleep(1000);
        hp.clickFirstDestination();
    }


    @And("User selects checkin {string} and checkout {string} dates")
    public void userSelectsCheckinAndCheckoutDates(String checkin, String checkout) {
        hp.chooseCheckin();
        hp.chooseCheckOut();
    }


    @And("User clicks search")
    public void userClicksSearch() {
        hp.clickSearch();
    }

    @When("User applies filter")
    public void userAppliesFilter() throws InterruptedException {
        hlp.applyFilter();
    }

    @And("User clicks first hotel in the displayed list")
    public void userClicksFirstHotelInTheDisplayedList() {
        hlp.selectFirstHotel();
    }

    @Then("User navigates to the Hotel page")
    public void userNavigatesToTheHotelPage() {
        Assert.assertNotEquals(driver.getTitle(),"Booking.com: Hotels in Tirupati. Book your hotel now!");
    }

    @When("User selects room from the hotel")
    public void userSelectsRoomFromTheHotel() {
        hop.clickReserve();
        hop.selectRooms();
    }

    @And("User Reverse the selected room")
    public void userReverseTheSelectedRoom() throws InterruptedException {
        hop.clickReserveIt();
//        softAssert.assertAll();
    }

//    @When("User selects Breakfast included filter")
//    public void userSelectsBreakfastIncludedFilter() throws InterruptedException {
//        hlp.applyFilter("Breakfast included");
//        Thread.sleep(3000);
//    }

//    @And("User selects Free WiFi filter")
//    public void userSelectsFreeWiFiFilter() throws InterruptedException {
////        hlp.applyFilter("WiFi");
////        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[text()='Free WiFi']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[text()='Room service']")).click();
//        Thread.sleep(3000);
//    }


}
