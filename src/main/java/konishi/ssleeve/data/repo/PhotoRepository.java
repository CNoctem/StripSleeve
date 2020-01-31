package konishi.ssleeve.data.repo;

import konishi.ssleeve.data.Photo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

    @Query(value = "SELECT * FROM PHOTOS WHERE OWNER_ID=:uid", nativeQuery = true)
    Iterable<Photo> findByUserId(@Param("uid") int uid);

}
