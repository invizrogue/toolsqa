package hometask.tests;

import hometask.base.Base;
import hometask.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import static hometask.base.utils.RandomUtils.*;

public class PracticeFormTest extends Base {

    @Test
    void submitPracticeFormTest() {

        String firstName = randomFirstName(),
                lastName = randomLastName(),
                email = randomEmail(),
                phoneNumber = randomPhoneNumber(),
                address = randomFullAddress(),
                fileName = "cat_notebook.jpeg",
                day = randomDay(),
                month = randomMonth(),
                year = randomBirthYear();

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
