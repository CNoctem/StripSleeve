package konishi.ssleeve.data.repo;

import konishi.ssleeve.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {}