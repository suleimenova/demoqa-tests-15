package com.demoqa.tests;



import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithFakerTest extends TestData {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picturePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name",firstName + " " + lastName )
                .checkResult("Student Email",email)
                .checkResult("Gender", gender)
                .checkResult("Mobile",number)
                .checkResult("Date of Birth", birthDay)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }
}
