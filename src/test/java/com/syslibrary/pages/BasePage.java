package com.syslibrary.pages;

import com.syslibrary.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public static void goToMenu(String topMenu){
        String path="//*[@class='title'][contains(.,'"+topMenu+"')]";
        Driver.get().findElement(By.xpath(path)).click();
    }

}
