package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Mira");
        $("#lastName").setValue("Suleimenova");
        $("#userEmail").setValue("test@mail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("77072999999");
        $("#dateOfBirth-wrapper").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/file.jpeg"));
        $("#currentAddress").setValue("Astana, test address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text("Mira Suleimenova"));
        $(".table-responsive table").$(byText("Student Email"))
                .parent().shouldHave(text("test@mail.com"));
        $(".table-responsive table").$(byText("Gender"))
                .parent().shouldHave(text("Female"));
        $(".table-responsive table").$(byText("Mobile"))
                .parent().shouldHave(text("7707299999"));
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text("14 June,1998"));
        $(".table-responsive table").$(byText("Subjects"))
                .parent().shouldHave(text("History"));
        $(".table-responsive table").$(byText("Hobbies"))
                .parent().shouldHave(text("Reading"));
        $(".table-responsive table").$(byText("Picture"))
                .parent().shouldHave(text("file.jpeg"));
        $(".table-responsive table").$(byText("Address"))
                .parent().shouldHave(text("Astana, test address"));
        $(".table-responsive table").$(byText("State and City"))
                .parent().shouldHave(text("NCR Noida"));

    }
}




