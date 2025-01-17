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
import com.medicine.model.*;

 
public class QRCodeGenarator1 {
 
	private MedicineModel mm=null;
	public QRCodeGenarator1(MedicineModel mm)
	{
		this.mm=mm;
	}
	
	public String getStoreData()
	{
		String data="";
		data += "name :"+mm.getName()+",";
		data +=" form :"+mm.getForm()+",";
		data+="dose :"+mm.getDose()+",";
		data+="route:"+mm.getRoute()+",";
		
	
		return data;
	}
	
	
	public void QRCodeMedicine()
	{
		 String myCodeText = getStoreData();
		 String dir=System.getProperty("user.dir");
		 System.out.println(dir);
		 String filePath = dir+File.separator+"QrImages"+File.separator+"QR"+mm.getQr_code()+".png";
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
		MedicineModel mm=new MedicineModel();
		mm.setQr_code(1);
		mm.setName("asprin");
		QRCodeGenarator1 qr=new QRCodeGenarator1(mm);
		
		qr.QRCodeMedicine();
		
	}
 
     
}