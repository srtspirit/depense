package ca.vastier.depense.web.config;

import ca.vastier.depense.web.interceptors.AuthorisingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebServiceConfigurer implements WebMvcConfigurer
{
	@Override
	public void addInterceptors(final InterceptorRegistry registry)
	{
		//TODO get this interceptor from the spring context so that it can use other beans
		registry.addInterceptor(new AuthorisingInterceptor());
	}
}
