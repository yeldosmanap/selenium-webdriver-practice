package assignment5.tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static assignment5.utils.extent_reports.ExtentManagerTest.startTest;

public class LoginTests extends BaseTest {

    // Annotating the methods by @Test annotation and giving their description
    @Test(description = "Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method) {
        // starting test and its reporting by giving the name and description of the test as well
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        // go to main page, then go to login page and try to log in with wrong data and verify errors
        homePage
                .goToMainPage()
                .goToLoginPage()
                .loginToN11("manapov38@gmail.com", "11122233444")
                .verifyLogError();
    }


    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");

        homePage
                .goToMainPage()
                .goToLoginPage()
                .loginToN11("", "")
                .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
                .verifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }
}






