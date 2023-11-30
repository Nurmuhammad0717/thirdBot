package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class OtherPhoto {
    @SneakyThrows
    public static void sezarSalad(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/sezar_salad.jpg")));
        sendPhoto.setCaption("Sezar salad \n" +
                "price: 21,000 ");
        bot.execute(sendPhoto);
    }
      @SneakyThrows
    public static void sezamSalad(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/sezam_salad.jpg")));
        sendPhoto.setCaption("Sezam salad \n" +
                "price: 24,000 ");
        bot.execute(sendPhoto);
    }
      @SneakyThrows
    public static void greekSalad(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/greek_salad.jpg")));
        sendPhoto.setCaption("Greek salad \n" +
                "price: 20,000 ");
        bot.execute(sendPhoto);
    }

}
