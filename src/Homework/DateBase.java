package Homework;
import java.sql.*;


/**
 *实验十：数据库编程
 */
public class DateBase {
    public static void main(String []args) throws Exception
    {
        Class.forName("org.postgresql.Driver");
        Connection conn=DriverManager.getConnection("jdbc:postgresql://www.chizhouyu.com:5432/corejava","corejava","java");
        String str="INSERT INTO superstar VALUES('170312149','蒋骏','你好')";
        String hh="SELECT*FROM superstart";
        Statement st=conn.createStatement();
        //st.executeQuery(hh);
        ResultSet res=st.executeQuery(hh);
        //int nres=st.executeUpdate(hh);
        ResultSetMetaData resm=res.getMetaData();
        int cot=resm.getColumnCount();
        while(res.next()) {
            for(int i=1;i<=cot;i++)
            {
                System.out.println(res.getString(i)+"\n");
            }
        }
        res.next();
        int id=res.getInt(1);
        System.out.println(id);
    }
}
