package com.test.ibrax.repositories;

import com.test.ibrax.documents.User;
import org.springframework.stereotype.Repository;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@supinfo.com>
 */
@Repository
public interface UserRepository extends BaseRepository<User, String> {

    User findByUsername(final String username);

    User findByUsernameAndPassword(final String username, final String password);

    boolean existsByUsername(String username);
}
