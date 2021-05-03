package day15;

import java.util.List;
import java.util.function.Predicate;

public class Challenge {

    private final List<Ingredient> ingredients;
    private int highScore;

    public Challenge(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int solvePart1() {
        return getHighScore(cookie -> cookie.getScore() > highScore);
    }

    public int solvePart2() {
        return getHighScore(cookie -> cookie.calories == 500 && cookie.getScore() > highScore);
    }

    private int getHighScore(Predicate<Cookie> isPerfectCookie) {
        highScore = 0;
        buildCookiesAndFindHighScore(new Cookie(), ingredients.size(), 100, isPerfectCookie);
        return highScore;
    }

    /*
     * Following https://www.reddit.com/r/adventofcode/comments/3wwj84/day_15_solutions/cy0l04r/?utm_source=share&utm_medium=web2x&context=3
     */
    private void buildCookiesAndFindHighScore(Cookie cookie, int numIngredients, int remainingSpoons, Predicate<Cookie> isPerfectCookie) {
        Cookie newCookie;

        for (int i = numIngredients > 1 ? 1 : remainingSpoons; i <= remainingSpoons; i++) {
            newCookie = new Cookie(cookie);

            Ingredient ingredient = ingredients.get(numIngredients - 1);
            newCookie.addIngredient(ingredient, i);

            if (numIngredients > 1)
                buildCookiesAndFindHighScore(newCookie, numIngredients - 1, remainingSpoons - i, isPerfectCookie);

            if (isPerfectCookie.test(newCookie))
                this.highScore = newCookie.getScore();
        }
    }
}
