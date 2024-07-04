package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HotelListingPage {
    public WebDriver driver;

    public HotelListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[text()='Breakfast included']")
    @CacheLookup
    WebElement breakFastFilter;


    @FindBy(xpath ="//div[text()='Free WiFi']")
    @CacheLookup
    WebElement wifiFilter;

    @FindBy(xpath ="//div[text()='Room service']")
    @CacheLookup
    WebElement roomServiceFilter;


    @FindBy(xpath = "//input[@name='Breakfast included']")
    @CacheLookup
    WebElement breakFastInput;

    @FindBy(xpath = "//input[@name='Free WiFi']")
    @CacheLookup
    WebElement wifiInput;

    @FindBy(xpath = "//div[@data-testid='title']")
    @CacheLookup
    WebElement firstHotel;

//    public void applyFilter(String filterName) throws InterruptedException {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(breakFastFilter));
////        if (!checkbox.isSelected()) {
////            checkbox.click();
////        }
////        if(filterName.equals("Breakfast included")){
//        driver.findElement(By.xpath("//div[text()='Breakfast included']")).click();
//
////        Thread.sleep(3000);
////        }
////        else if (filterName.equals("WiFi")){
////            if(!wifiFilter.isSelected())wifiFilter.click();
////        }
//
//        System.out.println(filterName);
//    }

    public void applyFilter() throws InterruptedException {
        breakFastFilter.click();
        Thread.sleep(1000);
        wifiFilter.click();
        Thread.sleep(1000);
        roomServiceFilter.click();
        Thread.sleep(1000);
    }



//    public void applyFilter(String filterName) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement checkbox = null;
//
//        if (filterName.equals("Breakfast included")) {
//            checkbox = wait.until(ExpectedConditions.elementToBeClickable(breakFastFilter));
//        } else if (filterName.equals("WiFi")) {
//            checkbox = wait.until(ExpectedConditions.elementToBeClickable(wifiFilter));
//        }
//
//        if (checkbox != null) {
//            if (!checkbox.isSelected()) {
//                checkbox.click();
//                // Wait until the checkbox is selected
//                wait.until(ExpectedConditions.elementToBeSelected(checkbox));
//            }
//        }
//
//        System.out.println(filterName);
//    }

    public void selectFirstHotel(){
        firstHotel.click();
        List<String> windows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
    }





}
