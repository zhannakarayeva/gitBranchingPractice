package gestures;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.pool.TypePool;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import javax.swing.text.Utilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class TapAction {
  @Test
  public void tapTest() throws MalformedURLException {
      File apkfile=new File("src/test/resources/ApiDemos-debug.apk");
      DesiredCapabilities caps=new DesiredCapabilities();
      caps.setPlatform(Platform.ANDROID);
      caps.setCapability("deviceName","ZhannaPhone");
      caps.setCapability("automationName","uiautomator2");
      caps.setCapability("app",apkfile.getAbsolutePath());
      URL serverUrl=new URL("http://0.0.0.0:4723/wd/hub");
      AndroidDriver driver=new AndroidDriver(serverUrl,caps);
      WebElement viewsButton= driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
      TouchAction touchAction=new TouchAction(driver);
      touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();
      WebElement tap=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]\n"));
      touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(tap))).perform();
      WebElement tap2=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]\n"));
      touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(tap2))).perform();
      WebElement peopleName=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]\n"));
      touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleName)).withDuration(Duration.ofSeconds(2))).perform();

  }

  @Test
    public void scrollTest() throws MalformedURLException {
      File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
      DesiredCapabilities caps=new DesiredCapabilities();
      caps.setPlatform(Platform.ANDROID);
      caps.setCapability(MobileCapabilityType.DEVICE_NAME,"ZhannaPhone");
      caps.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
      caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

      URL appiumServerUrl=new URL("http://0.0.0.0:4723/wd/hub");
      AndroidDriver driver=new AndroidDriver(appiumServerUrl,caps);
      WebElement viewsButton= driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
      TouchAction touchAction=new TouchAction(driver);
      touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();
      //WebElement tabButton=driver.findElementByAccessibilityId("Tabs");
      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");

  }
  /*
  !Navigate Views:->Date Widgets ->Inline
  Set clock arrow to 3:15, 6:05, and 10:25
   */
    @Test
    public <WebDriverWait> void homework() throws MalformedURLException, InterruptedException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZhannaPhone");
        caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);
        WebElement viewsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();
        WebElement dateWidget = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dateWidget))).perform();
        WebElement inline = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"2. Inline\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inline))).perform();
        WebElement time12 = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"12\"]\n"));
        WebElement time3 = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"3\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(time3))).perform();
        Thread.sleep(1000);
        WebElement minute15 = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"15\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(minute15))).perform();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inline))).perform();
        WebElement time6 =driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"6\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(time6))).perform();
        Thread.sleep(1000);
        WebElement time05 =driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"5\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(time05))).perform();
        driver.navigate().back();
        Thread.sleep(1000);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inline))).perform();
        WebElement time10=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"10\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(time10))).perform();
        Thread.sleep(1000);
        WebElement minute25=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"25\"]\n"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(minute25))).perform();
    }
}
