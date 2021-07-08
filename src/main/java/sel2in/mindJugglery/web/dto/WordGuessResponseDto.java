package sel2in.mindJugglery.web.dto;

public class WordGuessResponseDto {

    boolean correct;
    String msg;
    UserDto user;
    String wordId;

    public WordGuessResponseDto(WordGuessDto guess) {
        user = guess.getUser();
        wordId = guess.getWordId();
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }
}
