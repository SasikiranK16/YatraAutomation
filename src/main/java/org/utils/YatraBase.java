package org.utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YatraBase {

	public static Properties properties;
	public static FileInputStream fileInputStream;
	public static WebDriver driver;
	public static Function<WebDriver, Void> closeAdvertisment = (a) -> {
		a.findElement(By.xpath("(//*[starts-with(@alt,'cross')])[1]")).click();
		return null;
	};
	public static Function<WebDriver, Void> calendarClick = b -> {
		b.findElement(By.xpath("//*[starts-with(@class,'position-relative css-qf1gji')]")).click();
		return null;
	};

	public static Function<WebDriver, Void> clickParticularDate = f -> {
		f.findElements(By.xpath("//*[starts-with(@aria-label,'MAHA SHIVARATHIRI')]")).stream()
				.filter(p -> p.getText().contains("₹4,024")).findFirst().orElse(null).click();
		return null;
	};
	public static Function<WebDriver, Void> searchButton = cl -> {
		cl.findElement(By.xpath("(//*[starts-with(@type,'button')])[2]")).click();
		return null;
	};

	public static Properties getPropertyDetails(String fileName) {
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\org\\utils\\" + fileName + ".properties");
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	public static WebDriver optBrowser(String browserName, String urlLink) {
		if (browserName.toLowerCase().equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.toLowerCase().equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(urlLink);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver commonDrivers(WebDriver webDriver) {

		return webDriver;
	}
}
