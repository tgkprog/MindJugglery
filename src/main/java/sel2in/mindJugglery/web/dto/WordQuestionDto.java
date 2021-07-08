package sel2in.mindJugglery.web.dto;

public class WordQuestionDto {

    private String jumbledWord;
    private long cnt=0;
    String id;

    public WordQuestionDto(){}

    public String getJumbledWord() {
        return jumbledWord;
    }

    public void setJumbledWord(String jumbledWord) {
        this.jumbledWord = jumbledWord;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
