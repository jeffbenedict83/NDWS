package com.NDWS.common.repositories;

import com.NDWS.common.beans.UserFacebookProfilePhoto;
import com.NDWS.common.beans.UserProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/10/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserFacebookProfilePhotoRepository extends CrudRepository<UserFacebookProfilePhoto, Integer>{

    @Modifying
    @Transactional
    @Query("DELETE FROM UserFacebookProfilePhoto ufpp WHERE ufpp.ndwsUserId=:ndwsUserId")
    public void deleteAllFacebookProfilePhotosForUser(@Param("ndwsUserId") int ndwsUserId);

    @Query("select ufpp FROM UserFacebookProfilePhoto ufpp WHERE ufpp.ndwsUserId=:ndwsUserId")
    public ArrayList<UserFacebookProfilePhoto> findAllFacebookProfilePhotosForUser(@Param("ndwsUserId") int ndwsUserId);
}
