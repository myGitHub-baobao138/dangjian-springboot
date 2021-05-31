package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.*;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.partyInformation.*;
import com.partybuilding.webserver.dto.system.post.PostNameAndPostId;
import com.partybuilding.webserver.dto.system.sysPartyOrganizationPost.InsertPartyOrganizationPost;
import com.partybuilding.webserver.dto.system.sysPartyOrganizationPost.UpdatePartyOrgPostDto;
import com.partybuilding.webserver.entity.system.SysPartyMemberInformation;
import com.partybuilding.webserver.service.system.SysPartyMemberInformationService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.apache.poi.ss.usermodel.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


@Transactional
@Service
public class SysPartyMemberInformationServiceImpl implements SysPartyMemberInformationService {

    @Autowired
    SysPartyMemberInformationMapper mapper;

    @Autowired
    SysPostMapper sysPostMapper;

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysOrganizationalStructureMapper organizationMapper;

    @Autowired
    SysPartyOrganizationPostMapper orgPostMapper;


    @Autowired
    ModelMapper modelMapper;

    List<PostNameAndPostId> postNameAndPostIdList=null;

    List<SnoAndId> snoList= new LinkedList<>();


    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加单条党员数据
     * @param record
     * @return
     */
    @Override
    public JsonResult insert(AddInformationDto record) {
        AddPartyInformationDto addPartyInformationDto = modelMapper.map(record,AddPartyInformationDto.class);
        InsertPartyOrganizationPost insertPartyOrganizationPost = modelMapper.map(record,InsertPartyOrganizationPost.class);
        insertPartyOrganizationPost.setId(Uuid.getUuid());
        JsonResult jsonResult = new JsonResult();


        int addSuccess = mapper.insert(addPartyInformationDto);
        int insertSuccess = orgPostMapper.addPartyOrgPostSingle(insertPartyOrganizationPost);
        if(addSuccess>0&&insertSuccess>0){
            jsonResult.setCode(200);
            jsonResult.setMessage("添加成功!");
        }else {
            jsonResult.setMessage("添加失败！");
        }
        return jsonResult;
    }


    @Override
    public int insertSelective(SysPartyMemberInformation record) {
        return mapper.insertSelective(record);
    }

    @Override
    public SysPartyMemberInformation selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysPartyMemberInformation record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 修改党员信息 over 12/24
     * @param record
     * @return
     */
    @Override
    public JsonResult updateByPrimaryKey(UpdateInformation record) {
        AddPartyInformationDto addPartyInformationDto = modelMapper.map(record,AddPartyInformationDto.class);
        UpdatePartyOrgPostDto updatePartyOrgPostDto = modelMapper.map(record,UpdatePartyOrgPostDto.class);
        if ("学生".equals(addPartyInformationDto.getCategory())) {
            addPartyInformationDto.setCategory("0");
        } else if ("教师".equals(addPartyInformationDto.getCategory())) {
            addPartyInformationDto.setCategory("1");
        }
        int updateInfo = mapper.updateByPrimaryKey(addPartyInformationDto);
        int updateOrg = orgPostMapper.updateInfo(updatePartyOrgPostDto);
        JsonResult jsonResult = new JsonResult();

        if(updateInfo>0&&updateOrg>0){
            jsonResult.setCode(200);
            jsonResult.setMessage("修改成功");
            return jsonResult;
        }else {
            jsonResult.setCode(500);
            jsonResult.setMessage("修改失败");
            return jsonResult;
        }
    }

