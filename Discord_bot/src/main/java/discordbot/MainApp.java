package discordbot;

import listener.LunchListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.BasicConfigurator;

import javax.security.auth.login.LoginException;
import java.security.cert.TrustAnchor;

public class MainApp extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {


        BasicConfigurator.configure();

        // 기본 jda를 만들고
        JDA jda = JDABuilder.createDefault("token").build();

        // jda에 이벤트를 감지하는 리스너를 넣는다.
        jda.addEventListener(new MainApp());

        try {
            jda.addEventListener(new LunchListener());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
