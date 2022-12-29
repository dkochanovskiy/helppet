package kz.onlineshelter.helppet.service;

import kz.onlineshelter.helppet.model.Message;
import java.util.List;

public interface MessageService {
    List<Message> all();
    Message one(long id);
    Message save(Message message);
    Message update(long id, String text);
    void deleteById(long id);
}
