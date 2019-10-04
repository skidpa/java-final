package se.experis.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "character_classes")
public class CharacterClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_description")
    private String classDescription;

    //mapped by shuld be the name that is used in characters so in this case CharacterClasses characterClasses.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "characterClasses")
    private List<Characters> characters;

    public CharacterClasses() {
    id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public List<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }
}
