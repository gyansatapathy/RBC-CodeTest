package com.shoppingcart.calculate;

import com.shoppingcart.bean.ShoppingItem;
import com.shoppingcart.exception.CartExceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Gyan on 6/30/2017.
 */
public class ItemComputor implements Computor{

    private double basketItemSum=0;

    /**
     *
     * @param shoppingItemList
     * @return Total Cost of items in basket
     * @throws CartExceptions
     */
    public double getItemSum(List<ShoppingItem> shoppingItemList) throws CartExceptions {
        if(!shoppingItemList.isEmpty()) {
            try {
                for (ShoppingItem shoppingItem : shoppingItemList) {
                    if (shoppingItem.getQuantity() > 0) {
                        basketItemSum = basketItemSum + (getBasePriceItem(shoppingItem.getItemName()) * (shoppingItem.getQuantity()));


                    } else {
                        throw new CartExceptions("Invalid quantity for item  " + shoppingItem.getItemName(), "Negative Quantity Exception");
                    }
                }

                return basketItemSum;
            } finally {

            }
        }
        else {
            return 0.0;
        }
    }

    /**
     *
     * @param itemName
     * @return Base Price of the item
     * @throws CartExceptions
     */

    public double getBasePriceItem(String itemName) throws CartExceptions{
        final Map<String, Double> itemBasePriceMap= new HashMap<String,Double>();
        double price=0.0;
        itemBasePriceMap.put("ORANGES",90.00);
        itemBasePriceMap.put("BANANAS",30.50);
        itemBasePriceMap.put("APPLES",150.50);
        itemBasePriceMap.put("LEMONS",40.0);
        itemBasePriceMap.put("PEACHES",120.0);
        try {
            price = itemBasePriceMap.get(itemName.toUpperCase());
        }
        catch (NullPointerException ne){
            throw new CartExceptions("Price not Found for " + itemName, "Item Not Found");
        }
        return price;
    }
}
