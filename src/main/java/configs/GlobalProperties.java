package configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties // no prefix, root level.
public class GlobalProperties {

    //thread-pool , relax binding
    private int threadPool;
    private String email;

    //... getters and setters, toString()
}
