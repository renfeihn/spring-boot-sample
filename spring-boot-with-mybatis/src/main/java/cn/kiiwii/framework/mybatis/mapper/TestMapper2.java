package cn.kiiwii.framework.mybatis.mapper;

import cn.kiiwii.framework.mybatis.model.Account2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhong on 2016/12/22.
 */
public interface TestMapper2 {

    String ADD_MONEY = "update account2 set money = money+#{1} where id = #{0}";

    String MINUS_MONEY = "update account2 set money = money-#{1} where id = #{0}";

    String INSERT_ACCOUT2 = "insert into account2 (name,money,flag) values (#{name},#{money},#{flag})";

    String FIND_ACCOUNT2_BY_ID = "select " +
            " id as id," +
            " name as name," +
            " flag as flag," +
            " money as money" +
            " from account2 " +
            " where " +
            " id = #{id}";

    String FIND_ACCOUNT2S_BY_ID = "select " +
            " id as id," +
            " name as name," +
            " flag as flag," +
            " money as money" +
            " from account2 " +
            " where " +
            " id >= #{id}";

    @Update(ADD_MONEY)
    public int addMoney(int userId, float money);

    @Update(MINUS_MONEY)
    public int minusMoney(int userId, float money);

    @Insert(INSERT_ACCOUT2)
    public int insertAccount(Account2 account2);

    @Select(FIND_ACCOUNT2_BY_ID)
    public Account2 getAccount2ById(int id);

    @Select(FIND_ACCOUNT2S_BY_ID)
    public List<Account2> findAccount2sById(int id);


}
