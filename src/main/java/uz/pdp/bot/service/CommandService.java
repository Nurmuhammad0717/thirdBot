package uz.pdp.bot.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class CommandService {

    public static void callbackQueryStart(final Message message, final TelegramLongPollingBot bot) {

        InlineKeyboardMarkup keyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Search by Id").callbackData("id").build(),
                        InlineKeyboardButton.builder().text("Search by first name").callbackData("firstName").build()))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Search by last name").callbackData("lastName").build(),
                        InlineKeyboardButton.builder().text("Search by phone number").callbackData("phoneNumber").build()))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Search by birth date").callbackData("birthDate").build(),
                        InlineKeyboardButton.builder().text("Search by any information").callbackData("anyInfo").build()
                )).build();


    }


}
