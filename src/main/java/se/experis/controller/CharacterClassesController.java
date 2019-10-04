package se.experis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.experis.model.CharacterClasses;
import se.experis.repository.CharacterClassesRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
public class CharacterClassesController {
    @Autowired
    CharacterClassesRepository characterClassesRepository;

    public CharacterClassesController(CharacterClassesRepository characterClassesRepository) {
        this.characterClassesRepository = characterClassesRepository;
    }

    // add a new class
    @PostMapping("/api/class")
    @ResponseBody
    public CharacterClasses addClass(HttpServletResponse response, @RequestBody CharacterClasses characterClasses) {

        CharacterClasses newClass = characterClassesRepository.save(characterClasses);

        if (newClass.getId() == 0) {
            response.setStatus(400);
        } else {
            response.setStatus(201);
        }

        return newClass;
    }

    // works
    // get class by id
    @GetMapping("/api/class/{classID}")
    public CharacterClasses getClassByID(@PathVariable("classID") int classID) {
        return characterClassesRepository.findCharacterClassesById(classID);
    }

    // works
    // get class by name will get the first hit
    @GetMapping("/api/class/name/{classname}")
    public CharacterClasses getClassnames(@PathVariable("classname") String classname) {
        return characterClassesRepository.findCharacterClassesByclassName(classname);
    }

    // works
    // get class by id same as abowe but different approach
    @GetMapping("/api/class2/{classID}")
    public CharacterClasses getClassByID2(@PathVariable("classID") int classID) {
        return characterClassesRepository.findById(classID).get();
    }

    // works
    // get only the classname by id
    @GetMapping("/api/className/{classID}")
    public String getName(@PathVariable("classID") int classID) {
        return characterClassesRepository.findCharacterClassesById(classID).getClassName();
    }

    // works
    // get all classes
    @GetMapping("/api/class/list")
    public List<CharacterClasses> getAll() {
        return characterClassesRepository.findAll();
    }

    // works
    // get all classes by name
    @GetMapping("/api/class/list/name/{classname}")
    public List<CharacterClasses> getAllClassnames(@PathVariable("classname") String classname) {
        return characterClassesRepository.findAllCharacterClassesByclassName(classname);
    }
}
