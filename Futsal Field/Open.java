
import java.sql.*;//Mengimpor Class untuk mendukung akses dan pengolahan data dalam database
import javax.swing.*;//interface untuk komponen GUI  menyediakan dukungan untuk tampilan grafis 
import java.awt.event.*;//Mengimpor Class untuk perancangan user-interface dengan event
import java.awt.*;//Mengimpor Class untuk perancangan user-interface dan event-handling

public class Open//nama kelas
    {
    // membuat objek jendela variabel frame
    
    //membuat objek button dengan variabel
    static JButton btnData = new JButton ("Menu Transaksi");

     static void Run()//membuat fungsi run();
    {
        GUI();//terdapat fungsi UI = gui berisi perintah pencetakan tampilan pada frame
        Aksi();//aksi             =aksi berisi perintah menjalankan akepada button 
    }   
    
    static void GUI(){
        // membuat objek jendela variabel frame
        TimeFrame frame = new TimeFrame();
        
        //meembuat gambar dari (alamat direktori file)
        ImageIcon icon = new ImageIcon("D:/program/logo.png");
        //mengatur letak tampik posisi gambar
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 290, 60));
        // berikan judul pada frame
        frame.setTitle("Santiago Berdebu Futsal");
        // ukuran pada frame
        frame.setSize(500,320);
        //posisi frame berada di tengah
        frame.setLocationRelativeTo(null);
        //custom maximize mati
        frame.setResizable(true);
        //program muncul saat di jalankan
        frame.setVisible(true);
        //layout null
        frame.setLayout(null);
        //memberi warna pada tampilan frame dengan format hexadecimal
        frame.getContentPane().setBackground(Color.decode("#A8B0BA") );
        
        ////=membuatt tampilan
        //membuat label 
        JLabel intro = new JLabel();
        JLabel menu1 = new JLabel("~Jenis Lapangan");
        ////mengatur jenis dan ukuran font pada label
        menu1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        JLabel menu2 = new JLabel(" -  paket A (indoor + Lapangan vinyl + 3 bola)");
        menu2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu3 = new JLabel(" -  paket B (indoor + Lapangan Sintetis + 3 bola)");
        menu3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu4 = new JLabel("~Harga sewa perjam Paket A = Rp.75.000");
        menu4.setFont(new Font("Times New Roman", Font.BOLD, 17));
        JLabel menu5 = new JLabel(" -  1 jam   Rp.75.000");
        menu5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu6 = new JLabel(" -  2 jam   Rp.150.000 ");
        menu6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu7 = new JLabel(" -  3 jam   Rp.195.000 (Diskon)");
        menu7.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu8 = new JLabel("~Harga sewa Perjam Paket B = Rp.60.000");
        menu8.setFont(new Font("Times New Roman", Font.BOLD, 17));
        JLabel menu9 = new JLabel(" -  1 jam   Rp.60.000 ");
        menu9.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu10 = new JLabel(" -  2 jam   Rp.120.000 ");
        menu10.setFont(new Font("Times New Roman", Font.BOLD, 15));
        JLabel menu11 = new JLabel(" -  3 jam   Rp.150.000 (Diskon)");
        menu11.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        ////=menambahkan pada frame //posisi cetak pada frame 
        frame.add(menu1);   menu1.setBounds(20, 35, 350,20);
        frame.add(menu2);   menu2.setBounds(20, 55, 500,20);
        frame.add(menu3);   menu3.setBounds(20, 70, 500,20);
        frame.add(menu4);   menu4.setBounds(20, 100, 350,20);
        frame.add(menu5);   menu5.setBounds(20, 120, 350,20);
        frame.add(menu6);   menu6.setBounds(20, 135, 350,20);
        frame.add(menu7);   menu7.setBounds(20, 150, 350,20);
        frame.add(menu8);   menu8.setBounds(20, 180, 350,20);
        frame.add(menu9);   menu9.setBounds(20, 200, 350,20);
        frame.add(menu10);  menu10.setBounds(20, 215, 350,20);
        frame.add(menu11);  menu11.setBounds(20, 230, 350,20);
        
        frame.add(btnData);    btnData.setBounds(340, 240, 140,20);
        
        }
    
     static void Aksi()//membuat fungsi aksi
    {
        btnData.addActionListener(new ActionListener()//button saat di klik 
            {      
            public void actionPerformed(ActionEvent e)
            {   
                //menampilkan fungsi datautama pada class menu
                Menu.DataUtama();
            }
            });
        }     
    }