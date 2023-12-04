package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.handler.order.basket.BasketRepo;
import uz.pdp.bot.handler.order.basket.ProductRepo;
import uz.pdp.bot.handler.order.basket.model.Product;
import uz.pdp.bot.service.MessageHandlerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
            String num = data.split(";")[2];

            int quantity = Integer.parseInt(num)+1;
            long productId = Long.parseLong(s);

            BasketRepo.add(chatId, quantity, productId);

            EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                    .replyMarkup(ButtonUtils.getBasketButtons(productId,chatId,quantity))
                    .inlineMessageId(callbackQuery.getInlineMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .build();

            bot.execute(edited);

        } else if (callbackQuery.getData().startsWith("minus")) {

            String data = callbackQuery.getData();
            String s = data.split(";")[1];
            String num = data.split(";")[2];
            int quantity = Integer.parseInt(num);
            long productId = Long.parseLong(s);

            if(quantity<=0){
                quantity=0;
            }else quantity-=1;


            BasketRepo.minus(chatId, quantity, productId);

            EditMessageReplyMarkup edited = EditMessageReplyMarkup.builder()
                    .replyMarkup(ButtonUtils.getBasketButtons(productId,chatId,quantity))
                    .inlineMessageId(callbackQuery.getInlineMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .build();

            bot.execute(edited);

        } else if (callbackQuery.getData().equals("add_to_basket")) {

            Map<Long, Integer> map = BasketRepo.PRODUCT_MAP.get(chatId);
            StringBuffer sb = new StringBuffer();

            sb.append("Your products \n");

            for (Long key : map.keySet()) {

                Product product1 = ProductRepo.PRODUCT_LIST.stream()
                        .filter(product -> product.getId() == key)
                        .toList().get(0);

                sb.append(product1.getName()+", "+product1.getPrice());
                sb.append(" "+map.get(key)+" dona. \n");

            }

            SendMessage  message = new SendMessage(chatId.toString(), sb.toString());
            message.setReplyMarkup(ButtonUtils.addToBasketButtons());
            bot.execute(message);

        } else if (callbackQuery.getData().equals("do_payment")) {
            Map<Long, Integer> map = BasketRepo.PRODUCT_MAP.get(chatId);

            double finalPrice = 0;
            for (Long key : map.keySet()) {
                Product product1 = ProductRepo.PRODUCT_LIST.stream()
                        .filter(product -> product.getId() == key)
                        .toList().get(0);
                Integer quantity = map.get(key);
                finalPrice+=quantity*product1.getPrice();
            }

            SendMessage message = new SendMessage(chatId.toString(),"Payment" +
                    "\n Total price :"+String.valueOf(finalPrice));
            message.setReplyMarkup(ButtonUtils.wayOfPayment());

            bot.execute(message);

            BasketRepo.PRODUCT_MAP=new HashMap<>();


        } else if (callbackQuery.getData().equals("clear_basket")) {
            BasketRepo.PRODUCT_MAP=new HashMap<>();

        }


    }


    }





