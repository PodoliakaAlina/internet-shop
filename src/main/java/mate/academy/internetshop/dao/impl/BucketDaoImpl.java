package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Bucket;

@Dao
public class BucketDaoImpl implements BucketDao {
    @Override
    public Bucket create(Bucket bucket) {
        Storage.buckets.add(bucket);
        return bucket;
    }

    @Override
    public Optional<Bucket> get(Long id) {
        return Optional.ofNullable(Storage.buckets
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find bucket with id " + id)));
    }

    @Override
    public Optional<Bucket> update(Bucket bucket) {
        Optional<Bucket> updateBucket = get(bucket.getId());
        updateBucket.get().setItems(bucket.getItems());

        return updateBucket;
    }

    @Override
    public void delete(Long id) {

        Storage.buckets.removeIf(bucket -> bucket.getId().equals(id));
    }
}
