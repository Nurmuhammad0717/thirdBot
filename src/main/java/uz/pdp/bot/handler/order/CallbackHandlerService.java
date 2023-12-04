package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.handler.order.basket.BasketRepo;

import java.util.HashMap;
import java.util.Map;

import static uz.pdp.bot.ButtonUtils.*;
import static uz.pdp.bot.handler.order.basket.BasketRepo.PRODUCT_MAP;

public class CallbackHandlerService {

    @SneakyThrows
    public static void fastFood(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
//        Long chatId = callbackQuery.getMessage().getChatId();
//        SendMessage sendMessage = new SendMessage(chatId.toString(),"Fields");
//        sendMessage.setReplyMarkup(FIELDS);

        EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                .replyMarkup(FIELDS)
                .inlineMessageId(callbackQuery.getInlineMessageId())
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getMessageId())
                .build();

        bot.execute(edited);


    }


    @SneakyThrows
    public static void meals_menu(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
//        Long chatId = callbackQuery.getMessage().getChatId();
//        SendMessage sendMessage = new SendMessage(chatId.toString(),"Menu meals");
//        sendMessage.setReplyMarkup(MENU_FAST_FOOD);

        EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                .replyMarkup(MENU_FAST_FOOD)
                .inlineMessageId(callbackQuery.getInlineMessageId())
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getMessageId())
                .build();



        bot.execute(edited);

    }

    @SneakyThrows
    public static void drinks_menu(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
//        Long chatId = callbackQuery.getMessage().getChatId();
//        SendMessage sendMessage = new SendMessage(chatId.toString(),"Menu drinks");
//        sendMessage.setReplyMarkup(MENU_DRINKS);


        EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                .replyMarkup(MENU_DRINKS)
                .inlineMessageId(callbackQuery.getInlineMessageId())
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getMessageId())
                .build();


        bot.execute(edited);

    }

    @SneakyThrows
    public static void other_menu(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
//        Long chatId = callbackQuery.getMessage().getChatId();
//        SendMessage sendMessage = new SendMessage(chatId.toString(),"Menu drinks");
//        sendMessage.setReplyMarkup(OTHERS_MENU);


        EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                .replyMarkup(OTHERS_MENU)
                .inlineMessageId(callbackQuery.getInlineMessageId())
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getMessageId())
                .build();

        bot.execute(edited);
    }








}

