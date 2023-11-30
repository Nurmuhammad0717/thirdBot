package uz.pdp.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonUtils {

  public static   InlineKeyboardMarkup BUTTONS_RESTAURANTS = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Evos").callbackData("evos").build(),
                    InlineKeyboardButton.builder().text("Max Way").callbackData("max_way").build()
            ))

            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Oqtepa lavash").callbackData("oqtepa").build(),
                    InlineKeyboardButton.builder().text("LOOOK").callbackData("street77").build()
            )).build();

  public static InlineKeyboardMarkup FIELDS = InlineKeyboardMarkup.builder()
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().callbackData("meals").text("Meals").build(),
                  InlineKeyboardButton.builder().text("Drinks").callbackData("drinks").build(),
                  InlineKeyboardButton.builder().callbackData("other").text("Others").build()
          )).build();

  public static InlineKeyboardMarkup MENU_FAST_FOOD = InlineKeyboardMarkup.builder()
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().text("Barbeque burger").callbackData("barbeque_burger").build(),
                  InlineKeyboardButton.builder().text("Chicken cheeseburger").callbackData("chicken_cheeseburger").build()
          ))
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().callbackData("chicken_burger").text("Chicken burger").build(),
                  InlineKeyboardButton.builder().callbackData("double_chicken_cheese").text("Double chicken cheese").build()
          )).build();

    public static InlineKeyboardMarkup MENU_DRINKS = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Fanta").callbackData("fanta").build(),
                    InlineKeyboardButton.builder().text("Sprite").callbackData("sprite").build(),
                    InlineKeyboardButton.builder().text("Montella").callbackData("montella").build()
            )).build();

    public static InlineKeyboardMarkup OTHERS_MENU = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Greek salad").callbackData("greek_salad").build(),
                    InlineKeyboardButton.builder().text("Sezar salad").callbackData("sezar_salad").build(),
                    InlineKeyboardButton.builder().text("Sezam salad").callbackData("sezam_salad").build()
            )).build();

}
