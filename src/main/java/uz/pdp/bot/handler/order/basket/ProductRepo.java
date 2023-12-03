package uz.pdp.bot.handler.order.basket;

import uz.pdp.bot.handler.order.basket.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    public static final List<Product> PRODUCT_LIST = new ArrayList<>();

    static {
        PRODUCT_LIST.addAll(
                List.of(Product.builder().id(1L).name("Barbeque burger").description("burger").price(27000F).build(),
                        Product.builder().id(2L).name("Chicken burger").description("burger").price(27000F).build(),
                        Product.builder().id(3L).name("Chicken cheeseburger").description("burger").price(30000F).build(),
                        Product.builder().id(4L).name("Double chicken cheeseburger").description("burger").price(35000F).build(),
                        Product.builder().id(5L).name("Fanta").description("beverage").price(7000F).build(),
                        Product.builder().id(6L).name("Montella").description("beverage").price(3000F).build(),
                        Product.builder().id(7L).name("Sprite").description("beverage").price(7000F).build(),
                        Product.builder().id(8L).name("Sezar salad").description("salad").price(21000F).build(),
                        Product.builder().id(9L).name("Sezam salad").description("salad").price(24000F).build(),
                        Product.builder().id(10L).name("Greek salad").description("salad").price(25000F).build()
                        )
        );

    }

    public static Product getById(Long id) {
        return PRODUCT_LIST.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElseThrow(
                        () -> new IllegalStateException("Product not found with id - " + id)
                );
    }

}
