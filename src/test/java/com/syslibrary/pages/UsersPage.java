package com.syslibrary.pages;

import com.syslibrary.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage extends BasePage{

    @FindBy(css = ".btn.btn-lg.btn-outline.btn-primary.btn-sm")
    public WebElement addUserBttn;

    public static void checkInputs(String inputName, String value){
        String path="//label[contains(.,'"+inputName+"')]/../*[@class='form-control']";
        Driver.get().findElement(By.xpath(path)).clear();
        if(value!=null){
        Driver.get().findElement(By.xpath(path)).sendKeys(value);}

    }

    @FindBy(xpath = "//button[contains(.,'Save changes')]")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[@id='edit_user_modal']//label[@class='control-label']")
    public List<WebElement> allInputs;

    @FindBy(css = "#user_groups")
    public WebElement userGroupDrpdwn;

    @FindBy(id = "user_status")
    public WebElement userStatusDrpdwn;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/a")
    public WebElement editBtn;

    @FindBy(css = ".form-control.input-sm.input-xsmall.input-inline")
    public WebElement showDrpdwn;

    @FindBy(xpath = "//*[@class='fa fa-angle-right']/../..")
    public WebElement nextBtn;

    @FindBy(css = ".btn.default")
    public WebElement closeBtn;

}
