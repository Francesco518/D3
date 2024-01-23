package Exercise3;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog3 {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1L, "BoysProduct1", "Boys", 30.0),
                new Product(2L, "Phone", "Electronics", 200.0),
                new Product(3L, "BoysProduct2", "Boys", 40.0),
                new Product(4L, "Blanket", "Home Service", 50.0)
        );
        List<Product> discountedBoysProducts = products.stream()
                .filter(product -> "Boys".equals(product.getCategory()))
                .map(product -> new Product(product.getId(), product.getName(), product.getCategory(), product.getPrice() * 0.9))
                .collect(Collectors.toList());

        System.out.println("Discounted Boys Products:");
        discountedBoysProducts.forEach(product ->
                System.out.println("Product ID: " + product.getId() +
                        ", Name: " + product.getName() +
                        ", Category: " + product.getCategory() +
                        ", Discounted Price: " + product.getPrice()));
    }
}
