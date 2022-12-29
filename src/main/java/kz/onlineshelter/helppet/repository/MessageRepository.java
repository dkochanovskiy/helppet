package kz.onlineshelter.helppet.repository;

import kz.onlineshelter.helppet.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    Message findById(long id);

    Message saveAndFlush(Message message);
}