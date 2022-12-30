package hometask.tests;

import hometask.base.Base;
import hometask.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends Base {

    @Test
    void submitPracticeFormTest() {
        PracticeFormPage formPage = new PracticeFormPage("/automation-practice-form");
        formPage.checkMainHeader();
        formPage.fillFirstNameField("Dmitry");
        formPage.fillLastNameField("Mikhaylov");
        formPage.fillEmailField("test@test.com");
        formPage.fillMobileNumberField("9998887766");
        formPage.fillCurrAddressField("Vladivostok,\nLenina,\n1");
        formPage.pressSubmitButton();
        formPage.selectMaleGender();
    }
}
