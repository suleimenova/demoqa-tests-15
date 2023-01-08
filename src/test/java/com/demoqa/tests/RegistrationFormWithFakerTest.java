package com.demoqa.tests;



import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithFakerTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.number)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.picturePath)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName )
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.birthDay)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);

    }
}
