package uz.pdp.bot.handler.order;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.pdp.bot.ButtonUtils;

import java.util.List;

import static uz.pdp.bot.ButtonUtils.BUTTONS_RESTAURANTS;

public class OrderHandler {
    public static void handle(Message message, TelegramLongPollingBot bot) throws TelegramApiException {

            SendMessage sendMessage = new SendMessage(message.getChatId().toString()
                    , "Choose restaurant");
            sendMessage.setReplyMarkup(BUTTONS_RESTAURANTS);
            bot.execute(sendMessage);

    }
}
