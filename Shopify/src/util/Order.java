package util;

import java.util.HashMap;

public class Order {
    private int orderId;
    private HashMap<Integer,Integer> orderList = new HashMap<Integer, Integer>(); //******

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public HashMap<Integer, Integer> getOrderList() {
        return orderList;
    }

    public void setOrderList(HashMap<Integer, Integer> orderList) {
        this.orderList = orderList;
    }
}
