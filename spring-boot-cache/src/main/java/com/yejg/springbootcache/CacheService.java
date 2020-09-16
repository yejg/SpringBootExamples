package com.yejg.springbootcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejg
 * @since 2020-04-29
 */
@Service
public class CacheService {

    Logger log = LoggerFactory.getLogger(CacheService.class);

    private Map<Integer, User> dataMap = new HashMap<Integer, User>() {
        {
            for (int i = 1; i < 10; i++) {
                User u = new User("code" + i, "name" + i);
                put(i, u);
            }
        }
    };

    // , condition = "#user.getCode()!='code1'"  写法不对？
    // 获取数据
    @Cacheable(value = {"cache", "test"}, key = "'user:' + #id")
    public User get(int id) {
        log.info("通过id{}查询获取", id);
        return dataMap.get(id);
    }

    // 更新数据
    @CachePut(value = "cache", key = "'user:' + #id")
    public User set(int id, User u) {
        log.info("更新id{}数据", id);
        dataMap.put(id, u);
        return u;
    }

    //删除数据
    @CacheEvict(value = "cache", key = "'user:' + #id")
    public void del(int id) {
        log.info("删除id{}数据", id);
        dataMap.remove(id);
    }

}
