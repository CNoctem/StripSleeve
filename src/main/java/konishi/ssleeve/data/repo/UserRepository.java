package konishi.ssleeve.data.repo;

import konishi.ssleeve.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER_PROFILE WHERE ID=:id", nativeQuery = true)
    User getById(@Param("id") int id);

}