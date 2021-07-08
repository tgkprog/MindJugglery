//package sel2in.mindJugglery.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import sel2in.mindJugglery.model.WordInfo;
//import sel2in.mindJugglery.service.WordService;
//import sel2in.mindJugglery.web.WordsWeb;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(WordsWeb.class)
//public class WordsControllerTest {
//
//    @MockBean
//    private WordService WordsService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private JacksonTester<WordInfo> json;
//
//    @Before
//    public void setUp() {
//        JacksonTester.initFields(this, new ObjectMapper());
//    }
//
//    @Test
//    public void getRandomQ() throws Exception {
////        Multiplication multiplication = new Multiplication(70, 20);
////        given(multiplicationService.createRandomMultiplication()).willReturn(multiplication);
////
////        mockMvc.perform(get("/multiplications/random")
////                .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().is2xxSuccessful())
////                .andExpect(content().json(json.write(multiplication).getJson()));
//    }
//}