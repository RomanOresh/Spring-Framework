package cart.service;

import cart.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
@Scope("prototype")
public class Cart {
    private final List<Product> items = new ArrayList<>();

    public void add(Product product) {
        if (product != null) {
            items.add(product);
            System.out.println("Товар добавлен: " + product.getName());
        } else {
            System.out.println("Товар не найден");
        }
    }

    public void remove(int productId) {
        items.removeIf(p -> p.getId() == productId);
        System.out.println("Товар с ID " + productId + " удален с вашей корзины");
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Корзина пустая!");
        } else {
            System.out.println("\nВаша корзина:");
            items.forEach(System.out::println);
        }
    }
}