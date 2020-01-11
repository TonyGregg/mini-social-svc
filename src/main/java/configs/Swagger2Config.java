//package configs;
//
//import com.google.common.base.Predicates;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.io.IOException;
//
///**
// * Created by Antony Genil Gregory on 1/10/2020 2:20 PM
// * For project : mini-social-svc
// **/
//@Configuration
//@EnableSwagger2
//public class Swagger2Config {
//    @Value("${enable.swagger:false}")
//    private boolean enableSwagger;
//
//    @Bean
//    public Docket api() throws IOException {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
//                .build()
//                .enable(enableSwagger)
//                .apiInfo(getApiInfo());
//    }
//    private ApiInfo getApiInfo() {
//        return new ApiInfoBuilder().title("Mini Car Documentation")
//                .description("This is Mini Cars Inc company")
//                .version("1.0")
//                .build();
//    }
//}
