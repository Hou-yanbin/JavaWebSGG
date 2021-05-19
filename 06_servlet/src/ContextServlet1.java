import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext context = getServletContext();
//        context.setAttribute("key2", "valuepost");
//        System.out.println("Context1 中获取域数据key2的值是:"+ context.getAttribute("key2"));
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getServletConfig().getServletContext();//getServletConfig()调用Config对象来使用getServletContext
        // 获取ServletContext对象
        ServletContext context = getServletContext();
        //System.out.println(context)与ContextServlet2验证context地址是否是同一个，
        //一个web工程只有一个ServletContext对象实例
        System.out.println(context);
        System.out.println("保存之前: Context1 doGet获取 key1的值是:"+ context.getAttribute("key1"));

        //存数据
        context.setAttribute("key1", "value1");

        System.out.println("Context1 中获取域数据key1的值是:"+ context.getAttribute("key1"));//输出value1


    }
}
