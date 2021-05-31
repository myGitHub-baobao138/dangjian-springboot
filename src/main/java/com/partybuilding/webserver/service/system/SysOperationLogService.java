package com.partybuilding.webserver.service.system;


import com.partybuilding.webserver.dto.system.operationLog.AddOperationLogRequestDTO;
import com.partybuilding.webserver.dto.system.operationLog.FindOperationLogPageInfo;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface SysOperationLogService {
    /**
     * 查询系统日志
     * @return
     * @param dto
     */
    PageResult findOperationLog(FindOperationLogPageInfo dto);

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
    List<String> findOperatorName(String operatorName);
}
