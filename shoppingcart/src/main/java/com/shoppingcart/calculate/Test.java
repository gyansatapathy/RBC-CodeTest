package com.shoppingcart.calculate;

import com.shoppingcart.bean.ShoppingItem;
import com.shoppingcart.exception.CartExceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gyan on 6/30/2017.
 */
public class Test {
    public static void main(String[] args) {
        ShoppingItem item1 =new ShoppingItem();

        item1.setItemName("oranges");
        item1.setQuantity(2);
        ShoppingItem item2 =new ShoppingItem();
        item2.setItemName("bananas");
        item2.setQuantity(4);
        List<ShoppingItem> itemList = new ArrayList<ShoppingItem>();
        itemList.add(item1);
        itemList.add(item2);

        ItemComputor compute=new ItemComputor();

        try {
            System.out.println(compute.getItemSum(itemList));
        } catch (CartExceptions exceptions) {
            exceptions.printStackTrace();
        }

    }
}
