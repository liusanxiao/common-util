package lenovo.pcsd.products.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
/**
 *
 * @author kangjie
 *
 */
public class ImageHandleUtil {

	private static Logger logger = Logger.getLogger(ReflactForInstance.class);
	
	private static BufferedImage toImage(File f) {
		try {
			return ImageIO.read(new FileInputStream(f));
		} catch (IOException e) {
			logger.error(e);
		}
		return null;
	}
	
	/**
	 * 校验图片尺寸和大小
	 * @param f
	 * @param width
	 * @param height
	 * @param maxSize KB
	 * @return
	 */
	public static boolean isSizeValid(File f ,int width,int height,long maxSize) {
		BufferedImage image = toImage(f);
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		long imageSize = (long) (f.length()/1024.0);
		if (width > 0 && width != imageWidth) {
			return false;
		}
		
		if (height > 0 && height != imageHeight) {
			return false;
		}
		if ((maxSize > 0) && (imageSize > maxSize)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 校验图片尺寸和大小是否超过最大值
	 * @param f
	 * @param width =978
	 * @param height <1000
	 * @param maxSize KB   <400
	 * @return
	 */
	public static boolean isMaxSizeValid(File f ,int maxWidth,int maxHeight,long maxSize) {
		BufferedImage image = toImage(f);
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		long imageSize = (long) (f.length()/1024.0);
		if (imageWidth != 978 && imageWidth != 620 && imageWidth != 1240 && imageWidth != 1200) {
			return false;
		}
		if (maxHeight > 0 && imageHeight > maxHeight) {
			return false;
		}
		if ((maxSize > 0) && (imageSize > maxSize)) {
			return false;
		}
		return true;
	}
	/**
	 * 校验图片尺寸和大小
	 * @param f
	 * @param ImageRestriction 图片限制条件
	 * @return
	 */
	public static boolean isValid(File f, ImageRestriction ir, String fileName) {
		BufferedImage image = toImage(f);
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		long imageSize = (long) (f.length()/1024.0);
		return chkImg(ir, imageWidth, imageHeight, imageSize, fileName);
	}
	/**
	 * 校验图片尺寸和大小
	 */
	private static boolean chkImg(ImageRestriction ir, int imageWidth, int imageHeight, long imageSize, String fileName) {
		if(ir.he != null){
			if(!(ir.he == imageHeight)){
				return false;
			}
		}
		if(ir.we != null){
			if(!(ir.we == imageWidth)){
				return false;
			}
		}
		if(ir.hlt != null){
			if(!(ir.hlt < imageHeight)){
				return false;
			}
		}
		if(ir.wlt != null){
			if(!(ir.wlt < imageWidth)){
				return false;
			}
		}
		if(ir.hlte != null){
			if(!(ir.hlte <= imageHeight)){
				return false;
			}
		}
		if(ir.wlte != null){
			if(!(ir.wlte <= imageWidth)){
				return false;
			}
		}
		if(ir.hgt != null){
			if(!(ir.hgt > imageHeight)){
				return false;
			}
		}
		if(ir.wgt != null){
			if(!(ir.wgt > imageWidth)){
				return false;
			}
		}
		if(ir.hgte != null){
			if(!(ir.hgte >= imageHeight)){
				return false;
			}
		}
		if(ir.wgte != null){
			if(!(ir.wgte >= imageWidth)){
				return false;
			}
		}
		if(ir.hew != null){
			if(!(ir.hew && imageHeight == imageWidth)){
				return false;
			}
		}
		if(ir.maxSize != null){
			if(!(ir.maxSize >= imageSize)){
				return false;
			}
		}
		if(ir.namePattern != null && fileName != null){
			try {
				return fileName.matches(ir.namePattern);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @ClassName ImageRestriction 
	 * @Description 图片限制条件<br> 
	 * h：图片高度<br>
	 * w：图片宽度<br>
	 * e：等于某值<br>
	 * lt：小于某值<br>
	 * gt：大于某值<br>
	 * lte：小于等于某值<br>
	 * gte：大于等于某值<br>
	 * hew：高度等于宽度<br>
	 * maxSize：最大尺寸，单位KB<br>
	 * formatPattern：文件名格式 正则<br>
	 * @author kangjie kangjie_litsoft_com_cn
	 * @date 2016年8月24日 上午11:07:30
	 */
	public static class ImageRestriction {
		private Integer he;
		private Integer we;
		private Integer hlt;
		private Integer wlt;
		private Integer hgt;
		private Integer wgt;
		private Integer hlte;
		private Integer wlte;
		private Integer hgte;
		private Integer wgte;
		private Boolean hew;
		private Long maxSize;
		private String namePattern;
		public boolean hasDemand(){
			if(he != null)return true;
			if(we != null)return true;
			if(hlt != null)return true;
			if(wlt != null)return true;
			if(hgt != null)return true;
			if(wgt != null)return true;
			if(hlte != null)return true;
			if(wlte != null)return true;
			if(hgte != null)return true;
			if(wgte != null)return true;
			if(hew != null)return true;
			if(maxSize != null)return true;
			if(namePattern != null)return true;
			return false;
		}
		public String getDemand(){
			StringBuilder sb = new StringBuilder();
			sb.append("条件");
			if(he != null)sb.append(",高度等于" + he + "px");
			if(we != null)sb.append(",宽度等于" + we + "px");
			if(hlt != null)sb.append(",高度小于" + hlt + "px");
			if(wlt != null)sb.append(",宽度小于" + wlt + "px");
			if(hgt != null)sb.append(",高度大于" + hgt + "px");
			if(wgt != null)sb.append(",宽度大于" + wgt + "px");
			if(hlte != null)sb.append(",高度小于等于" + hlte + "px");
			if(wlte != null)sb.append(",宽度小于等于" + wlte + "px");
			if(hgte != null)sb.append(",高度大于等于" + hgte + "px");
			if(wgte != null)sb.append(",宽度大于等于" + wgte + "px");
			if(hew != null)sb.append(",高度等于宽度");
			if(maxSize != null)sb.append(",最大大小" + maxSize + "KB");
			if(namePattern != null)sb.append(",文件名格式:/" + namePattern + "/");
			return sb.toString();
		}
		public Integer getHe() {
			return he;
		}
		public void setHe(Integer he) {
			this.he = he;
		}
		public Integer getWe() {
			return we;
		}
		public void setWe(Integer we) {
			this.we = we;
		}
		public Integer getHlt() {
			return hlt;
		}
		public void setHlt(Integer hlt) {
			this.hlt = hlt;
		}
		public Integer getWlt() {
			return wlt;
		}
		public void setWlt(Integer wlt) {
			this.wlt = wlt;
		}
		public Integer getHgt() {
			return hgt;
		}
		public void setHgt(Integer hgt) {
			this.hgt = hgt;
		}
		public Integer getWgt() {
			return wgt;
		}
		public void setWgt(Integer wgt) {
			this.wgt = wgt;
		}
		public Integer getHlte() {
			return hlte;
		}
		public void setHlte(Integer hlte) {
			this.hlte = hlte;
		}
		public Integer getWlte() {
			return wlte;
		}
		public void setWlte(Integer wlte) {
			this.wlte = wlte;
		}
		public Boolean getHew() {
			return hew;
		}
		public void setHew(Boolean hew) {
			this.hew = hew;
		}
		public Long getMaxSize() {
			return maxSize;
		}
		public void setMaxSize(Long maxSize) {
			this.maxSize = maxSize;
		}
		public Integer getHgte() {
			return hgte;
		}
		public void setHgte(Integer hgte) {
			this.hgte = hgte;
		}
		public Integer getWgte() {
			return wgte;
		}
		public void setWgte(Integer wgte) {
			this.wgte = wgte;
		}
		public String getNamePattern() {
			return namePattern;
		}
		public void setNamePattern(String formatRegex) {
			this.namePattern = formatRegex;
		}
	}
	/**
	 * 
	 * @param imgInputStream
	 * @param imgOutputStream
	 * @param level
	 */
	public static void scaleImage(InputStream imgInputStream, OutputStream imgOutputStream, int limit) {
//		try {
//			float per = 0.7f;
//			Image src = javax.imageio.ImageIO.read(imgInputStream);
//			int width = src.getWidth(null);
//			int height = src.getHeight(null);
//			double rate = 0;
//			if(height > width){//如果高大于宽
//				rate = height * 1.0 / limit;
//				height = limit;//设置高为限制值
//				width = (int) Math.floor(width / rate);
//			} else {
//				rate = width * 1.0 / limit;
//				width = limit;//设置宽为限制值
//				height = (int) Math.floor(height / rate);
//			}
//			
////            // 构造Image对象  
////            int old_w = src.getWidth(null); // 得到源图宽  
////            int old_h = src.getHeight(null);  
////            int new_w = 0;  
////            int new_h = 0; // 得到源图长  
////            double w2 = (old_w * 1.00) / (w * 1.00);  
////            double h2 = (old_h * 1.00) / (h * 1.00);  
//            // 图片跟据长宽留白，成一个正方形图。  
//            BufferedImage oldpic = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); ;  
////            if (old_w > old_h) {  
////                oldpic = new BufferedImage(old_w, old_w,  
////                        BufferedImage.TYPE_INT_RGB);  
////            } else {  
////                if (old_w < old_h) {  
////                    oldpic = new BufferedImage(old_h, old_h,  
////                            BufferedImage.TYPE_INT_RGB);  
////                } else {  
////                    oldpic = new BufferedImage(old_w, old_h,  
////                            BufferedImage.TYPE_INT_RGB);  
////                }  
////            }  
//            Graphics2D g = oldpic.createGraphics();  
//            g.setColor(Color.white);  
////            if (old_w > old_h) {  
////                g.fillRect(0, 0, old_w, old_w);  
////                g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h,  
////                        Color.white, null);  
////            } else {  
////                if (old_w < old_h) {  
////                    g.fillRect(0, 0, old_h, old_h);  
////                    g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h,  
////                            Color.white, null);  
////                } else {  
////  
////                    // g.fillRect(0,0,old_h,old_h);  
////                    g.drawImage(src.getScaledInstance(old_w, old_h,  
////                            Image.SCALE_SMOOTH), 0, 0, null);  
////                }  
////            }  
//            g.drawImage(src, 0, 0, width, height, Color.white, null);  
//            g.dispose();  
//            src = oldpic;  
//            // 图片调整为方形结束  
////            if (old_w > w)  
////                new_w = (int) Math.round(old_w / w2);  
////            else  
////                new_w = old_w;  
////            if (old_h > h)  
////                new_h = (int) Math.round(old_h / h2);// 计算新图长宽  
////            else  
////                new_h = old_h;  
//            BufferedImage tag = new BufferedImage(width, height,  
//                    BufferedImage.TYPE_INT_RGB);  
//            // tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);  
//            // 绘制缩小后的图  
//            tag.getGraphics().drawImage(  
//                    src.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,  
//                    0, null);  
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(imgOutputStream);  
//            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);  
//            /* 压缩质量 */  
//            jep.setQuality(per, true);  
//            encoder.encode(tag, jep);  
//            // encoder.encode(tag);  
//            // 近JPEG编码  
//            imgOutputStream.close();  
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
