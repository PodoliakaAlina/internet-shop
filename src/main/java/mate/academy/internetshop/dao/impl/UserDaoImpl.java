package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.User;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Storage.users.add(user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.ofNullable(Storage.users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find user with id " + id)));
    }

    @Override
    public Optional<User> update(User user) {
        Optional<User> updateUser = get(user.getId());
        updateUser.get().setOrders(user.getOrders());

        return updateUser;
    }

    @Override
    public void delete(Long id) {
        Storage.users.removeIf(u -> u.getId().equals(id));
    }
}
