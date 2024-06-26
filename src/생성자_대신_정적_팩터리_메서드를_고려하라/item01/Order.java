package 생성자_대신_정적_팩터리_메서드를_고려하라.item01;


// 장점 1. 이름을 가질 수 있다. (동일한 시그니처의 생성자를 두개 가질 수 없다)

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    public static void main(String[] args) {

        // 1
        // 장점 1: 정적팩토리 메서드를 통해서 마치 이름이 있는 생성자를 구현하는것처럼 표현할 수 있다.
        // 장점 1: 특정 상태의 값을 가지고 있는 생성자를 구현하려 사용할 수 있다.
        Order primeOrder = Order.primeOrder(new Product());
        Order urgentOrder = Order.urgentOrder(new Product());

        Arrays.stream(OrderStatus.values()).forEach(it -> System.out.println(it));

        EnumSet<OrderStatus> orderStatuses = EnumSet.allOf(OrderStatus.class);
        EnumMap<OrderStatus, String> orderStatusStringEnumMap = new EnumMap<>(OrderStatus.class);

        orderStatuses.stream().forEach(it -> System.out.println(it));

        System.out.println(OrderStatus.DELIVERING == OrderStatus.DELIVERY);

    }

    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

}

