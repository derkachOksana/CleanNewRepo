package pageComponents.waiter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.waiter.WaiterAssignedWaiterPage;
import pages.waiter.WaiterHistoryPage;
import pages.waiter.WaiterInProgressPage;
import pages.waiter.WaiterMainPage;

import java.time.Duration;

public class WaiterHeaderPageComponent {

    private final JavascriptExecutor js;

    private final WebDriver driver;

    public WaiterHeaderPageComponent(WebDriver driver)    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    @FindBy(xpath = "//main//header//a[@href='/waiter/orders/Assigned waiter']")
    private WebElement waiterAssignedLink;

    @FindBy(xpath = "//main//header//a[@href='/waiter/orders/In progress']")
    private WebElement waiterInProgressLink;

    @FindBy(xpath = "//main//header//a[@href='/waiter/orders/History']")
    private WebElement waiterHistoryLink;

    @FindBy(xpath = "//main//header//a[@href='/waiter/orders/']")
    private WebElement waiterAllLink;

    public WaiterAssignedWaiterPage waiterAssignedWaiterPageAccess(Duration duration)  {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.elementToBeClickable(waiterAssignedLink));
        waiterAssignedLink.click();
        return new WaiterAssignedWaiterPage(driver);
    }

    public WaiterHistoryPage waiterHistoryPageAccess(Duration duration)    {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.elementToBeClickable(waiterHistoryLink));
        waiterHistoryLink.click();
        return new WaiterHistoryPage(driver);
    }

    public WaiterInProgressPage waiterInProgressPageAccess(Duration duration)  {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.elementToBeClickable(waiterInProgressLink));
        waiterInProgressLink.click();
        return new WaiterInProgressPage(driver);
    }

    public WaiterMainPage waiterMainPageAccess(Duration duration)  {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.elementToBeClickable(waiterAllLink));
        waiterAllLink.click();
        return new WaiterMainPage(driver);
    }
}
