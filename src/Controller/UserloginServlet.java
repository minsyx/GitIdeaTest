package Controller;

import Bean.Userinfo;
import DBUtil.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet(name = "UserloginServlet",urlPatterns = "/ulogin")
public class UserloginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码转译，解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取jsp上文本框里的用户名和密码,方便数据库的联动
        String user=req.getParameter("username");
        String pass=req.getParameter("passwd");

        DBconnect db=new DBconnect();
        Userinfo u=new Userinfo();

        if(user==null||pass==null)
            resp.getWriter().write("<script language=javascript>alert('用户名或密码不能为空');window.location='index.jsp'</script>");
        try {
            if(user!=null&&pass!=null)
            {
                String sql="select * from userinfo where username=? and passwd=? and qx="+1;
                Connection conn = db.getconnect();
                PreparedStatement p=conn.prepareStatement(sql);
                p.setString(1,user);
                p.setString(2,pass);
                ResultSet res=p.executeQuery();

                if(res.next())//若查询到相关记录，则登陆成功跳转页面
                    resp.getWriter().write("<script language=javascript>alert('登陆成功');window.location='main.jsp'</script>");
                if(!res.next())
                    resp.getWriter().write("<script language=javascript>alert('用户名或密码不正确');window.location='index.jsp'</script>");

                res.close();
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
