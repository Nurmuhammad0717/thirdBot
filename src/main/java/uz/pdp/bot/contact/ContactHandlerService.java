package uz.pdp.bot.contact;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.pdp.bot.contact.ContactRepo;
import uz.pdp.bot.contact.ContactStep;
import uz.pdp.bot.contact.InfoManager;
import uz.pdp.bot.contact.Person;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class ContactHandlerService {




    public ContactHandlerService() throws IOException {
    }
    private static final List<Person> data;

    static {
        try {
            data = InfoManager.getInfos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @SneakyThrows
    public static void searchPerson(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(), """
                /id_Search - searching by id\s
                /firstName_search - searching by first name
                /lastName_search - searching by last name
                /phoneNumber_search - searching by phone number
                /birthDate_search - searching by birth date
                /anyInfo_search - searching by any info\s"""));
    }


    @SneakyThrows
    public static void firstNameSearch( Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"Enter the name of person, you are looking for."));
        ContactRepo.CONTACT_STEP.put(chatId, ContactStep.FIRST_NAME);

    }

    @SneakyThrows
    public static void firstName(Long chatId, String text, TelegramLongPollingBot bot) {
        List<Person> result = data.stream().filter(person -> person.getFirstName().equals(text)).toList();
        if (!result.isEmpty()){
            StringBuilder res = new StringBuilder();
            for (Person person : result) {
                res.append("\n").append(person.toString());
            }
            bot.execute(new SendMessage(chatId.toString(), res.toString()));
        }else {
            bot.execute(new SendMessage(chatId.toString(), "Nothing is found ("));

        }
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FINISHED);

    }


    @SneakyThrows
    public static void lastNameSearch(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"Enter the last name of person, you are looking for."));
        ContactRepo.CONTACT_STEP.put(chatId, ContactStep.LAST_NAME);

    }

    @SneakyThrows
    public static void lastName(Long chatId, String text, TelegramLongPollingBot bot) {
        List<Person> result = data.stream().filter(person -> person.getLastName().equals(text)).toList();

        if (!result.isEmpty()){
            StringBuilder res = new StringBuilder();
            for (Person person : result) {
                res.append("\n").append(person.toString());
            }
            bot.execute(new SendMessage(chatId.toString(), res.toString()));
        }else{
            bot.execute(new SendMessage(chatId.toString(), "Nothing is found ("));

        }
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FINISHED);


    }

    @SneakyThrows
    public static void idSearch(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"Enter the id of person, you are looking for."));
        ContactRepo.CONTACT_STEP.put(chatId, ContactStep.ID);

    }

    @SneakyThrows
    public static void findId(Long chatId, Long text, TelegramLongPollingBot bot) {
        List<Person> result = data.stream().filter(person -> person.getId()==text).toList();

        if (!result.isEmpty()){
            StringBuilder res = new StringBuilder();
            for (Person person : result) {
                res.append("\n").append(person.toString());
            }
            bot.execute(new SendMessage(chatId.toString(), res.toString()));
        }else {
            bot.execute(new SendMessage(chatId.toString(), "Nothing is found ("));

        }
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FINISHED);

    }

    @SneakyThrows
    public static void phoneNumberSearch(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"Enter the phone number of person, you are looking for."));
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.PHONE_NUMBER);

    }

    @SneakyThrows
    public static void phoneNumber(Long chatId, String text, TelegramLongPollingBot bot) {

        List<Person> result = data.stream().filter(person -> person.getPhoneNumber().equals(text)).toList();

        if (!result.isEmpty()){
            StringBuilder res = new StringBuilder();
            for (Person person : result) {
                res.append("\n").append(person.toString());
            }
            bot.execute(new SendMessage(chatId.toString(), res.toString()));
        }else {
            bot.execute(new SendMessage(chatId.toString(), "Nothing is found ("));

        }
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FINISHED);


    }

    @SneakyThrows
    public static void birthDateSearch(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"Enter the birth date of person, you are looking for."));
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.BIRTH_DATE);

    }

    @SneakyThrows
    public static void birthDate(Long chatId, String text, TelegramLongPollingBot bot) {

        List<Person> result = data.stream().filter(person -> person.getBirthDate().equals(text)).toList();

        if (!result.isEmpty()){
            StringBuilder res = new StringBuilder();
            for (Person person : result) {
                res.append("\n").append(person.toString());
            }
            bot.execute(new SendMessage(chatId.toString(), res.toString()));
        }else {
            bot.execute(new SendMessage(chatId.toString(), "Nothing is found ("));

        }

        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FINISHED);


    }

    @SneakyThrows
    public static void fullInfoSearch(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"Enter the any information of person, you are looking for \n" +
                "in this pattern example: id=**\nfirstName=***\nlastname=***" +
                "gender=***\nphoneNumber=***..."));
        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FULL_INFO);

    }

    @SneakyThrows
    public static void fullInfo(Long chatId, String text, TelegramLongPollingBot bot) {

        List<Person> result = data.stream().filter(person -> {
            return person.toString().contains(text);
        }).toList();

        if (!result.isEmpty()){
            StringBuilder res = new StringBuilder();
            for (Person person : result) {
                res.append("\n").append(person.toString());
            }
            bot.execute(new SendMessage(chatId.toString(), res.toString()));
        }else {
            bot.execute(new SendMessage(chatId.toString(), "Nothing is found ("));

        }

        ContactRepo.CONTACT_STEP.put(chatId,ContactStep.FINISHED);

    }


    @SneakyThrows
    public static void finished(Long chatId, TelegramLongPollingBot bot) {
        bot.execute( new SendMessage(chatId.toString(),"If you want to search someone else press /search_person." +
                "\nIf you want use another function of bot press /help :)"));
    }
}
