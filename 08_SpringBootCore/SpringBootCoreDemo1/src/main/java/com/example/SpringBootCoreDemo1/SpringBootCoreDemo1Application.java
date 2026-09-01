package com.example.SpringBootCoreDemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
// instead of all above we use @SpringBootApplication annotation
@SpringBootApplication
public class SpringBootCoreDemo1Application {

	// run() returns ConfigurableApplicationContext and ConfigurableApplicationContext interface extends ApplicationContext
	public static void main(String[] args) {

		// collecting returning ConfigurableApplicationContext/ApplicationContext as context ref variable

		ApplicationContext context =
				SpringApplication.run(SpringBootCoreDemo1Application.class, args);

		// here we don't need to create config file separately

		// in SpingBoot we don't get beans from IoC. It is way in Spring Core. we handle it to SpringBoot
		// in web applications the methods gets automatic call via endpoints using @GetMapping


		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();

//		@Bean
//		public UserService getUserServiceBean() {
//			return new UserService();
//		}

		// @SpringBootConfiguration file is like AppConfig where
		// @ComponentScan uses default package for beans scanning
		// if we want to add diff package, or we have main parent package then that is also we valid
		// @EnableAutoConfiguration, see my project whichever important beans you have to create, create them It gets used internally
		// how it supports to create beans for the classes that are present in diff packages.. Which are the important packages
		//@ConditionalOnClass and @ConditionalOnMissing explain?
	}

	// creating a bean of external library classes
//	@Bean
//	public JsonParser getJsonParserBean(){
//		return new BasicJsonParser();
//	}

//	@Bean
//	public UserService getUserServiceBean(){
//		return new UserService();
//	}

}


// Explain @SpringBootApplication in detailed?
//@SpringBootConfiguration, @EnableAutoConfiguration,and @ComponentScan explain each?
// What happens after SpringAppication.run()?

/*
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
 */


// how to create custom annotations?