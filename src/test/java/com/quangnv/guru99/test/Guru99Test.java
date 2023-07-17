/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.quangnv.guru99.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author _viet.quangg
 */
public class Guru99Test {

    private static WebDriver myBrowser; //khai bao bien tro vao trinh duyet 

    @BeforeAll //Ham nay tien phong, chay truoc 1 lan duy nhat
    //khi file Test dc run!!
    //chay truoc thien ha, truoc tat ca @Test khac
    //de chuan bi data, moi truong, hay gi do
    //de cac @Test san sang su dung!!!
    //chuan bi mang data cua ddt chang han
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/_viet.quangg/Study/Subject Term 5/SWT301/chromedriver_mac_arm64/chromedriver");

        myBrowser = new ChromeDriver();
    }

    @AfterAll//ham nay chay cuoi cung, boc hau, sau khi tat ca @Test da chay xong thi thang nay duoc goi nhat cuoi
    //De don dep
    //Thuong don data rac torng ram, DB ma da lo chen vao
    //khi chay @Test
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(30000);
        myBrowser.quit();
    }
    //PHAN BIET 2 KHAI NIEM THU VIEN VA FRAMEWORK
    //CA 2 DEU LA NHUNG FILE. JAR, .DLL CHUA BEN TRONG 1 DONG CLASS VA CAC METHOD DE GIUP CHO MINH LAM DUOC GI DO
    //CHUNG DEU PHAI KHAI BAO LA DEPENDENCY DE ADD VAO TRONG PROJECT
    //THU VIEN DUOC VIET TU DO, GOI HAM CLASS O CHO NAO THICH HOP THI DUA VOAO
    //VD: JBDC DUOC DUA VAO TRONG DBUTIL, JSP, SERVLET, CLASS DAO THOAI MAI

    //NHUNG FW THI KHONG DUOC TU DO NHU VAY PHAI VIET CODE THEO NHUNG QUY UOC
    //QUY TAC CHO TRUOC
    //VD: JUNIT THI PHAI: TEN CLASS PHAI CO CHU TEST
    //  HAM TEST PHAI CO @TEST
    // HAM KHOI DONG PHAI CO @BEFORE..
    //SPRINGBOOT CUBG VAY, PHAI SU DUNG NHUNG @ DUNG CHO QUY UOC TRUOC
    //PHAI CO HAM MAIN() DE BAT DAU RUN APP
    //ENTITY FRAMEWORK CUA C# CUNG VAY, KET NOI CSDL, QUAN LI CSDL PHAI CO DBCONTEXT CLASS...
    //GENERATE DB, ENTITY CLASS PHAI THEO CU PHAP, CAU LENH
    @Test
    //thằng này dùng hàm so sánh expected vs. actual
    //để ra xanh đỏ
    //có quyền có nhiều hàm cùng có @Test
    //mỗi hàm có @test là ứng với 1 Test case
    public void testGuru99LoginGivenValidAccountShowsDashboard() throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/v4/");
        WebElement txtUsername;
        txtUsername = myBrowser.findElement(By.name("uid"));
        txtUsername.sendKeys("mngr510580");
        WebElement txtPassword;
        txtPassword = myBrowser.findElement(By.name("password"));
        txtPassword.sendKeys("eregapY");
        WebElement btnLogin;
        btnLogin = myBrowser.findElement(By.name("btnLogin"));
        btnLogin.click();

        //SE PHAI CHUYEN TRANG NEU LOGIN THANH CONG
        //NEU MANG LAG, THI TRANG CHUA KIP VE MAY MINH
        //NHUNG CAU LENH DI TIM TAG WELCOME  DA CHAY LUON ROI
        //DO CODE MINH DANG CHAY VA TRANG WEB NGOAI KIA LA 2 TIEN TRINH BAT DONG BO ASYNC
        Thread.sleep(3000); //ngu 3 giay cho app login xong
        //thi moi co welcome msg tra ve
        //trinh duyet dang bi tro boi myBrowser
        WebElement lblWelcome = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        System.out.println("Loi chao la: " + lblWelcome.getText());
        System.out.println("Loi chao la: " + lblWelcome);
        assertEquals("Manger Id : mngr510580", lblWelcome.getText());

    }
    public static Object[][] initData(){
        return new Object[][]{
                {"mngr510580","eregapY"},
                {"mngr510574","utuzuzU"},
        };
    }

    @ParameterizedTest
    @MethodSource(value="initData")
    public void testGuru99LoginDDT(String username, String password) throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/v4/");
        WebElement txtUsername;
        txtUsername = myBrowser.findElement(By.name("uid"));
        txtUsername.sendKeys(username);
        WebElement txtPassword;
        txtPassword = myBrowser.findElement(By.name("password"));
        txtPassword.sendKeys(password);
        WebElement btnLogin;
        btnLogin = myBrowser.findElement(By.name("btnLogin"));
        btnLogin.click();

        //SE PHAI CHUYEN TRANG NEU LOGIN THANH CONG
        //NEU MANG LAG, THI TRANG CHUA KIP VE MAY MINH
        //NHUNG CAU LENH DI TIM TAG WELCOME  DA CHAY LUON ROI
        //DO CODE MINH DANG CHAY VA TRANG WEB NGOAI KIA LA 2 TIEN TRINH BAT DONG BO ASYNC
        Thread.sleep(3000); //ngu 3 giay cho app login xong
        //thi moi co welcome msg tra ve
        //trinh duyet dang bi tro boi myBrowser
        WebElement lblWelcome = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        System.out.println("Loi chao la: " + lblWelcome.getText());
        System.out.println("Loi chao la: " + lblWelcome);
        assertEquals("Manger Id : " + username, lblWelcome.getText());
    }

    public static void main(String[] args) {
        setUpClass();
    }
}
