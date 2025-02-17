package cart.repository;

import cart.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Laptop", 1200.0));
        products.add(new Product(2, "Smartphone", 800.0));
        products.add(new Product(3, "TV", 400.0));
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}