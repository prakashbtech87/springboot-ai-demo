package com.prakash.ai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prakashkaruppusamy
 */
@RestController
public class HelloController {

    private final ChatClient chatClient;

    public HelloController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/hello")
    public String hello() {
        String message = "Myself Prakash Karuppusamy and exploring Spring AI";
        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create();
        return chatClient.call(prompt.getContents());
    }
}