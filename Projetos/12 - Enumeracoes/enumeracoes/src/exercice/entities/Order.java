package exercice.entities;

import exercice.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() { }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public double total() {
        double sum = 0;
        for (OrderItem item : orderItems) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ")
                .append(sdf.format(moment)).append("\n")
                .append("Order status: ")
                .append(status).append("\n")
                .append("Cliente: ")
                .append(client).append("\n")
                .append("Order itens:\n");
                for (OrderItem item : orderItems) {
                    sb.append(item).append("\n");
                }
                sb.append("Total price: $")
                        .append(String.format("%.2f", total()));
        return sb.toString();
    }
}
