/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_contact_app;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sir
 */
public class Myfunction {
    
    public ImageIcon resizePic(String picPath, byte[] BLOBpic, int width, int height) {
        
        ImageIcon myImg;
        if(picPath != null) {
            myImg = new ImageIcon(picPath);
        } else {
            myImg = new ImageIcon(BLOBpic);
        }
        
        Image img = myImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    
    public String browseImage(JLabel lbl) {
        String path = null;
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        // file extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*Images","jpg");
        filec.addChoosableFileFilter(fileFilter);
        
        int fileState = filec.showSaveDialog(null);
        
        // if the user select a file
        if(fileState == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
//            imagePth = path;
            
            // display image in jlabel using resize iamge
             lbl.setIcon(resizePic(path, null, lbl.getWidth(), lbl.getHeight()));
            
             // jLabel_picture.setIcon(new ImageIcon(path));
        }
        // if user cancel
        else if(fileState == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Image Selected");
        }
        return path;
    }
    
}
