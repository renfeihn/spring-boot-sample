package cn.kiiwii.framework.mybatis.controller;

import cn.kiiwii.framework.mybatis.model.Account;
import cn.kiiwii.framework.mybatis.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhong on 2016/11/10.
 */
@RestController
@Controller
public class TestController {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestController.class);
    @Autowired
    private ITestService testService;

//    @Autowired
//    private ITestXmlService testXmlService;

    @ResponseBody
    @RequestMapping("/test")
    public List<Account> test(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testService.findAccountsById(3);
        logger.info(accountList);
        return accountList;
    }
//    @ResponseBody
//    @RequestMapping("/testXml")
//    public List<Account> testXml(HttpServletRequest request, HttpServletResponse response) {
//        List<Account> accountList = this.testXmlService.findAccountsById(3);
//        logger.info(accountList);
//        return accountList;
//    }
}
