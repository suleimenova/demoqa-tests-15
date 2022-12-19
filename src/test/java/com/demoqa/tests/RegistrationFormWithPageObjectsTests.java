package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithPageObjectsTests {
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
                .setFirstName("Mira")
                .setLastName("Suleimenova")
                .setEmail("test@mail.com")
                .setGender("Female")
                .setNumber("77072999999")
                .setBirthDate("14", "June", "1998")
                .setSubjects("History")
                .setHobbies("Reading")
                .uploadPicture("src/test/resources/file.jpeg")
                .setAddress("Astana, test address")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name","Mira Suleimenova")
                .checkResult("Student Email","test@mail.com")
                .checkResult("Date of Birth","14 June,1998")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7707299999")
                .checkResult("Date of Birth", "14 June,1998")
                .checkResult("Subjects", "History")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "file.jpeg")
                .checkResult("Address", "Astana, test address")
                .checkResult("State and City","NCR Noida");


    }
}
