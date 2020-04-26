package configs;

import com.genil.learning.minisocialsvc.tms.repos.JdbcUserDAO;
import com.genil.learning.minisocialsvc.tms.repos.MongoDAO;
import com.genil.learning.minisocialsvc.tms.repos.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Antony Genil Gregory on 4/25/2020 6:16 PM
 * For project : mini-social-svc
 * If you run the application, such as java -jar myapp.jar -DdbType=MYSQL, only the JDBCUserDAO bean will be registered.
 * But if you set the property to MONGODB, then MongoUserDAO bean will be registered.
 **/
@Configuration
public class AppDbConfig {
    @Bean
    @Conditional(MySqlDatabaseTypeCondition.class)
    public UserDAO jdbcUserDAO() {
        return new JdbcUserDAO();
    }

    @Bean
    @Conditional(MangoDbSqlDatabaseCondition.class)
    public UserDAO mongoDAO() {
        return new MongoDAO();
    }
}
