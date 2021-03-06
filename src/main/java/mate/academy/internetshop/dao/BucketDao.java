package mate.academy.internetshop.dao;

import java.util.Optional;

import mate.academy.internetshop.model.Bucket;

public interface BucketDao {

    Bucket create(Bucket bucket);

    Optional<Bucket> get(Long id);

    Optional<Bucket> update(Bucket bucket);

    void delete(Long id);

}
