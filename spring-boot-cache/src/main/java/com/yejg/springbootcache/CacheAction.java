package com.yejg.springbootcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yejg
 * @since 2020-04-29
 */
@RestController
public class CacheAction {

    @Autowired
    private CacheService cacheService;

    @GetMapping("get")
    public User  get(@RequestParam int id){
        return cacheService.get(id);
    }

    @PostMapping("set")
    public User  set(@RequestParam int id, @RequestParam String code, @RequestParam String name){
        User u = new User(code, name);
        return cacheService.set(id, u);
    }

    @DeleteMapping("del")
    public void  del(@RequestParam int id){
        cacheService.del(id);
    }

}
