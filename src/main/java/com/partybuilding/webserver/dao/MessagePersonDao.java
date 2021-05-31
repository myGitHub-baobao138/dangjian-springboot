package com.partybuilding.webserver.dao;

import com.partybuilding.webserver.entity.MessagePerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (MessagePerson)表数据库访问层
 *
 * @author makejava
 */
@Mapper
@Repository
public interface MessagePersonDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessagePerson queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MessagePerson> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param messagePerson 实例对象
     * @return 对象列表
     */
    List<MessagePerson> queryAll(MessagePerson messagePerson);

    /**
     * 新增数据
     *
     * @param messagePerson 实例对象
     * @return 影响行数
     */
    int insert(MessagePerson messagePerson);

    /**
     * 修改数据
     *
     * @param messagePerson 实例对象
     * @return 影响行数
     */
    int update(MessagePerson messagePerson);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 批量插入数据
     * @param list
     * @return
     */
    int insertAll(List<MessagePerson> list);

}