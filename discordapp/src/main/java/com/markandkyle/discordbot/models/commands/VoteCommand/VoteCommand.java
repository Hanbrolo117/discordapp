package com.markandkyle.discordbot.models.commands.VoteCommand;


import com.markandkyle.discordbot.MessageHandler;
import com.markandkyle.discordbot.dataaccess.SessionDAO;
import com.markandkyle.discordbot.models.Session;
import com.markandkyle.discordbot.models.commands.Command;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by CptAmerica on 7/22/17.
 */
public class VoteCommand implements Command {
    MessageHandler msgHandler;
    MessageReceivedEvent event;
    SessionDAO sessionDAO;
    Session session;

    VoteCommand(MessageHandler handler, MessageReceivedEvent event) {
        this.msgHandler = handler;
        this.event = event;
        sessionDAO = new SessionDAO();
    }

    public void execute(String message) {}

    public void interpret(String message) {}

    public String removeVoteCommand(String msg) {
        return msg.replaceFirst("!vote","").trim();
    }

    /**
     * Gets the session id passed into any vote command.
     * @param message
     * @return
     */
    public String sessionIdParser(String message) {
        return message.trim().split(" ")[2];
    }

    public String getUserTag() {
        return event.getAuthor().mention();
    }
}
