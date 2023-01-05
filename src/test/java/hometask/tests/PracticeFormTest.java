package hometask.tests;

import com.github.javafaker.Faker;
import hometask.base.Base;
import hometask.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends Base {

    @Test
    void submitPracticeFormTest() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                phoneNumber = faker.phoneNumber().phoneNumber().replaceAll("\\D", "").substring(0, 10),
                address = faker.address().fullAddress(),
                fileName = "cat_notebook.jpeg",
                day = "5",
                month = "March",
                year = "1980";

        PracticeFormPage formPage = new PracticeFormPage("/automation-practice-form");
        formPage.disableScripts();

        formPage.checkMainHeader();
        // fields
        formPage.fillFirstNameField(firstName);
        formPage.fillLastNameField(lastName);
        formPage.fillEmailField(email);
        formPage.fillMobileNumberField(phoneNumber);
        formPage.fillCurrAddressField(address.replaceAll(", ", ",\n"));

        // radio-buttons
        formPage.selectOtherGender();
        formPage.selectFemaleGender();
        formPage.selectMaleGender();

        // check-boxes
        formPage.uncheckedChkboxSports();
        formPage.uncheckedChkboxReading();
        formPage.uncheckedChkboxMusic();
        formPage.clickChkboxMusic();
        formPage.clickChkboxReading();
        formPage.clickChkboxSports();
        formPage.checkedChkboxReading();
        formPage.checkedChkboxMusic();
        formPage.checkedChkboxSports();

        // subject
        formPage.fillSubjectField("Math");
        formPage.fillSubjectField("Arts");
        formPage.removeFirstSubjectInList();

        // calendar
        formPage.fillDate(day, month, year);

        // file-upload
        formPage.selectFileToUpload(fileName);

        // select state and city
        formPage.selectFirstState();
        formPage.selectFirstCity();

        // press submit button
        formPage.pressSubmitButton();
//        formPage.switchToModal();

        formPage.checkModal();
        formPage.checkFullName(firstName, lastName);
        formPage.checkEmail(email);
        formPage.checkGenderMale();
        formPage.checkMobile(phoneNumber);
        formPage.checkDateOfBirth(day, month, year);
        formPage.checkSubjects("Arts");
        formPage.checkHobbiesSports();
        formPage.checkPicture(fileName);
        formPage.checkAddress(address);
        formPage.checkStateAndCity();
        formPage.closeModal();
    }
}
