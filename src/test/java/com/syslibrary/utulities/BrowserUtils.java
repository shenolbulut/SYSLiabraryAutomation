package com.syslibrary.utulities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


    public static void waitFor(long time){
        try{
            Thread.sleep(time*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> getElementsText(List<WebElement> elements){
        List<String> list=new ArrayList<>();

        for(WebElement elm:elements){
            list.add(elm.getText());
        }
        return list;
    }

    public static List<String> getElementsText(By locator){
        List<String> list=new ArrayList<>();
        List<WebElement> elements=Driver.get().findElements(locator);
        for(WebElement elm:elements){
            list.add(elm.getText());
        }
        return list;
    }

    public static void waitForVisibility(WebElement element, long time){
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForClickability(WebElement element, long time){
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(By locator, long time){
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForClickability(By locator, long time){
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.elementToBeClickable(locator));
    }


}
