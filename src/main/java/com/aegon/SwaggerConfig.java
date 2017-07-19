package com.aegon;


import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.google.common.collect.Sets;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.aegon")
public class SwaggerConfig extends WebMvcConfigurerAdapter{
	
	
	private static final ModelRef API_ERROR_MODEL = new ModelRef("ApiError");

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    	
    	registry.addResourceHandler("/test/**").addResourceLocations("/test/").setCachePeriod(0);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(0);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(0);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(0);

    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new MappingJackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.aegon"))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
            .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
            .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
            .globalResponseMessage(RequestMethod.GET, getGlobalResponseMessages())
            .globalResponseMessage(RequestMethod.PUT, getGlobalResponseMessages());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Aegon Service API")
                .description("A service providing operations for a customer's rooms; e.g. personal details and contact information. ")
                .version("1")
                .build();
    }

    private List<ResponseMessage> getGlobalResponseMessages() {
        return Arrays.asList(
            new ResponseMessageBuilder().code(200).message("The request was completed successful").build(),

            new ResponseMessageBuilder().code(400).message("A request was made which is in error, such as an invalid property value")
                .responseModel(API_ERROR_MODEL).build(),

            new ResponseMessageBuilder().code(404).message("A resource was requested which does not exist")
                .responseModel(API_ERROR_MODEL).build(),

            new ResponseMessageBuilder().code(405).message("An HTTP method was requested which is not supported")
                .responseModel(API_ERROR_MODEL).build(),

            new ResponseMessageBuilder().code(406).message("The response type being returned is not set in the request's Accept HTTP header")
                .responseModel(API_ERROR_MODEL).build(),

            new ResponseMessageBuilder().code(415).message("A media type was used which is not supported")
                .responseModel(API_ERROR_MODEL).build(),

            new ResponseMessageBuilder().code(500).message("Something went unexpectedly wrong within the service while executing the request")
                .responseModel(API_ERROR_MODEL).build());
    }
}