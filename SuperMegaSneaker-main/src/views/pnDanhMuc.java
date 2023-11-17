/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainModels.DanhMucSanPham;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repositories.DanhMucSPRepository;

/**
 *
 * @author Legion
 */
public class pnDanhMuc extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DanhMucSPRepository dmRepo;

    /**
     * Creates new form pnDanhMuc
     */
    public pnDanhMuc() {
        initComponents();
        this.dmRepo = new DanhMucSPRepository();
        loadTableDM();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_DM = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDM = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();

        jLabel1.setText("Tên Danh Mục");

        tblDM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục"
            }
        ));
        tblDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDM);

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lamMoi.setText("Làm Mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txt_DM, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(57, 57, 57)
                                .addComponent(btn_Sua)
                                .addGap(54, 54, 54)
                                .addComponent(btn_xoa)
                                .addGap(49, 49, 49)
                                .addComponent(btn_lamMoi))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_DM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_Sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_lamMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String ten = this.txt_DM.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
        int checkDM = dmRepo.checkTenCL(ten);
        if (checkDM != 0) {
            JOptionPane.showMessageDialog(this, "Tên danh mục đã tồn tại");
            return;
        }
        DanhMucSanPham dm = new DanhMucSanPham();
        dm.setTenDanhMuc(ten);
        dmRepo.them(dm);
        loadTableDM();
        lamMoi2();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        String ten = this.txt_DM.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
        int row = tblDM.getSelectedRow();

        if (row == -1) {
            return;
        }

        int ma = Integer.parseInt(tblDM.getValueAt(row, 0).toString());
        DanhMucSanPham dm = dmRepo.findByName(ma);
        dm.setTenDanhMuc(ten);
        dmRepo.sua(dm);
        loadTableDM();
        lamMoi2();
        JOptionPane.showMessageDialog(this, "Sửa thành công");

    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        lamMoi2();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void tblDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDMMouseClicked
  this.btn_them.setEnabled(false);
        this.btn_Sua.setEnabled(true);
        this.btn_xoa.setEnabled(true);

        int row = tblDM.getSelectedRow();

        if (row == -1) {
            return;
        }

        String ten = tblDM.getValueAt(row, 1).toString();

        this.txt_DM.setText(ten);

        
    }//GEN-LAST:event_tblDMMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
         int row = tblDM.getSelectedRow();

        if (row == -1) {
            return;
        }

        int ma = Integer.parseInt(tblDM.getValueAt(row, 0).toString());
        int choose = JOptionPane.showConfirmDialog(this, "Có chắc muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.NO_OPTION || choose == JOptionPane.CLOSED_OPTION) {
            return;
        }
        DanhMucSanPham dm = dmRepo.findByName(ma);
            int checkXoaDm = dmRepo.checkTruocXoa(dm.getId());
            if (checkXoaDm != 0) {
                JOptionPane.showMessageDialog(this, "Doanh mục này hiện đang liên kết với bảng chi tiết giày.\n Vui lòng xóa CT giày chứa doanh mục này để xóa doanh mục này");
                return;
            }
            dmRepo.xoa(dm.getId());
            loadTableDM();
            lamMoi2();

            JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void loadTableDM() {
        dtm = (DefaultTableModel) tblDM.getModel();

        dtm.setRowCount(0);

        List<DanhMucSanPham> ds = dmRepo.getAll();

        if (ds == null) {
            return;
        }

        for (DanhMucSanPham d : ds) {
            Object[] data = {
                d.getMaDanhMuc(),
                d.getTenDanhMuc()
            };

            dtm.addRow(data);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDM;
    private javax.swing.JTextField txt_DM;
    // End of variables declaration//GEN-END:variables

    private void lamMoi2() {
        this.txt_DM.setText("");

        this.btn_them.setEnabled(true);
        this.btn_Sua.setEnabled(false);
        this.btn_xoa.setEnabled(false);
    }
}
