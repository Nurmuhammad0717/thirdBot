package uz.pdp.bot.handler.order.basket.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private Float price;

}
