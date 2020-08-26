package com.sun.api.server.admin.controller;
import com.sun.api.server.admin.service.AdminService;
import com.sun.api.server.admin.vo.AdminUserVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log
@RequestMapping(value="/admin")
@Controller
public class AdminViewController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value={"/","/index"})
    public String index(){
        log.info("index View");

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = req.getSession();

        AdminUserVo loginUser = (AdminUserVo)session.getAttribute("admin");
        if(loginUser == null){
            log.info("로그인페이지 이동 필요");
             return "redirect:/admin/adminLoginView";
            // return new RedirectView("/admin/adminLoginView");
        }else{
            log.info("로그인 성공한 상태");
        }
        
        return "index";
    }

    /**
     * Login View
     * @return
     */
    @RequestMapping(value="/adminLoginView", method = RequestMethod.GET)
    public String adminLoginView(){
        log.info("adminLoginView");
        return "adminLoginView";
    }

    /**
     * Login Post
     * @param adminUserVo
     * @return
     */
    @RequestMapping(value="/adminLoginView", method = RequestMethod.POST)
    public Object adminLoginViewData(AdminUserVo adminUserVo){
        log.info("Form Post");
        log.info(adminUserVo.toString());
        AdminUserVo fetchDbUser = adminService.fetchLoginUserInfo(adminUserVo);
        if(fetchDbUser != null){
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = req.getSession();
            session.setAttribute("admin", fetchDbUser);
            return new RedirectView("/admin/index");
        }
        return new RedirectView("/admin/adminLoginView");
    }

    /**
     * Rec Data  파일 업로드 하는 페이지.
     * @return
     */
    @RequestMapping(value="/recDataView")
    public String recDataView(){
        return "rec/recDataView";
    }

}
