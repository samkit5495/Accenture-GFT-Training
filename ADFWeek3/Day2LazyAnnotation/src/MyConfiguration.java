import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MyConfiguration {

	@Bean
	@Lazy
	public A getA(){
		return new A();
	}
	
	@Bean
	public B getB(){
		return new B();
	}
}
