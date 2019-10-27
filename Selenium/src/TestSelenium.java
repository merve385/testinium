import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "httpS://n11.com/giris-yap";
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("ozsahinmerve24@gmail.com");
        driver.findElement(By.id("password")).sendKeys("M12345");
        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.id("searchData")).sendKeys("Bilgisayar");
        driver.findElement(By.className("searchBtn")).click();
        driver.navigate().to("https://www.n11.com/arama?q=Bilgisayar&pg=2");
       driver.navigate().to("https://urun.n11.com/dizustu-bilgisayar/apple-macbook-pro-mv902tua-i7-26ghz-16gb-256gb-ssd-macos-15-sp-P357233969");

        String pagePrice = driver.findElement(By.id("productDisplayPrice")).getAttribute("value").replace(".", "").replace(",","");


        driver.findElement(By.className("btnAddBasket")).click();
        driver.navigate().to("https://www.n11.com/sepetim");
        driver.navigate().to("https://www.n11.com/sepetim");
        String prodPrice = driver.findElement(By.className("productPrice")).getAttribute("value").replace(".", "").replace(",","");;

        System.out.println(pagePrice);
        System.out.println(prodPrice);

        if ( Double.parseDouble(pagePrice)  ==  Double.parseDouble(prodPrice) ){

            System.out.println("Sepetteki Fiyatlar Tutuyor");

        }

        else {
            System.out.println("Sepetteki Fiyatlar Tutmuyor");
        }

        driver.findElement(By.className("spinnerUp")).click();

        String prodCount = driver.findElement(By.className("quantity")).getAttribute("value");

        System.out.println("Sepetinizde : "+prodCount+" Ürün Var");


        driver.findElement(By.className("removeProd")).click();

        driver.navigate().to("https://www.n11.com/sepetim");
        driver.navigate().to("https://www.n11.com/sepetim");

        String prodDeleteControl = driver.findElement(By.className("title")).getText();
        //System.out.println(prodDeleteControl);
if (prodDeleteControl.contains("Sepetiniz Boş")){

    System.out.println("Sepetiniz Boş");
}



        //close Fire fox
        //driver.close();

    }

}
