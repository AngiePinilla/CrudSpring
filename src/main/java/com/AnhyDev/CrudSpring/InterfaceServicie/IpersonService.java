package com.AnhyDev.CrudSpring.InterfaceServicie;

import com.AnhyDev.CrudSpring.Model.Person;

import java.util.List;
import java.util.Optional;

public interface IpersonService {
    public List<Person>listar();
    public Optional<Person>listarId(int id);
    public int save(Person p);
    public void delete(int id);
}
