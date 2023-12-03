package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.ButtonUtils;

import java.io.File;

public class MealsPhoto {
    @SneakyThrows
    public static void chicken_cheese(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/chicken_cheeseBurger.jpg")));
        sendPhoto.setCaption("""
                ID: 3
                Name: Chicken cheeseburger
                Price: 30,000""");
        sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(3L));

        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void barbequeBurger(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/barbeque_burger.jpg")));
        sendPhoto.setCaption("""
                ID: 1
                Name: Barbeque burger
                Price: 27,000""");
        sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(1L));

        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void chickenBurger(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/chicken_burger.jpg")));
        sendPhoto.setCaption("""
                ID:2
                Name: Chicken burger
                Price: 27,000""");
        sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(2L));

        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void doubleChickenCheese(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/double_chicken_cheese.jpg")));
        sendPhoto.setCaption("""
                ID: 4
                Name: Double chicken cheeseburger
                Price: 35,000""");
        sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(4L));

        bot.execute(sendPhoto);
    }

}
