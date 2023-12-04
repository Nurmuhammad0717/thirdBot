package uz.pdp.bot.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.pdp.bot.mailing.mail.MailManager;
import uz.pdp.bot.mailing.*;

public class MessageHandlerService {

    public static void start(Long chatId, TelegramLongPollingBot bot,String name) throws TelegramApiException {
       bot.execute(new SendMessage(chatId.toString(),"Hello "+name+" please press /help to learn what this bot can do :)"));
    }

    @SneakyThrows
    public static void help(Long chatId, TelegramLongPollingBot bot){
        bot.execute(new SendMessage(chatId.toString(), "This bot can help you to send messages from your e-mail address and" +
                "by this bot you can order food from your lovely restaurants and cafes." +
                "\n If you want to send mail press /mail" +
                "\n If you want to order food press /order" ));
    }

    @SneakyThrows
    public static void mail(Long chatId, TelegramLongPollingBot bot, String name){
        bot.execute(new SendMessage(chatId.toString(),
                name+" Please enter your e-mail address which you want to send messages from." ));
        UserRepo.STEPS.put(chatId, Steps.REGISTER_EMAIL);
    }


    @SneakyThrows
    public static void registerEmail(String userName, Long chatId, TelegramLongPollingBot bot) {

        if(Checker.checkEmail(userName)){

        UserRepo.REGISTRATION_DETAILS.put(chatId, new RegistrationDetails(userName));

        bot.execute(new SendMessage(chatId.toString(),
                "Now generate access token for this address and send it without spaces it contains.")
        );
        UserRepo.STEPS.put(chatId,Steps.REGISTER_TOKEN);
        }else {
            bot.execute(new SendMessage(chatId.toString(),"Please enter a valid and exist e-mail address :(" +
                    "\n now press /try please :)"));
        }

    }

    @SneakyThrows
    public static void registerToken(Long chatId, String token, TelegramLongPollingBot bot) {

        UserRepo.REGISTRATION_DETAILS.get(chatId).setPassword(token);

        bot.execute(new SendMessage(chatId.toString(),"Now enter the e-mail address of recipient :)"));

        UserRepo.STEPS.put(chatId,Steps.RECIPIENT_ADDRESS);

    }

    @SneakyThrows
    public static void recipientAddress(Long chatId, String recipientAddress, TelegramLongPollingBot bot) {

        if(Checker.checkEmail(recipientAddress)){
        UserRepo.MESSAGE_DETAILS.put(chatId,new MessageDetails(recipientAddress));
        bot.execute(new SendMessage(chatId.toString(),"Enter the subject of the message"));
        UserRepo.STEPS.put(chatId,Steps.SUBJECT);

        }else {
            bot.execute(new SendMessage(chatId.toString(),"Please enter a valid and exist e-mail address :(" ));
            UserRepo.STEPS.put(chatId,Steps.RECIPIENT_ADDRESS);

        }
    }

    @SneakyThrows
    public static void putSubject(Long chatId, String Subject, TelegramLongPollingBot bot) {
        UserRepo.MESSAGE_DETAILS.get(chatId).setSubject(Subject);
        bot.execute(new SendMessage(chatId.toString(),"Enter the text :"));
        UserRepo.STEPS.put(chatId,Steps.MESSAGE);
    }

    @SneakyThrows
    public static void putMessage(Long chatId, String text, TelegramLongPollingBot bot) {
        UserRepo.MESSAGE_DETAILS.get(chatId).setText(text);

        MailManager.sendMail(UserRepo.MESSAGE_DETAILS.get(chatId),UserRepo.REGISTRATION_DETAILS.get(chatId));

        bot.execute(new SendMessage(chatId.toString(),"Your message has been sent and " +
                "\n Here are details :"+UserRepo.MESSAGE_DETAILS.get(chatId).toString()));
        UserRepo.STEPS.put(chatId,Steps.FINISHED);

    }

    @SneakyThrows
    public static void reSend(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),
                "If you want to send another message press /resend \n\n " +
                        "If you want to write from another e-mail address" +
                        " press /start :)"));
    }
}
