package assignment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException{

		 System.setProperty("webdriver.chrome.driver","./drivers/chromedriverneww.exe");
			WebDriver driver =new ChromeDriver();
			driver.get("http://www.qaclickacademy.com/practice.php");
		//driver.manage().window().maximize();
        AutomationDriver.exerciseOne(driver);
	    AutomationDriver.exerciseTwo(driver);
	    AutomationDriver.exerciseThree(driver);
		AutomationDriver.exerciseFour(driver);
	    AutomationDriver.exerciseFourPointOne(driver);
	    AutomationDriver.exerciseFourPointTwo(driver);
		AutomationDriver.exerciseFive(driver); 
		AutomationDriver.exerciseSix(driver);
		AutomationDriver.exerciseSeven(driver);
		AutomationDriver.exerciseEight(driver);
	    AutomationDriver.exerciseNine(driver);
	    }
	
	/* 
	 * MethodName:ExerciseOne
	 * Description:To Automate RadioButton
	 */
	 public static void exerciseOne(WebDriver driver) {
	 driver.findElement(By.cssSelector("[value='radio1']")).click();
	 Assert.assertTrue(driver.findElement(By.cssSelector("[value='radio1']")).isSelected());
	 driver.findElement(By.cssSelector("[value='radio2']")).click();
	 Assert.assertTrue(driver.findElement(By.cssSelector("[value='radio2']")).isSelected());
	 driver.findElement(By.cssSelector("[value='radio3']")).click();
	 Assert.assertTrue(driver.findElement(By.cssSelector("[value='radio3']")).isSelected());
    }
	
	/*
	 * MethodName:ExerciseTwo
	 * Description:To Automate Suggestion Class
	 * 
	 */
	public static void exerciseTwo(WebDriver driver) throws InterruptedException{
	driver.findElement(By.id("autocomplete")).sendKeys("United States");
	Thread.sleep(3000);
	List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
	for(WebElement option : options)
	{
		if(option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))
		{
		option.click();
		Assert.assertTrue(driver.findElement(By.id("autocomplete")).isDisplayed());
		break;
		}
	}
 }
	
	/*
	 * MethodName:ExerciseThree
	 * Description:To Automate DropDown
	 * 
	 */
	public static void exerciseThree(WebDriver driver) {
		WebElement static1 = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown1 = new Select(static1);
		dropdown1.selectByIndex(1);
		Assert.assertTrue(driver.findElement(By.id("dropdown-class-example")).isDisplayed());
		WebElement static2 = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown2 = new Select(static2);
		dropdown2.selectByIndex(2);
		Assert.assertTrue(driver.findElement(By.id("dropdown-class-example")).isDisplayed());
		WebElement static3 = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown3 = new Select(static3);
		dropdown3.selectByIndex(3);
		Assert.assertTrue(driver.findElement(By.id("dropdown-class-example")).isDisplayed());
	}
	
	/*
	 * MethodName:ExerciseFour
	 * Description:To Automate Checkbox
	 */
	public static void exerciseFour(WebDriver driver) {
		driver.findElement(By.cssSelector("input[id*='checkBoxOption1'] ")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='checkBoxOption1'] ")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption2']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='checkBoxOption2'] ")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='checkBoxOption2']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='checkBoxOption2'] ")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption2']")).isSelected());
	
		driver.findElement(By.cssSelector("input[id*='checkBoxOption3'] ")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='checkBoxOption3']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='checkBoxOption3'] ")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption3']")).isSelected());
	
	}
	/*
	 * MethodName:ExerciseFourPointOne
	 * Description:To Automate Checkbox:By Selecting All
	 */
	
	public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector("input[id*='checkBoxOption1'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption2'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption3'] ")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption2']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption3']")).isSelected());
		
		List <WebElement> Allcheckboxes = driver.findElements(By.xpath("//input[@type ='checkbox']"));
		int size = Allcheckboxes.size();
		for(int i=0; i<size ; i++)
		{
			Allcheckboxes.get(i).click();
		}
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption2']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption3']")).isSelected());
	}
	
	/*
	 * MethodName:ExerciseFourPointTwo
	 * Description:To Automate Checkbox:By Selecting All
	 * 
	 */
	
	public static void exerciseFourPointTwo(WebDriver driver) throws InterruptedException {
		List <WebElement> Allcheckboxes = driver.findElements(By.xpath("//input[@type ='checkbox']"));
		int size = Allcheckboxes.size();
		{
		for(int i=0; i<size ; i++)
		{
			Allcheckboxes.get(i).click();
			
		}
		}
		driver.findElement(By.cssSelector("input[id*='checkBoxOption1'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption2'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption3'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption1'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption2'] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='checkBoxOption3'] ")).click();	
		Thread.sleep(1000);
	}
	/*
	 * MethodName:ExerciseFive
	 * Description:To Automate SwitchWindow
	 */
	 
	
	public static void exerciseFive(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
	 driver.findElement(By.id("openwindow")).click();
     Assert.assertTrue(driver.findElement(By.id("openwindow")).isDisplayed());
	Thread.sleep(1000);
	
	Set<String> windows = driver.getWindowHandles();
	Iterator<String>it =windows.iterator();
	String parentid = it.next();
	String childid= it.next();
	driver.switchTo().window(childid);
	driver.close();
	driver.switchTo().window(parentid);
}
	/*
	 * MethodName:ExerciseSix
	 * Description:To Automate SwitchTab
	 */
	 public static void exerciseSix(WebDriver driver) throws InterruptedException{
    driver.findElement(By.id("opentab")).click();
	Thread.sleep(1000);
	System.out.println(driver.findElement(By.id("opentab")).isDisplayed());
	Set<String> windows = driver.getWindowHandles();
	Iterator<String>it =windows.iterator();
	String parentid = it.next();
	String childid= it.next();
	Thread.sleep(1000);
	driver.switchTo().window(childid);
	Thread.sleep(1000);
	driver.close();
	driver.switchTo().window(parentid);
	Thread.sleep(1000);
	System.out.println(driver.getWindowHandle().equals(parentid));
   
 }
        /*
		 * MethodName:ExerciseSeven
		 * Description:To Automate SwitchToAlert
		 */
        public static void exerciseSeven(WebDriver driver) throws InterruptedException{
		String text = "charitha ";
		WebElement d2 = driver.findElement(By.id("name"));
		Actions action = new Actions(driver);
		action.moveToElement(d2).sendKeys(text);
		driver.findElement(By.cssSelector("[id ='alertbtn']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
        /*
    	 * MethodName:ExerciseEight
    	 * Description:To Automate Table
    	 */
	
        public static void exerciseEight(WebDriver driver) throws InterruptedException {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
	 }
        /*
    	 * MethodName:ExerciseNine
    	 * Description:To Automate Mouse Hover
    	 */
	public static void exerciseNine(WebDriver driver) throws InterruptedException {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		WebElement mouse = driver.findElement(By.id("mousehover"));
		mouse.click();
		WebElement top = driver.findElement(By.xpath("//a[text() = 'Top']"));
		top.click();
	    driver.quit();
	}

}

	
	
	
	

