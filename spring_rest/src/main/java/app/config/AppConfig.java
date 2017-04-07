package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"app"})
public class AppConfig extends WebMvcConfigurerAdapter{

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	    registry.enableContentNegotiation(new MappingJackson2XmlView());
	    registry.jsp();
	}
	
}
