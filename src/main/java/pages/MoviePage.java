// src/main/java/pages/MoviePage.java
package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import org.openqa.selenium.By;

public class MoviePage {

    // --- ИСПРАВЛЕНО: Кнопка "Купить билет" ---
    // Используем селектор по тексту внутри кнопки
    private SelenideElement buyTicketButton = $(By.xpath("//button[contains(., 'Купить билет')]"));

    // Поле ввода отзыва
    private SelenideElement reviewTextarea = $("[data-qa-id='movie_review_input']");

    // Кнопка отправки отзыва
    private SelenideElement submitReviewButton = $("[data-qa-id='movie_review_submit_button']");

    // Кнопка выбора рейтинга (всплывающее меню)
    private SelenideElement ratingSelectButton = $("[data-qa-id='movie_rating_select']").parent();

    // Успешное сообщение об отзыве (по классу из acceptedreview.txt)
    private SelenideElement successMessage = $(".go3958317564");

    // Заголовок фильма (для проверки)
    private SelenideElement movieTitle = $("h2");

    public void clickBuyTicket() {
        System.out.println("🖱️ Нажимаем кнопку 'Купить билет'...");
        buyTicketButton.click();
    }

    public void publishReview(String reviewText, int rating) {
        System.out.println("📝 Вводим текст отзыва...");
        reviewTextarea.setValue(reviewText);

        System.out.println("⭐ Выбираем оценку '" + rating + "'...");
        ratingSelectButton.click();

        // --- ИСПРАВЛЕНО: Используем XPath для поиска опции внутри списка ---
        String ratingText = String.valueOf(rating);
        SelenideElement ratingOption = $(By.xpath("//div[@role='listbox']//div[@role='option']//span[text()='" + ratingText + "']/.."));
        ratingOption.shouldBe(visible).click();

        System.out.println("📤 Нажимаем кнопку 'Отправить отзыв'...");
        submitReviewButton.click();
    }

    public boolean isReviewSuccessMessageDisplayed() {
        System.out.println("✅ Проверяем, отображается ли сообщение об успешной публикации отзыва...");
        return successMessage.shouldBe(visible).isDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }
}