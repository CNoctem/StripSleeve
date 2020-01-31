package konishi.ssleeve.data.repo;

import konishi.ssleeve.data.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    @Query(value = "SELECT * FROM ALBUM WHERE OWNER_ID=:uid", nativeQuery = true)
    Iterable<Album> getByUserId(@Param("uid") int uid);

}
