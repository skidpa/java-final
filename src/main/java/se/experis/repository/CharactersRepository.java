package se.experis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.model.Characters;

import java.util.List;

public interface CharactersRepository extends JpaRepository<Characters, Integer> {
    Characters findCharactersById(int id);
    Characters findCharactersBycharName(String name);
    List<Characters> findAllCharactersBycharName(String name);
}
