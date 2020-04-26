package configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Antony Genil on 1/6/20 at 05 04 for licensing-service
 **/
@Component
public class LicenseConfig {
    @Value("${tracer}")
    private String tracer;

    public String getTracer() {
        return tracer;
    }

    public void setTracer(String tracer) {
        this.tracer = tracer;
    }
}
