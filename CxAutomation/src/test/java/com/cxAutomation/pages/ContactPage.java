package com.cxAutomation.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
	
	    public static By contactLink = By.xpath("//a[@title='Contact']");
		public static By send = By.xpath("//input[@value='Send']");
		public static By name =By.xpath("//input[@name='your-name']");
		public static  By email =By.xpath("//input[@name='your-email']");
		public static  By subject =By.xpath("//input[@name='your-subject']");
		public static  By message =By.xpath("//textarea[@name='your-message']");
		public static  By validationMessage=By.xpath("//*[@id='wpcf7-f375-p28-o1']/form/div[2]");
		public static  By dummy=By.xpath("//*[@id='wpcf7-f375-p28-o1']/form/div[2]");

		//Branch 1 comment
		//Branch 3 comment testing testing
		
		
}
