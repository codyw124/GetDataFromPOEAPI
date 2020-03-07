package com.example.accessingdatamysql;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

import com.example.accessingdatamysql.StashPage;

public interface StashPageRepository extends CrudRepository<StashPage, Integer> {

    List<StashPage> findAll(Sort sort);
}
