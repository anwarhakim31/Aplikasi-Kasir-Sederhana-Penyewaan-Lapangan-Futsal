////bagian deklarasi
import javax.swing.*;//Mengimpor kelas dan interface untuk komponen GUI  seperti JOptio
import java.sql.*;//Mengimpor Class untuk mendukung akses dan pengolahan data dalam databse
import java.awt.event.*;//Mengimpor Class untuk perancangan user-interface dengan event
import java.awt.*;//Mengimpor Class untuk perancangan user-interface dan event-handling

public class Menu//membuat class
{
    
    static JFrame frame = new JFrame();
    
    ////membuat button/tombol 
    static JRadioButton paketA = new JRadioButton ("Kelas A");
    static JRadioButton paketB = new JRadioButton ("Kelas B");
    
    static JRadioButton ls1 = new JRadioButton ("1 jam");
    static JRadioButton ls2 = new JRadioButton ("2 jam");
    static JRadioButton ls3 = new JRadioButton ("3 jam");
    
    
    static JButton btnBayar = new JButton ("Pembayaran");
    static JButton btnReset = new JButton ("Reset");
    static JButton btnDataPemesan = new JButton ("Data Pemesan");
    static JButton btnCancelCustom = new JButton ("Cancel");
    static JButton btnCustom = new JButton ("> 3 jam");
    
    ////membuat button variabel secara kelompok 
    static ButtonGroup grupPaket = new ButtonGroup();
    static ButtonGroup grupWaktu = new ButtonGroup();

    ////membuat label 
    static JLabel input = new JLabel("Data Pemesan : ");
    static JLabel p1 = new JLabel("Paket Lapangan :");
    static JLabel p2 = new JLabel("Waktu Sewa :");
    
