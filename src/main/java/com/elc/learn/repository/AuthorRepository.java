/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.elc.learn.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{

}
