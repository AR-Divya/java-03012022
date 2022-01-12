package com.div.orm.repository;

import com.div.orm.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCrudRepo extends CrudRepository<Car, Long > { }