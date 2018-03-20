/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elc.learn.model.User;

public interface UserRepository extends MongoRepository<User, String> {
   
}