package uz.pdp.bot.handler.order.basket;

import java.util.HashMap;
import java.util.Map;

public class BasketRepo {

    public static Map<Long,Map<Long,Integer>> PRODUCT_MAP = new HashMap<>();

    public static void add(long chatId, Integer quantity, Long productId){

        if(PRODUCT_MAP.get(chatId)!=null){
            PRODUCT_MAP.get(chatId).put(productId,quantity);
        }else {
            Map<Long,Integer> map = new HashMap<>();
            map.put(productId,quantity);
            PRODUCT_MAP.put(chatId,map);
        }

    }
}
