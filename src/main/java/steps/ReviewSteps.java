// src/main/java/steps/ReviewSteps.java
package steps;

import pages.MoviePage;

public class ReviewSteps {

    private final MoviePage moviePage = new MoviePage();

    public void publishReview(String text, int rating) {
        moviePage.publishReview(text, rating);
    }

    // --- ИСПРАВЛЕНО: Используем правильные имена методов из MoviePage ---
    public boolean isReviewPublishedSuccessfully() {
        // Вызываем метод, который проверяет видимость сообщения об успехе
        return moviePage.isReviewSuccessMessageDisplayed(); // <- Вот правильное имя!
    }

    public String getReviewConfirmationMessage() {
        // Вызываем метод, который возвращает текст сообщения
        return moviePage.getSuccessMessageText(); // <- Вот правильное имя!
    }
}