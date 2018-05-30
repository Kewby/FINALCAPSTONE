///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package function;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JTable;
//import models.ProductModel;
//
///**
// *
// * @author 
// */
//public class Temp {
//    
//    public static int ID;
//    
//    public static String imageName () {
//        ProductModel pm = new ProductModel();
//        String im = null;
//        
//        ResultSet rs = pm.getLastImageId();
//        try {
//            if (rs.next()) {
//                im = rs.getString("product_image");
//            } 
//        } catch (SQLException ex) {
//            Logger.getLogger(Temp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        if (im == null || im.equalsIgnoreCase("null")) {
//            im = "img0001";
//        } else {
//            int i = Integer.parseInt(im.substring(3, 7));
//            i++;
//            im = "img";
//            if (i >= 10 && i < 100) {
//                im = im+"00"+i;
//            } else if (i < 10) {
//                im = im+"000"+i;
//            } else if (i >= 100 && i < 1000) {
//                im = im+"0"+i;
//            } else {
//                im = im+i;  
//            }
//        }
//        
//        return im;
//    }
//}
