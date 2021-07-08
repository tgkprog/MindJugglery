package sel2in.mindJugglery.service;

import org.springframework.stereotype.Service;
import sel2in.mindJugglery.model.WordInfo;
import sel2in.mindJugglery.web.dto.WordGuessDto;
import sel2in.mindJugglery.web.dto.WordGuessResponseDto;
import sel2in.mindJugglery.web.dto.WordQuestionDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

@Service
public class WordService {
    private static final Logger logger = LogManager.getLogger(WordService.class.getName());


    private List<WordInfo> words = new ArrayList<>();
    private Map<String, WordInfo> wordsAliasIdsMap = new HashMap<>();

    public WordService(){}

    public WordQuestionDto getNewQuestion() {
        WordQuestionDto word =  getWordLazyLoad();
        return word;
    }

    private WordQuestionDto getWordLazyLoad(){
        final WordQuestionDto dto = new WordQuestionDto();

        final Random rnd = new Random();
        WordInfo word = null;
        if(words.size() < 10){
            word = new WordInfo();
            //lazy init
            List<String> wordsLst = Arrays.asList("Logging", "Certainly", "evaluative", "provenance"
            , "relegate", "detach", "protract", "indenture", "academia", "disgorge",
                    "libation", "expertly", "dwindle", "pessimist");
            String wrd = wordsLst.get(rnd.nextInt(wordsLst.size()));
            while(words.contains(wrd)){
                wrd = wordsLst.get(rnd.nextInt(wordsLst.size()));
            }
            words.add(word);
            word.setWord(wrd);

            final Character[ ] chrs2 = new Character[wrd.length()];
            for(int i = 0; i < wrd.length(); i++){
                chrs2[i] = wrd.charAt(i);
            }
            final StringBuilder sb = new StringBuilder();
            for(int i = 0; i < wrd.length(); i++){
                sb.delete(0, sb.length());
                List<Character> chrs3 = Arrays.asList(chrs2);
                Collections.shuffle(chrs3);
                chrs3.forEach(c -> sb.append(c));
                word.getJumbles().add(sb.toString().intern());
                final String rndId = UUID.randomUUID().toString().intern();
                word.addAliasId(rndId);
                wordsAliasIdsMap.put(rndId, word);
            }


        }
        word = words.get(rnd.nextInt(words.size()));
        word.usedOnce();
        dto.setCnt(word.getCntUsed());
        final List<String> jm = word.getJumbles();
        dto.setJumbledWord( jm.get(rnd.nextInt(jm.size())));
        dto.setId(word.randomAliasId(rnd));
        return dto;
    }

    public WordGuessResponseDto check(WordGuessDto guess){
        WordGuessResponseDto rsp = new WordGuessResponseDto(guess);
        WordInfo word = wordsAliasIdsMap.get(guess.getWordId());
        if(word == null){
            rsp.setMsg("Error 43");
            return rsp;
        }
        rsp.setCorrect(word.sameWord(guess.getGuess()));
        return rsp;
    }
}
