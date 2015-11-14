package zinjvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MongoConfig.class)
public class DataHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataHelperApplication.class, args);
    }
}
