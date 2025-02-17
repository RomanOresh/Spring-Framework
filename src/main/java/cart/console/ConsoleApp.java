package cart.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import cart.repository.ProductRepository;
import cart.service.Cart;

import java.util.Scanner;

@Component
public class ConsoleApp implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final ApplicationContext context;

    @Autowired
    public ConsoleApp(ProductRepository productRepository, ApplicationContext context) {
        this.productRepository = productRepository;
        this.context = context;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = context.getBean(Cart.class);

        while (true) {
            System.out.println("\nДоступные команды:\n" +
                    "1. Показать все товары\n" +
                    "2. Добавить товар в корзину\n" +
                    "3. Удалить товар с корзины\n" +
                    "4. Показать корзину\n" +
                    "5. Выйти\n" +
                    "Выберите опцию:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> productRepository.getAll().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Введите ID товара для добавления в корзину ");
                    int id = scanner.nextInt();
                    cart.add(productRepository.getById(id));
                }
                case 3 -> {
                    System.out.print("Введите ID товара для удаления с корзины ");
                    int id = scanner.nextInt();
                    cart.remove(id);
                }
                case 4 -> cart.showCart();
                case 5 -> {
                    System.out.println("Выход");
                    return;
                }
                default -> System.out.println("Ошибка!");
            }
        }
    }
}