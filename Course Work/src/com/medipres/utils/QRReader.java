package com.medipres.utils;

import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;

import com.google.zxing.common.HybridBinarizer;
import com.patient.model.PatientModel;
import com.patient.model.*;

public class QRReader {

	private PatientModel pm=null;
	
	
	public QRReader(PatientModel pm)
	{
		this.pm=pm;
	}
	
	
	public String getQrData()
	{
		Result result = null;
		BinaryBitmap binaryBitmap;
		try{
			String dir=System.getProperty("user.dir");
			System.out.println(dir);
			String filePath = dir+File.separator+"QrImages"+File.separator+"QR"+pm.getQr_code()+".png";
			binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
			result = new MultiFormatReader().decode(binaryBitmap);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result.getText();
	}
	
	public static void main(String[] args)
	{
		PatientModel pm=new PatientModel();
		pm.setQr_code(8);
		QRReader qr=new QRReader(pm);
		System.out.println(qr.getQrData());
	}
}