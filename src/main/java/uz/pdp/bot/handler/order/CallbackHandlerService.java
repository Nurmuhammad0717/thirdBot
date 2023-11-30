package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.File;

import static uz.pdp.bot.ButtonUtils.*;

public class CallbackHandlerService {

    @SneakyThrows
    public static void fastFood(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
        Long chatId = callbackQuery.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage(chatId.toString(),"Fields");
        sendMessage.setReplyMarkup(FIELDS);
        bot.execute(sendMessage);

    }


    @SneakyThrows
    public static void meals_menu(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
        Long chatId = callbackQuery.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage(chatId.toString(),"Menu meals");
        sendMessage.setReplyMarkup(MENU_FAST_FOOD);
        bot.execute(sendMessage);

    }

    @SneakyThrows
    public static void drinks_menu(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
        Long chatId = callbackQuery.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage(chatId.toString(),"Menu drinks");
        sendMessage.setReplyMarkup(MENU_DRINKS);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    public static void other_menu(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
        Long chatId = callbackQuery.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage(chatId.toString(),"Menu drinks");
        sendMessage.setReplyMarkup(OTHERS_MENU);
        bot.execute(sendMessage);
    }
}

