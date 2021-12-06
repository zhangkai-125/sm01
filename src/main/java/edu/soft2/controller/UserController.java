package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        System.out.println("--------logout()------------");
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println("session失效");
        String msg = "你已退出登录";
        request.setAttribute("msg", msg);
        return "forward:/index.jsp";
    }


    @RequestMapping("delete")
    public String delete() {
        System.out.println("--------delete()------------");
        return "hello";
    }

    @RequestMapping("hello")
    public String hello() {
        System.out.println("--------hello()------------");
        return "hello";
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        System.out.println("-----------login()---------");
        //调用业务层
        int flag = 1;
        if (flag == 1) {
            session.setAttribute("user", user);
            return "welcome";
        }
        return "hello";
    }


    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    public String upload(MultipartFile image, HttpServletRequest request) throws IOException {
        System.out.println("--------upload()---------");
        //获取文件的输入流对象
        InputStream is = image.getInputStream();
        //获取文件名称
        String filename = image.getOriginalFilename();
        //设置上传路径
        String reslPath = request.getServletContext().getRealPath("/images");
        System.out.println("上传路径=" + reslPath);
        //设置上传Server后的新名称TBO
        String newname = doFiename(filename);
        OutputStream os = new FileOutputStream(new File(reslPath, newname));
        int size = IOUtils.copy(is, os);
        System.out.println("上传" + "" + "文件到" + reslPath + "完毕,共计" + size + "字节，上传后文件名为'" + "'");
        //资源释放(原则：先后开关，后先开关)
        os.close();
        is.close();
        return "";
    }

    public String upload2() {

        return "";
    }


    private String doFilenname(String filename) {
        String extension = FilenameUtils.getExtension(filename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + extension;
    }

    private String doFiename(String filename) {
        String extension = FilenameUtils.getExtension(filename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + extension;
    }
}






















