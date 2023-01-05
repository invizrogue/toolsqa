package hometask.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    // headers
    private final SelenideElement mainHeader = $(".main-header");
    private final SelenideElement modalHeader = $(".modal-header");

    // fields
    private final SelenideElement fieldFirstName = $("[placeholder='First Name']");
    private final SelenideElement fieldLastName = $("[placeholder='Last Name']");
    private final SelenideElement fieldEmail = $("#userEmail");
    private final SelenideElement fieldMobileNumber = $("[placeholder='Mobile Number']");
    private final SelenideElement fieldCurrAddress = $("#currentAddress");

    // radio
    private final SelenideElement radioMale = $("#gender-radio-1");
    private final SelenideElement radioFemale = $("#gender-radio-2");
    private final SelenideElement radioOther = $("#gender-radio-3");
    private final SelenideElement clickplaceRadioMale = $("label[for='gender-radio-1'");
    private final SelenideElement clickplaceRadioFemale = $("label[for='gender-radio-2'");
    private final SelenideElement clickplaceRadioOther = $("label[for='gender-radio-3'");

    // checkbox
    private final SelenideElement chkboxSports = $("#hobbies-checkbox-1");
    private final SelenideElement chkboxReading = $("#hobbies-checkbox-2");
    private final SelenideElement chkboxMusic = $("#hobbies-checkbox-3");
    private final SelenideElement clickplaceChkboxSports = $("label[for='hobbies-checkbox-1']");
    private final SelenideElement clickplaceChkboxReading = $("label[for='hobbies-checkbox-2']");
    private final SelenideElement clickplaceChkboxMusic = $("label[for='hobbies-checkbox-3']");

    // calendar
    private final SelenideElement fieldCalendar = $("#dateOfBirthInput");
    private final SelenideElement dropdownYear = $(".react-datepicker__year-select");
    private final ElementsCollection listYears = $$(".react-datepicker__year-select>option");
    private final SelenideElement dropdownMonth = $(".react-datepicker__month-select");
    private final ElementsCollection listMonths = $$(".react-datepicker__month-select>option");
    private final ElementsCollection listDaysCurrentMonth =
            $$("div.react-datepicker__week div:not(.react-datepicker__day--outside-month)");

    // file-upload
    private final SelenideElement buttonUploadPicture = $("#uploadPicture");

    // dropdown-menu
    private final SelenideElement dropdownState = $("#state");
    private final SelenideElement dropdownCity = $("#city");
    private final ElementsCollection listStates =
            $$x("//div[@id='state']//div[contains(@id, 'react-select-3-option')]");
    private final ElementsCollection listCities =
            $$x("//div[@id='city']//div[contains(@id, 'react-select-4-option')]");

    // subject
    private final SelenideElement fieldSubjects = $("#subjectsInput");
    private final ElementsCollection listSubjectOptions =
            $$(".subjects-auto-complete__menu-list .subjects-auto-complete__option");
    private final ElementsCollection listRemoveSubjectOptions =
            $$(".subjects-auto-complete__multi-value__remove");

    // buttons
    private final SelenideElement buttonSubmit = $("#submit");
    private final SelenideElement buttonCloseModal = $("#closeLargeModal");

    public PracticeFormPage(String url) {
        open(url);
    }

    public void disableScripts() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void selectFirstState() {
        dropdownState.click();
        listStates.first().click();
    }

    public void selectFirstCity() {
        dropdownCity.shouldBe(enabled);
        dropdownCity.click();
        listCities.first().click();
    }

    public void selectFileToUpload(String file) {
        buttonUploadPicture.uploadFromClasspath(file);
    }

    public void fillSubjectField(String subject) {
        fieldSubjects.setValue(subject);
        listSubjectOptions.first().click();
    }

    private void fillYear(String year) {
        dropdownYear.click();
        listYears.findBy(text(year)).click();
    }

    private void fillMonth(String month) {
        dropdownMonth.click();
        listMonths.findBy(text(month)).click();
    }

    private void fillDay(String day) {
        listDaysCurrentMonth.findBy(text(day)).click();
    }

    public void fillDate(String day, String month, String year) {
        fieldCalendar.click();
        fillYear(year);
        fillMonth(month);
        fillDay(day);
    }

    public void removeFirstSubjectInList() {
        listRemoveSubjectOptions.first().click();
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
        fieldCurrAddress.setValue(address);
    }

    public void selectMaleGender() {
        clickplaceRadioMale.click();
        radioMale.shouldBe(checked);
        radioFemale.shouldNotBe(checked);
        radioOther.shouldNotBe(checked);
    }

    public void selectFemaleGender() {
        clickplaceRadioFemale.click();
        radioMale.shouldNotBe(checked);
        radioFemale.shouldBe(checked);
        radioOther.shouldNotBe(checked);
    }

    public void selectOtherGender() {
        clickplaceRadioOther.click();
        radioMale.shouldNotBe(checked);
        radioFemale.shouldNotBe(checked);
        radioOther.shouldBe(checked);
    }

    public void clickChkboxSports() {
        clickplaceChkboxSports.click();
    }

    public void checkedChkboxSports() {
        chkboxSports.shouldBe(checked);
    }

    public void uncheckedChkboxSports() {
        chkboxSports.shouldNotBe(checked);
    }

    public void clickChkboxReading() {
        clickplaceChkboxReading.click();
    }

    public void checkedChkboxReading() {
        chkboxReading.shouldBe(checked);
    }

    public void uncheckedChkboxReading() {
        chkboxReading.shouldNotBe(checked);
    }

    public void clickChkboxMusic() {
        clickplaceChkboxMusic.click();
    }

    public void checkedChkboxMusic() {
        chkboxMusic.shouldBe(checked);
    }
    public void uncheckedChkboxMusic() {
        chkboxMusic.shouldNotBe(checked);
    }

    public void pressSubmitButton() {
        buttonSubmit.scrollTo().click();
    }

    public void checkModal() {
        modalHeader.should(visible);
    }
    public void checkFullName(String firstName, String lastName) {
        $(withTagAndText("td", "Student Name"))
                .sibling(0).shouldHave(text(firstName + " " + lastName));
    }

    public void checkEmail(String email) {
        $(withTagAndText("td", "Student Email"))
                .sibling(0).shouldHave(text(email));
    }

    public void checkGenderMale() {
        $(withTagAndText("td", "Gender"))
                .sibling(0).shouldHave(text("Male"));
    }

    public void checkMobile(String phoneNumber) {
        $(withTagAndText("td", "Mobile"))
                .sibling(0).shouldHave(text(phoneNumber));
    }

    public void checkDateOfBirth(String day, String month, String year) {
        // добавляю ведущий нуль, если число не двузначное
        if (day.length() == 1) {
            day = "0" + day;
        }
        $(withTagAndText("td", "Date of Birth"))
                .sibling(0).shouldHave(text(day + " " + month + "," + year));
    }

    public void checkSubjects(String subj) {
        // проверяю наличие только оставшейся дисциплины (можно и список проверить, но конкретного тз не было
        $(withTagAndText("td", "Subjects"))
                .sibling(0).shouldHave(text(subj));
    }

    public void checkHobbiesSports() {
        $(withTagAndText("td", "Hobbies"))
                .sibling(0).shouldHave(text("Sports"));
    }

    public void checkPicture(String fileName) {
        $(withTagAndText("td", "Picture"))
                .sibling(0).shouldHave(text(fileName));
    }

    public void checkAddress(String address) {
        $(withTagAndText("td", "Address"))
                .sibling(0).shouldHave(text(address));
    }

    public void checkStateAndCity() {
        $(withTagAndText("td", "State and City"))
                .sibling(0).shouldHave(text("NCR Delhi"));
    }

    public void  closeModal() {
        buttonCloseModal.click();
    }
}
