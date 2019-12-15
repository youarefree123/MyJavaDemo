package Database;

import com.sun.source.tree.WhileLoopTree;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class Connect {
    public static void main(String[] args) throws SQLException, IOException {
        try {
            Connection conn = getConnection();
            System.out.println("是否成功连接pg数据库"+conn);
            String sql ="select * from public.superstart";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
//            update(statement);
            showResultSet(resultSet); //列出表内数据
//            System.out.println("查询：");
//            searchData(resultSet,"170312149");
            resultSet.close();
            statement.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }



    }

    public static void update(Statement statement) throws SQLException
    {
        String sql = "INSERT INTO superstart VALUES ('170312195','宣自风','风少','我爱学java')";
        //执行更新操作
        statement.executeUpdate(sql);
    }


    public static void searchData(ResultSet resultSet,String id) throws SQLException
    {
        ResultSetMetaData metaData = resultSet.getMetaData(); //得到元数据
        int columnCount = metaData.getColumnCount(); //得到每条数据的项数
        boolean flag = false;
        while(resultSet.next()){
            if(resultSet.getString(1).equals(id)){
                flag = true;
                for (int i = 1; i <= columnCount; i++)
                {
                    if (i > 1) System.out.print(", ");
                    System.out.print(resultSet.getString(i));
                }
                break;
            }
        }
        if(!flag)
            System.out.println("NOT FOUND");


    }
    public static void showResultSet(ResultSet result) throws SQLException
    {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++)
        {
            if (i > 1) System.out.print(", ");
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (result.next())
        {
            for (int i = 1; i <= columnCount; i++)
            {
                if (i > 1) System.out.print(", ");
                System.out.print(result.getString(i));
            }
            System.out.println();
        }
    }



    public static Connection getConnection() throws SQLException, IOException
    {
        Properties prop = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("./src/Database/database.properties")))
        {
            prop.load(in);
        }
        String drivers = prop.getProperty("jdbc.drivers");
        String url = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}


