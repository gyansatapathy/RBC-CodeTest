package com.shoppingcart.calculate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.shoppingcart.bean.ShoppingItem;
import com.shoppingcart.exception.CartExceptions;


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
        double price=0.0;
        try {
        	InputStream isr= new FileInputStream("ItemList.properties");
            Properties props = new Properties();
        	 props.load(isr);
        	 price=Double.parseDouble(props.getProperty(itemName.toUpperCase()));
        	}
        catch (NullPointerException ne){
        	 throw new CartExceptions("Price not Found for " + itemName, "Item Not Found");
        } 
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return price;
    }
}
