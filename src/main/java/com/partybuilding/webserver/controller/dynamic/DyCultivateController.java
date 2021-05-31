package com.partybuilding.webserver.controller.dynamic;


import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.cultivate.CreateCultivateEssayInDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayPageDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.modifyEssayInDto;
import com.partybuilding.webserver.service.dynamic.DyCultivateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;

import java.util.UUID;

/**
 * 党校培训管理controller
 */

@RestController
@CrossOrigin
@RequestMapping("/Dynamic/DyCultivateController")
@Api("党校培训管理controller")
public class  DyCultivateController {

    @Autowired
    private DyCultivateService service;

    /*查询显示所有的文章*/
    @ApiOperation(value = "模糊查询全部的文章信息")
    @GetMapping("/findEssayInformation")
    @RequiresPermissions("/Dynamic/DyCultivateController/**")
    public JsonResult findEssayInformation(@Validated CultivateEssayPageDto dto){
        JsonResult jsonResult =new JsonResult(service.findEssayInformation(dto));
        if (jsonResult.getData() != null) {
            jsonResult.setMessage("成功");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("失败");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    /*创建文章*/
    @ApiOperation(value = "创建党建培训文章")
    @PostMapping("/createCultivateEssay")
    @RequiresPermissions("/Dynamic/DyCultivateController/**")
    public JsonResult createCultivateEssay(@RequestBody @Validated CreateCultivateEssayInDto inDto){
        JsonResult jsonResult = new JsonResult();
        int num=service.createCultivateEssay(inDto);
        if (num > 0) {
            jsonResult.setMessage("文章创建成功!");
            jsonResult.setCode(200);
        }
        else {
            jsonResult.setMessage("创建文章失败!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    /*
     * 删除文章*/
    @ApiOperation(value = "通过文章id删除")
    @GetMapping("/deleteCultivateEssayById")
    @RequiresPermissions("/Dynamic/DyCultivateController/**")
    public JsonResult deleteCultivateEssayById(String cultivateEssayId){
        JsonResult jsonResult = new JsonResult();
        int result = service.deleteCultivateEssayById(cultivateEssayId);
        if (result > 0) {
            jsonResult.setMessage("成功删除");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("删除失败");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    /*
     * 发布文章*/
    @ApiOperation(value = "发布文章")
    @PostMapping("/publishEssayById")
    @RequiresPermissions("/Dynamic/DyCultivateController/**")
    public JsonResult publishEssayById(@RequestBody String[] cultivateEssayId){
//        System.out.println(cultivateEssayId.length);
        JsonResult jsonResult = new JsonResult();
        int result = service.publishEssayById(cultivateEssayId);
        if (result > 0) {
            jsonResult.setMessage("文章发布成功");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("发布失败");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }
    /*
     * 修改文章*/
    @ApiOperation(value = "修改文章")
    @PostMapping("/modifyEssayById")
    @RequiresPermissions("/Dynamic/DyCultivateController/**")
    public JsonResult modifyEssayById(@RequestBody @Validated modifyEssayInDto inDto){
//        System.out.println(inDto.getOrganizationId());
        JsonResult jsonResult = new JsonResult();
        int num=service.modifyEssayById(inDto);
        if (num > 0) {
            jsonResult.setMessage("文章修改成功!");
            jsonResult.setCode(200);
        }
        else {
            jsonResult.setMessage("修改文章失败!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    @ApiOperation("上传图片")
    @PostMapping("/uploadPic")
//    @RequiresPermissions("/Dynamic/DyCultivateController/**")
//    @RequestMapping("/uploadPic")
    public String uploadPic(@RequestParam MultipartFile file, MultipartHttpServletRequest request) throws IOException {

//        String path= ResourceUtils.getURL("").getPath() +"src/main/resources/static/picture/";//工程路径
        String path= ResourceUtils.getURL("").getPath() +"src/main/resources/static/images/";//工程路径
        String name = file.getOriginalFilename();   //获取传过来的
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID().toString().replaceAll("-", ""));  //用uuid来命名
        sb.append(name.substring(name.indexOf(".")));   //取后面的格式
//        String saveFileName =sb.toString();
        String savePath=path+sb.toString();

        File saveFile = new File(savePath);

        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();			//第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            System.out.print(saveFile.getParentFile());
        }
        try {
            System.out.print(saveFile.getParentFile());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(file.getBytes());
            out.flush();
            out.close();


//            return "http://localhost:9090/picture/"+saveFile.getName();
            return "http://localhost:9090/images/"+saveFile.getName();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "图片上传失败,";
        } catch (IOException e) {
            e.printStackTrace();
            return "图片上传失败,";
        }

    }

    @ApiOperation("上传附件")
    @PostMapping("/uploadPlugin")
    @RequiresPermissions("/Dynamic/DyCultivateController/**")
//    @RequestMapping("/uploadPlugin")
    public String uploadPlugin(@RequestParam MultipartFile file, MultipartHttpServletRequest request) throws IOException {

        String path= ResourceUtils.getURL("").getPath() +"src/main/resources/static/plugin/";//工程路径
        String name = file.getOriginalFilename();   //获取传过来的
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID().toString().replaceAll("-", ""));  //用uuid来命名
        sb.append(name.substring(name.indexOf(".")));   //取后面的格式

        String savePath=path+sb.toString();

        File saveFile = new File(savePath);

        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();			//第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            System.out.print(saveFile.getParentFile());
        }
        try {
            System.out.print(saveFile.getParentFile());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(file.getBytes());
            out.flush();
            out.close();

//            System.out.println("http://127.0.0.1:9090/plugin/"+savePath);

            return "http://localhost:9090/plugin/"+saveFile.getName();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "附件上传失败";
        } catch (IOException e) {
            e.printStackTrace();
            return "附件上传失败";
        }

    }
}
