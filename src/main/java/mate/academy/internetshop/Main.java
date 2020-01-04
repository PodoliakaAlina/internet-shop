package mate.academy.internetshop;

import java.util.List;

import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.BucketService;
import mate.academy.internetshop.service.ItemService;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.UserService;

public class Main {

    @Inject
    private static UserService userService;
    @Inject
    private static OrderService orderService;
    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        User userTest = userService.create(new User("UserTest"));

        Bucket bucketUserTest = new Bucket(userTest.getId());
        bucketService.create(bucketUserTest);

        Item item1 = itemService.create(new Item("item1", 1.0));
        Item item2 = itemService.create(new Item("item2", 2.0));

        bucketService.addItem(bucketUserTest.getId(), item1.getId());
        bucketService.addItem(bucketUserTest.getId(), item2.getId());

        orderService.completeOrder(bucketUserTest.getItems(), userTest);
        bucketService.clear(bucketUserTest);

        List<Order> ordersForUserTest = orderService.getUserOrders(userTest);
        System.out.println(ordersForUserTest);

    }
}
