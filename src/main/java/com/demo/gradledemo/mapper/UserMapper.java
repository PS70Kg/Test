package com.demo.gradledemo.mapper;

import com.demo.gradledemo.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select count(*) from user")
    long count();

    // @Select("select * from user order by id limit #{beginIndex},#{pageSize}")
    //List<User> selectAll(@Param("beginIndex") int beginIndex,@Param("pageSize") int pageSize);

    @SelectProvider(type = UserDaoProvider.class, method = "selectAll")
    public List<User> selectAll(@Param("beginIndex") int beginIndex, @Param("pageSize") int pageSize, @Param("search") String search);

    class UserDaoProvider {
        public String selectAll(@Param("beginIndex") int beginIndex, @Param("pageSize") int pageSize, @Param("search") String search) {
            String sql = "select * from user";
            if (search != "") {
                sql = sql + " where name like concat(concat('%',#{search},'%')) or cast(age as char) like concat(concat('%',#{search},'%')) order by id limit #{beginIndex},#{pageSize}";
                return sql;
            }
            sql = sql + " order by id limit #{beginIndex},#{pageSize}";
            return sql;
        }
    }

    @Insert("insert into user(id,name,age) values(#{id},#{name},#{age})")
    int insertOne(User user);

    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    int updateOne(User user);

    @Delete("delete from user where id=#{id}")
    int deleteOne(int id);
}
