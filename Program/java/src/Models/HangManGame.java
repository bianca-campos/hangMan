package Models;

public class HangManGame {
    private int guessLeft = 0;
    private int countDraw = 0;

    /**
     * Constructor
     * @param guessLeft - guess left to ends the game
     * @param countDraw - count to draw the hangMan
     */
    public HangManGame(int guessLeft, int countDraw) {
        this.guessLeft = guessLeft;
        this.countDraw = countDraw;
    }

    /**
     * getters
     */
    public int getGuessLeft() {
        return guessLeft;
    }

    public int getCountDraw() {
        return countDraw;
    }

    /**
     * Setters
     */
    public void setGuessLeft(int guessLeft) {
        this.guessLeft = guessLeft;
    }

    public void setCountDraw(int countDraw) {
        this.countDraw = countDraw;
    }
}

