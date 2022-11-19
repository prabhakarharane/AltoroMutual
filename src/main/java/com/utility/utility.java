package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.baseClass;

public class utility extends baseClass{

	
	public static void dropDown(WebElement ele, String value) {
		Select stl = new Select(ele);
		stl.selectByValue(value);	
	}
}
