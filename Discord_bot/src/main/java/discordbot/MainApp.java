import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.BasicConfigurator;

import javax.security.auth.login.LoginException;

public class MainApp extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        BasicConfigurator.configure();

        // 기본 jda를 만들고
        JDA jda = JDABuilder.createDefault("ODY5OTE1OTIwOTM4NzA0OTU4.YQFKVQ.eloF3lATwuypjm6GertkdJaa2wM").build();

        // jda에 이벤트를 감지하는 리스너를 넣는다.
        jda.addEventListener(new MainApp());

    }

}