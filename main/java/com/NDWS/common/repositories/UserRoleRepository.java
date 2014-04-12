package com.NDWS.common.repositories;

import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserRole;
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
public interface UserRoleRepository extends CrudRepository<UserRole, Integer>{
    public User getByNdwsUserId(int ndwsUserId);
}
