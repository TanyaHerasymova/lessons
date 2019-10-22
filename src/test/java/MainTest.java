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
import java.util.Arrays;
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
            List<String> listCourses = new ArrayList<String>();
            listCourses.add("Тестирование");
            listCourses.add("Frontend development");
            listCourses.add("development");
            listCourses.add("Веб-дизайн");
            listCourses.add("PHP");
            listCourses.add("Программирование под IOS");
            listCourses.add("Программирование под Android");
            listCourses.add("Java programming");
            listCourses.add("Python");
            listCourses.add("Data Science/Machine Learning");
            listCourses.add("C# /.NET development");
            listCourses.add("C++");
            listCourses.add("Game Development");
            listCourses.add("DEVOPS");
            listCourses.add("Digital Marketing");
            listCourses.add("Управление персоналом");
            listCourses.add("Управление проектами");
            listCourses.add("Менеджмент");
            listCourses.add("Кибербезопасность");
            listCourses.add("Mobile development");
            listCourses.add("Видеомонтаж");
            listCourses.add("Cisco");
            listCourses.add("Go development");
            /*for(int i = 0; i < listCourses.size(); i++) {
                System.out.println(listCourses.get(i));
            }*/
            boolean isPresent = true;
             List<WebElement> itemCourses = driver.findElements(By.xpath("(//div[@class='container_12 isotope 23'])[1]/div/h2"));
             for(WebElement el: itemCourses) {
                 String text = el.getText();
                 if(!listCourses.contains(text)) {
                     isPresent = false;
                 }
             }
             assertTrue(isPresent);
    }
        @Test
                public static void coursesTest() {
            homePage.isShown();
            String arr[] = {"a", "b"};
            List<String> list = new ArrayList<String>(Arrays.asList(arr));


            List<String> expected = new ArrayList<String>();
            expected.add("RU");
            expected.add("UA");
            expected.add("EN");

            boolean isPresent = true;
            List<WebElement> elements = driver.findElements(By.xpath("(//ul[@class='lang'])[1]/li/a"));
            for(WebElement el: elements) {
                String text = el.getText();
                if(!expected.contains(text)) {
                    isPresent = false;
                }
            }
            assertTrue(isPresent);
        }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
    public Object[] [] provider() {
        return new Object[][] {
                {"ru-RU"},
                {},
                {}
        };
    }

}
