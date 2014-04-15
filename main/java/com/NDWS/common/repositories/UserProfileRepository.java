package com.NDWS.common.repositories;

import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserProfile;
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
public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>{
    public UserProfile findByNdwsUserId(int ndwsUserId);
    public UserProfile getByNdwsUserId(int ndwsUserId);
    public UserProfile getByUsername(String username);
    public UserProfile getByUsernameAndNdwsUserIdNot(String username, int ndwsUserId);
}
