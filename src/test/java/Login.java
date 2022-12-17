import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class Login {

    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        // open browser
        wd = new ChromeDriver();
        // open site
        wd.get("https://telranedu.web.app/");
    }
    @Test
    public void findElementOnPage (){
        WebElement element = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        // By id
        WebElement el1 = wd.findElement(By.id("root"));

        //By class
        WebElement el2 = wd.findElement(By.className("container"));

        //By link text
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.partialLinkText("AB"));
        //By name
       // wd.findElement(By.name("name"));
    }

    @Test
    public void loginSuccess(){
        // open form
        // wd find button + click

        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();
        // fill form
        // find email + click + clear + type
        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("noa@gmail.com");
        // find password + click + clear + type
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Nnoa12345$");
        // submit  form
        // find button login + click
        List<WebElement> button = wd.findElements(By.tagName("button"));
        WebElement buttonlogin = button.get(0);
        buttonlogin.click();

        Assert.assertEquals("","");
        // ac ==exp
    }
    @AfterMethod
    public void postCondition(){
        // close browser
       // wd.quit();
    }
}
