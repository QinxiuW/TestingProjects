package com.patterson.memcache.repository;

import com.patterson.memcache.model.ArtUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * IArtUserRepository.
 *
 * @Description: IArtUserRepository
 * @Date 29/11/2021 11:06
 * @Created by Qinxiu Wang
 */
public interface IArtUserRepository extends JpaRepository<ArtUser, Integer> {

}
