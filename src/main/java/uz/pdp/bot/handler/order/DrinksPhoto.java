package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.handler.order.basket.ProductRepo;
import uz.pdp.bot.handler.order.basket.model.Product;

import java.io.File;
import java.util.stream.Stream;

public class DrinksPhoto {
   @SneakyThrows
   public static void fanta(Message message, TelegramLongPollingBot bot){
       SendPhoto sendPhoto = new SendPhoto();
       sendPhoto.setChatId(message.getChatId());
       sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/fanta.jpg")));
       sendPhoto.setCaption("""
               ID: 5
               Name: Fanta 0,5L
               Price: 7,000""");
       sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(5L));
       bot.execute(sendPhoto);
   }
     @SneakyThrows
   public static void sprite(Message message, TelegramLongPollingBot bot){
       SendPhoto sendPhoto = new SendPhoto();
       sendPhoto.setChatId(message.getChatId());
       sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/sprite.jpg")));
       sendPhoto.setCaption("""
               ID: 7
               Name: Sprite 0,5L
               Price: 7,000""");
         sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(7L));
       bot.execute(sendPhoto);
   }

   @SneakyThrows
   public static void montella(Message message, TelegramLongPollingBot bot){
       SendPhoto sendPhoto = new SendPhoto();
       sendPhoto.setChatId(message.getChatId());
       sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/montella.jpg")));
         sendPhoto.setCaption("""
                 ID: 6
                 Name: Montella 0,5L
                 Price : 3,000""");
       sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(6L));
       bot.execute(sendPhoto);
   }


}
