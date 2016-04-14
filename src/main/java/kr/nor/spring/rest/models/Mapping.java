package kr.nor.spring.rest.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
public class Mapping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private MessengerGroup messengerGroup;

    @ManyToOne
    private Field field;

    private Time start;

    private Time end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MessengerGroup getMessengerGroup() {
        return messengerGroup;
    }

    public void setMessengerGroup(MessengerGroup messengerGroup) {
        this.messengerGroup = messengerGroup;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }
}
