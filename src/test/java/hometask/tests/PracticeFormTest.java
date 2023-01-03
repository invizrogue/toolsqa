package hometask.tests;

import hometask.base.Base;
import hometask.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends Base {

    @Test
    void submitPracticeFormTest() {
        PracticeFormPage formPage = new PracticeFormPage("/automation-practice-form");

        formPage.checkMainHeader();
        // fields
        formPage.fillFirstNameField("Dmitry");
        formPage.fillLastNameField("Mikhaylov");
        formPage.fillEmailField("test@test.com");
        formPage.fillMobileNumberField("9998887766");
        formPage.fillCurrAddressField("Vladivostok,\nLenina,\n1");

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
        formPage.fillDate("15", "March", "1980");

        formPage.pressSubmitButton();
    }
}
