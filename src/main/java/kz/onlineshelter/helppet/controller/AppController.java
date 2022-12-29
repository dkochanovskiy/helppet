package kz.onlineshelter.helppet.controller;

import kz.onlineshelter.helppet.model.Message;
import kz.onlineshelter.helppet.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class AppController {
    private final MessageService messageService;

    public AppController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/greeting")
    public String app () {
        return "main";
    }

    @GetMapping("/message")
    public String message(Map<String, Object> model) {
        Iterable<Message> messages = messageService.all();

        model.put("messages", messages);

        return "message1";
    }

    @GetMapping("/message/{id}")
    public String one(@PathVariable int id, Map<String, Object> model) {
        Message messages = messageService.one(id);

        model.put("messages", messages);

        return "message1";
    }

    @PostMapping
    public void save(@RequestBody Message message) {
        messageService.save(message);
    }

    @PutMapping("/message/edit/{id}/{text}")
    public void update(@PathVariable long id, @PathVariable String text) {
        messageService.update(id, text);
    }

    @DeleteMapping("/message/delete/{id}")
    public void delete(@PathVariable long id) {
        messageService.deleteById(id);
    }
}
