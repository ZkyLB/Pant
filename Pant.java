import discord4j.core.*;
import discord4j.core.event.domain.message.*;
import discord4j.core.object.entity.*;
import discord4j.core.object.reaction.*;

import java.text.*;

public class Pant{
    public static void main(String[] args){
        final DiscordClient client = new DiscordClientBuilder(System.getProperty("token")).build();

        client.getEventDispatcher().on(MessageCreateEvent.class).map(MessageCreateEvent::getMessage)
            .filter(msg -> msg.getContent().map(s -> Normalizer.normalize(s.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").contains("pant")).orElse(false))
            .flatMap(m -> m.addReaction(ReactionEmoji.unicode("\uD83E\uDD5A")))
            .subscribe();

        client.getEventDispatcher().on(MessageCreateEvent.class).map(MessageCreateEvent::getMessage).filter(m -> Math.random() < 1.0 / 1000.0)
            .flatMap(Message::getChannel).flatMap(channel -> channel.createMessage("eat pant")).subscribe();

        client.login().block();
    }
}
