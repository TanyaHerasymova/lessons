package test.java;

import main.java.CoursesPage;
import main.java.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MainTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static CoursesPage coursesPage;

    @BeforeMethod
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver",
                 "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);
    }

    @Test
    public static void mainTest() throws InterruptedException {
        homePage.isShown()
                .selectLanguage("ru-RU")
                .clickLogo();
    }
        @Test
         public static void homeTaskOandC() {
            homePage.isShown()
                    .mainMenu()
                    .subMenu();
            List<String> list = new ArrayList<String>();
            list.add("Тестирование");
            list.add("Frontend development");
            list.add("development");
            list.add("Веб-дизайн");
            list.add("PHP");
            list.add("Программирование под IOS");
            list.add("Программирование под Android");
            list.add("Java programming");
            list.add("Python");
            list.add("Data Science/Machine Learning");
            list.add("C# /.NET development");
            list.add("C++");
            list.add("Game Development");
            list.add("DEVOPS");
            list.add("Digital Marketing");
            list.add("Управление персоналом");
            list.add("Управление проектами");
            list.add("Менеджмент");
            list.add("Кибербезопасность");
            list.add("Mobile development");
            list.add("Видеомонтаж");
            list.add("Cisco");
            list.add("Go development");

            boolean isPresent = true;
             List<WebElement> itemCourses = driver.findElements(By.xpath("(//div[@class='container_12 isotope 23'])[1]/div/h2"));
             for(WebElement el: itemCourses) {
                 String text = el.getText();
                 if(!list.contains(text)) {
                     isPresent = false;
                 }
             }
             assertTrue(isPresent);
    }
        @Test
                public static void coursesTest() {
        homePage.isShown();
        coursesPage.clickPay();
        assertTrue(coursesPage.checkIfLocationIsSelected("ВДНХ"));
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();

    }

}
