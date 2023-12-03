package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import uz.pdp.bot.handler.order.basket.BasketRepo;

import java.util.HashMap;
import java.util.Map;

import static uz.pdp.bot.ButtonUtils.*;
import static uz.pdp.bot.handler.order.basket.BasketRepo.PRODUCT_MAP;

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

    public static void plusProduct(String data, Long chatId) {
        String[] split = data.split(";");
            long productId = Long.parseLong(data);
        if(PRODUCT_MAP.get(chatId)!=null){
            Integer quantity = PRODUCT_MAP.get(chatId).get(productId);
            PRODUCT_MAP.get(chatId).put(productId,++quantity);
        }else{
            Map<Long,Integer> productAmount = new HashMap<>();
            int quantity = 1;
            productAmount.put(productId,quantity);
            PRODUCT_MAP.put(chatId,productAmount);
        }

    }

    public static void minusProduct(String data, Long chatId) {
        String[] split = data.split(";");
        if(PRODUCT_MAP.get(chatId)!=null){
            long productId = Long.parseLong(data);
            Integer quantity = PRODUCT_MAP.get(chatId).get(productId);
            PRODUCT_MAP.get(chatId).put(productId,--quantity);
        }else{
            Map<Long,Integer> productAmount = new HashMap<>();
            int quantity = 0;
            PRODUCT_MAP.put(chatId,productAmount);
        }

    }




}

