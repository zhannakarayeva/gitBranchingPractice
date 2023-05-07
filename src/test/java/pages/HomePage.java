package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import utils.GesturesUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
public HomePage(AndroidDriver driver){
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
}
  @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
  WebElement nameField;

  @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    WebElement femaleRadioButton;

  @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    WebElement letsShopButton;

  public void enterName(String name){
      this.nameField.click();
      this.nameField.sendKeys(name);
  }
  public void selectGender(){
      femaleRadioButton.click();
  }
  public void signIn(){
      letsShopButton.click();
  }


}
