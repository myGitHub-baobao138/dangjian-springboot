package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.system.operationLog.FindOperationLogPageInfo;
import com.partybuilding.webserver.dto.system.operationLog.OperationLogDTO;
import com.partybuilding.webserver.dto.system.right.URLS;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysOperationLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysOperationLog record);

    int insertSelective(SysOperationLog record);

    SysOperationLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysOperationLog record);

    int updateByPrimaryKey(SysOperationLog record);

    int insertManyLogs(List<SysOperationLog> leaveManyLogs);

    /**
     * 查询操作页面和内容
     */
    SysOperationLog selectPageAndContent(URLS dto);

    /**
     * 查询系统日志
     * @return
     */
    List<OperationLogDTO> findOperationLog(FindOperationLogPageInfo dto);

    /**
     * 添加系统日志
     * @param log
     * @return
     */
    int addOperationLog(SysOperationLog log);

    /**
     * 查询出操作人员姓名
     * @param operatorName
     * @return
     */
    List<String>  findOperatorName(String operatorName);
}