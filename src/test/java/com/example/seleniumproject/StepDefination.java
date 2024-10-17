package com.example.seleniumproject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefination {

    WebDriver driver;
    WebDriverWait wait;
    ChromeOptions options = new ChromeOptions();
    @Before
    public void setUp() {
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Given("User visits iths.se")
    public void user_visits_iths_se() {
        driver.get("https://iths.se");
        WebElement cookieBtn = driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        cookieBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement popUpClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"popmake-5683\"]/button")));
        popUpClose.click();
    }

//  Scenario:  iths.se should show correct title
    @Then("The title should be {string}")
    public void the_title_should_be(String string) {
        String websiteTitle = driver.getTitle();
        String expectedTitle = "IT-Högskolan – Här startar din IT-karriär!";
        Assertions.assertEquals(expectedTitle, websiteTitle, "Titeln stämmer inte med förväntat");
    }

    //Scenario: menu element shoud be visible in website size compatible
    @When("user opens website in small size")
    public void user_opens_website_in_small_size() {
        Dimension newSize = new Dimension(400, 498);
        driver.manage().window().setSize(newSize);
    }
    @Then("Menu should be visible")
    public void menu_should_be_visible() {
        WebElement menuElement = driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
        Boolean isVisible = menuElement.isDisplayed();
        Assertions.assertTrue(isVisible);

    }

    //  Scenario: Menu should be clickable and first element should be "UTBILDNINGAR"
    @When("user clicks on Menu")
    public void userClicksOnMenu() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try{
            Thread.sleep(5000);
            WebElement menuElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-bars']")));

            menuElement.click();
        }catch (Exception e) {
            System.out.println("Failed to click menu button or assert menu item: " + e.getMessage());
        }

    }
    @Then("first element in menu list should be {string}")
    public void firstElementInMenuListShouldBe(String expectedText) {
        String actualText;
        WebElement firstMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='nav-utbildningar']")));
        actualText = firstMenuItem.getText().trim();
        Assertions.assertEquals(expectedText,actualText );
    }
    //Scenario: utbildningar page should open
    @When("user clicks on Alla Utbildningar button")
    public void userClicksOnAllaUtbildningarButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try{
            Thread.sleep(2000);
            WebElement utbildningarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Alla utbildningar'])[1]")));
            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", utbildningarBtn);

            Actions actions = new Actions(driver);
            actions.moveToElement(utbildningarBtn).perform();
            utbildningarBtn.click();
        }catch (Exception e) {
            System.out.println("Failed to click menu button or assert menu item: " + e.getMessage());
        }
    }

    @Then("the page header should be {string}")
    public void thePageHeaderShouldBe(String expectedText) {
        String actualText;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Utbildningar']")));
        actualText = pageHeader.getText().trim();
        Assertions.assertEquals(expectedText,actualText );
    }

    //Scenario: IT-utbildningar Göteborg page should open
    @When("user clicks on Göteborg button")
    public void userClicksOnGöteborgButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try{
            WebElement utbildningarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='hero'] a:nth-child(2)")));// .xpath("//a[normalize-space()='Alla utbildningar']")));

            Actions actions = new Actions(driver);
            actions.moveToElement(utbildningarBtn).perform();
            utbildningarBtn.click();
        }catch (Exception e) {
            System.out.println("Failed to click menu button or assert menu item: " + e.getMessage());
       }

    }
    @Then("new page header should be {string}")
    public void newPageHeaderShouldBe(String expectedText) {
        String actualText;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='IT-utbildningar Göteborg']")));
        actualText = pageHeader.getText().trim();
        Assertions.assertEquals(expectedText,actualText );
    }

    //Scenario: IT-utbildningar Stockholm page should open
    @When("user clicks on Alla Stockholm button")
    public void userClicksOnAllaStockholmButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try{
            WebElement utbildningarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='hero'] a:last-child")));// .xpath("//a[normalize-space()='Alla utbildningar']")));

            Actions actions = new Actions(driver);
            actions.moveToElement(utbildningarBtn).perform();
            utbildningarBtn.click();
        }catch (Exception e) {
            System.out.println("Failed to click menu button or assert menu item: " + e.getMessage());
        }
    }

    @Then("page header should be {string}")
    public void pageHeaderShouldBe(String expectedText) {
        String actualText;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='IT-utbildningar Stockholm']")));
        actualText = pageHeader.getText().trim();
        Assertions.assertEquals(expectedText,actualText );
    }
    //Scenario: Utbildningar page should open
    @When("user clicks on Sen ansökan")
    public void userClicksOnSenAnsökan() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement senAnsokanElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("banner__content")));// .xpath("//a[normalize-space()='Alla utbildningar']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(senAnsokanElement).perform();
        senAnsokanElement.click();
    }

    @Then("new page should open and page hearder should be {string}")
    public void newPageShouldOpenAndPageHearderShouldBe(String expectedText) {
        String actualText;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Utbildningar']")));
        actualText = pageHeader.getText().trim();
        Assertions.assertEquals(expectedText,actualText );
    }

    //Scenario : student name should change
    @When("user clicks on right arrow")
    public void user_clicks_on_right_arrow() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(By.className("slick-next")));
        Actions actions = new Actions(driver);
        actions.moveToElement(rightArrow).perform();
        rightArrow.click();
    }
    @Then("student name should change to {string}")
    public void student_name_should_change_to(String expected_name) {
        String actual_name;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement studentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='quote-block-small slick-slide slick-active'] p[class='quote-block-small__person-name']")));
        actual_name = studentName.getText().trim();
        Assertions.assertEquals(expected_name,actual_name );
    }

    //Scenario: When clicked on Göteborg in Utbildningar page Göteborg should be selected
    @When("user clicks on Göteborg")
    public void user_clicks_on_göteborg() {
        driver.navigate().to("https://www.iths.se/utbildningar");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement goteborgBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-place='goteborg']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(goteborgBtn).perform();
        goteborgBtn.click();
    }
    @Then("Göteborg should be selected")
    public void göteborg_should_be_selected() {
        Boolean goteborgIsSelected,allUtbIsDeselected;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement goteborgBtn = driver.findElement(By.xpath("//a[@data-place='goteborg']"));
        WebElement allUtbBtn = driver.findElement(By.xpath("//a[normalize-space()='Alla utbildningar']"));

        goteborgIsSelected = goteborgBtn.getAttribute("class").contains("btn current-term btn--filter");
        allUtbIsDeselected = allUtbBtn.getAttribute("class").contains("btn");

        Assertions.assertTrue(goteborgIsSelected);
        Assertions.assertTrue(allUtbIsDeselected);
    }

    //Scenario: drop-down should open
    @When("user clicks on Utbildningsform button")
    public void user_clicks_on_utbildningsform_button() {
        driver.navigate().to("https://www.iths.se/utbildningar");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement utbFormBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='sitesDropdown']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(utbFormBtn).perform();
        utbFormBtn.click();
    }
    @Then("drop-down should open")
    public void drop_down_should_open() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sites dropdown open']")));

        Assertions.assertTrue(dropdownElement.isDisplayed());
    }

    @After
    public void driver_quit() {
        if(driver != null){
            driver.quit();
        }
    }

}
