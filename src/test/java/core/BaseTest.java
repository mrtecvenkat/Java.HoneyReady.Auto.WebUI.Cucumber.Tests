package core;
import core.helper.TestKeywords;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.List;
import java.util.Set;

public class BaseTest {

    public static String DRIVER_PATH="C:\\Users\\s9922\\kosanam\\Drivers";
    public  String mainWindowId;
    public  String curWindowIDs[];
    public WebDriver driver=null;
    public Reporter reporter;
    private int globalTimeOut=30;
    public BaseTest(){
        System.out.println("This base path"+DRIVER_PATH);

        if(driver==null)
            driver = getWebDriver(TestKeywords.BrowserList.CHROME_BROWSER,TestKeywords.OSList.OS_WINDOWS,DRIVER_PATH);
        reporter = new Reporter();
    }


    public  void switchToFrame(int index) {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(index);
        }catch (Exception e) {
            reporter.logError(TestKeywords.ErrorType.ERROR+TestKeywords.Action.SWITCH_TO_FRAME+e.getMessage());
        }
    }
    public void switchToFrame(String frameName) {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(frameName);
        }catch (Exception e) {
            reporter.logError(TestKeywords.ErrorType.ERROR+TestKeywords.Action.SWITCH_TO_FRAME+e.getMessage());
        }
    }
    public  void switchToWindow(String windowId) {
        try {
            driver.switchTo().window(windowId);
        }catch (Exception e) {
            reporter.logError(TestKeywords.ErrorType.ERROR+TestKeywords.Action.SWITCH_TO_WINDOW+e.getMessage());
        }
    }
    public  void setMainWindowId() {
        try {
            mainWindowId = driver.getWindowHandle();
        }catch (Exception e) {
            reporter.logError(TestKeywords.ErrorType.ERROR+TestKeywords.Action.SWITCH_TO_WINDOW+e.getMessage());
        }
    }
    public  void setWindowIds() {
        try {
            Set<String> allWindwIds =  driver.getWindowHandles();
            curWindowIDs = new String[allWindwIds.size()];
        }catch (Exception e) {
            reporter.logError(TestKeywords.ErrorType.ERROR+TestKeywords.Action.SWITCH_TO_WINDOW+e.getMessage());
        }
    }
    public  void switchToNewlyOpenedWindow() {
        try {
            for(String windowid : curWindowIDs) {
                if(windowid!=mainWindowId)
                {
                    driver.switchTo().window(windowid);
                    break;
                }
            }
        }catch (Exception e) {
            reporter.logError(TestKeywords.ErrorType.ERROR+TestKeywords.Action.SWITCH_TO_WINDOW+e.getMessage());
        }
    }

    public void navigateToURL(String url){
        driver.get(url);
    }

    public WebElement getVisibleElement(By selector){
        try{
            waitUntilElementVisible(selector);
            return driver.findElement(selector);
        }catch (Exception er){
            return null;
        }
    }

    public List<WebElement> getVisibleElements(By selector){
        try{
            waitUntilElementVisible(selector);
            return driver.findElements(selector);
        }catch (Exception er){
            return null;
        }
    }

    public void waitUntilElementVisible(By selector){
        try {
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        }catch (Exception er){
            reporter.logError("Element Not found for >> "+selector.toString());
        }
    }
    public void waitUntilElementNotVisible(By selector){
        try {
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
        }catch (Exception er){
            reporter.logError("Element Not found for >> "+selector.toString());
        }
    }

    public WebDriver getWebDriver(TestKeywords.BrowserList targetBrowser, TestKeywords.OSList targetOS, String driverPath){
        WebDriver driver = null;
        if(targetBrowser== TestKeywords.BrowserList.CHROME_BROWSER){
            System.setProperty("webdriver.chrome.driver", new File(driverPath).getAbsolutePath()+"\\chromedriver.exe");
            ChromeOptions c = new ChromeOptions();
            c.addArguments("disable-extensions");
            driver = new ChromeDriver(c);
        }else if(targetBrowser== TestKeywords.BrowserList.IE_BROWSER) {
            System.setProperty("webdriver.ie.driver", new File(driverPath).getAbsolutePath() + "\\IEDriverServer.exe");
            DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
            dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(dc);
        }else {
            driver = new FirefoxDriver();
        }
        if(driver!=null)
            driver.manage().window().maximize();
        return driver;
    }

    public WebElement getElementById(String selector){
        return getVisibleElement(By.id(selector));
    }
    public WebElement getElementByName(String selector){
        return getVisibleElement(By.name(selector));
    }
    public WebElement getElementByCSSSelector(String selector){
        return getVisibleElement(By.cssSelector(selector));
    }
    public WebElement getElementByClassName(String selector){
        return getVisibleElement(By.className(selector));
    }
    public WebElement getElementByLinkText(String selector){
        return getVisibleElement(By.linkText(selector));
    }
    public WebElement getElementByPartiallLinkText(String selector){
        return getVisibleElement(By.partialLinkText(selector));
    }
    public WebElement getElementByXpath(String selector){
        return getVisibleElement(By.xpath(selector));
    }
    public WebElement getElementByTagName(String selector){
        return getVisibleElement(By.tagName(selector));
    }
    public List<WebElement> getElementsById(String selector){
        return getVisibleElements(By.id(selector));
    }
    public List<WebElement> getElementsByName(String selector){
        return getVisibleElements(By.name(selector));
    }
    public List<WebElement> getElementsByCSSSelector(String selector){
        return getVisibleElements(By.cssSelector(selector));
    }
    public List<WebElement> getElementsByClassName(String selector){
        return getVisibleElements(By.className(selector));
    }
    public List<WebElement> getElementsByLinkText(String selector){
        return getVisibleElements(By.linkText(selector));
    }
    public List<WebElement> getElementsByPartiallLinkText(String selector){
        return getVisibleElements(By.partialLinkText(selector));
    }
    public List<WebElement> getElementsByXpath(String selector){
        return getVisibleElements(By.xpath(selector));
    }
    public List<WebElement> getElementsByTagName(String selector){
        return getVisibleElements(By.tagName(selector));
    }
    
    public String clickByElement(WebElement ele){
        if(ele!=null) {
            try {
                ele.click();
                reporter.logInfo("Successfully clicked on " + ele.toString());
                return "";
            } catch (Exception er) {
                return er.getMessage();
            }
        }else
            return "Given Element not present";
    }
    public void clickById(String selector){
        String res = clickByElement(getElementById(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.ID,selector,res);
        else
            if(reporter.showDebugMessages)
                reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.ID,selector,res);

    }
    public void clickByClassName(String selector){
        String res = clickByElement(getElementByClassName(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.CLASSNAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.CLASSNAME,selector,res);
    }
    public void clickByCSSSelector(String selector){
        String res = clickByElement(getElementByCSSSelector(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.CSSSELECTOR,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.CSSSELECTOR,selector,res);
    }
    public void clickByLinkText(String selector){
        String res = clickByElement(getElementByLinkText(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.LINKTEXT,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.LINKTEXT,selector,res);
    }
    public void clickByName(String selector){
        String res =clickByElement(getElementByName(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.NAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.NAME,selector,res);
    }
    public void clickByPartialllLinkText(String selector){
       String res = clickByElement(getElementByPartiallLinkText(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.PARTIALLLINKTEXT,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.PARTIALLLINKTEXT,selector,res);
    }
    public void clickByTagName(String selector){
        String res = clickByElement(getElementByTagName(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.TAGNAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.TAGNAME,selector,res);
    }
    public void clickByXpath(String selector){
        String res = clickByElement(getElementByXpath(selector));
        if(res!="")
            reporter.logError(TestKeywords.Action.CLICK,TestKeywords.Selecots.XPATH,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.CLICK,TestKeywords.Selecots.XPATH,selector,res);
    }

    public String setByElement(WebElement ele, String valueToEnter){
        if(ele!=null) {
            try {
                if(ele.getTagName().toLowerCase().contains("input")||ele.getTagName().toLowerCase().contains("text")) {
                    ele.sendKeys(valueToEnter);
                    reporter.logInfo("Successfully Set value ("+valueToEnter+") to " + ele.toString());
                }
                else
                    return "Unable to set test to given field due to field tag is"+ele.getTagName();
                return "";
            } catch (Exception er) {
                return er.getMessage();
            }
        }else
            return "Given Element not present";
    }

    public void setElementValuedById(String selector, String valueToEnter){
        String res = setByElement(getElementById(selector),valueToEnter);
        if(res!="")
            reporter.logError(TestKeywords.Action.SET,TestKeywords.Selecots.ID,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SET,TestKeywords.Selecots.ID,selector,res);
    }
    public void setElementValuedByName(String selector, String valueToEnter){
        String res = setByElement(getElementByName(selector),valueToEnter);
        if(res!="")
            reporter.logError(TestKeywords.Action.SET,TestKeywords.Selecots.NAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SET,TestKeywords.Selecots.NAME,selector,res);
    }
    public void setElementValuedByXpath(String selector, String valueToEnter){
        String res = setByElement(getElementByXpath(selector),valueToEnter);
        if(res!="")
            reporter.logError(TestKeywords.Action.SET,TestKeywords.Selecots.XPATH,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SET,TestKeywords.Selecots.XPATH,selector,res);
    }
    public void setElementValuedByCSSSelector(String selector, String valueToEnter){
        String res = setByElement(getElementByCSSSelector(selector),valueToEnter);
        if(res!="")
            reporter.logError(TestKeywords.Action.SET,TestKeywords.Selecots.CSSSELECTOR,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SET,TestKeywords.Selecots.CSSSELECTOR,selector,res);
    }
    public void setElementValuedByClassName(String selector, String valueToEnter){
        String res = setByElement(getElementByClassName(selector),valueToEnter);
        if(res!="")
            reporter.logError(TestKeywords.Action.SET,TestKeywords.Selecots.CLASSNAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SET,TestKeywords.Selecots.CLASSNAME,selector,res);
    }
    public void setElementValuedByTagName(String selector, String valueToEnter){
        String res = setByElement(getElementByTagName(selector),valueToEnter);
        if(res!="")
            reporter.logError(TestKeywords.Action.SET,TestKeywords.Selecots.TAGNAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SET,TestKeywords.Selecots.TAGNAME,selector,res);
    }

    public String selectValueFromElement(WebElement ele, String valueToSelect){
        String successMessage = "Successfully selected ("+valueToSelect+") from "+ele.toString();
        if(ele!=null) {
            try {
                if(ele.getTagName().toLowerCase().contains("select")){
                    Select curSelect = new Select(ele);
                    try{
                        curSelect.selectByVisibleText(valueToSelect);
                        reporter.logInfo(successMessage);
                        return "";
                    }catch (Exception byText){
                        try{
                            curSelect.selectByValue(valueToSelect);
                            reporter.logInfo(successMessage);
                            return "";
                        }catch (Exception byValue){
                            try {
                                curSelect.selectByIndex(Integer.parseInt(valueToSelect));
                                reporter.logInfo(successMessage);
                                return "";
                            }catch (Exception byIndex){
                                return byIndex.getMessage();
                            }
                        }
                    }
                }else
                    return "Unable to select value "+valueToSelect+" due to element tag is "+ele.getTagName();

            } catch (Exception er) {
                return er.getMessage();
            }
        }else
            return "Given element not present";
    }

    public void selectValueFromElementById(String selector, String valueToSelect){
        String res = selectValueFromElement(getElementById(selector),valueToSelect);
        if(res!="")
            reporter.logError(TestKeywords.Action.SELECT,TestKeywords.Selecots.ID,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SELECT,TestKeywords.Selecots.ID,selector,res);
    }
    public void selectValueFromElementByNamme(String selector, String valueToSelect){
        String res = selectValueFromElement(getElementByName(selector),valueToSelect);
        if(res!="")
            reporter.logError(TestKeywords.Action.SELECT,TestKeywords.Selecots.NAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SELECT,TestKeywords.Selecots.NAME,selector,res);
    }
    public void selectValueFromElementByXpath(String selector, String valueToSelect){
        String res = selectValueFromElement(getElementByXpath(selector),valueToSelect);
        if(res!="")
            reporter.logError(TestKeywords.Action.SELECT,TestKeywords.Selecots.XPATH,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SELECT,TestKeywords.Selecots.XPATH,selector,res);
    }
    public void selectValueFromElementByCSSSelector(String selector, String valueToSelect){
        String res = selectValueFromElement(getElementByCSSSelector(selector),valueToSelect);
        if(res!="")
            reporter.logError(TestKeywords.Action.SELECT,TestKeywords.Selecots.CSSSELECTOR,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SELECT,TestKeywords.Selecots.CSSSELECTOR,selector,res);
    }
    public void selectValueFromElementByClassName(String selector, String valueToSelect){
        String res = selectValueFromElement(getElementByClassName(selector),valueToSelect);
        if(res!="")
            reporter.logError(TestKeywords.Action.SELECT,TestKeywords.Selecots.CLASSNAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SELECT,TestKeywords.Selecots.CLASSNAME,selector,res);
    }
    public void selectValueFromElementByTagName(String selector, String valueToSelect){
        String res = selectValueFromElement(getElementByTagName(selector),valueToSelect);
        if(res!="")
            reporter.logError(TestKeywords.Action.SELECT,TestKeywords.Selecots.TAGNAME,selector,res);
        else
        if(reporter.showDebugMessages)
            reporter.logDebug(TestKeywords.Action.SELECT,TestKeywords.Selecots.TAGNAME,selector,res);
    }

}
