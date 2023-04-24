package com.AnhyDev.CrudSpring.Interfaces;

import com.AnhyDev.CrudSpring.Model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerson extends CrudRepository<Person,Integer> {
}
