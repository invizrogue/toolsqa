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
        formPage.disableScripts()
                .checkMainHeader()
                .fillFirstNameField(firstName)
                .fillLastNameField(lastName)
                .fillEmailField(email)
                .fillMobileNumberField(phoneNumber)
                .fillCurrAddressField(address.replaceAll(", ", ",\n"))
        // radio
                .selectOtherGender()
                .selectFemaleGender()
                .selectMaleGender()
        // check-box
                .uncheckedChkboxSports()
                .uncheckedChkboxReading()
                .uncheckedChkboxMusic()
                .clickChkboxMusic()
                .clickChkboxReading()
                .clickChkboxSports()
                .checkedChkboxReading()
                .checkedChkboxMusic()
                .checkedChkboxSports()
        // subject
                .fillSubjectField("Math")
                .fillSubjectField("Arts")
                .removeFirstSubjectInList()
        // calendar
                .fillDate(day, month, year)
        // file-upload
                .selectFileToUpload(fileName)
        // select state and city
                .selectFirstState()
                .selectFirstCity()
        // press submit button
                .pressSubmitButton()
        // modal
                .checkFinalModal(
                        firstName, lastName, email, phoneNumber,
                        day, month, year, fileName, address
                );
    }
}
