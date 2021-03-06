package mate.academy.internetshop.service.impl;

import java.util.Optional;

import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private static UserDao userDao;

    @Override
    public User create(User user) {

        return userDao.create(user);
    }

    @Override
    public Optional<User> get(Long id) {

        return userDao.get(id);
    }

    @Override
    public Optional<User> update(User user) {

        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {

        userDao.delete(id);
    }
}
