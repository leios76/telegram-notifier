package kr.nor.spring.rest.services;

import kr.nor.spring.rest.models.MessengerGroup;

import java.util.List;

public interface Messenger {
    public List<MessengerGroup> getGroups();

    public void sendMessage();
}
