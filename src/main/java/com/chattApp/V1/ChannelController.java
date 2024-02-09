package com.chattApp.V1;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    private  ChannelService channelService;



    // Skapa kanal
    @PostMapping("/")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }


    // Hämta kanaler
    @GetMapping("/")
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }



    // Ta bort kanal
    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable Long id) {
        channelService.deleteChannel(id);
    }


    //channels/id
  @GetMapping("/{id}")
    public ResponseEntity<?> getChannelById(@PathVariable Long id) {
        try {
            Channel channel = channelService.getChannelById(id);

            if (channel != null) {
                return ResponseEntity.ok(channel);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Channel not found with ID: " + id);
            }
        } catch (Exception e) {
           // denna del av koden med hjälp  av ChatGPT hotfix
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No channel by ID: " + id);
        }
    }


    // Uppdatera titeln
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateChannelTitle(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String newTitle = requestBody.get("title");

        try {
            Channel updatedChannel = channelService.updateChannelTitle(id, newTitle);
            return ResponseEntity.ok(updatedChannel);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Channel: " + id + " ,not found.");
        }
    }

    // Skapa meddelande
    @PutMapping("/{id}/messages")
    public ChatMessage createMessage(@PathVariable Long id, @RequestBody ChatMessage chatMessage) {
        return channelService.createMessage(id, chatMessage);
    }

    // Hämta meddelanden
    @GetMapping("/{id}/messages")
    public List<ChatMessage> getAllMessagesInChannel(@PathVariable Long id) {
        return channelService.getAllMessagesInChannel(id);
    }

    // Uppdatera text  meddelande
    @PatchMapping("{id}/messages")
    public ResponseEntity<?> updateMessageContent(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String newText = requestBody.get("newText");
        try {
            ChatMessage updatedMessage = channelService.updateMessageContent(id, newText);
            return ResponseEntity.ok(updatedMessage);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Msg not found with ID: " + id);
        }
    }

    // Ta bort  meddelande
    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable Long id) {
        channelService.deleteMessage(id);
    }
}
