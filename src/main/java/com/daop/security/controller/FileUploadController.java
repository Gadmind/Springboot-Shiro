package com.daop.security.controller;

import com.daop.security.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.controller
 * @Description: 文件上传控制器
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
@RestController
public class FileUploadController {
    @PostMapping("/fileUpload")
    public ResultUtil fileUpload(MultipartHttpServletRequest request) {

        List<String> name = new ArrayList<>();
        name.add("stander");
        name.add("normal");
        name.add("error");
        name.add("warn");
        List<String> names = new ArrayList<>();
        for (String s : name) {
            MultipartFile file = request.getFile(s + "files");
            System.out.println(file.getOriginalFilename());
            names.add(file.getOriginalFilename());
        }
        return new ResultUtil(200, "上传成功", names);
    }
}
