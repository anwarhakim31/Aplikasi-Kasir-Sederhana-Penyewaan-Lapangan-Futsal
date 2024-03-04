import java.sql.*;//Mengimpor Class untuk mendukung akses dan pengolahan data dalam databse
import javax.swing.*;//Mengimpor kelas dan interface untuk komponen GUI  seperti JOptioxt()
import java.awt.event.*;//Mengimpor Class untuk perancangan user-interface dengan event
import javax.swing.table.*;//Mengimpor kelas dan interface untuk komponen GUI  tampilan grafis Tabel
import java.awt.*;//Mengimpor Class untuk perancangan user-interface dan event-handling

public class DataPemesan //membuat kelas
    {
    static JFrame frame = new JFrame("Data Pemesan");
    
    //JTable Mendeklarasikan table sebagai Class yang digunakan untuk menampilkan Tabel
    static JTable table = new JTable(); 
    //membuat bagian scroll pada tabel
    static JScrollPane scroll = new JScrollPane(table);
    static Font font1 = new Font("Times New Roman",Font.BOLD, 14);
    
    static JLabel No = new JLabel("No Pesanan Yang ingin dihapus");
    static JTextField txtNo = new JTextField();
    static JButton btnHapus = new JButton("Hapus");
    
           
    static void MenuTable(){    //membuat fungsi
        //terdiri dari fungsi 
        GUI();                   //= gui berisi pencetakan tampilan pada frame table
        isiData();              //=pengambilan data dari database
        aksi();                 //=perintah untuk button
        
    }
    
    static void GUI(){ //membuat Tampilan pada frame
        
        ////mengatur tambpilan dan posisi 
        frame.setSize(740,300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
       
        frame.add(No);              No.setBounds(50,215,200,20);
        frame.add(txtNo);           txtNo.setBounds(20,215,20,20);
        frame.add(btnHapus);        btnHapus.setBounds(240,215,90,20);
        frame.add(scroll);          scroll.setBounds(10, 10, 700, 200);
        frame.setLayout(null);
    }
    
    static void isiData() //membuat fungsi
    {
        //mendeklarasi fungsi untuk memberikan header dan data pada kolom dan baris tabel
        DefaultTableModel tab = new DefaultTableModel();
        JTableHeader tableHeader = table.getTableHeader();
        
        //untuk warna background table
        tableHeader.setBackground(Color.decode("#4F79AD"));
        tableHeader.setFont(font1);
        
        table.setBackground(Color.decode("#A8B0BA"));
        
        ////menambah kolom
        tab.addColumn("Nomer");
        tab.addColumn("Nama");
        tab.addColumn("Tlp");
        tab.addColumn("Tanggal");
        tab.addColumn("Jam Main");
        tab.addColumn("Paket");
        tab.addColumn("Harga");
        tab.addColumn("Durasi");
        table.setModel(tab);
        
        try{  ////mengambil data dari database
            
            //menymabung ke koneksi data
            Connection con = new koneksi().getConnection();
            //menjadikan stat membuat statement 
            Statement stat = con.createStatement();
            //menyamapain kan statement ke data base untuk menampilalkan data yang ada
            ResultSet data = stat.executeQuery("select * from data");
            
            //selama ada data maka
            while (data.next()){
                //membuat baris dari  data di bawah pada database
                tab.addRow(new Object[]{
                ////mengambil data menggunakan variabel pada database
                data.getInt("No"),
                data.getString("Nama"),
                data.getString("Tlp"),
                data.getString("Tanggal_Main"),
                data.getString("Jam_Main"),
                data.getString("Paket"),
                data.getInt("Harga"),
                data.getInt("Durasi"),
                });
            }
        }catch (Exception x){
        }
    }
    
    static void aksi()//fungsi perintaah
    {
        btnHapus.addActionListener(new ActionListener()//button di klik maka
        {
            public void actionPerformed(ActionEvent e)
            {
            try{    
                    //menymabung ke koneksi data
                    Connection con = new koneksi ().getConnection();
                    //menjadikan stat membuat statement 
                    Statement stat = con.createStatement();
                    //menyamapain kan statement ke data base untuk mnampilkan Table No sesuai inputan
                    ResultSet set = stat.executeQuery("select * from data where No ='"+ txtNo.getText()+"'");
                    
                    if (set.next()){//selama data ada maka
                        //jika data yang di input dengan table No sama pada database maka
                          if(txtNo.getText().equals(set.getString("No"))){
                            //menghapus data pada Table No pada database
                            stat.executeUpdate("delete from data where No ='"+txtNo.getText()+"'");
                            JOptionPane.showMessageDialog(null," Data Berhasil Dihapus");
                            frame.setVisible(false);
                            MenuTable();
                            
                            txtNo.setText("");
                        }
                    }
                }catch (Exception x){
            
                
            }
           
        }            
            
        });
        
    }   
}

    
    

