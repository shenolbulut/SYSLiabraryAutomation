package com.syslibrary.pages;

import com.syslibrary.utulities.BrowserUtils;
import com.syslibrary.utulities.ConfigurationReader;
import com.syslibrary.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "inputEmail")
    public WebElement nameInput;
    @FindBy(id = "inputPassword")
    public WebElement passwordInput;
    @FindBy(css = ".btn.btn-lg.btn-primary.btn-block")
    public WebElement submitBtn;

    public static void logi(){
        Driver.get().get(ConfigurationReader.get("url"));

        new LoginPage().nameInput.sendKeys(ConfigurationReader.get("username_librarion"));

        new LoginPage().passwordInput.sendKeys(ConfigurationReader.get("password_librarion"));
        new LoginPage().submitBtn.click();
        BrowserUtils.waitFor(2);
    }
}
