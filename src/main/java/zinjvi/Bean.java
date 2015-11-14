package zinjvi;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vitaliy on 11/14/2015.
 */
@Service
public class Bean {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private DB db;

    public Bean() {
        System.out.println("bean");
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
        System.out.println("mo: " + mongoOperations);

        Map<String, String> map = new HashMap<>();
        map.put("te", "st");

        db.getCollection("t").insert(new BasicDBObject(map));

//        Test test = new Test();
//        test.setName("n");
//        mongoOperations.save(test);




    }

    @Document(collection = "t")
    public class Test {
        @Id
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
