package com.NDWS.common.repositories;

import com.NDWS.common.beans.UserFacebook;
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
public interface UserFacebookRepository extends CrudRepository<UserFacebook, Integer>{
    public UserFacebook findByNdwsUserId(int ndwsUserId);
    public UserFacebook getByNdwsUserId(int ndwsUserId);
    public UserFacebook getByFacebookUsernameAndNdwsUserIdNot(String facebookUsername, int ndwsUserId);

}
