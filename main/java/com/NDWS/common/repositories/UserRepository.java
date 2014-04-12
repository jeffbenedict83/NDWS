package com.NDWS.common.repositories;

import com.NDWS.common.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/10/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    public User findByUsername(String username);
    public User getByUsername(String username);
}
