package uz.pdp.bot.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.pdp.bot.mailing.Steps;
import uz.pdp.bot.mailing.UserRepo;
//import uz.pdp.bot.mail.MailManager;
import uz.pdp.bot.service.MessageHandlerService;

public class MessageHandler {

    @SneakyThrows
    public static void handle(Message message, TelegramLongPollingBot bot){

        User from = message.getFrom();

        if(message.hasText()){

            if(message.getText().equals("/start")) {
                MessageHandlerService.start(message.getChatId(), bot, from.getFirstName());

            } else if (message.getText().equals("/search_person")) {
                ContactHandler.handle(message,bot);

            } else if (message.getText().equals("/help")) {
                MessageHandlerService.help(message.getChatId(),bot);

            } else if (message.getText().equals("/try")) {
                MessageHandlerService.trY(message.getChatId(),bot,from.getFirstName());

            } else if (UserRepo.STEPS.get(message.getChatId())== Steps.REGISTER_EMAIL) {
               MessageHandlerService.registerEmail(message.getText(),message.getChatId(), bot);

            } else if (UserRepo.STEPS.get(message.getChatId())==Steps.REGISTER_TOKEN) {
                MessageHandlerService.registerToken(message.getChatId(),message.getText(),bot);

            } else if (UserRepo.STEPS.get(message.getChatId())==Steps.RECIPIENT_ADDRESS||message.getText().equals("/resend")) {
                MessageHandlerService.recipientAddress(message.getChatId(),message.getText(),bot);

            } else if (UserRepo.STEPS.get(message.getChatId())==Steps.SUBJECT) {
                MessageHandlerService.putSubject(message.getChatId(),message.getText(),bot);

            } else if (UserRepo.STEPS.get(message.getChatId())==Steps.MESSAGE) {
                MessageHandlerService.putMessage(message.getChatId(),message.getText(),bot);

            } else if (UserRepo.STEPS.get(message.getChatId())==Steps.FINISHED) {
                MessageHandlerService.reSend(message.getChatId(),bot);
            }

        }



    }

}
