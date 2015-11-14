package zinjvi;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * Created by Vitaliy on 11/14/2015.
 */
@Configuration
public class MongoConfig {

    public static final String DB_NAME = "data_helper";
    @Autowired
    private Mongo mongo;
    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new MongoClient();
    }

    @Bean
    public DB db() {
        return mongo.getDB(DB_NAME);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(mongo, DB_NAME);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory);
    }

}
