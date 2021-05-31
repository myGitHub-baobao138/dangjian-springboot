package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.partyInformation.AddInformationDto;
import com.partybuilding.webserver.dto.system.partyInformation.FindPartyBaseInfoPageInfoDTO;
import com.partybuilding.webserver.dto.system.partyInformation.SelectSnoAndName;
import com.partybuilding.webserver.dto.system.partyInformation.UpdateInformation;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderDto;
import com.partybuilding.webserver.service.system.SysPartyMemberInformationService;
import com.partybuilding.webserver.service.system.SysPartyReminderService;
import com.partybuilding.webserver.service.system.SysUserService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 党员信息controller
 */
@RestController
@CrossOrigin
@RequestMapping("/System/PartyMemberInformationController")
@Api("党员信息管理controller")
public class SysPartyMemberInformationController {
    @Autowired
    SysPartyMemberInformationService service;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SysPartyReminderService reminderservice;

    @ApiOperation("党员信息模板文件下载")
    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response) throws IOException {
        InputStream inputStream = null;
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String("党员信息表.xlsx".getBytes("GB2312"), "ISO-8859-1"));
            ServletOutputStream outputStream = response.getOutputStream();
            inputStream = this.getClass().getResourceAsStream("/static/excel/党员信息表.xlsx");
            //服务器端找不到路径
//            inputStream = new FileInputStream(new File(ResourceUtils.getURL("classpath:").getPath() + "static/excel/党员记录表.xlsx"));
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, length);
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @ApiOperation("上传Excel")
    @PostMapping("/uploadExcel")
    public JsonResult uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        JsonResult jsonResult = new JsonResult();
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream input = file.getInputStream();
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        int size = (int) file.getSize();
        Workbook wb = null;

        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            wb = new XSSFWorkbook(input);
            jsonResult = service.validateExcel(wb);
        } else {
            jsonResult.setMessage("fail");
            jsonResult.setData("文件格式不对！");
            return jsonResult;
        }
        int sheetSize = wb.getNumberOfSheets();
        if (sheetSize <= 0) {
            jsonResult.setMessage("fail");
            jsonResult.setData("文件内容不能为空！");
            return jsonResult;
        } else {
        }
        if (size <= 0) {
            jsonResult.setMessage("fail");
            jsonResult.setData("文件大小不符合！");
            return jsonResult;
        }
        if (file.isEmpty()) {
            jsonResult.setMessage("fail");
            jsonResult.setData("文件不能为空！");
            return jsonResult;
        }
//        String path = System.getProperty("user.dir");
//        File dest = new File(path + "/src/main/resources/static" + file);
//        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
//            dest.getParentFile().mkdir();
//        }
//        try {
//            file.transferTo(dest); //保存文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return jsonResult;
    }

    /**
     * 查询组织下的所有党员
     *
     *
     * @param academy_id
     * @return
     */
//    @PostMapping("/findPartyMemberByOrganization")
//    @ApiOperation(value = "查询当前组织下的党员信息")
//    public JsonResult getPartyMemberByOrganization(Integer academy_id) {
//        JsonResult jsonResult = new JsonResult();
//        List<CreatePartyMemberDTO> list;
//        if ((list = service.findPartyMemberByOrganization(academy_id)).isEmpty()) {
//            jsonResult.setMessage("查询出错");
//        } else {
//            jsonResult.setMessage("查询成功");
//            jsonResult.setData(list);
//        }
//        return jsonResult;
//    }

    /**
     * 编辑党员信息
     *
     * @return
     */
    @PostMapping("/editInformation")
    @ApiOperation(value = "/编辑党员信息")
    public JsonResult editInformation(@RequestBody UpdateInformation updateInformation) {
        JsonResult jsonResult = new JsonResult();
        jsonResult = service.updateByPrimaryKey(updateInformation);
        return jsonResult;
    }

//	/**
//	 *
//	 * 根据管理员级别查找党员的全部信息，
//	 * @param pageInputDTO
//	 * @return
//	 */
//	@ApiOperation(value = "根据管理员级别查找党员信息")
//    @GetMapping({"/selectAllInformation"})
//    public  JsonResult selectAllInformation( @ModelAttribute PageInputDTO pageInputDTO){
//        JsonResult jsonResult = new JsonResult();
////        GetCurrentUserInfoDTO sysUser = sysUserService.getCurrentUserInfoByUserId(pageInputDTO.getPartyId());
////        if(sysUser.getSchool()){
////			jsonResult = service.selectAllInformation(pageInputDTO);
////		}else {
////        	jsonResult = service.selectInformationByAcademy(sysUser.getAcademyId(),pageInputDTO);
////		}
//        return jsonResult;
//    }

    /**
     * 根据党员学号工号查询数据
     *
     * @param snoOrNumber
     * @return
     *
     */
    @GetMapping("/selectInformationBySno")
    public JsonResult selectInformationBySno(@RequestParam String snoOrNumber) {
        JsonResult jsonResult = new JsonResult();
        AddInformationDto addInformationDto = service.selectInformationBySno(snoOrNumber);
        if (addInformationDto != null) {
            jsonResult.setData(addInformationDto);
            jsonResult.setMessage("查询成功！");
        }
        return jsonResult;
    }


