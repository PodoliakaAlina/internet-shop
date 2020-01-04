package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Item;

@Dao
public class ItemDaoImpl implements ItemDao {
    @Override
    public Item create(Item item) {
        Storage.items.add(item);
        return item;
    }

    @Override
    public Optional<Item> get(Long id) {
        return Optional.ofNullable(Storage.items
                .stream()
                .filter(item -> item.getId() == (id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find item with id " + id)));
    }

    @Override
    public Optional<Item> update(Item item) {
        Optional<Item> updateItem = get(item.getId());
        updateItem.get().setName(item.getName());
        updateItem.get().setPrice(item.getPrice());

        return updateItem;
    }

    @Override
    public void delete(Long id) {

        Storage.items.removeIf(item -> item.getId() == id);
    }

    @Override
    public void delete(Item item) {
        Storage.items.removeIf(i -> i.equals(item));
    }
}
