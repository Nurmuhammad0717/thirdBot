package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class DrinksPhoto {
   @SneakyThrows
   public static void fanta(Message message, TelegramLongPollingBot bot){
       SendPhoto sendPhoto = new SendPhoto();
       sendPhoto.setChatId(message.getChatId());
       sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/fanta.jpg")));
       sendPhoto.setCaption("Fanta 1,0L \n" +
               "price : 12,000");
       bot.execute(sendPhoto);
   }
     @SneakyThrows
   public static void sprite(Message message, TelegramLongPollingBot bot){
       SendPhoto sendPhoto = new SendPhoto();
       sendPhoto.setChatId(message.getChatId());
       sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/sprite.jpg")));
         sendPhoto.setCaption("Sprite 1,0L \n" +
                 "price : 12,000");
       bot.execute(sendPhoto);
   }

   @SneakyThrows
   public static void montella(Message message, TelegramLongPollingBot bot){
       SendPhoto sendPhoto = new SendPhoto();
       sendPhoto.setChatId(message.getChatId());
       sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/montella.jpg")));
         sendPhoto.setCaption("Sprite 0,5L \n" +
                 "price : 3,000");
       bot.execute(sendPhoto);
   }


}
