package uz.pdp.bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.pdp.bot.contact.ContactRepo;
import uz.pdp.bot.contact.ContactStep;
import uz.pdp.bot.service.ContactHandlerService;

public class ContactHandler {

    public static void handle(Message message, TelegramLongPollingBot bot){

        User from = message.getFrom();

        if(message.hasText()){

            if(message.getText().equals("/search_person")) {
                ContactHandlerService.searchPerson(message.getChatId(), bot);

            } else if (message.getText().equals("/id_Search")) {
                ContactHandlerService.idSearch(message.getChatId(),bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())== ContactStep.ID) {
                ContactHandlerService.findId(message.getChatId(),Long.parseLong(message.getText()),bot);

            } else if (message.getText().equals("/firstName_search")) {
                ContactHandlerService.firstNameSearch(message.getChatId(),bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())== ContactStep.FIRST_NAME) {
                ContactHandlerService.firstName(message.getChatId(),message.getText(),bot);

            } else if (message.getText().equals("/lastName_search")) {
                ContactHandlerService.lastNameSearch(message.getChatId(),bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())==ContactStep.LAST_NAME) {
                ContactHandlerService.lastName(message.getChatId(),message.getText(),bot);
            }


        }



    }


}
