package Exercise4;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog {
    public static void main(String[] args) {
        // Sample data setup
        List<Product> products = List.of(
                new Product(1L, "Product1", "Category1", 100.0),
                new Product(2L, "Product2", "Category2", 150.0),
                new Product(3L, "Product3", "Category1", 200.0)
        );
        List<Customer> customers = List.of(
                new Customer(1L, "Customer1", 1),
                new Customer(2L, "Customer2", 2),
                new Customer(3L, "Customer3", 2)
        );
        List<Order> orders = List.of(
                new Order(1L, "Delivered", LocalDate.parse("2021-03-15"), LocalDate.parse("2021-03-20"),
                        List.of(products.get(0), products.get(1)), customers.get(1)),
                new Order(2L, "Processing", LocalDate.parse("2021-02-10"), LocalDate.parse("2021-02-15"),
                        List.of(products.get(2)), customers.get(2))

        );
        List<Product> productsOrderedByTier2Customers = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 &&
                        order.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) &&
                        order.getOrderDate().isBefore(LocalDate.parse("2021-04-01")))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Products ordered by tier 2 customers between 01-Feb-2021 and 01-Apr-2021:");
        productsOrderedByTier2Customers.forEach(product ->
                System.out.println("Product ID: " + product.getId() +
                        ", Name: " + product.getName() +
                        ", Category: " + product.getCategory() +
                        ", Price: " + product.getPrice()));
    }
}
