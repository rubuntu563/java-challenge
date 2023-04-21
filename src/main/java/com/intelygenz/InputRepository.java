package com.intelygenz;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InputRepository extends MongoRepository<InputEntity, String> {


}