package com.atguigu.enumerate;

import javax.xml.crypto.Data;
import java.util.EnumMap;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: Jia_Q
 * @create: 2020-07-19 18:33
 **/
public class DataBaseInfo {
    public enum DataBaseType
    {
        MYSQL,ORACLE,DB2,SQLSERVER
    }

    //某类中定义的获取数据库URL的方法以及EnumMap的声明
    private EnumMap<DataBaseType, String> urls = new EnumMap<DataBaseType, String>(DataBaseType.class);
    public DataBaseInfo()
    {
        urls.put(DataBaseType.DB2,"jdbc:db2://localhost:5000/sample");
        urls.put(DataBaseType.MYSQL,"jdbc:mysql://localhost/mydb");
        urls.put(DataBaseType.ORACLE,"jdbc:oracle:thin:@localhost:1521:sample");
        urls.put(DataBaseType.SQLSERVER,"jdbc:microsoft:sqlserver://sql:1433;Database=mydb");
    }

}
