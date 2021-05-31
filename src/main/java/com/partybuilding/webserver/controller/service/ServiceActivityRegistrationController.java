package com.partybuilding.webserver.controller.service;


import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.volunteer.InsertActivityDTO;
import com.partybuilding.webserver.service.service.ServiceActivityRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/Service/ActivityRegistration")
@Api
public class ServiceActivityRegistrationController {

    @Autowired(required = false)
    ServiceActivityRegistrationService service;

    static String imgName;
    static String fileName;

    @GetMapping("/selectInfoByActivityId")
    @RequiresPermissions("/Service/ActivityRegistration/**")
    public JsonResult selectInfoByActivityId(String activityId){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(service.selectInfoByActivityId(activityId));
        if (jsonResult.getData()!=null){
            jsonResult.setMessage("查询成功");
        }else {
            jsonResult.setMessage("查询失败");
        }
        return jsonResult;
    }


//    /**
//     * 上传图片
//     * author 包嵩
//     * @param image
//     * @return
//     * @throws FileNotFoundException
//     */
//    @ApiOperation("上传")
//    @PostMapping("/upload")
//    @RequiresPermissions("/Service/ActivityRegistration/**")
//    public String upload(@RequestParam("file") MultipartFile image) throws FileNotFoundException{
//        System.out.println("123");
//        imgName="";
//        String contentType = image.getContentType();
//        String imageName = image.getOriginalFilename();
//        imgName = imageName;
//        String imagePath = ResourceUtils.getURL("").getPath()+"src/main/resources/static/images/";
//        if(image.isEmpty()) {
//            return "文件为空";
//        }
//        try {
//            uploadImage(image.getBytes(),imagePath,imageName);
//        }catch(Exception e) {
//
//        }
//
//        return "上传成功";
//    }
    /**
     * 上传图片
     * author 包嵩
     * @param image
     * @return
     * @throws FileNotFoundException
     */
    @ApiOperation("上传")
    @PostMapping("/upload")
//    @RequiresPermissions("/Service/ActivityRegistration/**")
    public String upload(@RequestParam("file") MultipartFile image, MultipartHttpServletRequest request) throws FileNotFoundException{
        //        String path= ResourceUtils.getURL("").getPath() +"src/main/resources/static/picture/";//工程路径
        String path= ResourceUtils.getURL("").getPath() +"src/main/resources/static/images/";//工程路径
        String name = image.getOriginalFilename();   //获取传过来的
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
            out.write(image.getBytes());
            out.flush();
            out.close();


            return "http://localhost:9090/images/"+saveFile.getName();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "图片上传失败,";
        } catch (IOException e) {
            e.printStackTrace();
            return "图片上传失败,";
        }
    }

    /**
     * 删除图片
     * author 包嵩
     * @param fileName
     * @throws FileNotFoundException
     */
    @RequestMapping(value= {"/deleteImage"},method = RequestMethod.POST)
//    @RequiresPermissions("/Service/ActivityRegistration/**")
    public void deleteImage(String fileName) throws FileNotFoundException {
        String imagePath = ResourceUtils.getURL("").getPath()+"src/main/resources/static/images/";
        File file = new File(imagePath+fileName);
        file.delete();

    }


    /**
     * 上传文件
     * author 包嵩
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping(value= {"/uploadFile"},method=RequestMethod.POST)
    @RequiresPermissions("/Service/ActivityRegistration/**")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        fileName="";
        String contentType = file.getContentType();
        String fName = file.getOriginalFilename();
        fileName = fName;
        String imagePath = ResourceUtils.getURL("").getPath()+"src/main/resources/static/files/";
        if(file.isEmpty()) {
            return "文件为空";
        }
        try {
            uploadImage(file.getBytes(),imagePath,fName);
        }catch(Exception e) {

        }

        return "上传成功";
    }

    public static void uploadImage(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);

        if (!targetFile.exists()) {

            targetFile.mkdirs();

        }

        FileOutputStream out = new FileOutputStream(filePath +"/"+ fileName);
//		System.out.println(filePath +"/"+ fileName);

        out.write(file);

        out.flush();

        out.close();

    }

    @PostMapping("/insertActivity")
    @RequiresPermissions("/Service/ActivityRegistration/**")
    public JsonResult insertActivity(@RequestBody InsertActivityDTO dto){
        Date date = new Date();
        dto.setReleaseTime(date);
        JsonResult jsonResult = new JsonResult();
//        dto.setPicture("http://localhost:9090/images/"+imgName);
//        dto.setAnnex("http://localhost:9090/files/"+fileName);
        if (service.insertActivity(dto)==1){
            jsonResult.setData(true);
            jsonResult.setMessage("添加成功");
        }else {
            jsonResult.setData(false);
            jsonResult.setMessage("添加失败");
        }
        return jsonResult;
    }
}






















