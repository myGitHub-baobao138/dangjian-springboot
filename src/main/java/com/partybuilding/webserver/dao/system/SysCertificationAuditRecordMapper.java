package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.system.auditRecord.VerifyWxUserInputDTO;
import com.partybuilding.webserver.entity.system.SysCertificationAuditRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysCertificationAuditRecordMapper {

    /**
     * 插入审核记录
     * @param inputDTO
     * @return
     */
    boolean insertCertificationAuditRecord(VerifyWxUserInputDTO inputDTO);


    int deleteByPrimaryKey(String id);

    int insert(SysCertificationAuditRecord record);

    int insertSelective(SysCertificationAuditRecord record);

    SysCertificationAuditRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysCertificationAuditRecord record);

    int updateByPrimaryKey(SysCertificationAuditRecord record);

    /**
     * 获取组织下拉框数据
     * @param id
     * @return
     */
    List<Organization> getOrganizationDownById(String id);
}