    /**
     *
     * 批量插入数据
     *
     * @param hssfWorkbook
     * @return
     */
    @Override
    public JsonResult validateExcel(Workbook hssfWorkbook) {
        JsonResult jsonResult = new JsonResult();
        List<AddInformationDto> informationDtos = new LinkedList<>();
        //党员表的信息
        List<AddPartyInformationDto> addPartyInformationDtos = new LinkedList<>();
        //党员组织职务表的信息
        List<InsertPartyOrganizationPost> insertPartyOrganizationPosts = new LinkedList<>();
        for (int i = 0; i < hssfWorkbook.getNumberOfSheets(); i++) {
            Sheet sheet = hssfWorkbook.getSheetAt(i);
            int rowNum = sheet.getLastRowNum() + 1;
            for (int j = 2; j < rowNum; j++) {
                Row row = sheet.getRow(j);

                AddPartyInformationDto addPartyInformationDto = new AddPartyInformationDto();
                InsertPartyOrganizationPost insertPartyOrganizationPost = new InsertPartyOrganizationPost();

                AddInformationDto addInformationDto = new AddInformationDto();

                int cellSize = row.getLastCellNum();
                for (int k = 0; k < cellSize; k++) {
                    //拿到title数据对对应数据进行提取
                    Cell cellTitle = sheet.getRow(1).getCell(k);
                    if ("姓名".equals(cellTitle.toString())) {
                        if (!isNull(row.getCell(k).toString())) {
                            addInformationDto.setName(row.getCell(k).toString());
                        } else {
                            jsonResult.setMessage("所填姓名不能为空，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("电话号码".equals(cellTitle.toString())) {
                        DecimalFormat df = new DecimalFormat("#");
                        boolean isPhone = false;
                        String phone="";
                        switch (row.getCell(k).getCellType()){
                            case NUMERIC:
                                isPhone=isPhoneNumber(df.format(row.getCell(k).getNumericCellValue()));
                                phone = df.format(row.getCell(k).getNumericCellValue());
                                break;
                            case STRING:
                                isPhone=isPhoneNumber(df.format(Double.parseDouble(row.getCell(k).toString())));
                                phone = df.format(Double.parseDouble(row.getCell(k).toString()));
                                break;
                            default:
                                isPhone=isPhoneNumber(row.getCell(k).toString());
                                phone = row.getCell(k).toString();
                                break;
                        }
                        if (!isNull(row.getCell(k).toString()) && isPhone) {
                            addInformationDto.setPhoneNumber(phone);
                        } else {
                            jsonResult.setMessage("所填电话不正确，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("组织".equals(cellTitle.toString())) {
                        if (!isNull(row.getCell(k).toString())) {
                            String organizationName = isExistOrganizationName(row.getCell(k).toString());
                            if (organizationName != null) {
                                addInformationDto.setOrganizationName(organizationName);
                            } else {
                                jsonResult.setMessage("所填院校不正确或者不存在" + (j + 1) + "行");
                                return jsonResult;
                            }
                        } else {
                            jsonResult.setMessage("所填院校不正确或者不存在，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("职务".equals(cellTitle.toString())) {
                        if (!isNull(row.getCell(k).toString())) {
                            String postId = isExistPostName(row.getCell(k).toString());
                            if (postId!=null){
                                addInformationDto.setPostName(postId);
                            }else {
                                jsonResult.setMessage("所填职务不存在或者不正确，第" + (j + 1) + "行");
                            }
                        } else {
                            jsonResult.setMessage("所填职务不存在或者不正确，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("性别".equals(cellTitle.toString())) {
                        if (!isNull(row.getCell(k).toString())) {
                            int sex;
                            if ("男".equals(row.getCell(k).toString())) {
                                sex = 1;
                            } else if ("女".equals(row.getCell(k).toString())) {
                                sex = 0;
                            } else {
                                jsonResult.setMessage("性别填写错误，第" + (j + 1) + "行");
                                return jsonResult;
                            }
                            addInformationDto.setSex(sex);
                        } else {
                            jsonResult.setMessage("所性别不正确或为空，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("类别".equals(cellTitle.toString())) {
                        if (!isNull(row.getCell(k).toString())) {
                            int category = isExistCategory(row.getCell(k).toString());
                            if (category != -1) {
                                addInformationDto.setCategory(String.valueOf(category));
                            } else {
                                jsonResult.setMessage("所填类别不存在或者不正确，第" + (j + 1) + "行");
                                return jsonResult;
                            }
                        } else {
                            jsonResult.setMessage("所填类别不能为空，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("学号/工号".equals(cellTitle.toString())) {
                        if (row.getCell(k).getCellType() == CellType.NUMERIC) {
                            row.getCell(k).setCellType(CellType.STRING);
                        }
                        if (!isNull(row.getCell(k).toString())) {
                            addInformationDto.setSnoOrJobNumber(row.getCell(k).getStringCellValue());
                            DecimalFormat df = new DecimalFormat("#");
                        } else {
                            jsonResult.setMessage("所填工号为空或者不正确，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    } else if ("入党时间".equals(cellTitle.toString())) {

                        if (row.getCell(k).getCellType()==CellType.STRING){
                            row.getCell(k).setCellType(CellType.NUMERIC);
                        }
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        if (!isNull(row.getCell(k).toString()) && isDateTime(simpleDateFormat.format(row.getCell(k).getDateCellValue()))) {
                            addInformationDto.setEnterTime(simpleDateFormat.format(row.getCell(k).getDateCellValue()));
                        } else {
                            jsonResult.setMessage("所填时间为空或者不正确，第" + (j + 1) + "行");
                            return jsonResult;
                        }
                    }
                }
                boolean flag = true;
                if(informationDtos.size()>0){
                    for(AddInformationDto add:informationDtos){

                        //如果学号工号相同，判断是否组织与职务也相同，如果不相同则，插入组织职务表
                        if (add.getSnoOrJobNumber().equals(addInformationDto.getSnoOrJobNumber())){
                            //如果有重复的组织以及职务，则不插入这条党员信息
                            if(addInformationDto.getOrganizationName().equals(add.getOrganizationName())
                                    && add.getPostName().equals(addInformationDto.getPostName())){
                                //不要这条数据
                                flag = false;
                                continue;
                            } else {
                                //插入组织职务信息
                                insertPartyOrganizationPost = modelMapper.map(addInformationDto,InsertPartyOrganizationPost.class);
                                insertPartyOrganizationPost.setPartyId(add.getPartyId());
                                insertPartyOrganizationPost.setId(Uuid.getUuid());
                                insertPartyOrganizationPosts.add(insertPartyOrganizationPost);
                                flag =false;
                                continue;
                            }

                            //如果学号工号不同，则插入数据
                        }
                    }
                    if(flag==true){
                        String partyId = updateRepeatData(addInformationDto);
                        //如果数据库里面不存在相同工号或者账号，就直接插入数据
                        if(partyId==null) {
                            addInformationDto.setPartyId(Uuid.getUuid());
                            addPartyInformationDto = modelMapper.map(addInformationDto, AddPartyInformationDto.class);
                            insertPartyOrganizationPost = modelMapper.map(addInformationDto, InsertPartyOrganizationPost.class);
                            insertPartyOrganizationPost.setId(Uuid.getUuid());
                            addPartyInformationDtos.add(addPartyInformationDto);
                            insertPartyOrganizationPosts.add(insertPartyOrganizationPost);
                            informationDtos.add(addInformationDto);

                        }else {//如果存在相同的数据并且需要将数据更新
                            addInformationDto.setPartyId(partyId);
                            addPartyInformationDto = modelMapper.map(addInformationDto,AddPartyInformationDto.class);
                            //更新相同的数据
                            mapper.updateByPrimaryKey(addPartyInformationDto);

                            insertPartyOrganizationPost = modelMapper.map(addInformationDto, InsertPartyOrganizationPost.class);
                            //判断数据库是否有相同的组织以及职务的党员
                            InsertPartyOrganizationPost test = orgPostMapper.getOrgAngPost(insertPartyOrganizationPost.getOrganizationName(),insertPartyOrganizationPost.getPostName(),partyId);
                            //无则将组织数据导入进组织职务表
                            if (test==null){
                                insertPartyOrganizationPost.setId(Uuid.getUuid());
                                insertPartyOrganizationPosts.add(insertPartyOrganizationPost);
                            }else {
                                jsonResult.setCode(500);
                                jsonResult.setMessage("相同组织职务的党员不能重复导入，重复的学号/工号为"+addInformationDto.getSnoOrJobNumber());
                                return jsonResult;
                            }
                        }
                    }
                }else {
                    //如果数据库有重复的学号或者工号，更新数据库
                    String partyId = updateRepeatData(addInformationDto);
                    if(partyId==null){
                        addInformationDto.setPartyId(Uuid.getUuid());
                        addPartyInformationDto = modelMapper.map(addInformationDto,AddPartyInformationDto.class);
                        addPartyInformationDtos.add(addPartyInformationDto);
                        insertPartyOrganizationPost = modelMapper.map(addInformationDto,InsertPartyOrganizationPost.class);
                        insertPartyOrganizationPost.setId(Uuid.getUuid());
                        insertPartyOrganizationPosts.add(insertPartyOrganizationPost);
                        informationDtos.add(addInformationDto);
                    }else {
                        addInformationDto.setPartyId(partyId);
                        addPartyInformationDto = modelMapper.map(addInformationDto,AddPartyInformationDto.class);
                        mapper.updateByPrimaryKey(addPartyInformationDto);
                        insertPartyOrganizationPost = modelMapper.map(addInformationDto, InsertPartyOrganizationPost.class);
                        //判断数据库是否有相同的组织以及职务的党员
                        InsertPartyOrganizationPost test = orgPostMapper.getOrgAngPost(insertPartyOrganizationPost.getOrganizationName(),insertPartyOrganizationPost.getPostName(),partyId);
                        //无则将组织数据导入进组织职务表
                        if (test==null){
                            insertPartyOrganizationPost.setId(Uuid.getUuid());
                            insertPartyOrganizationPosts.add(insertPartyOrganizationPost);
                        }else {
                            jsonResult.setCode(500);
                            jsonResult.setMessage("相同组织职务的党员不能重复导入，重复的学号/工号为"+addInformationDto.getSnoOrJobNumber()+"您可以导入相同组织不同职务，或者不同组织相同职务的人");
                            return jsonResult;
                        }
                    }
                }
            }
        }
//        for (AddInformationDto addInformationDto : informationDtos) {
//            System.out.println(addInformationDto.toString());
//        }
        jsonResult = insertData(addPartyInformationDtos,insertPartyOrganizationPosts);
        return jsonResult;
    }

    /**
     * 插入数据到党员表与组织职务表
     * @param addPartyInformationDtos
     * @param insertPartyOrganizationPosts
     * @return
     */
    public JsonResult insertData(List<AddPartyInformationDto> addPartyInformationDtos, List<InsertPartyOrganizationPost> insertPartyOrganizationPosts){
        int successParty = mapper.insertList(addPartyInformationDtos);
        int successOrg = orgPostMapper.addPartyOrgPost(insertPartyOrganizationPosts);
        JsonResult jsonResult = new JsonResult();
        if(successOrg>0&&successParty>0){
            jsonResult.setMessage("导入数据成功!");
            jsonResult.setCode(200);
            postNameAndPostIdList.clear();
            snoList.clear();
        }else {
            jsonResult.setMessage("导入数据失败!请重试");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    /**
     * 更新数据
     * @param addInformationDto
     * @return
     */
    public String updateRepeatData(AddInformationDto addInformationDto){
        if(snoList.size()==0||snoList==null){
            snoList = mapper.getSnoList();
        }
        if(snoList.size()>0||snoList!=null){
            for(SnoAndId snoAndId:snoList){
                if(snoAndId.getSnoOrJobNumber().equals(addInformationDto.getSnoOrJobNumber())){
                    return snoAndId.getId();
                }
            }
        }
        return null;
    }


    /**
     * 按照学号或者工号查询数据
     *
     * @param number
     * @return
     */
    @Override
    public AddInformationDto selectInformationBySno(String number) {
        AddInformationDto addInformationDto = mapper.selectInformationBySno(number);
        if ("0".equals(addInformationDto.getCategory())) {
            addInformationDto.setCategory("学生");
        } else if ("1".equals(addInformationDto.getCategory())) {
            addInformationDto.setCategory("教师");
        }
        return mapper.selectInformationBySno(number);
    }

    /**
     * 院级用户
     * 根据学院查询数据
     * @param academy
     * @param pageInputDTO
     * @return
     */
    @Override
    public JsonResult selectInformationByAcademy(String academy, PageInputDTO pageInputDTO) {
        PageHelper.startPage(pageInputDTO.getCurrentPage(), pageInputDTO.getPageSize());
        List<SearchResultDto> addInformationDtos = mapper.selectInformationByAcademy(academy);
        PageResult<SearchResultDto> result = getPageResult(addInformationDtos);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        jsonResult.setCode(200);
        jsonResult.setMessage("数据查询成功");
        return jsonResult;
    }

    /**
     * 校级用户
     * 查询全部数据
     *
     * @param pageInputDTO
     * @return
     */
    @Override
    public JsonResult selectAllInformation(PageInputDTO pageInputDTO) {
        PageHelper.startPage(pageInputDTO.getCurrentPage(), pageInputDTO.getPageSize());
        List<SearchResultDto> addInformationDtos = mapper.selectAllInformation();
        PageResult<SearchResultDto> result = getPageResult(addInformationDtos);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        jsonResult.setCode(200);
        jsonResult.setMessage("数据查询成功");
        return jsonResult;
    }

    @Override
    public int updateBySnoOrNumber(AddInformationDto addInformationDto) {
        return 0;
    }

    /**
     * 根据管理员级别  以及职务id，姓名模糊查询党员信息
     *
     * @param searchPostAndNameDto
     * @return
     */
    @Override
    public JsonResult selectByNameAndPost(SearchPostAndNameDto searchPostAndNameDto) {
        PageHelper.startPage(searchPostAndNameDto.getCurrentPage(), searchPostAndNameDto.getPageSize());
        List<SearchResultDto> searchResultDtos = null;
        JsonResult jsonResult = new JsonResult();
//        if(sysUser.){
//            searchResultDtos = mapper.selectByNameAndPost(searchPostAndNameDto);
//            PageResult<SearchResultDto> result = getPageResult(searchResultDtos);
//            jsonResult.setData(result);
//        }else if(!sysUser.getSchool()){
//            SearchPostAndNameAndAcademyDto searchPostAndNameAndAcademyDto = new SearchPostAndNameAndAcademyDto();
//            searchPostAndNameAndAcademyDto.setAcademyId(sysUser.getAcademyId());
//            searchPostAndNameAndAcademyDto.setName(searchPostAndNameDto.getName());
//            searchPostAndNameAndAcademyDto.setPostName(searchPostAndNameDto.getPostName());
//            searchResultDtos = mapper.selectByNameAndPostAndAcademy(searchPostAndNameAndAcademyDto);
//            PageResult<SearchResultDto> result = getPageResult(searchResultDtos);
//            jsonResult.setData(result);
//        }else {
//            jsonResult.setData("-1");
//            jsonResult.setMessage("fail");
//            jsonResult.setCode(500);
//        }
        return jsonResult;
    }

    /**
     * 根据管理员级别 以及 姓名查询所需要的党员数据
     *
     * @param searchByNameDto
     * @return
     */
    @Override
    public JsonResult selectByName(SearchByNameDto searchByNameDto) {
        PageHelper.startPage(searchByNameDto.getCurrentPage(), searchByNameDto.getPageSize());

        List<SearchResultDto> searchResultDtos = null;
        JsonResult jsonResult = new JsonResult();
//        if(sysUser.getSchool()){
//            searchResultDtos = mapper.selectByName(searchByNameDto.getName());
//            PageResult<SearchResultDto> result = getPageResult(searchResultDtos);
//            jsonResult.setData(result);
//        }else if(!sysUser.getSchool()){
//            SearchByNameAndAcademy searchByNameAndAcademy = new SearchByNameAndAcademy();
//            searchByNameAndAcademy.setAcademy(sysUser.getAcademyId());
//            searchByNameAndAcademy.setName(searchByNameDto.getName());
//            searchResultDtos = mapper.selectByNameAndAcademy(searchByNameAndAcademy);
//            PageResult<SearchResultDto> result = getPageResult(searchResultDtos);
//            jsonResult.setData(result);
//        }else {
//            jsonResult.setData("-1");
//            jsonResult.setMessage("fail");
//            jsonResult.setCode(500);
//        }
        return jsonResult;
    }

    /**
     * 根据党员的职务名称查询数据
     *
     * @param searchByPostDto
     * @return
     */
    @Override
    public JsonResult selectByPostName(SearchByPostDto searchByPostDto) {
//        GetCurrentUserInfoDTO sysUser = sysUserMapper.getCurrentUserInfoByUserId(searchByPostDto.getUserId());
//        PageHelper.startPage(searchByPostDto.getCurrentPage(),searchByPostDto.getPageSize());
//
//        List<SearchResultDto> searchResultDtos=null;
        JsonResult jsonResult = new JsonResult();
//        if(sysUser.getSchool()){
//            //校级数据
//            searchResultDtos = mapper.selectByPostName(searchByPostDto.getPostName());
//            PageResult<SearchResultDto> result = getPageResult(searchResultDtos);
//            jsonResult.setData(result);
//        }else if (!sysUser.getSchool()){
//            //院级数据
//            searchResultDtos = mapper.selectByPostNameAndAcademy(searchByPostDto.getPostName(),sysUser.getAcademyId());
//            PageResult<SearchResultDto> result = getPageResult(searchResultDtos);
//            jsonResult.setData(result);
//        }else {
//            jsonResult.setData("-1");
//            jsonResult.setMessage("fail");
//            jsonResult.setCode(500);
//        }
        return jsonResult;
    }

    @Override
    public List<SelectSnoAndName> selectPartyNameLike(String name) {
        return mapper.selectPartyNameLike(name);
    }

    @Override
    public int selectByNumber(String number) {
        return mapper.selectByNumber(number);
    }

    //查询数据的返回
    public List<SearchResultDto> getObjetcInformation(List<SearchResultDto> list) {
        for (SearchResultDto informationDto : list) {
            if ("0".equals(informationDto.getCategory())) {
                informationDto.setCategory("学生");
            } else if ("1".equals(informationDto.getCategory())) {
                informationDto.setCategory("教师");
            }
        }
        return list;
    }

    public PageResult<SearchResultDto> getPageResult(List<SearchResultDto> addInformationDtos) {
        PageInfo<SearchResultDto> pageInfo = new PageInfo<SearchResultDto>(addInformationDtos);
        // 封装需要返回的分页实体
        PageResult<SearchResultDto> result = new PageResult<SearchResultDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(getObjetcInformation(pageInfo.getList()));
        return result;
    }

    public String isExistPostName(String postName){
        String postId = null;
        if(postNameAndPostIdList==null||postNameAndPostIdList.size()==0){
            postNameAndPostIdList = sysPostMapper.findPostNameAndPostId();
        }

        for (PostNameAndPostId postNameAndPostId : postNameAndPostIdList) {
            if (postNameAndPostId.getPostName().equals(postName)) {
                postId = postNameAndPostId.getPostId();
                return postId;
            }
        }
        return postId;
    }
    public String isExistOrganizationName(String organizationName) {
        String organizationId = organizationMapper.getOrganizationIdByName(organizationName);
        if (organizationId == null || "".equals(organizationId)) {
            return null;
        } else {
            return organizationId;
        }
    }

    public boolean isPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^[1][3,4,5,7,8,9,6][0-9]{9}$")) {
            return true;
        }
        return false;
    }


    public boolean isNull(String data) {
        if (data == "" || data == null || "".equals(data)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否存在已经导入过的学号、工号数据
     * 存在
     * 如果存在且不存在相同职务相同等级的数据，则更新导入的数据
     *
     * @param addPartyInformationDto
     * @return
     */
    public boolean isExistNumber(AddPartyInformationDto addPartyInformationDto) {

        if(snoList.size()==0||snoList==null){
            snoList = mapper.getSnoList();
        }
        for(SnoAndId snoAndId:snoList){
            if(snoAndId.getSnoOrJobNumber().equals(addPartyInformationDto.getSnoOrJobNumber())){
                mapper.updateByPrimaryKey(addPartyInformationDto);
            }
        }

        if(1>0){
            return true;
        }
        return false;
    }
    public void isRepeat(List<AddInformationDto> informationDtos){

        List<AddPartyInformationDto> addPartyInformationDto = modelMapper.map(informationDtos, new TypeToken<List<AddPartyInformationDto>>() {
        }.getType());
        List<InsertPartyOrganizationPost> insertPartyOrganizationPosts = modelMapper.map(informationDtos, new TypeToken<List<InsertPartyOrganizationPost>>() {
        }.getType());
        for(int i=addPartyInformationDto.size();i>=0;i--){
            for(int j=insertPartyOrganizationPosts.size();j>=0;j--){

            }
        }
    }

    /**
     * 判断是否存在所填类别
     *
     * @param category
     * @return
     */
    public int isExistCategory(String category) {
        List<String> categories = new LinkedList<>();
        categories.add("学生");
        categories.add("教师");
        if (categories.contains(category)) {
            if (categories.get(0).equals(category)) {
                return 0;
            } else if (categories.get(1).equals(category))
                return 1;
        }
        return -1;
    }

    /**
     * 判断是否是正确时间
     *
     * @param date
     * @return
     */
    public boolean isDateTime(String date) {
//        System.out.println(date);
        if (date.matches("^[1-9]{1}[0-9]{3}/[0-9]{2}/[0-9]{2}$")) {
            return true;
        }
        return false;
    }

    /**
     * 查询党员基本信息
     * @param dto
     * @return
     */
   public PageResult findPartyBaseInfo(FindPartyBaseInfoPageInfoDTO dto){
       //  判断参数是否有误
       if (dto.getCurrentPage() <= 0) {
           dto.setCurrentPage(1);  //设置默认当前页
       }
       if (dto.getPageSize() <= 0) {
           dto.setPageSize(5); // 默认每页5条
       }

       PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
       List<FindPartyBaseInfoDTO> list=new LinkedList<>();
       list = mapper.findPartyBaseInfo(dto);
       // 获取分页查询后的数据
       PageInfo<FindPartyBaseInfoDTO> pageInfo = new PageInfo<>(list);
       // 封装需要返回的分页实体
       PageResult<FindPartyBaseInfoDTO> result = new PageResult<FindPartyBaseInfoDTO>();
       // 设置总记录数total
       result.setTotal((int) pageInfo.getTotal());
       // 设置数据库集合
       result.setList(list);
       return result;
   }
   @Override
   public List<PostNameAndPostId> findPostNameAndPostId(){
        return sysPostMapper.findPostNameAndPostId();
   }
}
