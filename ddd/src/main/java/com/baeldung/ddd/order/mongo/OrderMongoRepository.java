package com.baeldung.ddd.order.mongo;

import com.baeldung.ddd.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderMongoRepository extends MongoRepository<Order, String> {

}
