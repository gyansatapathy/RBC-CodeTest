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
        ItemComputor compute = new ItemComputor();
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
        ItemComputor compute = new ItemComputor();
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



