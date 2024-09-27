package lldPractice.OMSSystem;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class OMSDemo {
    public static void main(String[] args) {
        // ORDER CAN BE GIVEN BY USER
        // ORDER PAYMENT CAN BE DONE BY USER
        // ORDER CAN BE MODIFIED / CANCELLED BY USER
        /*
        *  Entities : Order , OrderPayment , User
        *  Service : OrderService , OrderPaymentService
        *
        *
        * */
    }
}

// ENITITES
class Product{
    String productId;
    String productName;
    String description;
    //....
}
class OrderedProduct{
    String id;
    Product product;
    int qty;
}
class Order{
    String id;
    String orderId;
    OrderStatus status;
    List<OrderedProduct> products;
    OrderPayment orderPaymentDetail;
    OrderType orderType;
    String bookedBy;
    Order(OrderType orderType){
        this.orderType=orderType;
    }
}
enum OrderType{
    PRIME,NON_PRIME
}
enum OrderStatus{
    BOOKED, CANCELLED, DELIVERED
}
class User{
    String id;
    String name;
    String address;
}

class OrderPayment{
    String paymentType;
    double amount;
    OrderPaymentStatus status ;
}
enum OrderPaymentStatus{
    PAID , UNPAID ,UNDER_PROCESS
}

// SERIVCE
class OrderService{
    private static OrderService orderService;
    private static NotificationService notificationService;
    private ConcurrentHashMap<String,Order> orderRepo;
    private OrderService(){
        // db connection setup
        orderRepo=new ConcurrentHashMap<>();
        notificationService=new NotificationService(
                List.of(
                        new OrderSmsService(),
                        new OrderEmailService()
                )
        );
    }
    // SINGLETON PATTERN
    public static OrderService  getInstance(){
        if(orderService==null){
            synchronized (OrderService.class){
                orderService=new OrderService();
            }
        }
        return orderService;
    }

    //  cancellation / modification /  / payment
    // factory method , creation of order
    public synchronized Order createOrder(OrderType orderType, HashMap<String , Object> orderInfo){
        Order order=  switch (orderType){
            case PRIME -> new Order(OrderType.PRIME);
            case NON_PRIME -> new Order(OrderType.NON_PRIME);
            default -> throw new RuntimeException("UNEXPECTED ORDER TYPE RECIEVED");
        };
        orderRepo.put(order.id,order);
        return order;
    }

    public synchronized void processOrderPayment(PaymentStrategy paymentStrategy,Order order){
        // complete the payment
        paymentStrategy.processPayment(order);
        // notify the user -- observer service
        notificationService.notifyObservers();
    }

}

interface PaymentStrategy {
    boolean processPayment(Order order);
}
class COD implements PaymentStrategy{
    @Override
    public boolean processPayment(Order order) {
        order.orderPaymentDetail=new OrderPayment();
        order.orderPaymentDetail.paymentType="COD";
        return true;
    }
}

interface OrderUpdateObserver{
    void update();
}

class OrderSmsService implements OrderUpdateObserver{

    @Override
    public void update() {
        System.out.println("sending update about order to user via sms ");
    }
}

class OrderEmailService implements OrderUpdateObserver{

    @Override
    public void update() {
        System.out.println("sending update about order to user via email ");
    }
}

abstract class OrderUpdateObservable{
    OrderUpdateObservable(List<OrderUpdateObserver> observers){
        this.observers=observers;
    }
    List<OrderUpdateObserver> observers;
    public void notifyObservers(){
        observers.forEach(OrderUpdateObserver::update);
    }
}

class  NotificationService extends OrderUpdateObservable{
    NotificationService(List<OrderUpdateObserver>observers){
        super(observers);
    }
}


