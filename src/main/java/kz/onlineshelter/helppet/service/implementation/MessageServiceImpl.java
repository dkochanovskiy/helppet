package kz.onlineshelter.helppet.service.implementation;

import kz.onlineshelter.helppet.model.Message;
import kz.onlineshelter.helppet.repository.MessageRepository;
import kz.onlineshelter.helppet.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    @Transactional
    public List<Message> all() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    @Transactional
    public Message one (long id) {
        return messageRepository.findById(id);
    }

    @Override
    @Transactional
    public Message save (Message message) {
        return messageRepository.saveAndFlush(message);
    }

    @Override
    @Transactional
    public Message update(long id, String text) {
        Message messageFromDb = messageRepository.findById(id);
        messageFromDb.setText(text);

        return messageFromDb;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        messageRepository.deleteById(id);
    }
}
