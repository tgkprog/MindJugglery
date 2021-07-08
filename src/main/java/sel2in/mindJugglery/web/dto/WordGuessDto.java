package sel2in.mindJugglery.web.dto;

public class WordGuessDto {

    String guess;
    String jumbled;
    String wordId;
    UserDto user;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getJumbled() {
        return jumbled;
    }

    public void setJumbled(String jumbled) {
        this.jumbled = jumbled;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
