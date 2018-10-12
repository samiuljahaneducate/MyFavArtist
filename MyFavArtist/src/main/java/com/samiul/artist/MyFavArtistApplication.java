package com.samiul.artist;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyFavArtistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFavArtistApplication.class, args);
	}
	
	@Bean
    	public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Artist").select()
                .apis(RequestHandlerSelectors.basePackage("com.samiul.artist"))               
                .paths(any()).build().apiInfo(new ApiInfo("Favorite Artis",
                        "API to provide information about an artist", "1.0.0", null,
                        new Contact("Samiul Jahan", "https://samiuljahan@gmail.com", null),null, null));
    	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
}
