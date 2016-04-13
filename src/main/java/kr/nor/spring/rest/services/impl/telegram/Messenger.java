package kr.nor.spring.rest.services.impl.telegram;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.nor.spring.rest.models.MessengerGroup;
import kr.nor.spring.rest.services.impl.telegram.struct.Update;
import kr.nor.spring.rest.services.impl.telegram.struct.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Messenger implements kr.nor.spring.rest.services.Messenger {

    private static final Logger logger = LoggerFactory.getLogger(Messenger.class);

    private final RestTemplate restTemplate;

    public Messenger() {
        restTemplate = new RestTemplate();
    }

    @Override
    public List<MessengerGroup> getGroups() {
        logger.info("getGroups");

        String html = restTemplate.getForObject("https://api.telegram.org/bot94980980:AAGuZNtNY2IH9cUDNG1plEbhtwHwkz3zG0E/getUpdates", String.class);

        List<MessengerGroup> mappings = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        GetUpdatesResult getUpdatesResult;
        try {
            getUpdatesResult = mapper.readValue(html, GetUpdatesResult.class);

            for (Update update : getUpdatesResult.getResult()) {
                if (update.getMessage().isGroup_chat_created()) {
                    if (update.getMessage().getChat().getType().equals("group")) {
                        logger.info("New group: {}", update.getMessage().getChat().getId());
                        mappings.add(new MessengerGroup(update.getMessage().getChat().getId(), update.getMessage().getChat().getTitle()));
                        continue;
                    }
                }
                User new_chat_member = update.getMessage().getNew_chat_member();
                if (new_chat_member != null) {
                    if (new_chat_member.getId() == 94980980) {
                        if (update.getMessage().getChat().getType().equals("group")) {
                            logger.info("New group: {}", update.getMessage().getChat().getId());
                            mappings.add(new MessengerGroup(update.getMessage().getChat().getId(), update.getMessage().getChat().getTitle()));
                            continue;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mappings;
    }

    @Override
    public void sendMessage() {
        logger.info("sendMessage");
    }
}
