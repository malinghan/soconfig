package com.so.soconfig.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.so.soconfig.server.model.Configs;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
@Mapper
@Repository
public interface ConfigsMapper {

    @Select("select * from configs where app=#{app} and env=#{env} and ns=#{ns}")
    List<Configs> list(String app, String env, String ns);

    @Select("select * from configs where app=#{app} and env=#{env} and ns=#{ns} and pkey=#{pkey} limit 1")
    Configs select(String app, String  env, String ns, String pkey);

    @Insert("insert into configs (app, env, ns, pkey, pval) values (#{app}, #{env}, #{ns}, #{pkey}, #{pval})")
    int insert(Configs configs);

    @Update("update configs set pval=#{pval} where app=#{app} and env=#{env} and ns=#{ns} and pkey=#{pkey}")
    int update(Configs configs);
}
