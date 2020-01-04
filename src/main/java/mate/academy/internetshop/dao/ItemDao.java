package mate.academy.internetshop.dao;

import java.util.Optional;

import mate.academy.internetshop.model.Item;

public interface ItemDao {

    Item create(Item item);

    Optional<Item> get(Long id);

    Optional<Item> update(Item item);

    void delete(Long id);

    void delete(Item item);
}
