package upload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Uploadfile {

	public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\\\SOTWARES\\\\chromedriver.exe");  

        WebDriver driver = new ChromeDriver();
		driver.get("http://www.filehosting.org");
		WebElement uploadButton = driver.findElement(By.name("upload_file"));
		uploadButton.click();
            uploadFile("D:\\emailtemplate.docx");
    }


private static void uploadFile(String fileLocation) {
    // TODO Auto-generated method stub
    try {
        //Setting clip board with file location
        setClipboardData(fileLocation);
        //native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
    } catch (Exception exp) {
        exp.printStackTrace();
    }
}
private static void setClipboardData(String string) {
    // TODO Auto-generated method stub
    //StringSelection is a class that can be used for copy and paste operations.

       StringSelection stringSelection = new StringSelection(string);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
}