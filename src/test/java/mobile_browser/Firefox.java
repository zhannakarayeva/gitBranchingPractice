package mobile_browser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Firefox {
    @Test
    public void browserTest() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"ZhannaPhone");
        caps.setCapability("appPackage","org.mozilla.firefox");
        caps.setCapability("appActivity",".App");

        URL serverUrl=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver(serverUrl,caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        WebElement searchBar=driver.findElement(By.xpath("//textarea[@name='q']"));
        searchBar.sendKeys("Codefish"+ Keys.ENTER);
    }
}
// we just need to install firefox
//we can add cucumber on top here and get reports