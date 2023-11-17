package uz.pdp.bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HandlerManager {

    public static void handle(Update update, TelegramLongPollingBot bot){

        if(update.hasMessage()){
            Message message = update.getMessage();
            MessageHandler.handle(message,bot);
        }

    }



}
