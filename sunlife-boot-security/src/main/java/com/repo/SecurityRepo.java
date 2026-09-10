package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.AppUser;
@Repository
public interface SecurityRepo extends CrudRepository<AppUser, Integer>{

}
