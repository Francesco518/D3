package exercise2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog2 {

    public static void main(String[] args) {
        List<Order> orders = createSampleOrders();

        // Get a list of orders with products that belong to the <Baby> category
        List<Order> babyCategoryOrders = orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> "Baby".equals(product.category)))
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Orders with products in the <Baby> category:");
        babyCategoryOrders.forEach(order ->
                System.out.println("Order ID: " + order.id +
                        ", Status: " + order.getStatus() +
                        ", Order Date: " + order.getOrderDate()));
    }

    private static List<Order> createSampleOrders() {
        Product babyProduct = new Product(1L, "BabyProduct", "Baby", 50.0);
        Product electronic1 = new Product(2L, "Electronic1", "Electronics", 150.0);

        Order order1 = new Order(101L, "Shipped", LocalDate.of(2021, 10, 1), LocalDate.of(2021, 10, 5),
                List.of(babyProduct, electronic1), new Customer(1L, "John Doe", 2));

        Order order2 = new Order(102L, "Delivered", LocalDate.of(2021, 11, 15), LocalDate.of(2021, 11, 20),
                List.of(electronic1), new Customer(2L, "Alice Smith", 3));

        return List.of(order1, order2);
    }
}
