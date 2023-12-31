package uz.pdp.bot;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.bot.handler.order.basket.BasketRepo;

import java.util.List;

public class ButtonUtils {

  public static   InlineKeyboardMarkup BUTTONS_RESTAURANTS = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Evos").callbackData("evos").build(),
                    InlineKeyboardButton.builder().text("Max Way").callbackData("max_way").build()
            ))

            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Oqtepa lavash").callbackData("oqtepa").build(),
                    InlineKeyboardButton.builder().text("LOOOK").callbackData("look").build()
            ))
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().text("Back ↩️").callbackData("back_to_help").build()
          )).build();

  public static InlineKeyboardMarkup FIELDS = InlineKeyboardMarkup.builder()
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().callbackData("meals").text("Meals").build(),
                  InlineKeyboardButton.builder().text("Drinks").callbackData("drinks").build(),
                  InlineKeyboardButton.builder().callbackData("other").text("Others").build()
          ))
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().callbackData("back_to_restaurants").text("Back ↩️").build()
          )).build();

  public static InlineKeyboardMarkup MENU_FAST_FOOD = InlineKeyboardMarkup.builder()
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().text("Barbeque burger").callbackData("barbeque_burger").build(),
                  InlineKeyboardButton.builder().text("Chicken cheeseburger").callbackData("chicken_cheeseburger").build()
          ))
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().callbackData("chicken_burger").text("Chicken burger").build(),
                  InlineKeyboardButton.builder().callbackData("double_chicken_cheese").text("Double chicken cheese").build()
          ))
          .keyboardRow(List.of(
                  InlineKeyboardButton.builder().callbackData("back").text("Back ↩️").build()
          )).build();

    public static InlineKeyboardMarkup MENU_DRINKS = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Fanta").callbackData("fanta").build(),
                    InlineKeyboardButton.builder().text("Sprite").callbackData("sprite").build(),
                    InlineKeyboardButton.builder().text("Montella").callbackData("montella").build()
            ))
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().callbackData("back").text("Back ↩️").build()
            )).build();

    public static InlineKeyboardMarkup OTHERS_MENU = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().text("Greek salad").callbackData("greek_salad").build(),
                    InlineKeyboardButton.builder().text("Sezar salad").callbackData("sezar_salad").build(),
                    InlineKeyboardButton.builder().text("Sezam salad").callbackData("sezam_salad").build()
            ))
            .keyboardRow(List.of(
                    InlineKeyboardButton.builder().callbackData("back").text("Back ↩️").build()
            )).build();


    public static InlineKeyboardMarkup getBasketButtons(Long productId,Long chatId, Integer quantity){




        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("-").callbackData("minus;" + productId+";"+quantity).build(),
                        InlineKeyboardButton.builder().text(String.valueOf(quantity)).callbackData("quantity").build(),
                        InlineKeyboardButton.builder().text("+").callbackData("plus;" + productId+";"+quantity).build()
                ))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().callbackData("add_to_basket").text("Add to basket 🧺").build()
                )).build();

        return build;
    }


    public static ReplyKeyboard addToBasketButtons() {

        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Clear basket").callbackData("clear_basket").build(),
                        InlineKeyboardButton.builder().text("Go to payment").callbackData("do_payment").build()
                ))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().callbackData("back").text("Back ↩️").build()
                )).build();

    }

    public static ReplyKeyboard wayOfPayment() {
        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Click").callbackData("clear_basket").build(),
                        InlineKeyboardButton.builder().text("Pay me").callbackData("do_payment").build()
                )).build();

    }
}
