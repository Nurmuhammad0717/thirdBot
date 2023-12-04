package uz.pdp.bot.contact;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

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

            } else if (message.getText().equals("/phoneNumber_search")) {
                ContactHandlerService.phoneNumberSearch(message.getChatId(),bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())==ContactStep.PHONE_NUMBER) {
                ContactHandlerService.phoneNumber(message.getChatId(),message.getText(),bot);

            } else if (message.getText().equals("/birthDate_search")) {
            ContactHandlerService.birthDateSearch(message.getChatId(), bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())==ContactStep.BIRTH_DATE) {
            ContactHandlerService.birthDate(message.getChatId(),message.getText(),bot);

            }  else if (message.getText().equals("/anyInfo_search")) {
            ContactHandlerService.fullInfoSearch(message.getChatId(), bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())==ContactStep.FULL_INFO) {
            ContactHandlerService.fullInfo(message.getChatId(),message.getText(),bot);

            } else if (ContactRepo.CONTACT_STEP.get(message.getChatId())==ContactStep.FINISHED) {
                ContactHandlerService.finished(message.getChatId(),bot);

            }


        }



    }


}
