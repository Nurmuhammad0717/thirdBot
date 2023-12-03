package uz.pdp.bot.handler.order;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.ButtonUtils;

import java.io.File;

public class OtherPhoto {
    @SneakyThrows
    public static void sezarSalad(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/sezar_salad.jpg")));
        sendPhoto.setCaption("""
                ID: 8
                Name: Sezar salad
                Price: 21,000\s""");
        sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(8L));

        bot.execute(sendPhoto);
    }
      @SneakyThrows
    public static void sezamSalad(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/sezam_salad.jpg")));
        sendPhoto.setCaption("""
                ID: 9
                Name: Sezam salad
                Price: 24,000\s""");
          sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(9L));

          bot.execute(sendPhoto);
    }
      @SneakyThrows
    public static void greekSalad(Message message, TelegramLongPollingBot bot){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photos/greek_salad.jpg")));
        sendPhoto.setCaption("""
                ID: 10
                Name: Greek salad
                Price: 25,000\s""");
          sendPhoto.setReplyMarkup(ButtonUtils.getBasketButtons(10L));

          bot.execute(sendPhoto);
    }

}
