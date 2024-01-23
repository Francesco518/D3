import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog {

    public static void main(String[] args) {
        List<Order> orders = createSampleOrders();

        // Get a list of products that belong to the <Books> category and have a price > 100
        List<Product> distinctBooksOver100Price = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Books".equals(product.category) && product.getPrice() > 100)
                .distinct()
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Distinct Books with Price > 100:");
        distinctBooksOver100Price.forEach(product ->
                System.out.println("Product ID: " + product.id +
                        ", Name: " + product.name +
                        ", Category: " + product.category +
                        ", Price: " + product.getPrice()));
    }

    private static List<Order> createSampleOrders() {
        Product book1 = new Product(1L, "Book1", "Books", 120.0);
        Product book2 = new Product(2L, "Book2", "Books", 90.0);
        Product electronic1 = new Product(3L, "Electronic1", "Electronics", 150.0);

        Order order1 = new Order(101L, "Shipped", LocalDate.of(2021, 10, 1), LocalDate.of(2021, 10, 5),
                List.of(book1, electronic1), new Customer(1L, "John Doe", 2));

        Order order2 = new Order(102L, "Delivered", LocalDate.of(2021, 11, 15), LocalDate.of(2021, 11, 20),
                List.of(book2), new Customer(2L, "Alice Smith", 3));

        return List.of(order1, order2);
    }
}
