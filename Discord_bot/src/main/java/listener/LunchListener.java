package listener;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utill.TimeTable;

public class LunchListener extends ListenerAdapter {
    private TimeTable tt;

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String msg = e.getMessage().getContentRaw();
        System.out.println("msg");



        if (msg.startsWith("!yy")){
            int idx =msg.indexOf(" ");
            if (idx <0){
                sayMsg(e.getChannel(), "(ex: !yy 도움말)입력 해서 도움말을 확인해주세요!)");
                return;
            }
            String cmd =msg.substring(idx+1);
            int paramIdx =cmd.indexOf(" ");

            String param ="";
            if (paramIdx >= 0){
                param =cmd.substring(paramIdx + 1);
                cmd = cmd.substring(0,paramIdx);
            }
            switch (cmd){
                case "도움말":
                    if (param.isEmpty()){
                        sayMsg(e.getChannel(),"(ex: !yy echo 할말) 입력하면 따라 합니다");
                        sayMsg(e.getChannel(),"(ex: !yy time 20210901 2) 입력하면 14반의 시간표가 나옵니다");
                        sayMsg(e.getChannel(),"아직 초기 봇이라 매우 불안정 합니다!");
                    }
                    break;

                case " ":{
                    if (param.isEmpty()){
                        sayMsg(e.getChannel(), "(ex: !yy 도움말)입력 해서 도움말을 확인해주세요!)");
                    }
                }
                case "echo":
                    if (param.isEmpty()){
                        sayMsg(e.getChannel(),"echo는 메아리할 말을 입력해야 합니다.");
                    }else {
                        sayMsg(e.getChannel(), param);
                    }
                    break;
                case "time":
                    String[]params =param.split(" ");
                    if (params.length != 2 ){
                        sayMsg(e.getChannel(), "시간표조회 : !yy time 날짜(20190920) 반(1또는 2) 으로 입력하세요");
                    }else{
                        sayMsg(e.getChannel(),  tt.getTime(params[0], params[1]));
                    }
                    break;
            }

        }


    }
    private void sayMsg(MessageChannel channel, String msg){
        channel.sendMessage(msg).queue();

    }
    public LunchListener(){

        tt =new TimeTable();
    }
}
