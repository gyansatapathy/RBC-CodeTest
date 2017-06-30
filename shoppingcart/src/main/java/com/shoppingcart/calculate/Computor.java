package com.shoppingcart.calculate;

import com.shoppingcart.bean.ShoppingItem;
import com.shoppingcart.exception.CartExceptions;

import java.util.List;

/**
 * Created by Gyan on 6/30/2017.
 */
public interface Computor {
    public double getItemSum(List<ShoppingItem> shoppingItemList) throws CartExceptions;
}
