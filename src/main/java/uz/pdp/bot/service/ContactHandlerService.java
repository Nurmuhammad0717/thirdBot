package uz.pdp.bot.service;

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
    private static final List<Person> data = InfoManager.getInfos();


    @SneakyThrows
    public static void searchPerson(Long chatId, TelegramLongPollingBot bot) {
        bot.execute(new SendMessage(chatId.toString(),"/id_Search - searching by id\n" +
                "/firstName_search - searching by first name\n" +
                "/lastName_search - searching by last name\n" +
                "/phoneNumber_search - searching by phone number\n" +
                "/birthDate_search - searching by birth date\n" +
                "/fullInfo_search - searching by full info "));
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
        }
    }
}
