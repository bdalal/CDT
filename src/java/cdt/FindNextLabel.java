package cdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateful;

@Stateful
public class FindNextLabel implements FindNextLabelLocal {
    
    Connection con;
    Statement s;
    ResultSet rs,rs2;
    String sql,retstmt;

    /**
     *
     * @param current
     * @param next
     * @return
     */
    @Override
    public Object findNext(float current,float next){
        
        retstmt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdt", "root", ".hack%//sign66");
            s=con.createStatement();
            
            if(next<40){
                sql="select pid,problm,pdesc,yesL,noL from cdt.problem where pid='"+next+"'";
                rs=s.executeQuery(sql);
                
                rs.next();
                retstmt=rs.getObject("problm").toString()+"///"+rs.getObject("pdesc").toString()+"///"+rs.getObject("pid").toString()+"///"+rs.getObject("yesL").toString()+"///"+rs.getObject("noL").toString();
                return retstmt;
            }
            else if(next>=40){
                sql="select soln from cdt.solution where sid='"+next+"'";
                rs=s.executeQuery(sql);
                
                rs.next();
                retstmt=rs.getObject("soln").toString()+"///end";     
                return retstmt;
            }
        
            rs.close();
            s.close();
            con.close();
        }
        catch(Exception e){
            return e.getClass()+"\n"+e.getCause();
        }
        
        return retstmt;
        
    }

}
