package br.com.treinamento.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private static MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
				
	/*	
	 *Modelo Query Param abaixo 
	 *
		configurer.favorParameter(true)
				.parameterName("mediaType").ignoreAcceptHeader(true)
				.useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON)
		        .mediaType("xml", MediaType.APPLICATION_XML);
	*/
	//Modelo Header Param Abaixo	
	
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("json", MediaType.APPLICATION_JSON)
          .mediaType("xml", MediaType.APPLICATION_XML)
          .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
		
		
	
	}
	
	
	
	
}
