package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by RJzz on 2016/12/3.
 */
public class SqlHelper {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private ResultSetMetaData metaData = null;

    //链接数据库的属性
    private String driver, url;
    Properties properties = new Properties();
    //使用类加载器关联文件
    public SqlHelper() {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("DB.properties");
        try {
            properties.load(input);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            //加载驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                input = null;
                e.printStackTrace();
            }
        }

    }

    //查询函数
    public Vector<Object[]> executeQuery(String sql, String[] parameters) {
        Vector<Object[]> vector = new Vector<Object[]>();

        try {
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement(sql);
            //给问号赋值
            if(parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    statement.setString(i + 1, parameters[i]);
                }
            }
            resultSet = statement.executeQuery();
            //得到共有多少列
            metaData = resultSet.getMetaData();
            int column = metaData.getColumnCount();

            //循环取出数据
            while(resultSet.next()) {
                Object[] objects = new Object[column];
                for(int i = 0; i < objects.length; ++i) {
                    objects[i] = resultSet.getObject(i);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return vector;
    }

    //增删改函数
    public int executeUpdate(String sql, String parameters[], Date date) {
        int isOk = 0;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement(sql);
            //给问号赋值
            if(parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    statement.setString(i + 1, parameters[i]);
                }
            }
            if(date != null) {
                statement.setDate(9, date);
            }
            isOk = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return isOk;
    }

    //查询共有多少列和列名
    public String[] executeColumn(String sql, String[] parameters) {
        String columnName[] = null;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement(sql);
            //给问号赋值
            if(parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    statement.setString(i + 1, parameters[i]);
                }
            }
            resultSet = statement.executeQuery();
            metaData = resultSet.getMetaData();
            int column = metaData.getColumnCount();
            columnName = new String[column];
            while(resultSet.next()) {
                for(int i = 0; i < columnName.length; ++i) {
                    columnName[i] = metaData.getCatalogName(i + 1);
                }
            }
        } catch (SQLException e) {
            new RuntimeException(e.getMessage());
            e.printStackTrace();
        }finally {
            this.close();
        }
        return columnName;
    }

    //针对表的查询函数
    public Vector<Object> executeTable(String sql, String parameters[]) {
        Vector<Object> vector = new Vector<Object>();
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement(sql);
            //给问号赋值
            if(parameters!=null){
                for(int i=0;i<parameters.length;i++){
                    statement.setString(i+1, parameters[i]);
                }
            }
            resultSet = statement.executeQuery();
            //得到共有多少列
            metaData = resultSet.getMetaData();
            //循环的取出数据
            while(resultSet.next()){
                //临时集合
                Vector<String> temp = new Vector<String>();

                for(int i = 0; i < metaData.getColumnCount() ; ++i){
                    //把每列的数据加入临时集合
                    temp.add(resultSet.getString(i+1));
                }
                //把每行数据加入集合
                vector.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return vector;
    }

    //关闭资源函数
    public void close(){
        try {
            if(resultSet!=null) resultSet.close(); resultSet=null;
            if(statement!=null) statement.close(); statement=null;
            if(resultSet!=null) resultSet.close(); resultSet=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
