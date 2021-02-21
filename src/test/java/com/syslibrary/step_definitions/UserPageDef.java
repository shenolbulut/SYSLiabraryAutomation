package com.syslibrary.step_definitions;

import com.syslibrary.pages.BasePage;
import com.syslibrary.pages.LoginPage;
import com.syslibrary.pages.UsersPage;
import com.syslibrary.utulities.BrowserUtils;
import com.syslibrary.utulities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserPageDef {
    LoginPage loginPage=new LoginPage();
    @Given("librarian should be on base page")
    public void librarian_should_be_on_base_page() {
        LoginPage.logi();
        BrowserUtils.waitFor(3);
    }

    @Given("librarin goes to {string} page from Basepage")
    public void librarin_goes_to_page_from_Basepage(String string) {
        BasePage.goToMenu(string);
        BrowserUtils.waitFor(2);
    }


    @Then("verify that selected option is {string}")
    public void verify_that_selected_option_is(String string) {
        String text = new Select(new UsersPage().userGroupDrpdwn).getFirstSelectedOption().getText();
        Assert.assertEquals(string,text);
    }

    @Then("librarian can select {string} from dropdown")
    public void librarian_can_select_from_dropdown(String string) {
        new Select(new UsersPage().userGroupDrpdwn).selectByVisibleText(string);

    }

    @When("librarian click status button")
    public void librarian_click_status_button() {
        new UsersPage().userStatusDrpdwn.click();
    }

    @Then("Status should have")
    public void status_should_have(List<String> status) {
       List<String> listStatus=BrowserUtils.getElementsText(new Select(new UsersPage().userStatusDrpdwn).getOptions());
       Assert.assertEquals(status,listStatus);
    }

    @When("librarian click edit button")
    public void librarian_click_edit_button() {
       new UsersPage().editBtn.click();
    }

    @Then("librarian should be able to send following credential")
    public void librarian_should_be_able_to_send_following_credential(Map<String,String> editTable) {
        for(String key: editTable.keySet()){
            UsersPage.checkInputs(key, editTable.get(key));
        }
        new UsersPage().saveBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("librarian can see the edited user on the table")
    public void librarian_can_see_the_edited_user_on_the_table() {
        Assert.assertEquals("ali demir",Driver.get().findElement(By.xpath("//tbody/tr[1]/td[3]")).getText());
    }

    @When("librarian clicks the show dropdown")
    public void librarian_clicks_the_show_dropdown() {
        new UsersPage().showDrpdwn.click();
    }

    @When("ten must be first selected options")
    public void ten_must_be_first_selected_options() {
        Assert.assertEquals("10", new Select(new UsersPage().showDrpdwn).getFirstSelectedOption().getText());

    }

    @Then("librarian should see the following numbers")
    public void librarian_should_see_the_following_numbers(List<String> showDrpdwnOptns) {
        List<String> showNumbers=BrowserUtils.getElementsText(new Select(new UsersPage().showDrpdwn).getOptions());
        Assert.assertEquals(showDrpdwnOptns, showNumbers);
    }

    @Then("librarian should select all dropdowns")
    public void librarian_should_select_all_dropdowns(List<String> showDrpdwnOptns) {
        for (String optn: showDrpdwnOptns){
            new Select(new UsersPage().showDrpdwn).selectByValue(optn);
            Assert.assertEquals(optn, new Select(new UsersPage().showDrpdwn).getFirstSelectedOption().getText());
        }
    }

    @Given("first selected option of Status must be ACTIVE")
    public void first_selected_option_of_Status_must_be_ACTIVE() {
        String text = new Select(new UsersPage().userStatusDrpdwn).getFirstSelectedOption().getText();
        Assert.assertEquals("ACTIVE", text);
    }

    @When("librarian clicks the Status dropdown")
    public void librarian_clicks_the_Status_dropdown() {
        new UsersPage().userStatusDrpdwn.click();
    }

    @Then("all the options should be able to select")
    public void all_the_options_should_be_able_to_select(List<String>  statusOptn) {
      for(String opt: statusOptn){
          new Select(new UsersPage().userStatusDrpdwn).selectByValue(opt);
          Assert.assertEquals(opt, new Select(new UsersPage().userStatusDrpdwn).getFirstSelectedOption().getText());
      }
    }

    @When("librarian enters {string} to the search button")
    public void librarian_enters_to_the_search_button(String text) {
        new UsersPage().searchInput.sendKeys(text, Keys.ENTER);
        BrowserUtils.waitFor(1);
    }

    @Then("all the results have {string} string")
    public void all_the_results_have_string(String string) {
        List<WebElement> listTable=new ArrayList<>();
        List<WebElement> emailTable=new ArrayList<>();
        if(!Driver.get().findElement(By.xpath("//tbody/tr/td[1]")).isEnabled()){
            throw new WebDriverException("no results");
            }
        do{
           listTable=Driver.get().findElements(By.xpath("//tbody/tr/td[3]"));
           emailTable=Driver.get().findElements(By.xpath("//tbody/tr/td[4]"));
           List<String> nameList=BrowserUtils.getElementsText(listTable);
           List<String> emailList=BrowserUtils.getElementsText(emailTable);
           for (int i=1; i<nameList.size(); i++){
               Assert.assertTrue(nameList.get(i).toLowerCase().contains(string.toLowerCase()) || emailList.get(i).toLowerCase().contains(string.toLowerCase()));
           }
            try{
                new UsersPage().nextBtn.click();
                BrowserUtils.waitFor(1);
            }catch (Exception e){
                throw new WebDriverException("next is disabled");
            }
        }while (!new UsersPage().nextBtn.getAttribute("class").contains("disabled"));

    }

    @When("librarian click user group")
    public void librarian_click_user_group() {
        new UsersPage().userGroupDrpdwn.click();
    }

    @Then("User Group should have two user types as")
    public void user_Group_should_have_two_user_types_as(List<String> userGrupOptn) {
        List<WebElement> allSelectedOptions = new Select(new UsersPage().userGroupDrpdwn).getOptions();
        List<String> listGrup=BrowserUtils.getElementsText(allSelectedOptions);
        Assert.assertEquals(userGrupOptn, listGrup);
    }

    @When("librarin clicks the edit")
    public void librarin_clicks_the_edit() {
        new UsersPage().editBtn.click();
    }

    @Then("Edit user information should have following parameters")
    public void edit_user_information_should_have_following_parameters(List<String> editTable) {
        List<String > editTableText=BrowserUtils.getElementsText(new UsersPage().allInputs);
        Assert.assertEquals(editTable, editTableText);
    }

    @Then("librarian gives invalid credentials for user name")
    public void librarianGivesInvalidCredentialsForUserName() {

        Assert.assertFalse(Driver.get().findElement(By.xpath("//div[@class='toast-message']")).isDisplayed());
    }
}
