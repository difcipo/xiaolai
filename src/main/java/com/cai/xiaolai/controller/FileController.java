package com.cai.xiaolai.controller;

import com.cai.xiaolai.entity.Emplyee;
import com.cai.xiaolai.entity.UpFile;
import com.cai.xiaolai.service.UpFileService;
import com.cai.xiaolai.utils.FormatNumber;
import com.cai.xiaolai.utils.FormatUUID;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FileController {


//    @Value("${path}")
    private String path = "E:/Intellij/xiaolai/src/file/";
    @Autowired
    private UpFileService upFileService;

    @RequestMapping("/toFileM")
    public String toFileM(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(defaultValue = "") String empname,@RequestParam(defaultValue = "") String title){
        PageInfo<UpFile> pageInfo = upFileService.getFileList(pageNum, 3,empname,title);
        model.addAttribute("pageInfo",pageInfo);
        return "filemanager";
    }

    @RequestMapping("/toAddFile")
    public String toAdd(){
        return "fileadd";
    }

    @RequestMapping("upFile")
    public String upFile(HttpServletRequest request,MultipartFile file,Model model, UpFile uf) throws Exception {
        Emplyee emplyee = (Emplyee) request.getSession().getAttribute("emplyee");
        //获取文件名称
        String filename = file.getOriginalFilename();
        //设置文件新名称
        String suffixx = filename.substring(filename.lastIndexOf("."), filename.length());
//        String nname = FormatUUID.getUUID(null, 8).concat(".").concat(suffixx);
        String nname = path.concat(uf.getTitle()).concat(suffixx);
        File filepath = new File(nname);

            //获取文件输出路径
            FileOutputStream fos = new FileOutputStream(filepath);
            //获取文件输入流
            InputStream ins = file.getInputStream();
            FileCopyUtils.copy(ins,fos);
            uf.setTitle(uf.getTitle()+suffixx);
            uf.setEmplyee(emplyee);
            uf.setUpTime(FormatNumber.format("YYYY-mm-dd hh:mm:ss",""));
            upFileService.save(uf);
            return "redirect:/toFileM";

//        model.addAttribute("upmsg","上传失败！");
//        return "redirect:/toAddFile";

    }

    @RequestMapping("/download/{filename}")
    public String download(Model model,@PathVariable("filename") String filename) throws IOException {
        File filepath = new File(path);
        File[] files = filepath.listFiles();
        //File file = new File(filepath + filename);
        if(filepath.exists()){
            File file = new File("E:/Intellij/xiaolai/src/down/");
//            if(!file.exists()){
//                file.mkdirs();
//                //file = new File();
//            }
//            FileOutputStream fos = new FileOutputStream(file);
//            FileInputStream fis = new FileInputStream(filepath);
            FileCopyUtils.copy(new File(filepath+"/"+filename),new File("E:/Intellij/xiaolai/src/down/"+filename));
            return "redirect:/toFileM";
        }

        model.addAttribute("downmsg","下载失败！");
        return "redirect:/toFileM";

    }

    //文件删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        upFileService.delete(id);
        return "redirect:/toFileM";
    }
}
