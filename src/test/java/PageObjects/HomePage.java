package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='b43bdecede']")
    @CacheLookup
    WebElement popup;

    @FindBy(xpath = "//div[@class='b43bdecede']/div/div/div/button")
    @CacheLookup
    WebElement popUpCloseBtn;

    @FindBy(xpath = "//input[@aria-label='Where are you going?']")
    @CacheLookup
    WebElement destinationInput;

    @FindBy(xpath = "//li[@id='autocomplete-result-0']")
    @CacheLookup
    WebElement firstDropdownResult;

    @FindBy(xpath = "//span[@aria-label='1 July 2024']")
    @CacheLookup
    WebElement checkIn;

    @FindBy(xpath = "//span[@aria-label='3 July 2024']")
    @CacheLookup
    WebElement checkOut;

    @FindBy(xpath = "//span[text()='Search']")
    @CacheLookup
    WebElement searchBtn;

    public void closePopup(){
        popUpCloseBtn.click();
    }

    public void setDestinationInput(String destination){
        destinationInput.sendKeys(destination);
    }

    public void clickFirstDestination(){
        firstDropdownResult.click();
    }

    public void chooseCheckin(){
        checkIn.click();
    }

    public void chooseCheckOut(){
        checkOut.click();
    }

    public void clickSearch(){
        searchBtn.click();
    }

    public String getDestinationInput(){
        System.out.println(destinationInput.getText());
        return destinationInput.getText();

    }




}
