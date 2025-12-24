package junit;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import steps.AuthSteps;
import utils.ConfigLoader;

public class LoginExtension implements BeforeEachCallback {

    private final AuthSteps authSteps = new AuthSteps();

    @Override
    @Step("Выполняем авторизацию перед каждым тестом")
    public void beforeEach(ExtensionContext context) {
        openMainPage();
        String email = ConfigLoader.getProperty("auth.email");
        String password = ConfigLoader.getProperty("auth.password");
        authSteps.ensureLoggedIn(email, password);
    }

    @Step("Открываем главную страницу")
    private void openMainPage() {
        Selenide.open("https://cinescope.t-qa.ru/");
    }
}