package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class tiket_kereta {
    private JPanel panel;
    private JTextField textNama_kereta;
    private JTextField harga_tiket;
    private JTextField jumlah_tiket;
    private JTextField uang_bayar;
    private JTextField uang_kembali;
    private JTextField textNama_Pemesan;
    private JTextField textTotalBayar;
    private JComboBox kode_kereta;
    private JComboBox kelas_kereta;
    private JButton hapus;
    private JButton pesan;
    private JButton hitung;
    private JLabel labelKode;
    private JLabel labelRp4;
    private JLabel labelRp2;
    private JLabel labelRp1;
    private JLabel labelRp;
    private JLabel labelNama;
    private JLabel labelTotalbayar;
    private JLabel labelKembalian;
    private JLabel labelJudul;
    private JLabel NamaPemesan;
    private JLabel labelKelas;
    private JLabel labelHarga;
    private JLabel labelJumlahtiket;
    private JLabel labelUangbayar;
    private JTextArea DataPenumpang;
    private JButton keluar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pembelian Tiket Kereta Api");
        frame.setContentPane(new tiket_kereta().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public tiket_kereta() {
        kode_kereta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kode_kereta.getSelectedItem().equals("SBY-BDG")) {
                    textNama_kereta.setText("Surabaya - Bandung");
                } else if (kode_kereta.getSelectedItem().equals("SBY-JKT")) {
                    textNama_kereta.setText("Surabaya - Jakarta");
                } else if (kode_kereta.getSelectedItem().equals("SBY-SMG")) {
                    textNama_kereta.setText("Surabaya - Semarang");
                }
            }
        });

        kelas_kereta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kode_kereta.getSelectedItem().equals("SBY-BDG")) {
                    if (kelas_kereta.getSelectedItem().equals("Eksekutif")) {
                        harga_tiket.setText("300000");
                    } else if (kelas_kereta.getSelectedItem().equals("Bisnis")) {
                        harga_tiket.setText("250000");
                    } else if (kelas_kereta.getSelectedItem().equals("Ekonomi")) {
                        harga_tiket.setText("200000");
                    }
                } else if (kode_kereta.getSelectedItem().equals("SBY-JKT")) {
                    if (kelas_kereta.getSelectedItem().equals("Eksekutif")) {
                        harga_tiket.setText("270000");
                    } else if (kelas_kereta.getSelectedItem().equals("Bisnis")) {
                        harga_tiket.setText("22000");
                    } else if (kelas_kereta.getSelectedItem().equals("Ekonomi")) {
                        harga_tiket.setText("180000");
                    }
                } else if (kode_kereta.getSelectedItem().equals("SBY-SMG")) {
                    if (kelas_kereta.getSelectedItem().equals("Eksekutif")) {
                        harga_tiket.setText("210000");
                    } else if (kelas_kereta.getSelectedItem().equals("Bisnis")) {
                        harga_tiket.setText("160000");
                    } else if (kelas_kereta.getSelectedItem().equals("Ekonomi")) {
                        harga_tiket.setText("70000");
                    }
                }
            }
        });

        hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int harga = Integer.parseInt(harga_tiket.getText());
                int jumlah = Integer.parseInt(jumlah_tiket.getText());
                int hasil = harga * jumlah;
                textTotalBayar.setText(Integer.toString(hasil));
                int total = Integer.parseInt(textTotalBayar.getText());
                int uang = Integer.parseInt(uang_bayar.getText());
                int kembalian = uang - total;
                uang_kembali.setText(Integer.toString(kembalian));
            }
        });

        pesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = Integer.parseInt(textTotalBayar.getText());
                int uang = Integer.parseInt(uang_bayar.getText());
                int kembalian = uang - total;
                if (kembalian <= -1) {
                    JOptionPane.showMessageDialog(kode_kereta, "Mohon maaf proses gagal dikarenakan uang yang Anda bayar kurang", "Transaksi gagal", JOptionPane.WARNING_MESSAGE);
                } else if (kembalian >= 0)  {
                    JOptionPane.showMessageDialog(kode_kereta, "Tiket Anda akan dicetak dalam ");
                    for (int i=3; i>=1; i--) {
                        JOptionPane.showMessageDialog(kode_kereta, +i);
                    }

                    DataPenumpang.setText("E-TIKET KERETA API" + "\n\nNama Kereta : Singasari" + "\nNama Pemesan : " + textNama_Pemesan.getText() +
                            "\nKode Jurusan : " + kode_kereta.getSelectedItem() + "\nKelas Kereta : " + kelas_kereta.getSelectedItem() +
                            "\nBerangkat-Tiba : " + textNama_kereta.getText() + "\nHarga Tiket : Rp." + harga_tiket.getText() +
                            "\nJumlah Tiket : " + jumlah_tiket.getText() + "\nHarga Total : Rp." + textTotalBayar.getText() +
                            "\nUang Kembalian : Rp." + uang_kembali.getText() + "\n\nSilahkan ambil tiket pesanan Anda");
                }
            }
        });

        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNama_Pemesan.setText("");
                textNama_kereta.setText("");
                harga_tiket.setText("");
                jumlah_tiket.setText("");
                textTotalBayar.setText("");
                uang_bayar.setText("");
                uang_kembali.setText("");
                kelas_kereta.setSelectedIndex(0);
                kode_kereta.setSelectedIndex(0);
                DataPenumpang.setText("");
            }
        });

        keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(kode_kereta, "Terima kasih sudah menggunakan jasa kami :)");
                System.exit(0);
            }
        });
    }
}