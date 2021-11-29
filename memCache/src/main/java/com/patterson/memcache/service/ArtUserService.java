package com.patterson.memcache.service;

import com.patterson.memcache.model.ArtUser;
import com.patterson.memcache.repository.IArtUserRepository;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;
import javax.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * ArtUserService.
 *
 * @Description TODO
 * @Date 29/11/2021 11:08
 * @Created by Qinxiu Wang
 */
@Service
public class ArtUserService {

  @Resource
  private IArtUserRepository artUserRepository;


  public void init() {
    IntStream.range(0, 1000).forEach(x -> {
      ArtUser user = initUser();
      artUserRepository.save(user);
    });
  }

  @Cacheable(value = "cache")
  public List<ArtUser> showAll(int id) {
    return artUserRepository.findAll();
  }

  @Cacheable(value = "cache", key = "#id")
  public ArtUser showById(int id) {
    return artUserRepository.findByUserId(id);
  }

  private ArtUser initUser() {
    String name = RandomStringUtils.randomAlphabetic(10);
    String password = RandomStringUtils.randomAlphabetic(10);
    return ArtUser.builder().name(name).email(name + "@email.com").password(password).build();
  }

}
