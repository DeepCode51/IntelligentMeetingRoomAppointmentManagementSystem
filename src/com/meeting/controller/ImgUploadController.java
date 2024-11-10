package com.meeting.controller;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.meeting.util.Upload;
import com.meeting.util.CommonVal;
@Controller
@RequestMapping("/imgUpload")
public class ImgUploadController{
    //文件上传并生成缩略图
    @RequestMapping(value="thumb",method=RequestMethod.POST)
    @ResponseBody
    public Object GenerateImage(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException{
        Map<String,Object> result =new HashMap<String,Object>();
        String uriPath= CommonVal.imgPreUri;//图片链接访问前缀
        String realUploadPath = CommonVal.imgRealPath;//图片存储真实路径
        if(realUploadPath.equals("")){
            realUploadPath = request.getSession().getServletContext().getRealPath("/")+"/images";
            uriPath = "meeting_sys/images";
        }
        //获取上传后原图的相对地址
        String imageUrl=Upload.uploadImage(file, realUploadPath,uriPath);
        result.put("code", 0);
        result.put("url", "http://"+imageUrl);
        return result;
    }
    
    @RequestMapping(value="imgUploadForWangEditor",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> imgUploadForWangEditor(@RequestParam MultipartFile[] files,HttpServletRequest request) throws UnknownHostException{
        if(files==null){
            return null;
        }
        List<String> urls = new ArrayList<String>();
        Map<String,Object> result = new HashMap<String,Object>();
        String uriPath= CommonVal.imgPreUri;//图片链接访问前缀
        String realUploadPath = CommonVal.imgRealPath;//图片存储真实路径
        if(realUploadPath.equals("")){
            realUploadPath = request.getSession().getServletContext().getRealPath("/")+"/images";
            uriPath = "meeting_sys/images";
        }
        for(MultipartFile f:files){
            String imageUrl;
            try {
                imageUrl = Upload.uploadImage(f, realUploadPath,uriPath);
                urls.add("http://"+imageUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            result.put("data", urls);
            result.put("errno", 0);
            return result;
        }
        
    }
