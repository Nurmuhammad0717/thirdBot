package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.service.MessageHandlerService;

public class CallbackHandler {

    @SneakyThrows
    public static void handle(CallbackQuery callbackQuery, TelegramLongPollingBot bot){

        Long chatId = callbackQuery.getMessage().getChatId();

        if(callbackQuery.getData().equals("evos")){
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("max_way")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("oqtepa")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        }else if (callbackQuery.getData().equals("look")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("meals")){
            CallbackHandlerService.meals_menu(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("drinks")) {
            CallbackHandlerService.drinks_menu(callbackQuery,bot);

        }else if (callbackQuery.getData().equals("other")  ) {
            CallbackHandlerService.other_menu(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("chicken_cheeseburger")) {
           MealsPhoto.chicken_cheese(callbackQuery.getMessage(),bot);

        }else if (callbackQuery.getData().equals("barbeque_burger")) {
           MealsPhoto.barbequeBurger(callbackQuery.getMessage(),bot);

        }else if (callbackQuery.getData().equals("chicken_burger")) {
           MealsPhoto.chickenBurger(callbackQuery.getMessage(),bot);

        }else if (callbackQuery.getData().equals("double_chicken_cheese")) {
           MealsPhoto.doubleChickenCheese(callbackQuery.getMessage(),bot);

        } else if (callbackQuery.getData().equals("fanta")) {
           DrinksPhoto.fanta(callbackQuery.getMessage(),bot);

        } else if (callbackQuery.getData().equals("montella")) {
           DrinksPhoto.montella(callbackQuery.getMessage(),bot);

        } else if (callbackQuery.getData().equals("sprite")) {
           DrinksPhoto.sprite(callbackQuery.getMessage(),bot);

        }else if (callbackQuery.getData().equals("greek_salad")) {
           OtherPhoto.greekSalad( callbackQuery.getMessage(),bot);

        }else if (callbackQuery.getData().equals("sezar_salad")) {
           OtherPhoto.sezarSalad(callbackQuery.getMessage(),bot);

        }else if (callbackQuery.getData().equals("sezam_salad")) {
           OtherPhoto.sezamSalad(callbackQuery.getMessage(),bot);

        } else if (callbackQuery.getData().equals("back_to_help")) {
            MessageHandlerService.help(chatId,bot);

        } else if (callbackQuery.getData().equals("back_to_restaurants")) {
            OrderHandler.handle(callbackQuery.getMessage(),bot);

        } else if (callbackQuery.getData().equals("back")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().startsWith("plus")) {
            String data = callbackQuery.getData();
            String s = data.split(";")[1];
            long productId = Long.parseLong(s);
            CallbackHandlerService.plusProduct(data,callbackQuery.getMessage().getChatId());

            EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                    .replyMarkup(ButtonUtils.getBasketButtons(productId))
                    .inlineMessageId(callbackQuery.getInlineMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .build();

            bot.execute(edited);

        }

    }

}


