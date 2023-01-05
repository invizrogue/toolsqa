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
                phoneNumber = faker.phoneNumber().phoneNumber().replaceAll("\\D", ""),
                address = faker.address().fullAddress(),
                fileName = "cat_notebook.jpeg",
                day = "15",
                month = "March",
                year = "1980";

        PracticeFormPage formPage = new PracticeFormPage("/automation-practice-form");

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
        formPage.fillSubjectField("ma");
        formPage.fillSubjectField("ar");
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
    }
}
