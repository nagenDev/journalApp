package net.engineeringdigest.journlApp.repository;

import net.engineeringdigest.journlApp.entity.ConfigJournalApplEntry;
import net.engineeringdigest.journlApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalApplEntry, ObjectId> {


    }




