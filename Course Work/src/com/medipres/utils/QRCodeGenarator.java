package com.medipres.utils;
 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
 
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.patient.model.PatientModel;
import com.patient.model.*;

 
public class QRCodeGenarator {
 
	private PatientModel pm=null;
	public QRCodeGenarator(PatientModel pm)
	{
		this.pm=pm;
	}
	
	public String getStoreData()
	{
		String data="";
		data += "firstname :"+pm.getFirst_name()+",";
		data +=" middilename :"+pm.getMiddle_name()+",";
		data+="lastname :"+pm.getLast_name()+",";
		data+="phone:"+pm.getPhone()+",";
		data+="email"+pm.getEmail()+",";
	
		return data;
	}
	
	
	public void QRCodePatient()
	{
		 String myCodeText = getStoreData();
		 String dir=System.getProperty("user.dir");
		 System.out.println(dir);
		 String filePath = dir+File.separator+"QrImages"+File.separator+"QR"+pm.getQr_code()+".png";
	        int size = 125;
	        String fileType = "png";
	        File myFile = new File(filePath);
	        try {
	            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            QRCodeWriter qrCodeWriter = new QRCodeWriter();
	            BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText,BarcodeFormat.QR_CODE, size, size, hintMap);
	            int CrunchifyWidth = byteMatrix.getWidth();
	            BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
	                    BufferedImage.TYPE_INT_RGB);
	            image.createGraphics();
	 
	            Graphics2D graphics = (Graphics2D) image.getGraphics();
	            graphics.setColor(Color.WHITE);
	            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
	            graphics.setColor(Color.BLACK);
	 
	            for (int i = 0; i < CrunchifyWidth; i++) {
	                for (int j = 0; j < CrunchifyWidth; j++) {
	                    if (byteMatrix.get(i, j)) {
	                        graphics.fillRect(i, j, 1, 1);
	                    }
	                }
	            }
	            ImageIO.write(image, fileType, myFile);
	        } catch (WriterException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("You have successfully created QR Code.");
	    }       
	
	
	public static void main(String[] args)
	{
		PatientModel pm=new PatientModel();
		pm.setQr_code(1);
		pm.setFirst_name("Mani");
		QRCodeGenarator qr=new QRCodeGenarator(pm);
		
		qr.QRCodePatient();
		
	}
 
     
}