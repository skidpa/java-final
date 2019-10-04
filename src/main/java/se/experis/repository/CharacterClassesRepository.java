package se.experis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.model.CharacterClasses;

import java.util.List;

public interface CharacterClassesRepository extends JpaRepository<CharacterClasses, Integer> {
    CharacterClasses findCharacterClassesById(int id);

    //searchers for dbtable classname
    CharacterClasses findCharacterClassesByclassName(String classname);
    List<CharacterClasses> findAllCharacterClassesByclassName(String classname);

}
