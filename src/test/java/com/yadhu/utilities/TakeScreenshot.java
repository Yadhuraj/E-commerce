package com.yadhu.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	public static void captureSC(WebDriver driver, String TestName) throws IOException
	{
		TakesScreenshot sc = ((TakesScreenshot)driver);
		Date time = Calendar.getInstance().getTime();
		String name = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(time)
						.replace(' ', '-').replace(':', '_').replace('/', '_');
		System.out.println(name);
		
		File src = sc.getScreenshotAs(OutputType.FILE);
		File srcpath = new File(".//Screenshots//"+TestName+".png");
		
		FileUtils.copyFile(src, srcpath);
		
		
	}

}
