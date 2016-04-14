package kr.nor.spring.rest.services.impl.telegram;

import kr.nor.spring.rest.config.TelegramConfig;
import kr.nor.spring.rest.models.MessengerGroup;
import kr.nor.spring.rest.services.impl.telegram.struct.Update;
import kr.nor.spring.rest.services.impl.telegram.struct.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessengerImpl implements kr.nor.spring.rest.services.Messenger {
    private static final Logger logger = LoggerFactory.getLogger(MessengerImpl.class);

    @Autowired
    private TelegramConfig config;

    private final RestTemplate restTemplate;

    public MessengerImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public List<MessengerGroup> getGroups() {
        logger.info("getGroups");

        List<MessengerGroup> mappings = new ArrayList<>();

        GetUpdatesResponse getUpdatesResponse = restTemplate.getForObject("https://api.telegram.org/bot" + config.getToken() + "/getUpdates", GetUpdatesResponse.class);

        /*
        String html = restTemplate.getForObject("https://api.telegram.org/bot" + config.getToken() + "/getUpdates", String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            getUpdatesResponse = mapper.readValue(html, GetUpdatesResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        for (Update update : getUpdatesResponse.getResult()) {
            if (update.getMessage().isGroup_chat_created()) {
                if (update.getMessage().getChat().getType().equals("group")) {
                    logger.info("New group: {}", update.getMessage().getChat().getId());
                    mappings.add(new MessengerGroup(update.getMessage().getChat().getId(), update.getMessage().getChat().getTitle()));
                }
            } else {
                User new_chat_member = update.getMessage().getNew_chat_member();
                if (new_chat_member != null) {
                    if (new_chat_member.getId() == 94980980) {
                        if (update.getMessage().getChat().getType().equals("group")) {
                            logger.info("New group: {}", update.getMessage().getChat().getId());
                            mappings.add(new MessengerGroup(update.getMessage().getChat().getId(), update.getMessage().getChat().getTitle()));
                        }
                    }
                }
            }
        }
        return mappings;
    }

    @Override
    public void sendMessage(String text) {
        logger.info("sendMessage");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("chat_id", "-113879059");
        params.add("text", text);
        SendMessageResponse response = restTemplate.postForObject("https://api.telegram.org/bot" + config.getToken() + "/sendMessage", params, SendMessageResponse.class);

        logger.info("response: {}", response);
    }
}
