package cn.kiiwii.framework.mybatis.service;

import cn.kiiwii.framework.mybatis.model.Account;
import cn.kiiwii.framework.mybatis.model.Account2;

import java.util.List;

/**
 * Created by zhong on 2016/9/5.
 */
public interface ITestService {

    public void test();

    public boolean transfer(float money, int from, int to) throws Exception;

    public int insertAccount(Account account);

    public int insertAccount2(Account2 account2);


    public Account findAccountById(int i);

    public Account2 findAccount2ById(int i);


    public List<Account> findAccountsById(int i);
    public List<Account2> findAccount2sById(int i);

    public List<Account> findAccountUnionAll(int id);
}
