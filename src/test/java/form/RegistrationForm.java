package form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {
  @BeforeAll
  static void beforeAll() {
    Configuration.startMaximized = true;
  }

  @Test
  void fillFormTest() {
    String name = "Alex";
    String lastName = "Moreno";
    String email = "test@email.com";
    String gender = "Male";
    String phoneNumber = "7999123456";
    String birthdayMonth = "June";
    String birthdayYear = "1990";
    String firstSubject = "Maths";
    String secondSubject = "Chemistry";
    String hobie = "Sports";
    String imagePath = "images/selenide-logo.png";
    String imageName = "selenide-logo.png";
    String address = "Тестовый адрес";
    String city = "NCR";
    String state = "Delhi";


    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue(name);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(email);

    $("#genterWrapper").$(byText(gender)).click();

    $("#userNumber").setValue(phoneNumber);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(birthdayMonth);
    $(".react-datepicker__year-select").selectOption(birthdayYear);
    $(".react-datepicker__day--021:not(.react-datepicker__day--outside-month)").click();

    $("#subjectsInput").setValue(firstSubject).pressEnter();
    $("#subjectsInput").setValue(secondSubject).pressEnter();

    $("#hobbiesWrapper").$(byText(hobie)).click();

    $("#uploadPicture").uploadFromClasspath(imagePath);

    $("#currentAddress").setValue(address);

    $("#state").click();
    $("#stateCity-wrapper").$(byText(city)).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText(state)).click();

    $("#submit").click();

    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    $(".modal-dialog .table").shouldHave(text(name), text(lastName), text(email), text(gender), text(phoneNumber),
        text(birthdayMonth), text(birthdayYear), text(firstSubject), text(secondSubject), text(hobie), text(imageName), text(address),
        text(city), text(state));

    $("#closeLargeModal").click();
  }
}
