package com.example.webtaskmanager.repository;

import com.example.webtaskmanager.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {


}
