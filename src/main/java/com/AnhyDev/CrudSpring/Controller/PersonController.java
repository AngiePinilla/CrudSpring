package com.AnhyDev.CrudSpring.Controller;

import com.AnhyDev.CrudSpring.InterfaceServicie.IpersonService;
import com.AnhyDev.CrudSpring.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class PersonController {

    @Autowired
    private IpersonService servicep;

    @GetMapping("/")
    public String Inicio(){
        return "Index";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Person>Personas= servicep.listar();
        model.addAttribute("Personas", Personas);
        return "Lista";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("Persona", new Person());
        return "newPerson";
    }

    @PostMapping("/save")
    public String save(@Validated Person p, Model model){
        servicep.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Person>Persona= servicep.listarId(id);
        model.addAttribute("Persona", Persona);
        return "newPerson";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        servicep.delete(id);
        return "redirect:/listar";
    }
}
