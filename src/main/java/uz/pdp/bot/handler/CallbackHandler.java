package uz.pdp.bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.contact.CommandEnum;
import uz.pdp.bot.service.ContactHandlerService;

public class CallbackHandler {

    public static void handle(Message message, TelegramLongPollingBot bot){

        switch (CommandEnum.of(message.getText())){
            case ID -> ContactHandlerService.idSearch(message.getChatId(),bot);
            case FIRST_NAME -> ContactHandlerService.firstNameSearch(message.getChatId(),bot);
            case LAST_NAME -> ContactHandlerService.lastNameSearch(message.getChatId(),bot);
            case PHONE_NUMBER -> ContactHandlerService.phoneNumberSearch(message.getChatId(),bot);
            case BIRTH_DATE -> ContactHandlerService.birthDateSearch(message.getChatId(),bot);
            case ANY_INFO -> ContactHandlerService.fullInfoSearch(message.getChatId(),bot);
        }




    }

}
