package com.AnhyDev.CrudSpring.Service;

import com.AnhyDev.CrudSpring.InterfaceServicie.IpersonService;
import com.AnhyDev.CrudSpring.Interfaces.IPerson;
import com.AnhyDev.CrudSpring.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IpersonService {

    @Autowired
    private IPerson data;
    @Override
    public List<Person> listar() {
        return (List<Person>) data.findAll();
    }

    @Override
    public Optional<Person> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Person p) {
        int res=0;
        Person persona= data.save(p);
        if (!persona.equals(null)) {
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
