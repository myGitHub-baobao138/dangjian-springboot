package com.partybuilding.webserver.serviceImpl.dynamic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.dynamic.DynamicPublishEssayMapper;
import com.partybuilding.webserver.dao.system.SysOperationLogMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.essay.*;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import com.partybuilding.webserver.service.dynamic.DyPublishEssayService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DyPublishEssayServiceImpl implements DyPublishEssayService {

    @Autowired(required = false)
    private DynamicPublishEssayMapper publishEssayMapper;

    @Autowired(required = false)
    private SysOperationLogMapper operationLogMapper;

    @Override
    //根据 二级组织id/或者校级 获取文章列表信息
    public JsonResult getPublishEssayListByOrganization(AllEssaysListDto getListDto) {

        //判断参数是否有误
        int currentPage = this.checkCurrentPage(getListDto.getCurrentPage());
        int pageSize = this.checkPageSize(getListDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        List<PublishEssayDto> allEssayList =  publishEssayMapper.getPublishEssayList(
                getListDto.getOrganizationId(),getListDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<PublishEssayDto> pageInfo = new PageInfo<>(allEssayList);
        // 封装需要返回的分页实体
        PageResult<PublishEssayDto> result = new PageResult<PublishEssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(allEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }

    //下架单篇文章
    @Override
    @Transactional
    public JsonResult makeSingleEssayLeave(CheckFormDto leaveFormDto) {

        JsonResult jsonResult = new JsonResult();

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        leaveFormDto.setCheckTime(timeStamp);

        int isLeave = publishEssayMapper.makeSingleEssayLeave(leaveFormDto.getCheckedEssayId(),
                leaveFormDto.getCheckerId(), leaveFormDto.getCheckTime(), leaveFormDto.getDetails());

        //判断是否下架成功
        if(isLeave>0){
            jsonResult.setMessage("下架成功");
            jsonResult.setCode(200);

            //根据传来的信息获得 下架所要新增的内容
            SysOperationLog Log = this.getSingleLog(leaveFormDto,"leaveOut" );

            //新增单个日志记录
            this.insertSingleLogSelective(Log);
        }else {
            jsonResult.setMessage("下架失败，请重试");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    //批量下架文章
    @Override
    @Transactional
    public JsonResult makeManyEssayLeave(CheckFormDto leaveFormDto) {

        JsonResult jsonResult = new JsonResult();

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        leaveFormDto.setCheckTime(timeStamp);

        int isLeaveList = publishEssayMapper.makeManyEssayLeave(leaveFormDto);

        if (isLeaveList == leaveFormDto.getCheckedIdList().size()){
            jsonResult.setMessage("批量下架成功");
            jsonResult.setCode(200);

            //获取批量下架日志内容
            List<SysOperationLog> logs = this.getManyLogs(leaveFormDto,"leaveOut");

            this.insertManyLogsSelective(logs);

        }else{
            jsonResult.setMessage("批量下架失败!");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    //发布单篇文章（草稿发布）
    @Override
    @Transactional
    public JsonResult publishSingleEssayFromList(CheckFormDto publishFormDto) {

        JsonResult jsonResult = new JsonResult();

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        publishFormDto.setCheckTime(timeStamp);

        int isPublish = publishEssayMapper.publishSingleEssayFromList(publishFormDto);

        if(isPublish >0){
            jsonResult.setMessage("此草稿发布成功!");
            jsonResult.setCode(200);

            //获得一条草稿发布操作日志信息
            SysOperationLog log = this.getSingleLog(publishFormDto,"publish");

            this.insertSingleLogSelective(log);
        }else{
            jsonResult.setMessage("此草稿发布失败!");
            jsonResult.setCode(500);
        }
        return  jsonResult;
    }

    //白写了 目测不需要
    //发布批量文章（草稿发布）
    @Override
    public JsonResult publishManyEssayFromList(CheckFormDto publishFormListDto) {
        JsonResult jsonResult = new JsonResult();

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        publishFormListDto.setCheckTime(timeStamp);

        System.out.println(publishFormListDto.getCheckTime() + "checkTime");
        int isPublishList = publishEssayMapper.publishManyEssayFromList(publishFormListDto);

        if(isPublishList == publishFormListDto.getCheckedIdList().size()){
            jsonResult.setMessage("批量发布成功");
            jsonResult.setCode(200);

            List<SysOperationLog> logs = this.getManyLogs(publishFormListDto,"publish");

            this.insertManyLogsSelective(logs);
        }else{
            jsonResult.setMessage("批量发布失败");
            jsonResult.setCode(500);
        }

        return jsonResult;
    }

    //置顶文章
    @Override
    public JsonResult setTop(CheckFormDto publishFormDto) {
        JsonResult jsonResult = new JsonResult();

        int isTop = publishEssayMapper.setTop(publishFormDto.getCheckedEssayId());
        if(isTop >0){
            jsonResult.setMessage("置顶成功");
            jsonResult.setCode(200);

            SysOperationLog log = this.getSingleLog(publishFormDto, "setTop");
            this.insertSingleLogSelective(log);
        }else{
            jsonResult.setMessage("置顶失败");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    //取消置顶
    @Override
    public JsonResult setOutTop(CheckFormDto publishFormDto) {
        JsonResult jsonResult = new JsonResult();

        int isTop = publishEssayMapper.setOutTop(publishFormDto.getCheckedEssayId());
        if(isTop >0){
            jsonResult.setMessage("取消置顶成功");
            jsonResult.setCode(200);

            SysOperationLog log = this.getSingleLog(publishFormDto, "setOutTop");
            this.insertSingleLogSelective(log);

        }else{
            jsonResult.setMessage("取消置顶失败");
            jsonResult.setCode(500);
        }

        return jsonResult;
    }

    //根据时间段获取 发布文章信息
    @Override
    public JsonResult queryByTimeZone(QueryEssayBodyDto queryBodyDto) {
        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        List<PublishEssayDto> allEssayList =  publishEssayMapper.queryByTimeZone(
                queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank(),
                queryBodyDto.getStartTime(), queryBodyDto.getEndTime());


        // 获取分页查询后的数据
        PageInfo<PublishEssayDto> pageInfo = new PageInfo<>(allEssayList);
        // 封装需要返回的分页实体
        PageResult<PublishEssayDto> result = new PageResult<PublishEssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(allEssayList);

        jsonResult.setData(result);

        if(allEssayList.size() ==0){
            jsonResult.setMessage("没有符合查询条件数据");
        }else{
            jsonResult.setMessage("查询成功！");
        }
        return jsonResult;
    }

    //根据输入内容获取 发布文章信息
    @Override
    public JsonResult queryByInputContent(QueryEssayBodyDto queryBodyDto) {
        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());
        PageHelper.startPage(currentPage, pageSize);

        JsonResult jsonResult = new JsonResult();
        List<PublishEssayDto> allEssayList = new ArrayList<>();

        int source = this.isQueryBySource(queryBodyDto);
        System.out.println("source"+ source);

        if(source == 0){
            //根据输入内容查询
            String inputContent = this.getInputContentSQL(queryBodyDto.getInputContent());
            allEssayList =  publishEssayMapper.queryByInputContent(
                    queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank(),
                    inputContent);
        }else{
            //根据文章来源查询
            allEssayList =  publishEssayMapper.queryBySource(
                    queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank(), source);
        }

        // 获取分页查询后的数据
        PageInfo<PublishEssayDto> pageInfo = new PageInfo<>(allEssayList);
        // 封装需要返回的分页实体
        PageResult<PublishEssayDto> result = new PageResult<PublishEssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(allEssayList);

        jsonResult.setData(result);

        if(allEssayList.size() ==0){
            jsonResult.setMessage("没有符合查询条件数据");
        }else{
            jsonResult.setMessage("查询成功！");
        }
        return jsonResult;
    }

    //根据输入内容和时间段获取 发布文章信息
    @Override
    public JsonResult getQueryByInputAndTime(QueryEssayBodyDto queryBodyDto) {
        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());
        PageHelper.startPage(currentPage, pageSize);

        JsonResult jsonResult = new JsonResult();
        List<PublishEssayDto> allEssayList = new ArrayList<>();

        int source = this.isQueryBySource(queryBodyDto);
        System.out.println("bothSource" + source);

        if(source == 0){
            //根据输入内容查询 和 时间段
            String inputContent = this.getInputContentSQL(queryBodyDto.getInputContent());
            allEssayList =  publishEssayMapper.queryByInputAndTime(
                    queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank(),
                    inputContent,
                    queryBodyDto.getStartTime(), queryBodyDto.getEndTime());
        }else{
            //根据文章来源查询 和时间段
            allEssayList =  publishEssayMapper.queryBySourceAndTime(
                    queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank(), source,
                    queryBodyDto.getStartTime(), queryBodyDto.getEndTime());
        }

        // 获取分页查询后的数据
        PageInfo<PublishEssayDto> pageInfo = new PageInfo<>(allEssayList);
        // 封装需要返回的分页实体
        PageResult<PublishEssayDto> result = new PageResult<PublishEssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(allEssayList);

        jsonResult.setData(result);

        if(allEssayList.size() ==0){
            jsonResult.setMessage("没有符合查询条件数据");
        }else{
            jsonResult.setMessage("查询成功！");
        }
        return jsonResult;
    }


    //删除草稿
    @Override
    public JsonResult deleteByEssayIdFromList(String essayId) {
        JsonResult jsonResult = new JsonResult();
        System.out.println("essayId" + essayId);
         int isDelete = publishEssayMapper.deleteByIdFromList(essayId);

         if(isDelete >0){
             jsonResult.setMessage("删除成功");
             jsonResult.setCode(200);

         }else{
             jsonResult.setMessage("删除失败");
             jsonResult.setCode(500);
         }

        return jsonResult;
    }

    //发布文字//保存草稿
    @Override
    public JsonResult insertNewEssay(InsertEssayDto insertEssayDto) {

        JsonResult jsonResult = new JsonResult();

        int checkStatus = insertEssayDto.getCheckStatus();//获取操作是发布还是保存

        insertEssayDto.setId(Uuid.getUuid());
        System.out.println(insertEssayDto.getId()+ "id");

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        insertEssayDto.setContributeTime(timeStamp);

        int isInsert = publishEssayMapper.insertNewEssay(insertEssayDto);

        if(isInsert >0){
            jsonResult.setCode(200);
            if(checkStatus == 1){
                jsonResult.setMessage("发布成功");
            }else{
                jsonResult.setMessage("草稿保存成功");
            }
        }else{
            if(checkStatus == 1){
                jsonResult.setMessage("发布失败");
            }else{
                jsonResult.setMessage("草稿保存失败");
            }
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    //获取要编辑的草稿信息
    @Override
    public JsonResult getUpdateEssayInf(String essayId) {
        JsonResult jsonResult = new JsonResult();

        InsertEssayDto updateEssayBody = publishEssayMapper.getUpdateEssayById(essayId);

        if(updateEssayBody.getId() != null || updateEssayBody.getId() != ""){
            jsonResult.setData(updateEssayBody);
            jsonResult.setCode(200);
            jsonResult.setMessage("获取草稿成功");
        }else{
            jsonResult.setCode(500);
            jsonResult.setMessage("获取草稿失败");

        }
        return jsonResult;
    }

    @Override
    public JsonResult updataEssayById(InsertEssayDto updateEssayDto) {
        JsonResult jsonResult = new JsonResult();

        int checkStatus = updateEssayDto.getCheckStatus();//获取修改类型 1--发布  -2保存草稿
        int isOperate = -1;//是否操作成功

        if(checkStatus ==1){
            //获取审核时间
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            updateEssayDto.setCheckTime(timeStamp);
            isOperate = publishEssayMapper.publishEssayById(updateEssayDto);

        }else{
            isOperate = publishEssayMapper.updateEssayById(updateEssayDto);
        }

        if(isOperate >0){
            jsonResult.setCode(200);
            if(checkStatus ==1){
                jsonResult.setMessage("发布成功");
                //获得一条草稿发布操作日志信息
                SysOperationLog log = this.getSingleLogFromOther(updateEssayDto);
                this.insertSingleLogSelective(log);

            }else{
                jsonResult.setMessage("保存成功");
            }

        }else{
            jsonResult.setCode(500);
            if(checkStatus ==1){
                jsonResult.setMessage("发布失败");

            }else{
                jsonResult.setMessage("保存失败");
            }
        }

        return jsonResult;
    }

    //新增一条操作记录
    @Transactional
    public void insertSingleLogSelective(SysOperationLog leaveSingleLog) {
        operationLogMapper.insertSelective(leaveSingleLog);
    }

    @Transactional
    //新增多条操作记录
    public void insertManyLogsSelective(List<SysOperationLog> logList){
        operationLogMapper.insertManyLogs(logList);
    }

    //判断是否为按文章来源查询
    private int isQueryBySource(QueryEssayBodyDto queryBodyDto) {
        int source = 0;
        System.out.println(queryBodyDto.getInputContent() + "isQueryBySource");
        if(queryBodyDto.getInputContent().equals("党员先锋")){
            source =1;
        }else if(queryBodyDto.getInputContent().equals("基层风采")){
            source =2;
        }else if(queryBodyDto.getInputContent().equals("党主题日")){
            source =3;
        }
        return source;
    }

    //获取在sql里面用的查询内容（ "%字%字%"）
    private String getInputContentSQL(String inputContent) {
        StringBuilder stringBuilder = new StringBuilder("%");
        for(int i=0; i<inputContent.length();i++){
            stringBuilder.append(inputContent.charAt(i));
            stringBuilder.append("%");
        }
        return stringBuilder.toString();
    }

    //获取单条操作记录
    private SysOperationLog getSingleLog(CheckFormDto formDto, String operationType) {

        SysOperationLog log = new SysOperationLog();

        //操作日志id
        log.setId(Uuid.getUuid());

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        log.setOperationTime(timeStamp);

        //操作页面
        log.setOperationPage("文章发布管理");

        //操作人id
        log.setPartyId(formDto.getCheckerId());

        //操作内容
        String operatorName = formDto.getCheckerName();
        String essayName = formDto.getCheckedEssayName();
        StringBuilder stringBuilder = new StringBuilder(operatorName);

        if(operationType.equals("setTop")){
            stringBuilder.append("置顶了");
        }else if(operationType.equals("leaveOut")){
            stringBuilder.append("下架了");
        }else if(operationType.equals("publish")){
            stringBuilder.append("发布了");
        }else if(operationType.equals("setOutTop")){
            System.out.println("setOutTop");
            stringBuilder.append("取消置顶");
        }

        stringBuilder.append(essayName);
        String operateContent = stringBuilder.toString();
        log.setOperationContent(operateContent);


        return log;
    }

    //获取单挑操作记录 不同实体
    private SysOperationLog getSingleLogFromOther(InsertEssayDto updateEssayDto) {
        SysOperationLog log = new SysOperationLog();

        //操作日志id
        log.setId(Uuid.getUuid());

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        log.setOperationTime(timeStamp);

        //操作页面
        log.setOperationPage("文章发布管理");

        //操作人id
        log.setPartyId(updateEssayDto.getOperatorId());

        //操作内容
        String operatorName = updateEssayDto.getOperatorName();
        String essayName = updateEssayDto.getTitle();

        StringBuilder stringBuilder = new StringBuilder(operatorName);
        stringBuilder.append("发布了");
        stringBuilder.append(essayName);
        String operateContent = stringBuilder.toString();
        log.setOperationContent(operateContent);

        return log;
    }

    //组成多条操作记录
    private List<SysOperationLog> getManyLogs(CheckFormDto publishFormListDto, String operationTYpe) {
        List<SysOperationLog> logs = new ArrayList<>();

        for(int i=0; i<publishFormListDto.getCheckedIdList().size(); i++){
            SysOperationLog log = new SysOperationLog();

            //操作时间
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            log.setOperationTime(timeStamp);

            //操作页面
            log.setOperationPage("文章发布管理");

            //操作人id
            log.setPartyId(publishFormListDto.getCheckerId());

            log.setId(Uuid.getUuid());

            //操作人姓名
            StringBuilder stringBuilder = new StringBuilder(publishFormListDto.getCheckerName());
            if(operationTYpe.equals("publish")){
                stringBuilder.append("发布了");
            }else{
                stringBuilder.append("下架了");
            }

            stringBuilder.append(publishFormListDto.getCheckedNameList().get(i));

            String operateContent = stringBuilder.toString();
            log.setOperationContent(operateContent);

            logs.add(log);
        }
        return logs;
    }

    //判断传入的当前页是否有错
    private int checkCurrentPage(int currentPage) {
        if(currentPage <=0){
            return 0;
        }
        return currentPage;
    }

    //判断传入的页码
    private int checkPageSize(int pageSize) {
        if(pageSize <=0 ){
            return 5;
        }
        return pageSize;
    }

}
