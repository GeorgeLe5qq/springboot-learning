package com.zccoder.springboot.dao;

import com.zccoder.springboot.domain.Person;
import com.zccoder.springboot.support.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 定义数据访问接口
 * Created by ZC on 2017/4/7.
 */
public interface PersonRepository extends CustomRepository<Person,Long> {

    // 使用方法名查询，接受一个name参数，返回值为列表。
    List<Person> findByAddress(String name);

    // 使用方法名查询，接受name和address，返回值为单个对象。
    Person findByNameAndAddress(String name,String address);

    // 使用 @Query 查询，参数按照名称绑定。
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);

    // 使用 @NamedQuery查询，请注意我们在实体类中做的@NamedQuery的定义
    List<Person> withNameAndAddressNamedQuery(String name,String address);
}
