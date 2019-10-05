package se.experis.model;

import javax.persistence.*;


@Entity
@Table
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "character_name", nullable = false)
    //@NotBlank(message = "not blank")
    private String charName;

    @Column(name = "character_level", nullable = false)
    //@NotBlank(message = "not blank")
    private int charLevel;

    @Column(name = "character_race", nullable = false)
    //@NotBlank(message = "not blank")
    private String charRace;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "class_id", nullable = false)
    private int classId;

    @ManyToOne(optional = false /*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false) // insertable, updatable and optional tips from tim.
    private Users users;

    @ManyToOne(optional = false /*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CharacterClasses characterClasses;


    public Characters() {
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(int charLevel) {
        this.charLevel = charLevel;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public CharacterClasses getCharacterClasses() {
        return characterClasses;
    }

    public Users getUsers() {
        return users;
    }
}
