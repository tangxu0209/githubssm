package com.controller;

import com.pojo.Admin;
import com.pojo.Article;
import com.pojo.Banner;
import com.pojo.Users;
import com.service.AdminService;
import com.service.ArticleService;
import com.service.BannerService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("adminindex")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/loginadmin")
    private String LoginAdmin(Model model, Admin admin, HttpSession httpSession) {

        Admin admin1 = adminService.getAdminByName(admin);
        if (admin1 == null) {
            model.addAttribute("message1", "用户名不存在");
            return "admin/index";
        } else {
            Admin admin2 = adminService.LoginAdmin(admin);
            if (admin2 == null) {
                model.addAttribute("message2", "密码错误");
                return "admin/index";
            } else {
                httpSession.setAttribute("adminid", admin2.getAdminid());
                httpSession.setAttribute("adminname", admin2.getUsername());
                httpSession.setAttribute("realname", admin2.getRealname());
                return "admin/main";
            }
        }
    }

    // 准备添加数据
    @RequestMapping("createAdmin")
    public String createAdmin() {
        return "admin/addadmin";
    }

    @RequestMapping("addAdmin")
    private String AddAdmin(Admin admin) {
        admin.setAdminid(UUID.randomUUID().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        admin.setAddtime(simpleDateFormat.format(new Date()));
        int i = adminService.AddAdmin(admin);
        return "redirect:admin/createAdmin";
    }

    @RequestMapping("listAdmin")
    private String ListAdmin(Model model) {
        List<Admin> adminList = adminService.getAdminList();
        model.addAttribute("adminList", adminList);
        return "admin/listadmin";
    }

    @RequestMapping("getAdminById")
    private String getAdminById(String id, Model model) {
        Admin adminById = adminService.getAdminById(id);
        model.addAttribute("admin", adminById);
        return "admin/editadmin";
    }

    @RequestMapping("deleteAdminById")
    private String deleteAdminById(String id) {
        int i = adminService.deleteAdminById(id);
        System.out.println(i);
        return "redirect:admin/listAdmin";
    }

    @RequestMapping("updateAdminById")
    private String updateAdminById(Admin admin) {
        int i = adminService.updateAdminById(admin);
        if (i > 0) {
            return "redirect:admin/listAdmin";
        }
        return "redirect:admin/getAdminById";
    }

    @RequestMapping("queryAdminByCondIndex")
    private String queryAdminByCondIndex(Model model) {
        List<Admin> adminList = adminService.getAdminList();
        model.addAttribute("adminList", adminList);
        return "admin/queryadmin";
    }

    @RequestMapping("queryAdminByCond")
    private String queryAdminByCond(Model model, String cond, String name) {
        List<Admin> adminCondition = adminService.getAdminCondition(cond, name);
        model.addAttribute("adminList", adminCondition);
        return "admin/queryadmin";
    }

    @RequestMapping("prePwd")
    private String prePwd() {
        return "admin/editpwd";
    }

    @RequestMapping("updateAdminpassword")
    private String updateAdminpassword(Model model, String password, String newpassword, String repassword, HttpSession session) {
        String adminid = (String) session.getAttribute("adminid");
        Admin adminById = adminService.getAdminById(adminid);
        if (adminById != null) {
            if (adminById.getPassword().equals(password)) {
                if (newpassword.equals(repassword)) {
                    String username = (String) session.getAttribute("adminname");
                    String realname = (String) session.getAttribute("realname");
                    Admin admin = new Admin();
                    admin.setAdminid(adminid);
                    admin.setUsername(username);
                    admin.setPassword(newpassword);
                    admin.setRealname(realname);
                    int i = adminService.updateAdminById(admin);
                    if (i > 0) {
                        session.invalidate();
                        return "admin/check_logstate";
                    }
                }
                session.setAttribute("message", "新密码两次校验错误");
                return "redirect:admin/prePwd";
            }
            session.setAttribute("message", "旧密码错误");
            return "redirect:admin/prePwd";
        }
        return "redirect:admin/prePwd";
    }

    @RequestMapping("userList")
    public String userList(Model model) {
        List<Users> users = userService.getUsers();
        model.addAttribute("usersList", users);
        return "admin/listusers";
    }

    @RequestMapping("updateUserStatus")
    public String updateUserStatus(String id) {
        String status = "解锁";
        Users userById = userService.getUserById(id);
        if (status.equals(userById.getStatus())) {
            status = "锁定";
        }
        userById.setStatus(status);
        userService.updateUserStatus(userById);
        return "redirect:admin/userList";
    }

    @RequestMapping("deleteUsers")
    public String DeleteUsers(String id) {
        userService.deleteUserById(id);
        return "redirect:admin/userList";
    }

    @RequestMapping("queryUsersByCondIndex")
    private String queryUsersByCondIndex(Model model) {
        List<Users> users = userService.getUsers();
        model.addAttribute("usersList", users);
        return "admin/queryusers";
    }

    @RequestMapping("queryUsersByCond")
    private String queryUsersByCond(String cond, String name, Model model) {
        List<Users> users = userService.queryUsersByCond(cond, name);
        model.addAttribute("usersList", users);
        return "admin/queryusers";
    }

    @RequestMapping("createArticle")
    private String createArticle(Model model){
        List<Banner> bannerList = bannerService.getBannerList();
        model.addAttribute("bannerList",bannerList);
        return "admin/addarticle";
    }

    @PostMapping("addArticle")
    private String addArticle(String title,String bannerid, @RequestParam("fileup") MultipartFile file,String contents){
        //新文件吗
        String s = UUID.randomUUID().toString();
        //获取源文件的后缀
        String substring = file.getOriginalFilename();
        int i = substring.lastIndexOf(".");
        String substring1 = substring.substring(i);
        File myFile = new File("d:/img/ssmxianmu");
        if (!myFile.exists()) {
            myFile.mkdirs();
        }
        String path = myFile+"/"+s+substring1;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Article article = new Article();
        article.setArticleid(s);
        article.setTitle(title);
        article.setBannerid(bannerid);
        article.setImage(path);
        article.setContents(contents);
        article.setAddtime(simpleDateFormat.format(new Date()));
        article.setHits("0");

        int i1 = articleService.addArticle(article);

        return "redirect:getAllArticle";
    }

    @RequestMapping("getAllArticle")
    public String listArticle(Model model){
        List<Article> article = articleService.getArticle();
        model.addAttribute("articleList",article);
        return "admin/listarticle";
    }

    @RequestMapping("getArticleById")
    public String getArticleById(String id,Model model){
        Article articleById = articleService.getArticleById(id);
        List<Banner> bannerList = bannerService.getBannerList();
        model.addAttribute("bannerList",bannerList);
        model.addAttribute("article",articleById);
        return "admin/editarticle";
    }

    @RequestMapping("updateArticle")
    public String updateArticle(String articleid,String title,String bannerid, @RequestParam("fileup") MultipartFile file,String contents){
        //新文件吗
        String s = UUID.randomUUID().toString();
        //获取源文件的后缀
        String substring = file.getOriginalFilename();
        int i = substring.lastIndexOf(".");
        String substring1 = substring.substring(i);
        File myFile = new File("d:/img/ssmxianmu");
        if (!myFile.exists()) {
            myFile.mkdirs();
        }
        String path = myFile+"/"+s+substring1;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String contentType = "<p>"+contents+"<p>";

        Article article = new Article();
        article.setArticleid(articleid);
        article.setTitle(title);
        article.setBannerid(bannerid);
        article.setImage(path);
        article.setContents(contentType);

        int i1 = articleService.updateArticle(article);
        return "redirect:getAllArticle";
    }

    @RequestMapping("deleteArticle")
    public String deleteArticle(String id){
        int i = articleService.deleteArticle(id);
        return "redirect:getAllArticle";
    }

    @RequestMapping("queryArticleByCond")
    public String queryArticleByCond(Model model){
        List<Article> articleList = articleService.getArticle();
        model.addAttribute("articleList",articleList);
        return "admin/queryarticle";
    }

    @RequestMapping("myQueryArticleByCond")
    public String myQueryArticleByCond(String cond,String name){

        return "";
    }

}
