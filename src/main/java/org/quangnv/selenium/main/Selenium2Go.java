/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.quangnv.selenium.main;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author _viet.quangg
 */
public class Selenium2Go {

    public static void main(String[] args) {
        playWithGooleSearch();
    }
    
    //Test Case #1: Check Search Google runs well or not with a keyword
    //Steps:
    //  1. Open a certain browser, eg Chrome
    //  2. Type the following url: https://google.com
    //  3. Hit enter to open Google search page
    //  4. Type the keyword: "Trang Nemo"
    //  5. Hit enter to activate the search process
    //Expected Result:
    //  All web pages with "Trang Nemo" keyword included are shown
    
    //3 diem thi PE
    //test case cho code, app tương đươg nhau
    //đều gồm data đưa vào (5!, 7!, "Trang Nemo"), giá trị kì vọngß
    //và các bước gọi hàm, gọi màn hình, chức năng !!!
    // getF(5) open search Page
    public static void playWithGooleSearch(){
        WebDriver myBrowser; //biến object trỏ vào trình duyệt sẽ được new
        System.setProperty("webdriver.chrome.driver", "/Users/_viet.quangg/Study/Subject Term 5/SWT301/chromedriver_mac_arm64/chromedriver");
        // y chang như class.forName() bên jdbc
        //tải cái file .exe hồi nãy xã nén vào ram để điều khiển trình duyệt

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=en-US");
        opt.addArguments("--remote-allow-origins=*");

        //trình duyệt xuất hiện dùm, new Object
        myBrowser = new ChromeDriver(opt);
        myBrowser.get("https://youtube.com");
        myBrowser.manage().window().maximize();
        //bung trình duyệt rộng ra

        WebElement searchBox = myBrowser.findElement(By.name("search_query"));
        searchBox.sendKeys("phan ung cua tao");
        searchBox.submit();

        // Create a Duration object using the integer value (in seconds)
        Duration duration = Duration.ofSeconds(10);

        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(myBrowser, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("video-title")));

        // Click on the first video result
        WebElement videoResult = myBrowser.findElement(By.id("video-title"));
        videoResult.click();
    }
}
