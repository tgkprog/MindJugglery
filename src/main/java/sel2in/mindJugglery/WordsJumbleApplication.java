package sel2in.mindJugglery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import io.swagger.oas.inflector.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
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

//	@Bean
//	Configuration configuration(ApplicationContext applicationContext)
//	{
//		Configuration configuration = Configuration.read();
//		configuration.setControllerFactory((cls, operation) -> applicationContext.getBean(cls));
//		return configuration;
//	}

	/**
	 * Since we're using both Actuator and Jersey, we need to use Springs
	 * <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cors.html#_filter_based_cors_support">Filter based CORS support</a>
	 *
	 * @return corsFilter
	 */
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
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