import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
//https://discordapp.com/oauth2/authorize?client_id=486530547661930518&scope=bot&permissions=0


public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, IOException {
        JDABuilder builder = new JDABuilder((AccountType.BOT));
        FileReader r = new FileReader(new File("C:\\Users\\hjcad\\Desktop\\token.txt"));
        BufferedReader buff = new BufferedReader(r);
        String token = buff.readLine();
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.setGame(Game.playing("Kirby Planet Robobot"));
        builder.buildAsync();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Random r = new Random();
        String[] smug = {"https://i.imgur.com/DiWS30Y.jpg", "https://i.imgur.com/sqQlid7.jpg",
                "https://i.imgur.com/FKC5CGp.jpg", "https://i.imgur.com/uJqQ4Gj.jpg",
                "https://i.imgur.com/LIOvSmo.jpg", "https://i.imgur.com/Gefe560.png",
                "https://i.imgur.com/CHOFPo7.jpg", "https://i.imgur.com/kwb2LYD.jpg",
                "https://i.imgur.com/niweAfq.png", "https://i.imgur.com/obbVBmY.png"};
        if(event.getAuthor().isBot()){
            return;
        }
        System.out.println("We revieved a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());
        if((event.getMessage().getContentRaw().equalsIgnoreCase("!Hi"))){
            event.getChannel().sendMessage("Poyo").queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!smug")){
            event.getChannel().sendMessage(smug[r.nextInt(smug.length -1)]).queue();
            event.getChannel().sendMessage("Poyo?").queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!disapoint")){
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/187638685683023872/498162103132225536/" +
                    "SmartSelect_20181006-105324_iFunny_.jpg").queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!help")){
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/364" +
                    "145544706260992/495641584159686657/SmartSelect_20180929-124924_iFunny_.jpg").queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!David")){
            event.getChannel().sendMessage("David behave").queue();
        }
        if((event.getMessage().getContentRaw().equalsIgnoreCase("!Poyo"))){
            event.getChannel().sendMessage("https://78.media.tumblr.com/b57280b8d0ee4e7cebf5fbd495c246b9/" +
                    "tumblr_p6ft3ekn0H1u9w5zpo1_640.gif").queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Sm4sh")){
            event.getChannel().sendMessage("Add role Sm4sh to " + event.getAuthor().getName()).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Melee")){
            event.getChannel().sendMessage("Add role Melee to " + event.getAuthor().getName()).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Pokemon")){
            event.getChannel().sendMessage("Add role Pokemon to " + event.getAuthor().getName()).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!League")){
            event.getChannel().sendMessage("Add role League to " + event.getAuthor().getName()).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Overwatch")){
            event.getChannel().sendMessage("Add role Overwatch to " + event.getAuthor().getName()).queue();
        }
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Sm4sh")){
            Member m = event.getMember();
            Role game = event.getGuild().getRolesByName("Sm4sh", true).get(0);
            event.getGuild().getController().addSingleRoleToMember(m, game).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Melee")){
            Member m = event.getMember();
            Role game = event.getGuild().getRolesByName("Melee", true).get(0);
            event.getGuild().getController().addSingleRoleToMember(m, game).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Pokemon")){
            Member m = event.getMember();
            Role game = event.getGuild().getRolesByName("Pokemon", true).get(0);
            event.getGuild().getController().addSingleRoleToMember(m, game).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!League")){
            Member m = event.getMember();
            Role game = event.getGuild().getRolesByName("League", true).get(0);
            event.getGuild().getController().addSingleRoleToMember(m, game).queue();
        }
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!Overwatch")){
            Member m = event.getMember();
            Role game = event.getGuild().getRolesByName("Overwatch", true).get(0);
            event.getGuild().getController().addSingleRoleToMember(m, game).queue();
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Member m = event.getMember();
        Role member = event.getGuild().getRolesByName("CUGI Member", true).get(0);
        event.getGuild().getController().addSingleRoleToMember(m, member).queue();

    }

}
