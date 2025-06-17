package net.engineeringdigest.journlApp.repository;

import net.engineeringdigest.journlApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;



    public List<User> getUsersForSA(){
        Query query = new Query();
        // we need that users who opt sentment analysis and there email is exists
//       query.addCriteria(Criteria.where("email").exists(true));
//       query.addCriteria(Criteria.where("email").ne(null).ne(""));
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
       query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        List<User> users = mongoTemplate.find(query,User.class);

      //  Criteria criteria = new Criteria();
// we can use and or operator in this
//         query.addCriteria(criteria.orOperator(Criteria.where("email").exists(true),
//                Criteria.where("sentimentAnalysis").is(true))
//        );
        return users;

    }

}
