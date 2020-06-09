package org.launchcode.chefs_table;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfig {

    @Configuration
    public class WebApplicationCOnfig implements WebMvcConfigurer {

        @Bean
        public AuthenticationFilter authenticationFilter() {
            return new AuthenticationFilter();
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor( authenticationFilter() );
        }

    }

}
