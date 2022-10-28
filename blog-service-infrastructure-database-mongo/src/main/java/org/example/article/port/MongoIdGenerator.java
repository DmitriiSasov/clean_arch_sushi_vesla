package org.example.article.port;

import com.rcore.database.mongo.commons.port.impl.ObjectIdGenerator;
import org.bson.types.ObjectId;
import org.example.article.port.ArticleIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class MongoIdGenerator extends ObjectIdGenerator implements ArticleIdGenerator<ObjectId> {
}
