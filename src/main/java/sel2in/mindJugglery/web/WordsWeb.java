package sel2in.mindJugglery.web;

//
//import io.swagger.annotations.ApiParam;
//import io.swagger.v3.oas.annotations.ExternalDocumentation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import  io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sel2in.mindJugglery.service.WordService;
import sel2in.mindJugglery.web.dto.WordGuessDto;
import sel2in.mindJugglery.web.dto.WordGuessResponseDto;
import sel2in.mindJugglery.web.dto.WordQuestionDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author moises.macero
 */

@RestController
@RequestMapping("/words/v1")
public class WordsWeb {
    @Value("spring.application.name")
    private String hostName;

    private static final Logger logger = LogManager.getLogger();
    @Autowired
    private WordService wordService;


    @GetMapping("/getNewQ")
//    @ApiResponse(responseCode = "200", description = "All good, random question with jumbled word provided")
//    @ApiResponse(responseCode = "400", description = "Invalid username supplied")
//    @ExternalDocumentation(description="How to enter new words, see ", url="https://sel2in.com/pages")

    public ResponseEntity<WordQuestionDto> getARandomQuestio() {

        WordQuestionDto wordQuestionDto = wordService.getNewQuestion();
        logger.info("getNewQ v4 :{}", wordQuestionDto);
        System.out.println("get a q " + wordQuestionDto);
        return ResponseEntity.ok(wordQuestionDto);
    }

    @PostMapping("/check")
    //@ApiParam(name = "guess", allowableValues= "Valid WordGuessDto with your answer, previously obtained wordId and User ")
    public ResponseEntity<WordGuessResponseDto> check(@RequestBody WordGuessDto guess) {
        WordGuessResponseDto rsp = wordService.check(guess);
        logger.info("check v3 :{} for {}", rsp, guess);
        return ResponseEntity.ok(rsp);
    }

//    @RequestMapping("/")
//    public String ribbonPing() {
//        return this.hostName;
//    }

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

}
