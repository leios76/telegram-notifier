package kr.nor.spring.rest.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MessengerGroup {
    @Id
    private int id;

    private String name;


    public MessengerGroup() {
        this(0, "");
    }

    public MessengerGroup(int id) {
        this(id, "");
    }

    public MessengerGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
