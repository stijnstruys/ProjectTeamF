package be.kdg.teamf.controller;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 1-3-13
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {
   /* private ChromeDriver driver;

    @Test
    public void register() {
        driver = makeChromeDriver();
        WebElement registerLink = driver.findElementById("registerLink");
        registerLink.click();

        WebElement userName = driver.findElementById("userName");
        WebElement password = driver.findElementById("password");
        WebElement email = driver.findElementById("email");
        WebElement firstName = driver.findElementById("firstName");
        WebElement lastName = driver.findElementById("lastName");
        WebElement dateOfBirth = driver.findElementById("dateOfBirth");
        WebElement telephone = driver.findElementById("telephone");
        WebElement street = driver.findElementById("street");
        WebElement number = driver.findElementById("number");
        WebElement zipcode = driver.findElementById("zipcode");
        WebElement city = driver.findElementById("city");
        WebElement submitButton = driver.findElementById("register_submit");

        userName.sendKeys("test");
        password.sendKeys("test");
        email.sendKeys("stijn.struys@student.kdg.be");
        firstName.sendKeys("test");
        lastName.sendKeys("test");
        telephone.sendKeys("034598685");
        street.sendKeys("Test");
        number.sendKeys("12");
        zipcode.sendKeys("2275");
        city.sendKeys("Wechelderzande");
        dateOfBirth.click();
        List<WebElement> date = driver.findElementsByTagName("a");
        date.get(12).click();
        submitButton.click();

        driver.close();
    }


    @Test
    public void logInTest() {
        driver = makeChromeDriver();
        logIn();

        driver.close();
    }

    @Test
    public void failedLogInTest() {
        driver = makeChromeDriver();
        headerDropDownClick();
        WebElement userNameText = driver.findElementByName("j_username");
        userNameText.sendKeys("testfailed");
        WebElement passwordText = driver.findElementByName("j_password");
        passwordText.sendKeys("test");
        WebElement logInButton = driver.findElementByName("submit");
        logInButton.click();

        driver.close();
    }

    @Test
    public void logInAndOutTest(){
        driver = makeChromeDriver();
        logIn();
        logOut();

        driver.close();
    }

 /*   @Test
    public void updateUserProfileTest() {
        driver = makeChromeDriver();
        logIn();
        WebElement profileLink = driver.findElementById("profileLink");
        headerDropDownClick();
        profileLink.click();

        WebElement user_modify_profile = driver.findElementById("user_modify_profile");
        user_modify_profile.click();
        WebElement firstName = driver.findElementById("firstName");
        WebElement lastName = driver.findElementById("lastName");
        WebElement update = driver.findElementById("updateButton");

        firstName.sendKeys("Stijn");
        lastName.sendKeys("Struys");
        update.click();
        logOut();

        driver.close();
    }*/
         /*
    @Test
    public void updateUserPasswordTest(){
        driver = makeChromeDriver();
        logIn();
        WebElement profileLink = driver.findElementById("profileLink");
        headerDropDownClick();
        profileLink.click();

        WebElement user_change_password = driver.findElementById("user_change_password");
        user_change_password.click();

        WebElement currentpw = driver.findElementById("currentpw");
        WebElement newpw = driver.findElementById("newpw");
        WebElement confirmpw = driver.findElementById("confirmpw");
        WebElement changepw = driver.findElementById("changepw");

        currentpw.sendKeys("test");
        newpw.sendKeys("test");
        confirmpw.sendKeys("test");
        changepw.click();

        logOut();

        driver.close();

    }

    public void logIn() {
        headerDropDownClick();
        WebElement userNameText = driver.findElementByName("j_username");
        userNameText.sendKeys("test");
        WebElement passwordText = driver.findElementByName("j_password");
        passwordText.sendKeys("test");
        WebElement logInButton = driver.findElementByName("submit");
        logInButton.click();
    }

    private void headerDropDownClick() {
        WebElement dropDown = driver.findElementByClassName("dropdown-toggle");
        dropDown.click();
    }

    public void logOut(){
        headerDropDownClick();
        WebElement logoutLink = driver.findElementById("logoutLink");
        logoutLink.click();
    }


    private ChromeDriver makeChromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://localhost:8080/ProjectTeamF-1.0/general/index.html");
        return driver;
    } */
}
