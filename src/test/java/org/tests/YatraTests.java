package org.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;
import org.utils.YatraBase;


public class YatraTests extends YatraBase {

	@BeforeSuite
	public void launch() {

		optBrowser(getPropertyDetails("Yatra").getProperty("browser"), getPropertyDetails("Yatra").getProperty("url"));
		closeAdvertisment.apply(driver);
		commonDrivers(driver);
	}

	@Test
	public void testOne() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		calendarClick.apply(driver);
		clickParticularDate.apply(driver);
		searchButton.apply(driver);
		driver.findElements(By.xpath("//*[starts-with(@class,'fs-18 bold price-color text-center fare-price')]"))
				.stream().map(WebElement::getText).map(s -> s.replace(",", "")).map(String::trim).map(Integer::parseInt)
				.collect(Collectors.toList()).forEach(p -> {
					if (p<5544) {
						System.out.println(p);
					}
				});

	}

}
