package com.shoppingcart.calculate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.shoppingcart.bean.ShoppingItem;
import com.shoppingcart.exception.CartExceptions;

/**
 * Created by Gyan on 6/30/2017.
 */
public class TestShoppingCart {


    @Test
    //This will compute the total cost of the items in the basket. The unit price of each item are hard coded
    public void getTotalSumOfItems() {
        ShoppingItem item1 = new ShoppingItem();
        item1.setItemName("oranges");
        item1.setQuantity(1);
        ShoppingItem item2 = new ShoppingItem();
        item2.setItemName("bananas");
        item2.setQuantity(4);
        List<ShoppingItem> itemList = new ArrayList<ShoppingItem>();
        itemList.add(item1);
        itemList.add(item2);

        ItemComputor compute = new ItemComputor();
        try {
            assert (compute.getItemSum(itemList) == 212.0);
        } catch (CartExceptions ce) {
            System.out.println(ce);

        }
    }

    @Test
    //If the quantity is negative it will throw invalid quantity exception.
    public void noOfQuantityException() {
        ShoppingItem item1 = new ShoppingItem();
        item1.setItemName("oranges");
        item1.setQuantity(1);
        ShoppingItem item2 = new ShoppingItem();
        item2.setItemName("bananas");
        item2.setQuantity(-4);
        List<ShoppingItem> itemList = new ArrayList<ShoppingItem>();
        itemList.add(item1);
        itemList.add(item2);
        boolean flag=false;
        Computor compute = new ItemComputor();
        try {
            double price = compute.getItemSum(itemList);
        }
        catch (CartExceptions ce){
            System.err.println(ce);
            flag=true;
        }
        assert(flag);
        

    }
    @Test
    //If the item is not present in the list it will throw Item Not Found Exception
    public void itemNotFoundException(){
    	ShoppingItem item1 = new ShoppingItem();
        item1.setItemName("oranges");
        item1.setQuantity(1);
        ShoppingItem item2 = new ShoppingItem();
        item2.setItemName("grapes");
        item2.setQuantity(3);
        List<ShoppingItem> itemList = new ArrayList<ShoppingItem>();
        itemList.add(item1);
        itemList.add(item2);
        boolean flag=false;
        Computor compute = new ItemComputor();
        try {
            double price = compute.getItemSum(itemList);
        }
        catch (CartExceptions ce){
            System.err.println(ce);
            flag=true;
        }
        assert(flag);
        

    }
    	
    }



