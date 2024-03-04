// Mengimpor kelas
import java.sql.*;//Mengimpor Class untuk mendukung akses dan pengolahan data dalam database
public class koneksi{//nama kelas
    static Connection con;
    static Statement stat;
    
    public Connection getConnection(){//menghubungkan blue j ke data base
        try{
        //menentukan drivernya 
        Class.forName("org.sqlite.JDBC");
        //variabel con untuk menanmpung alamat di database ()
        con = DriverManager.getConnection("jdbc:Sqlite:C:/sqlite3/futsal.db");        
        }catch(Exception e) {
        System.out.println("Koneksi Gagal " + e.getMessage());
        } 
        return con;
    }
}
    