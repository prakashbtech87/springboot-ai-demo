package com.prakash.ai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author prakashkaruppusamy
 */
@RestController
@RequestMapping("/api/ai")
public class PromptController {

    private final ChatClient chatClient;

    public PromptController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        return chatClient.call(prompt);
    }

    @GetMapping("/health")
    public String health() {
        return "AI Service is up and running!";
    }

    @GetMapping("/trending")
    public String getTrendingDestinations() {
        String message = """
        I would like to know the top 5 trending destinations to visit in August 2024.
        Please provide a concise response with just the destination names and a brief reason why they're trending.
        """;
        
        return chatClient.call(message);
    }
}
