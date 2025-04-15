import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class FileUploadPage {
    private static final SelenideElement FILE_UPLOAD_PAGE_LINK = $("a[href='https://practice-automation.com/file-upload/']");
    private static final SelenideElement FILE_UPLOAD_BUTTON = $("#file-upload");
    private static final SelenideElement UPLOAD_SUBMIT_BUTTON = $("#upload-btn");
    private static final String INVALID_FILE_PATH = "src/main/resources/InvalidPictureToUpload.bmp";
    private static final String VALID_FILE_PATH = "src/main/resources/ValidPictureToUpload.png";
    private static final SelenideElement FILE_TYPE_ERROR_MESSAGE = $(".wpcf7-not-valid-tip");
    private static final SelenideElement UPLOAD_STATUS_MESSAGE = $(".wpcf7-response-output");

    public FileUploadPage goToSpinnersPage() {
        FILE_UPLOAD_PAGE_LINK.hover().click();
        AllTest.HEADER.shouldHave(text("File Upload"));
        return this;
    }

    public FileUploadPage testUploadingFile() {
        // Verifies file upload behavior for llowed file type
        FILE_UPLOAD_BUTTON.uploadFile(new File(INVALID_FILE_PATH));
        FILE_TYPE_ERROR_MESSAGE.shouldHave(exactText("You are not allowed to upload files of this type."));
        UPLOAD_SUBMIT_BUTTON.click();
        UPLOAD_STATUS_MESSAGE.shouldHave(exactText("One or more fields have an error. Please check and try again."));

        // Verifies file upload behavior disallowed file type
        FILE_UPLOAD_BUTTON.uploadFile(new File(VALID_FILE_PATH));
        FILE_TYPE_ERROR_MESSAGE.shouldNotBe(visible);
        UPLOAD_SUBMIT_BUTTON.click();
        UPLOAD_STATUS_MESSAGE.shouldHave(exactText("Thank you for your message. It has been sent."));
        return this;
    }
}