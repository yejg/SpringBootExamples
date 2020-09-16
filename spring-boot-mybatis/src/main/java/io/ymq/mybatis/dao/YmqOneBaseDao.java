package io.ymq.mybatis.dao;

import io.ymq.mybatis.dao.base.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 描述:数据源 one
 *
 * @author yanpenglei
 * @create 2017-10-20 11:27
 **/
@Repository
public class YmqOneBaseDao extends BaseDao {

    // 这里是 dao指定 sqlSessionFactorYmqOne（创建自DBOneConfiguration）
    // XPE 通过 AbstractRoutingDataSource 实现动态数据源
    @Resource
    public void setSqlSessionFactorYmqOne(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
