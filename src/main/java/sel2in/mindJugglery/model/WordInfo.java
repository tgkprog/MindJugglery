package sel2in.mindJugglery.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class WordInfo {
    private String id;
    private String word;
    private List<String> jumbles = new ArrayList<>();
    private List<String> alaisIds = new ArrayList<>();

    private long cntUsed;

    public String getWord() {
        return word;
    }


    public boolean sameWord(String n) {
        if(n == null || word == null)return false;
        return word.equalsIgnoreCase(n);
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getJumbles() {
        return jumbles;
    }

    public void setJumbles(List<String> jumbles) {
        this.jumbles = jumbles;
    }

    public long getCntUsed() {
        return cntUsed;
    }

    public void usedOnce() {
        cntUsed++;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordInfo)) return false;
        WordInfo wordInfo = (WordInfo) o;
        return Objects.equals(word, wordInfo.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    public String randomAliasId(Random rnd) {
        return alaisIds.get(rnd.nextInt(alaisIds.size()));
    }

    public boolean contains(String rndId) {
        return alaisIds.contains(rndId);
    }

    public void addAliasId(String rndId) {
        alaisIds.add(rndId);
    }

    public boolean removeAliasId(String rndId) {
         return alaisIds.remove(rndId);
    }
}
