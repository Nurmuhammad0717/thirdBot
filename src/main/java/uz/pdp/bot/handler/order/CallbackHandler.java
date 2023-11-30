package uz.pdp.bot.handler.order;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class CallbackHandler {

    public static void handle(CallbackQuery callbackQuery, TelegramLongPollingBot bot){

        if(callbackQuery.getData().equals("evos")){
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("max_way")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("oqtepa")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        }else if (callbackQuery.getData().equals("kamolon")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        }else if (callbackQuery.getData().equals("bellissiomo_pizza")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        }else if (callbackQuery.getData().equals("street77")) {
            CallbackHandlerService.fastFood(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("meals")) {
            CallbackHandlerService.meals_menu(callbackQuery,bot);

        } else if (callbackQuery.getData().equals("drinks")) {
            CallbackHandlerService.drinks_menu(callbackQuery,bot);

        }else if (callbackQuery.getData().equals("other")) {
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

        }


    }

}