//	@ApiOperation("根据党员职务进行查询数据")
//    @PostMapping("/selectByPostName")
//	public JsonResult selectByPostName(SearchByPostDto searchByPostDto){
//        JsonResult jsonResult = new JsonResult();
//        jsonResult= service.selectByPostName(searchByPostDto);
//        return jsonResult;
//    }
//    @ApiOperation("/根据党员姓名以及职务id查询党员信息")
//    @PostMapping("/selectByNameAndPost")
//    public JsonResult selectByNameAndPost(@Validated @RequestBody SearchPostAndNameDto searchPostAndNameDto){
//        JsonResult jsonResult = new JsonResult();
//        jsonResult= service.selectByNameAndPost(searchPostAndNameDto);
//	    return jsonResult;
//    }
//	/**
//	 * 根据职务查询党员信息
//	 * @return
//	 */
//	@ApiOperation("根据党员职务查询党员数据")
//    @PostMapping("/selectByPostName")
//	public JsonResult searchByPosition(@RequestBody SearchByPostDto searchByPostDto){
//		JsonResult jsonResult = service.selectByPostName(searchByPostDto);
//		return jsonResult;
//	}

//    /**
//     * 根据党员姓名模糊查询数据
//     * @param searchByNameDto
//     * @return
//     */
//	@ApiOperation("根据党员姓名进行模糊查询数据")
//    @PostMapping("/selectByName")
//	public JsonResult selectByName(@RequestBody SearchByNameDto searchByNameDto){
//        JsonResult jsonResult = new JsonResult();
//        jsonResult = service.selectByName(searchByNameDto);
//        return jsonResult;
//    }

    /**
     * 删除党员信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id删除数据")
    @GetMapping("/deleteById")
    public JsonResult deleteById(@RequestParam String id) {
        int success = service.deleteByPrimaryKey(id);
        JsonResult jsonResult = new JsonResult();
        if (success > 0) {
            jsonResult.setData("1");
            jsonResult.setCode(200);
            jsonResult.setMessage("删除成功");
        } else {
            jsonResult.setMessage("删除失败，请重试");
            jsonResult.setCode(500);

        }
        return jsonResult;
    }

    /**
     * 添加单条党员信息
     *
     * @return
     */
    @ApiOperation("新增单条党员信息")
    @PostMapping("/addSingleInfo")
    public JsonResult insertInformation(@RequestBody AddInformationDto addInformationDto) {
        addInformationDto.setPartyId(Uuid.getUuid());
        JsonResult jsonResult = new JsonResult();
        jsonResult = service.insert(addInformationDto);
        return jsonResult;
    }

    /**
     * 根据党员姓名查询对应名字的工号学号
     *
     * @param name
     * @return
     */
    @ApiOperation("根据党员姓名查询对应名字的工号学号")
    @PostMapping("/selectPartyNameLike")
    public JsonResult selectPartyNameLike(String name) {
        JsonResult jsonResult = new JsonResult();
        List<SelectSnoAndName> selectSnoAndNames = service.selectPartyNameLike(name);
        jsonResult.setData(selectSnoAndNames);
        return jsonResult;
    }

    /**
     * 查询党员基本信息
     *
     * @param dto
     * @return
     */
    @ApiOperation("查询党员基本信息")
    @PostMapping("/findPartyBaseInfo")
    public JsonResult findPartyBaseInfo(@RequestBody FindPartyBaseInfoPageInfoDTO dto) {
        JsonResult jsonResult = new JsonResult();

        PageResult pageResult = service.findPartyBaseInfo(dto);

        if (pageResult.getTotal() > 0) {
            jsonResult.setMessage("查询成功!");
            jsonResult.setCode(200);
            jsonResult.setData(pageResult);
        } else {
            jsonResult.setMessage("查询失败,数据为空!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    /**
     * 返回职务的名称与id信息
     * @return
     */
    @ApiOperation("/查找职务信息")
    @GetMapping("/findPostNameAndPostId")
    public JsonResult findPostNameAndPostId() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(service.findPostNameAndPostId());
        return jsonResult;
    }



    @PostMapping("/insertReminder")
    @ApiOperation("批量添加提醒或者单个添加提醒")
    @RequiresPermissions("/System/PartyMemberInformationController/**")
    public JsonResult insertReminder(@RequestBody List<AddReminderDto> list){
        JsonResult jsonResult = reminderservice.insertList(list);
        return jsonResult;
    }
}
