package sel2in.mindJugglery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WordsJumbleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordsJumbleApplication.class, args);
		System.out.println("Main class ver " + getVersion());
	}

	private static String getVersion() {
		return "1.0.111";
	}

}

//
//@RefreshScope
//@RestController
//class MessageRestController {
//
//	@Value("${message:Hello default}")
//	private String message;
//
//	@RequestMapping("/message")
//	String getMessage() {
//		return this.message;
//	}
//}


//DEBUG

//	@Bean
//	public CommandLineRunner eventTester(EventDispatcher eventDispatcher) {
//		return args -> {
//			eventDispatcher.send(new JuggledEvent("d", pojo, true));
//		};
//	}