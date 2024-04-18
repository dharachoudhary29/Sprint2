 package Page;
  
 import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
  
  import org.openqa.selenium.JavascriptExecutor; import
  org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
  org.openqa.selenium.support.CacheLookup; import
  org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
  
  public class NotificationPageFactory {
  
  WebDriver driver;
  
  @FindBy(xpath="//input[@id=\"session_key\"]")
  
  @CacheLookup WebElement email;
  
  @FindBy(xpath="//input[@id=\"session_password\"]")
  
  @CacheLookup WebElement password;
  
  @FindBy(xpath="//button[@data-id=\"sign-in-form__submit-btn\"]") 
  WebElement lgbtn;
  
  @FindBy(xpath = "//span[@title=\"Notifications\"]")
   WebElement notify;
	 
  @FindBy(xpath="//a[@href=\"/mypreferences/d/categories/notifications\"]")
  WebElement ViewSetting;
  
  @FindBy(xpath="//div[@class=\"category-text category-text--new \"]//p[@class=\"category-text__name sans-medium  \"]") 
  WebElement JobSearch;
  
  @FindBy(xpath="//span[@class=\" _toggle-text_12ycew\"]")
  WebElement Button;
  
  @FindBy(xpath="//p[@class=\"toggle-label sans-16 t-black--light only-toggle-label\"]")
  WebElement state;
  
  public NotificationPageFactory(WebDriver driver) { 
	  this.driver=driver;
	  PageFactory.initElements(driver, this); } 
     public void login(String uname,String pwd) throws InterruptedException { 
	  email.sendKeys(uname);
      password.sendKeys(pwd);
      lgbtn.click();
  
  }
  public void ExplicitWait(WebElement webElement, int time)
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
	 public void clickNotifyBtn() throws InterruptedException{
		 ExplicitWait(notify,4);
		 notify.click();
	  }
	 
   public void SwitchToViewSettings() { 
	   String mainWindowHandle =driver.getWindowHandle(); 
	   Set<String> allWindowHandles =driver.getWindowHandles(); 
	   for (String handle : allWindowHandles) {
	   if(!handle.equals(mainWindowHandle)) {
	    driver.switchTo().window(handle);
  
  } 
	   } 
   } 
   public void ClickViewSettings() throws InterruptedException {
	   ExplicitWait(ViewSetting,3);
   ViewSetting.click();
   } 
   
   public void CLickJobSearch() throws InterruptedException 
   {
	   ExplicitWait(JobSearch,3);
	   JobSearch.click(); 
	 } 
   
   public void ClickButton() throws InterruptedException {
	   ExplicitWait(Button,3);
    Button.click(); 
   }
   
   public String stat() {
	   String res= state.getText();
	   System.out.println(res);
	   return res;
   }
    
  /*===================================Scenario 2========================================*/
	
	
	  @FindBy(xpath="//button[@aria-label=\"My posts\"]")
	  WebElement mypost;
	  
	  @FindBy(xpath="(//button[@class=\"artdeco-card overflow-hidden mt2\"])[1]") 
	  WebElement post;
	  
	  @FindBy (xpath="//div[@class=\"ql-editor ql-blank\"]") 
	  WebElement comment;
	  
      @FindBy (xpath ="//span[text()=\"Post\"]")
      WebElement submit;
      
      @FindBy (xpath="(//span[text()=\"Congratulations\"])")
       WebElement manage;
      
		  public void clickMyPost() throws InterruptedException {
			  ExplicitWait(mypost,1);
			  mypost.click();
		  }
		  
		  public void post() throws InterruptedException {
			  ExplicitWait(post,1);
			  post.click();
		  }
		  public void scroll() throws InterruptedException {
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript("arguments[0].scrollIntoView(true);",comment);
			  Thread.sleep(1000);
		  }
		  
		  public void comment(String com) throws InterruptedException {
			  ExplicitWait(comment,2);
			  comment.sendKeys(com);
		  }
		  
		  public void submit() throws InterruptedException
		  {
			  ExplicitWait(submit,3);
			  submit.click();
		  }
		  
		  public String mng() {
			  String mm=manage.getText();
			  return mm;
		  }
		  
		  /*===================================Scenario 3========================================*/
		  
		  @FindBy(xpath="//section[@class=\"artdeco-card nt-pill-list mb3\"]")
		  WebElement tab;
		  
		  public void not() throws AWTException, InterruptedException
		  {
			  tab.click();
			  Robot r=new Robot();
			  r.delay(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.delay(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.delay(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.delay(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.delay(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.delay(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.delay(3000);		 
			  r.keyPress(KeyEvent.VK_ENTER);
//			  Thread.sleep(4000);
		  }
		  
		  
		
		  /*===================================Scenario 4========================================*/
		  		  
		  @FindBy(xpath="//section[@class=\"artdeco-card nt-pill-list mb3\"]")
		  WebElement birthday;
		  
		  @FindBy (xpath="//div[@aria-label=\"Write a message…\"]")
		  WebElement wish ;
		  
		  @FindBy (xpath="//button[@type=\"submit\"]")
		  WebElement send;
		  
		  @FindBy(xpath="//span[text()=\"You sent Raja a message\"]")
		  WebElement raj;
		  
		  public void bday() throws InterruptedException, AWTException {
				  birthday.click();
				  Robot r=new Robot();
				  r.delay(4000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(1000);
				  r.keyPress(KeyEvent.VK_TAB);
				  r.delay(3000);
//				  r.keyPress(KeyEvent.VK_TAB);
//				  r.delay(1000);
//				  r.keyPress(KeyEvent.VK_TAB);
//				  r.delay(1000);
//				  r.keyPress(KeyEvent.VK_TAB);
//				  r.delay(1000);		  
				  r.keyPress(KeyEvent.VK_ENTER);
				  r.delay(4000);
		  }
		  public void wish(String ws) throws InterruptedException {
			  ExplicitWait(wish,3);
			  wish.sendKeys(ws);
			  
		  }
		  
		  public void send() throws InterruptedException {
			  ExplicitWait(send,3);
		  send.click();
		  }
		  
		  public String raaj() {
			  String rr=raj.getText();
			  return rr;
		  }
		  
		  
		  /*===================================Scenario 5========================================*/


       @FindBy(xpath="//section[@class=\"artdeco-card nt-pill-list mb3\"]")
       WebElement sharing;
       
       @FindBy(xpath="(//span[text()=\"Send\"])[1]")
       WebElement sendtoo;
       
       @FindBy(xpath="//input[@id=\"multisend-typeahead\"]")
       WebElement type;
       
       @FindBy(xpath="//label[@class=\"mt4 msg-connections-typeahead__checkbox-multisend\"]")
       WebElement tick;
       
       @FindBy(xpath="//div[@class=\"ml2\"]")
       WebElement finall;
       
       @FindBy(xpath="//h2[@id=\"multi-send-modal-header\"]")
		  WebElement sharng;
       
       public void shr() throws InterruptedException, AWTException {
    	   ExplicitWait(sharing,1);
    	   sharing.click();
 				  Robot r=new Robot();
 				   r.delay(4000);
 				  r.keyPress(KeyEvent.VK_TAB);
 				   r.delay(1000);
 				  r.keyPress(KeyEvent.VK_TAB);
 				 r.delay(1000);
 				  r.keyPress(KeyEvent.VK_TAB);
 				  r.delay(1000);
 				  r.keyPress(KeyEvent.VK_TAB);
 				 r.delay(1000);
 				  r.keyPress(KeyEvent.VK_TAB);
 				 r.delay(1000);
 				  r.keyPress(KeyEvent.VK_ENTER);

       }
       
       public void sendt() throws InterruptedException {
    	   ExplicitWait(sendtoo,1);
    	   sendtoo.click();
    	   
       }
       
       public void typname(String name) throws InterruptedException {
    	   ExplicitWait(type,1);
    	   type.sendKeys(name);
       }
       
       public void tickname() throws InterruptedException {
    	   ExplicitWait(tick,1);
    	   tick.click();
       }
       
       public void finaly() throws InterruptedException {
    	   ExplicitWait(finall,1);
    	   finall.click();
       }
       
       public String shrg() {
			  String sh=sharng.getText();
			  return sh;
		  }
       
       
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
	 

 
 

