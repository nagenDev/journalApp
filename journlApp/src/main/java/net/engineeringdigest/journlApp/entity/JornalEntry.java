package net.engineeringdigest.journlApp.entity;

import lombok.*;
import net.engineeringdigest.journlApp.enums.Sentiment;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JornalEntry {

    @Id
    private ObjectId id;
    @NonNull
    private String title;

    private String content;
    private LocalDateTime date;
    private Sentiment sentiment;

}
