import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.EventListener;

import javax.security.auth.login.LoginException;

public class main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        // 기본 jda를 만들고
        JDA jda = JDABuilder.createDefault("ODY5OTE1OTIwOTM4NzA0OTU4.YQFKVQ.eloF3lATwuypjm6GertkdJaa2wM").build();

        // jda에 이벤트를 감지하는 리스너를 넣는다.
        jda.addEventListener(new main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        // 받은 메세지 내용이 !ping이라면
        if (event.getMessage().getContentRaw().equals("!ping")) {
            // pong라는 내용을 보낸다.
            event.getChannel().sendMessage("pong!").queue();
        }
    }
}