    static JLabel No = new JLabel("Nomer ");
    static JLabel Nama = new JLabel("Nama  ");
    static JLabel Tlp = new JLabel("Telephone ");
    static JLabel Tanggal = new JLabel("Jadwal Main");
    static JLabel contoh = new JLabel("(kamis,31/12/2001)");
    static JLabel Mulai = new JLabel("Jam Main");
    static JLabel Custom = new JLabel(" Custom ");
    static JLabel lblJam = new JLabel(" Jam ");
    ////membuat textfield 
    static JTextField txtCustom = new JTextField();
    static JTextField txtNo = new JTextField();
    static JTextField txtNama = new JTextField();
    static JTextField txtTlp = new JTextField();
    static JTextField txtTanggal = new JTextField();
    static JTextField txtMulai = new JTextField();
    
    
    static void DataUtama()//mebuat fungsi datautama
    {
    GUI();//terdiri fungsi gui = Gui berisi pencetakan tampilan pada frame
    Aksi();//aksi            =aksi berisi perintah kepada button 
    }

    
    static void GUI(){ //membuat fungsi gUI
        
        ////membuat dan mengatur tampilan frame
        frame.setTitle("Santiago Berdebu Futsal");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 310, 60));
        frame.setSize(500,370);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#A8B0BA") );
        
        
        //membuat label 
        JLabel intro = new JLabel("~| Menu Transaksi |~");
        //mengatur jenis dan ukuran font pada label
        intro.setFont(new Font("Georgia", Font.BOLD, 20));
        
        ////=menambahkan pada frame //posisi cetak pada frame 
        frame.add(intro);   intro.setBounds(140, 10, 400,20);
        frame.add(input);   input.setBounds(50, 155, 300, 20);
        frame.add(p1);      p1.setBounds(50, 50, 130, 20);

        frame.add(paketA);     grupPaket.add(paketA);  paketA.setBounds(50, 85, 100,20);
        frame.add(paketB);     grupPaket.add(paketB);  paketB.setBounds(50, 105, 100,20);
        
        frame.add(p2);      p2.setBounds(160, 50, 100, 20);
        frame.add(ls1);     grupWaktu.add(ls1);  ls1.setBounds(160,75 , 80,20);
        frame.add(ls2);     grupWaktu.add(ls2);  ls2.setBounds(160,95, 80,20);
        frame.add(ls3);     grupWaktu.add(ls3);  ls3.setBounds(160,115, 80,20);
        
        frame.add(No);     No.setBounds(50, 180, 130, 20);
        frame.add(Nama);   Nama.setBounds(50, 205, 130, 20);
        frame.add(Tlp);    Tlp.setBounds(50, 230, 130, 20);
        frame.add(Tanggal);Tanggal.setBounds(50, 270, 130, 20);
        frame.add(contoh); contoh.setBounds(133, 250, 300, 20);
        frame.add(Mulai);  Mulai.setBounds(50, 295, 130, 20);
        
        
        frame.add(txtNo);   txtNo.setBounds(130, 180, 50, 20);
        frame.add(txtNama); txtNama.setBounds(130, 205, 110, 20);
        frame.add(txtTlp); txtTlp.setBounds(130, 230, 110, 20);
        frame.add(txtTanggal);txtTanggal.setBounds(130, 270, 110, 20);
        frame.add(txtMulai);  txtMulai.setBounds(130, 295, 50, 20);
        
        frame.add(btnBayar); btnBayar.setBounds(305 ,205, 120, 20);
        frame.add(btnReset); btnReset.setBounds(158, 155, 80, 20);
        frame.add(btnDataPemesan); btnDataPemesan.setBounds(305, 270, 120, 20);
        
        
        frame.add(btnCustom); btnCustom.setBounds(305, 60, 120, 20);
     
                
    }
    
    static void Aksi() //mebuat fungsi aksi untuk perintah pada button
    {
    btnBayar.addActionListener(new ActionListener(){//button saat di klik 
            
        public void actionPerformed(java.awt.event.ActionEvent e)
        {    
             //menampilkan fungsi 
             simpan();
             faktur();
             reset();
        }
    });
    btnDataPemesan.addActionListener(new ActionListener(){//button saat di klik 
        public void actionPerformed(ActionEvent e)
        {
            //memunculkan frame saat di klik
            frame.setVisible(true);
            //menmpilkan fungsi Menu Table pada class DataPemesan
            DataPemesan.MenuTable();
        }
    });
    btnReset.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e)
         {  
             reset();

         }
    });
    
    btnCancelCustom.addActionListener(new ActionListener(){ //saat di klik 
        public void actionPerformed(ActionEvent e) 
        {   
            ////bernilai false akan menyembuyikan di frame
            Custom.setVisible(false);   
            txtCustom.setVisible(false); 
            lblJam.setVisible(false);  
            btnCancelCustom.setVisible(false);
            txtCustom.setText("");
        }
    });
         btnCustom.addActionListener(new ActionListener(){//saat di klik
        public void actionPerformed(ActionEvent e)
        {
            
        frame.add(Custom);  Custom.setBounds(300,90,100,20);
        frame.add(txtCustom);txtCustom.setBounds(345,90, 40,20);
        frame.add(lblJam);  lblJam.setBounds(395,90,40,20);
        frame.add(btnCancelCustom);btnCancelCustom.setBounds(315,120,100,20);
         
        ////bernilai true akan menampilkan di frame
        Custom.setVisible(true);   
        txtCustom.setVisible(true); 
        lblJam.setVisible(true);  
        btnCancelCustom.setVisible(true);
        txtCustom.setText("");
        
        ////perintah saat mengklik custom maka menghapus button Grup
        grupPaket.clearSelection();
        grupWaktu.clearSelection();
        }
    });
    }
    static void reset(){
        btnReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            ////perintah membersihkan tampilan yang terisi di frame
            grupPaket.clearSelection();
            grupWaktu.clearSelection();
            txtNo.setText("");
            txtNama.setText("");
            txtTlp.setText("");
            txtTanggal.setText("");
            txtMulai.setText("");
            }
        });
    }
    
    static void faktur(){ //membuat fungsi faktur
        
        int harga;
        harga = 0;
    
        if(paketA.isSelected()){//jika pilih button paketA 
            if(ls1.isSelected()){//dan jika pilih button Ls1 
                harga=75000;
            }else if(ls2.isSelected()){
                harga=75000;
            }else if(ls3.isSelected()){
                harga=65000;
            }else{ //selain pilih di atas atau custom
                harga=75000;
            }
        }
        if(paketB.isSelected()){
            if(ls1.isSelected()){
                harga=60000;
            }else if(ls2.isSelected()){
                harga=60000;
            }else if(ls3.isSelected()){
                harga=50000;
            }else{
                harga=60000;
            }
        }
        String Durasi,Paket;
        Durasi ="";
        Paket =" ";
        if(paketA.isSelected()){
            Paket="Paket A ";
            if(ls1.isSelected()){
                Durasi ="1";
            }else if(ls2.isSelected()){
                Durasi = "2";
            }else if(ls3.isSelected()){
                Durasi="3";
            }else{
                Durasi=txtCustom.getText();
            }
        }
        if(paketB.isSelected()){
            Paket="Paket B";
            if(ls1.isSelected()){
                Durasi ="1";
            }else if(ls2.isSelected()){
                Durasi = "2";
            }else if(ls3.isSelected()){
                Durasi="3";
            }else{
                Durasi=txtCustom.getText();
            }
        }
        
        int Waktu = Integer.parseInt(Durasi);
        int jumlah = Waktu * harga;//menghitung harga total
       
        String output =//menampilkan faktur pada frame jOption
        
        
                "                               Faktur"+"\n"
                
                
                +"No: " + txtNo.getText()+"\n"
                +"Nama: " + txtNama.getText()+"\n"
                +"Tlp: " + txtTlp.getText()+"\n\n"
                +"Tanggal Main: " + txtTanggal.getText()+"\n"
                +"Jam Main: " + txtMulai.getText()+"\n"
                +"Pilihan Paket : "+ Paket +"\n"
                +"Durasi        : "+Waktu+" jam"+"\n"
                +"Harga Total   : "+"Rp."+jumlah+"\n\n"
                
                +"Uang          : ";
        
                                                                                    //menanmpilkan inputan pada Joption
        String faktur = JOptionPane.showInputDialog(null,output, "Santiag Berdebu",JOptionPane.QUESTION_MESSAGE);
        int uang = Integer.parseInt(faktur);
        int kembalian = uang-jumlah;
        JOptionPane.showMessageDialog(null,"Uang Kembalian = "+"Rp."+kembalian); 
    
        
        }
   
    static void simpan()
    {
        int harga;
        harga = 0;
        
        if(paketA.isSelected()){ //jika pilih button paketA 
            if(ls1.isSelected()){//dan jika milih button ls1
                harga=75000;
            }else if(ls2.isSelected()){
                harga=75000;
            }else if(ls3.isSelected()){
                harga=65000;
            }else{
                harga=75000;
            }
        }
        if(paketB.isSelected()){
            if(ls1.isSelected()){
                harga=60000;
            }else if(ls2.isSelected()){
                harga=60000;
            }else if(ls3.isSelected()){
                harga=50000;
            }else{
                harga=60000;
            }
        }
        String Durasi,Paket;
        Durasi ="";
        Paket =" ";
        if(paketA.isSelected()){
            Paket="Paket A ";
            if(ls1.isSelected()){
                Durasi ="1";
            }else if(ls2.isSelected()){
                Durasi = "2";
            }else if(ls3.isSelected()){
                Durasi="3";
            }else{
                Durasi=txtCustom.getText();
            }
        }
        if(paketB.isSelected()){
            Paket="Paket B";
            if(ls1.isSelected()){
                Durasi ="1";
            }else if(ls2.isSelected()){
                Durasi = "2";
            }else if(ls3.isSelected()){
                Durasi="3";
            }else{
                Durasi=txtCustom.getText();
            }
        }
        int Waktu = Integer.parseInt(Durasi);
        int jumlah = Waktu * harga;
        
        try{//menyimpan data yang sudah di iput ke database
             //menyambung ke class koneksi
            Connection con = new koneksi().getConnection();
            //menjadikan varibel stat membuat statement
            Statement stat = con.createStatement();
            //menampilkan statement untuk  mengupdate data pada tabel di database   
            stat.executeUpdate("Insert into data values ('"
            +txtNo.getText()+"','"
            +txtNama.getText()+"','"
            +txtTlp.getText()+"','"
            +txtTanggal.getText()+"','"
            +txtMulai.getText()+"','"
            + Paket +"','"
            + jumlah +"',"
            + Waktu +")"
            );
            //menampilkan pesan jika berhasil menyimpan
            JOptionPane.showMessageDialog(null,"          Data Tersimpan  ");    
        }catch(Exception x){
        JOptionPane.showMessageDialog(null,"Data Tidak Tersimpan");    
        }
    }
}
