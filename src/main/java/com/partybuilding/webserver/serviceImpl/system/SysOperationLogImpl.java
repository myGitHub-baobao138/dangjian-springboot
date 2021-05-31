package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysOperationLogMapper;
import com.partybuilding.webserver.dto.system.operationLog.AddOperationLogRequestDTO;
import com.partybuilding.webserver.dto.system.operationLog.FindOperationLogPageInfo;
import com.partybuilding.webserver.dto.system.operationLog.OperationLogDTO;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import com.partybuilding.webserver.service.system.SysOperationLogService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysOperationLogImpl implements SysOperationLogService {
    @Autowired
    private SysOperationLogMapper operationLogMapper;

    /**
     * 查询系统日志
     * @return
     * @param dto
     */
    @Override
    public PageResult findOperationLog(FindOperationLogPageInfo dto){
        //  判断参数是否有误
        if (dto.getCurrentPage() <= 0) {
            dto.setCurrentPage(1);  //设置默认当前页
        }
        if (dto.getPageSize() <= 0) {
            dto.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<OperationLogDTO> list;
        list = operationLogMapper.findOperationLog(dto);
        // 获取分页查询后的数据
        PageInfo<OperationLogDTO> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<OperationLogDTO> result = new PageResult<OperationLogDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    /**
     * 添加系统日志
     * @param log
     * @return
     */
    @Override
    public int addOperationLog(SysOperationLog log){
        SysOperationLog sysOperationLog = new SysOperationLog();
        sysOperationLog.setOperationTime(new Date());
        sysOperationLog.setId(UUID.randomUUID().toString().replaceAll("-",""));
        sysOperationLog.setPartyId(log.getPartyId());
        sysOperationLog.setOperationPage(log.getOperationPage());
        sysOperationLog.setOperationContent(log.getOperationContent());
        return operationLogMapper.addOperationLog(sysOperationLog);
    }

    /**
     * 查询出操作人员姓名
     * @param operatorName
     * @return
     */
    @Override
    public List<String> findOperatorName(String operatorName){
        if(operatorName==null){
            operatorName = "";
        }
        return operationLogMapper.findOperatorName(operatorName);
    }
}
