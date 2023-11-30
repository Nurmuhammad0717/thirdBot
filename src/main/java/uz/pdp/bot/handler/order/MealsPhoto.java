package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class MealsPhoto {
    @SneakyThrows
    public static void chicken_cheese(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/chicken_cheeseBurger.jpg")));
        sendPhoto.setCaption("Chicken cheeseburger \n" +
                "price: 30,000 ");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void barbequeBurger(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/barbeque_burger.jpg")));
        sendPhoto.setCaption("Barbeque burger \n" +
                "price: 27,000 ");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void chickenBurger(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/chicken_burger.jpg")));
        sendPhoto.setCaption("Chicken burger \n" +
                "price: 25,000 ");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void doubleChickenCheese(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/double_chicken_cheese.jpg")));
        sendPhoto.setCaption("Double chicken cheeseburger \n" +
                "price: 35,000 ");
        bot.execute(sendPhoto);
    }

}
