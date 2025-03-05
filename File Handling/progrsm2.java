import java.io.FileInputStream ;
import java.io.DataInputStream ;
import java.io.FileOutputStream ;
import java.io.DataOutputStream ;
import java.io.File ;

public class progrsm2 
{
    public static void main(String [] args) throws Exception
    {
        File f = new File("demo1.txt") ;

        FileOutputStream fos = new FileOutputStream(f) ;
        DataOutputStream dos = new DataOutputStream(fos) ;
        dos.writeUTF("Hey There.. Hello World!") ;

        FileInputStream fis = new FileInputStream(f) ;
        DataInputStream dis = new DataInputStream(fis) ;
        System.out.println(dis.readUTF()) ;
    }
}
