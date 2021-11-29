package com.patterson.memcache.controller;

import com.patterson.memcache.model.ArtUser;
import com.patterson.memcache.service.ArtUserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ArtUserController.
 *
 * @Description TODO
 * @Date 29/11/2021 11:17
 * @Created by Qinxiu Wang
 */
@RestController
public class ArtUserController {

  @Resource
  private ArtUserService artUserService;

  @PostMapping("reg")
  public String regUser() {
    artUserService.init();
    return "OK";
  }

  @GetMapping("/getAll")
  public List<ArtUser> getAllUser() {
    return artUserService.showAll(1);
  }

}
