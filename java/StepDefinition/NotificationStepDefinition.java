package StepDefinition;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverSetup.BaseSteps;
import Page.NotificationPageFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationStepDefinition {
          static WebDriver driver;
       NotificationPageFactory pf;
            
       
        @Given("User is logged In and User is on notification Page")
       public void user_is_logged_in(DataTable dataTable) throws InterruptedException, AWTException {
    	   driver = BaseSteps.chromedriver();
   		   pf=new NotificationPageFactory(driver);   		   
//   		   pf.login("dhara.choudhary1129@gmail.com", "Khushi@987");
   		List<List<String>> cells = dataTable.cells();
		pf.login(cells.get(0).get(0),cells.get(0).get(1));
   		   Thread.sleep(5000);
   		   pf.clickNotifyBtn();
   		   }
        
       @When("User clicks on View Settings")
		   public void  User_clicks_on_View_Settings() throws InterruptedException {
//    	   String title=driver.getTitle();
//		   Assert.assertFalse(title.contains("Swag Labs")); 
				  Thread.sleep(7000);
				  pf.ClickViewSettings(); 
				  pf.SwitchToViewSettings();
			
       }
		  
		  @And("User clicks on Searching for a job") 
		  public void user_clicks_on_searching_for_a_job() throws InterruptedException {
			  Thread.sleep(7000);
			  pf.CLickJobSearch();
		
		  }
		  
		  @And ("User switch on the toggle") 
		  public void User_switch_on_the_toggle() throws InterruptedException { 
			  Thread.sleep(7000);
			  pf.ClickButton(); 
		  }
		  
		  
		  @Then("notification searching for a job is on")
		  public void notification_searching_for_a_job_is_on(){
			   String ss=pf.stat();
			  Assert.assertTrue(ss.contains("Allow job search notifications"));
		  }
		  
		  
		  
		 /*-------------------------------------------------------------------------*/ 
			 
			  //Scenario 2
			  
				
				  @When("User clicks on my post") public void user_clicks_on_my_post() throws
				  AWTException, InterruptedException { 
					  pf.clickMyPost(); }
				 
				  @And("User clicks on the post")
				  public void user_clicks_on_the_post() throws InterruptedException {
  			         pf.post();
  			         pf.scroll();
				  }
		  
				  @And("User comment on the post") 
				  public void user_comment_on_the_post(DataTable dataTable) throws InterruptedException {
			      List<List<String>> cells = dataTable.cells();
			     
				  pf.comment(cells.get(0).get(0));
				  pf.submit();
				  
				  }
				  
				  @Then("comment should be reflected") public void
				  comment_should_be_reflected() {
				   String mn=pf.mng();
						  Assert.assertEquals(mn,"Congratulations");
				  
				  }
				  
				  /*-------------------------------------------------------------------------*/
				  
					
				  //Scenario 3
				  
				  @When("User open the notification in which other user viewed your profile is reflected")
				  public void User_open_the_notification_in_which_other_user_viewed_your_profile_is_reflected() throws InterruptedException, AWTException {
					  pf.not();
				  }
				   

                 @Then("profile picture and user name is not visible")
                public void profile_picture_and_user_name_is_not_visible() {
           
                 }
				
				 
				 
				 /*-------------------------------------------------------------------------*/
				 
				//Scenario 4
				 
				 @When ("User click on other user Birthday notification")
				 public void User_click_on_other_user_Birthday_notification() throws InterruptedException, AWTException {
					 pf.bday();
				 }
				 
				 @And ("Message box of other user should be open")
				 public void Message_box_of_other_user_should_be_open() {
				 }
				 
				 @And ("Happy Birthday message should be written")
				 public void Happy_Birthday_message_should_be_written(DataTable dataTable) throws InterruptedException {
					 List<List<String>> cells = dataTable.cells();
					 pf.wish(cells.get(0).get(0));
					 pf.send();
					 
				 }
				 
				 
				 @Then("the message should be sent")
				 public void the_message_should_be_sent() {
					 String rn=pf.raaj();
					  Assert.assertEquals(rn,"You sent Raja a message");
				 }
				 
				 
				 /*-------------------------------------------------------------------------*/
				 
				//Scenario 5
				 
				 @When ("User click on a particular post notification")
				 public void User_click_on_a_particular_post_notification() throws InterruptedException, AWTException {
					 pf.shr();
				 }
				 
				 @And ("clicks on send button of the post")
				 public void clicks_on_send_button_of_the_post() throws InterruptedException {
					 pf.sendt();
					 
				 }
				 
				 @And("^Enters the (.*)$")
				 public void enters_the(String name) throws InterruptedException {
					pf.typname(name);
				     
				 }
				 
				 @And ("Select the box infront of the reciever")
				 public void Select_the_box_infront_of_the_reciever() throws InterruptedException {
					 pf.tickname();
					 pf.finaly();
				 }
				 
				 @Then ("Click on the send button")
				 public void Click_on_the_send_button() throws InterruptedException {
					 String sm=pf.shrg();
					  Assert.assertEquals(sm,"Send Sri ram Kukkadapu’s Post");
				 }
				 
				 
				 
				 /*-------------------------------------Afterstep------------------------------------*/
				 

				 @AfterStep public static void takeScreendown(Scenario scenerio) {
				  
				  TakesScreenshot ts= (TakesScreenshot) driver; final byte[] src =
				  ts.getScreenshotAs(OutputType.BYTES); scenerio.attach(src,
				  "image/png",scenerio.getName()); }
}

