package com.chattApp.V1;

import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private Repository repository;

    @Autowired
    private MessageRepository messageRepository;

    // Hämta kanaler
    public List<Channel> getAllChannels() {
        return repository.findAll();
    }

    // Skapa kanal
    public Channel createChannel(Channel channel) {

        return repository.save(channel);
    }

    // Ta bort  kanal
    public void deleteChannel(Long channelId) {
        repository.deleteById(channelId);
    }

    // Uppdatera titeln
    public Channel updateChannelTitle(Long channelId, String newTitle) {
        Channel channel = repository.findById(channelId)
                .orElseThrow(() -> new EntityNotFoundException("Channel not found"));

        channel.setTitle(newTitle);
        return repository.save(channel);
    }

    // Skapa  meddelande
    public ChatMessage createMessage(Long channelId, ChatMessage chatMessage) {
        Channel channel = repository.findById(channelId)
                .orElseThrow(() -> new EntityNotFoundException("Channel not found"));

        chatMessage.setChannel(channel);
        return messageRepository.save(chatMessage);
    }

    // Hämta alla meddelanden i en kanal
    public List<ChatMessage> getAllMessagesInChannel(Long channelId) {
        return messageRepository.findByChannelId(channelId);
    }

    // Uppdatera innehållet i ett meddelande
    public ChatMessage updateMessageContent(Long messageId, String newContent) {
        ChatMessage message = messageRepository.findById(messageId)
                .orElseThrow(() -> new EntityNotFoundException("Message not found"));

        message.setText(newContent);
        return messageRepository.save(message);
    }

    // Ta bort meddelande
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    public Channel getChannelById(Long id) {
        // denna koden med hjälp  av ChatGPT hotfix
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Channel not found with ID: " + id));
    }

}
