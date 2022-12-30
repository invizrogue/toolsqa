package hometask.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    // header
    private final SelenideElement mainHeader = $(".main-header");

    // field
    private final SelenideElement fieldFirstName = $("[placeholder='First Name']");
    private final SelenideElement fieldLastName = $("[placeholder='Last Name']");
    private final SelenideElement fieldEmail = $("#userEmail");
    private final SelenideElement fieldMobileNumber = $("[placeholder='Mobile Number']");
    private final SelenideElement fieldCurrAddress = $("#currentAddress");

    // radio
    private final SelenideElement radioMale = $("#gender-radio-1");
    private final SelenideElement radioFemale = $("#gender-radio-2");
    private final SelenideElement radioOther = $("#gender-radio-3");

    // checkbox
    private final SelenideElement chkboxSports = $("#hobbies-checkbox-1");
    private final SelenideElement chkboxReading = $("#hobbies-checkbox-2");
    private final SelenideElement chkboxMusic = $("#hobbies-checkbox-3");

    // calendar

    // dropdown-menu

    // ???
    private final SelenideElement fieldSubjects = $("");

    // button
    private final SelenideElement buttonSubmit = $("#submit");

    public PracticeFormPage(String url) {
        open(url);
    }

    public void checkMainHeader() {
        mainHeader.shouldHave(text("Practice Form"));
    }

    public void fillFirstNameField(String name) {
        fieldFirstName.setValue(name);
    }

    public void fillLastNameField(String lastName) {
        fieldLastName.setValue(lastName);
    }

    public void fillEmailField(String email) {
        fieldEmail.setValue(email);
    }

    public void fillMobileNumberField(String phone) {
        fieldMobileNumber.setValue(phone);
    }

    public void fillCurrAddressField(String address) {
        fieldCurrAddress.scrollTo().setValue(address);
    }

    public void selectMaleGender() {
        radioMale.click();
        radioMale.shouldBe(checked);
    }

    public void pressSubmitButton() {
        buttonSubmit.scrollTo().click();
    }
}
