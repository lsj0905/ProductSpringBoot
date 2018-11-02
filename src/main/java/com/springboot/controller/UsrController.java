package com.springboot.controller;

import net.sf.json.JSONObject;
import com.springboot.model.User;
import com.springboot.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class UsrController {

    @Autowired
    UserServiceImp userServiceImp;


    @RequestMapping(value = "/getUser.do",method = RequestMethod.POST)
    public void getUser(HttpServletRequest request, HttpServletResponse response)  {

        String id=request.getParameter("id");
        User date= userServiceImp.getUserByid(Integer.parseInt(id));
        JSONObject json = JSONObject.fromObject(date);
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out= null;
        try {
            out = response.getWriter();
            out.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                out.close();
            }
        }

    }

    @RequestMapping(value="/multilFile.do",method = RequestMethod.POST)
    public void multilFile(MultipartRequest request, HttpServletResponse response) throws FileNotFoundException, InterruptedException {

        List<MultipartFile> list=request.getFiles("files");

        String id=((MultipartHttpServletRequest)request).getParameter("id");

        response.setCharacterEncoding("UTF-8");
        File rootDir=new File("D:\\xystorage\\");
        if(!rootDir.exists()){
            rootDir.mkdir();
        }

        for (MultipartFile mutipartFile:list) {

            String filename =mutipartFile.getOriginalFilename();
            File file=new File(rootDir,filename+"副本"+id);
            try {
                BufferedOutputStream outputStream= new BufferedOutputStream(new FileOutputStream(file));
                byte[] bytes=mutipartFile.getBytes();

                outputStream.write(bytes);
                outputStream.close();

                PrintWriter out=response.getWriter();
                out.write(file.getPath());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    @RequestMapping(value = "/insertUser" , method = RequestMethod.POST)
    @ResponseBody
    public boolean insertUser(User user) throws Exception {

        return userServiceImp.insertUser(user);

    }


    public static void main(String[] args) {

        JSONObject jsonObject=new JSONObject();

        jsonObject.put("liu",1);
        jsonObject.put("liu",1);
        System.out.println(jsonObject.toString());

    }

}
