package SongbySinatra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SongsSinatraParent {

    public  WebDriver driver;

    public   void navegar(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        driver = new ChromeDriver();   // Crea el driver tipo Chrome
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Hace una espera implicita de 10 segundos que le da para que carge los elementos de la pagina.
        driver.navigate().to(url);  //Navega hacia el sitio de la url que recibe al momento en que
    }

    public   void realizarLoginCorrecto(String usuario, String password) {
        WebElement loginLink = driver.findElement(By.xpath("//a[@href=\"/login\"]"));
        if (loginLink.isDisplayed()){

        loginLink.click();}

        WebElement usernametext = driver.findElement(By.id("username"));
        WebElement passwordtxt = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//input [@ value= \"Log In\"]"));

        if (usernametext.isDisplayed() && passwordtxt.isDisplayed() && loginbutton.isDisplayed())
        {
            System.out.println("All elements were located");
            usernametext.sendKeys(usuario);
            passwordtxt.sendKeys(password);
            loginbutton.click();

        }
    else
        System.out.println("Double check the locators");

//    HomePage:
//    linkLogin: txt="log in "
//
//    LoginPage:
//    usernameTxt: id="username"
//    passwordTxt: id="password"
//    loginBtn: value="Log In"

    }
    public  void validateSongsPage(){
        WebElement songsTitle = driver.findElement(By.tagName("h1"));
        String currentUrl = driver.getCurrentUrl();
        WebElement songsLink = driver.findElement(By.cssSelector("[href='/songs']"));
        String currentClass = songsLink.getAttribute("class");
        String s = "https://evening-bastion-49392.herokuapp.com/songs";
       /* if (currentUrl == s)
        {
            System.out.println("User is in Songs Page");
        }
        else
            {
                System.out.println("User is not in Songs Page");
            }*/
        //WebElement listaCanciones = driver.findElements(By.cssSelector("#songs li"));

        //if (songsTitle.isDisplayed () &&
          //   currentUrl )

    }
    public  void validarHomePage() {

     WebElement imgHome = driver.findElement(By.tagName("h1"));
     if (imgHome.isDisplayed())
     {
         System.out.println("Message exist in home");
     }
     else
     {
         System.out.println("Message is not displayed");
         cerrarBrowser();
     }
    }


    public  void validarMensajeBienvenida(String mensajeBienvenida) {
        WebElement welcomemsg = driver.findElement(By.cssSelector(".flash"));
        WebElement logoutbtn = driver.findElement(By.partialLinkText("/logout"));

      /*  if (welcomemsg.getText())
        {
            System.out.println("Welcome message is correct");
        }*/

    }

    public  void cerrarBrowser() {
        driver.close();
    }
}
