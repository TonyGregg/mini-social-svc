package configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Antony Genil on 4/27/2020 at 8:54 AM, for project - mini-social-svc.
 **/
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "validations")
@Data
public class ValidationErrorConfig {
    private HashMap<String, String> messages;
    private String regex;
    private String xssPattern;
}
