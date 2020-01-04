package mate.academy.internetshop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private static OrderDao orderDao;
    @Inject
    private static UserDao userDao;

    @Override
    public Order create(Order order) {

        return orderDao.create(order);
    }

    @Override
    public Optional<Order> get(Long id) {

        return orderDao.get(id);
    }

    @Override
    public Optional<Order> update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public void delete(Long id) {

        orderDao.delete(id);
    }

    @Override
    public Order completeOrder(List<Item> items, User user) {
        Order order = new Order(items, user.getId());
        orderDao.create(order);
        userDao.get(user.getId()).get().getOrders().add(order);
        return order;
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return Storage.orders
                .stream()
                .filter(o -> o.getUserId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}
