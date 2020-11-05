
package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class InputData extends JFrame{
    public String no_mk, nama_mk, kelas, nip;
    
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("JDBC");
   
    JLabel lNo = new JLabel("NO MK  ");
        JTextField tfNo = new JTextField();
    JLabel lNama = new JLabel("NAMA MK  ");
        JTextField tfNama = new JTextField();
    JLabel lNIP= new JLabel("NIP DOSEN ");
        JTextField tfNIP = new JTextField();
    JLabel lKelas = new JLabel("KELAS ");
        JTextField tfKelas = new JTextField();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnLihat = new JButton("Lihat");

    public InputData() {
        window.setLayout(null);
        window.setSize(550,200);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);


       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lNama);
        window.add(tfNo);
        window.add(tfNama);
        window.add(tfNIP);
        window.add(tfKelas);
        window.add(lNo);
        window.add(lKelas);
        window.add(lNIP);
        window.add(btnTambahPanel);
        window.add(btnLihat);



//LABEL
        lNo.setBounds(5, 35, 120, 20);
        lNama.setBounds(5, 60, 120, 20);
        lNIP.setBounds(5,85,120,20);
        lKelas.setBounds(5,105,120,20);

//TEXTFIELD
        tfNo.setBounds(110, 35, 120, 20);
        tfNama.setBounds(110, 60, 120, 20);
        tfNIP.setBounds(110, 85, 120, 20);
        tfKelas.setBounds(110, 105, 120, 20);


//BUTTON PANEL
        btnTambahPanel.setBounds(250, 35, 90, 20);
        btnLihat.setBounds(250,60,90,20);

        
        btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `jadwal`(`no_mk`, `nama_mk`,`nip_dosen`,`kelas`) VALUES ('"+getNo()+"','"+getNama()+"','"+getNIP()+"','"+getKelas()+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LihatData lihat = new LihatData();
            }
        });
    }
    
    

    public String getNama(){
        return tfNama.getText();
    }

    public String getNo() {
        return tfNo.getText();
    }

    public String getNIP() {
        return tfNIP.getText();
    }

    public String getKelas() {
        return tfKelas.getText();
    }
    
    public void inputDB(){
        
    }
}


