package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnect {
    private String driver="com.mysql.jdbc.Driver";
    private String user="root";
    private String passwd="jyx4269";
    private String url="jdbc:mysql://localhost:3306/ebook";
    Connection con;
    Statement st;

    public Connection getconnect()throws  Exception
    {
        Class.forName(driver);
        con= DriverManager.getConnection(url,user,passwd);
        return con;
    }
    public Statement getstatement() throws Exception
    {
        if(con==null)
            getconnect();
        if(st==null)
            st=con.createStatement();
        return st;
    }
    public int executeUpdate(String sql) throws Exception
    {
        if(st==null)
            getstatement();
        int i=st.executeUpdate(sql);
        return i;
    }
    public ResultSet executeQuery(String sql) throws Exception
    {
        if(st==null)
            getstatement();
        ResultSet rs=st.executeQuery(sql);
        return rs;
    }
    public void close()throws Exception
    {
        if(st!=null)
            st.close();
        if(con!=null)
            con.close();
    }

    public static void main(String [] args)
    {
        DBconnect db=new DBconnect();
        try
        {
            db.getconnect();
            System.out.println(db.con+"   连接成功!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
