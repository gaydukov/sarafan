package com.sarafan.sarafan.controller;

import com.sarafan.sarafan.domian.Message;
import com.sarafan.sarafan.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;
    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    @GetMapping
    public List<Message> list(){
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public Message getOne (@PathVariable("id") Message message){
        return message;
    }


    @PostMapping()
    public Message create(@RequestBody Message message){
        message.setCreationData(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message updata(@PathVariable ("id") Message messageFromDB, @RequestBody Message message){
        BeanUtils.copyProperties(message,messageFromDB,"id");
        return messageRepo.save(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable ("id") Message message){
        messageRepo.delete(message);
    }
}
