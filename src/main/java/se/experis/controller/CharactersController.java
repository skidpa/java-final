package se.experis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.experis.model.Characters;
import se.experis.model.User;
import se.experis.repository.CharactersRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import org.json.*;

@RestController
public class CharactersController {

    @Autowired
    private final CharactersRepository charactersRepository;

    public CharactersController(CharactersRepository charactersRepository){
        this.charactersRepository = charactersRepository;
    }
    // add a new character
    @PostMapping("/api/characters")
    @ResponseBody
    public Characters addCharacters(HttpServletResponse response, @RequestBody Characters characters) {

        return charactersRepository.save(characters);
    }

    // works
    // get character by id
    @GetMapping("/api/characters/{id}")
    public Characters getCharacterById(@PathVariable("id") int id){
        return charactersRepository.findCharactersById(id);
    }

    // works
    // get character by name this sould ony return the first one found since charactername is not unique
    // craches if more that one with same name...
    @GetMapping("/api/characters/name/{name}")
    public Characters getCharacterByName(@PathVariable("name") String name){
        return charactersRepository.findCharactersBycharName(name);
    }

    // works
    // get all characters
    @GetMapping("/api/characters/list")
    public List<Characters> getAllCharacters(){
        return charactersRepository.findAll();
    }

    // works
    //get all characters by name
    @GetMapping("/api/characters/list/name/{name}")
    public List<Characters> getCharacterListByName(@PathVariable String name){
        return charactersRepository.findAllCharactersBycharName(name);
    }

}
