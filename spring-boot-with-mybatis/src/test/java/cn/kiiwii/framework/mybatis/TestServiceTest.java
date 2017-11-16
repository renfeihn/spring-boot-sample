package cn.kiiwii.framework.mybatis;

import cn.kiiwii.framework.mybatis.aop.ServiceAop;
import cn.kiiwii.framework.mybatis.model.Account;
import cn.kiiwii.framework.mybatis.model.Account2;
import cn.kiiwii.framework.mybatis.service.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 2016/12/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestServiceTest {

//    private static Logger logger = LoggerFactory.getLogger(TestServiceTest.class);

    @Resource(name = "testService")
    private ITestService testService;


//    @Resource(name = "testXmlService")
//    private ITestXmlService testXmlService;

    private static int sum = 1000;

    @Test
    public void insert() {
        testInsert(0 * sum, 10 * sum);
        testInsert2(9 * sum, 10 * sum);
    }

    public void testInsert(int start, int end) {
        Account account = null;
        for (int i = start; i < end; i++) {
            account = new Account();
            account.setMoney(i + start);
            account.setName("kael");
            if (i >= 19 * sum) {
                account.setFlag("Y");
            } else {
                account.setFlag("N");
            }
            int id = testService.insertAccount(account);
        }

    }

    public void testInsert2(int start, int end) {
        Account2 account = null;
        for (int i = start; i < end; i++) {
            account = new Account2();
            account.setMoney(i + start);
            account.setName("kael");
            account.setFlag("N");
            int id = testService.insertAccount2(account);

        }
    }

//    @Test
//    public void testXmlInsert() {
//        long start = System.currentTimeMillis();
//        Account account = new Account();
//        account.setMoney(1000);
//        account.setName("小小1");
//        try {
//            int id = testXmlService.insertAccount(account);
//            long end = System.currentTimeMillis();
//            long time = (end - start) / 1000;
//            System.out.println("用时：" + time + " 秒");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void find() {
        fintJava();
        fingSql();
    }

    public void fintJava() {
        long start = System.currentTimeMillis();
        List<Object> list = new ArrayList();
        List<Account> accounts = testService.findAccountsById(0);
        List<Account2> account2s = testService.findAccount2sById(0);

        // 合并两个集合
        list.addAll(accounts);
        list.addAll(account2s);
        System.out.println("集合list size：" + list.size() + "  accounts size: " + accounts.size() + "  account2s size: " + account2s.size());
        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("java 用时：" + (System.currentTimeMillis() - start) + "毫秒   " + time + " 秒");
    }

    public void fingSql() {
        long start = System.currentTimeMillis();
        List<Account> accounts = testService.findAccountUnionAll(0);
        System.out.println("集合size：" + accounts.size());

        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("sql 用时：" + (System.currentTimeMillis() - start) + "毫秒   " + time + " 秒");
    }

    @Test
    public void testList() {
        try {
            List<Account> accounts = testService.findAccountsById(3);
            System.out.println(accounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testXmlList() {
//        try {
////			List<Account> accounts = testXmlService.findAccountsById(3);
//            Account account = testXmlService.findAccountById(3);
//            Account account2 = testXmlService.findAccountById(3);
//            System.out.println(account);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
