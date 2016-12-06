package com.tower.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class FileUpload {
	
	
	
	public static List<String> uploadFiles(HttpServletRequest request, String filepath){
		List<String> images = null;
		String image=null;
		String filename=null;
		// 获取上传文件
		// 转型为MultipartHttpRequest：
		// 保存
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 获得文件：
			List<MultipartFile> files=multipartRequest.getFiles("file");
			//MultipartFile file = multipartRequest.getFile("file");
			if (files.size() >  0) {
				images = new ArrayList<String>();
			}
			for (MultipartFile file : files) {
				
				String path = request.getSession().getServletContext()
						.getRealPath("/");
		        if(path.endsWith(File.separator))
		        	path=path.substring(0,path.length()-1);
				path=path.substring(0,path.lastIndexOf(File.separator));
				path=path+"/"+filepath;
				System.out.println(path);

				String oldname = file.getOriginalFilename();
				String extname = oldname.substring(oldname.indexOf("."));
				// 获得文件名：
				 filename =UUID.randomUUID().toString().replace("-", "")+extname;
				System.out.println(filename);
				File targetFile = new File(path, filename);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}

				file.transferTo(targetFile);
				image =filename;
				images.add(image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return images;
	}
	

	public static String uploadFile(HttpServletRequest request, String filepath,
			String inputfileid) {
		String filename=null;
		boolean result = false;
		// 获取上传文件
		// 转型为MultipartHttpRequest：
		// 保存
		String image = null;
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 获得文件：
			MultipartFile file = multipartRequest.getFile(inputfileid);
			if (file != null) {
				
				String path = request.getSession().getServletContext()
						.getRealPath("/");
		        if(path.endsWith("\\"))
		        	path=path.substring(0,path.length()-1);
				path=path.substring(0,path.lastIndexOf('\\'));
//				path=path+"\\mugong_file\\"+filepath;
				path=path+"/"+filepath;
				System.out.println(path);

				String oldname = file.getOriginalFilename();
				String extname = oldname.substring(oldname.indexOf("."));
				// 获得文件名：
				 filename =UUID.randomUUID().toString().replace("-", "")+extname;
				System.out.println(filename);
				File targetFile = new File(path, filename);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}

				file.transferTo(targetFile);
//				image ="mugong_file/"+filepath + filename;
				image =filename;
			}
		} catch (Exception e) {
			image=null;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return image;
	}
	
	
	public static String uploadFile_excel(HttpServletRequest request, String filepath,
			String inputfileid) {
		String filename=null;
		boolean result = false;
		// 获取上传文件
		// 转型为MultipartHttpRequest：
		// 保存
		String image = null;
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 获得文件：
			MultipartFile file = multipartRequest.getFile(inputfileid);
			if (file != null) {
				String path = request.getSession().getServletContext()
						.getRealPath("/");
		        if(path.endsWith("\\"))
		        	path=path.substring(0,path.length()-1);
				path=path.substring(0,path.lastIndexOf('\\'));
				path=path+"\\mugong_file\\"+filepath;

				String oldname = file.getOriginalFilename();
				String extname = oldname.substring(oldname.indexOf("."));
				// 获得文件名：
				 filename =UUID.randomUUID().toString().replace("-", "")+extname;
				System.out.println(filename);
				File targetFile = new File(path, filename);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}

				file.transferTo(targetFile);
				image=path+"\\"+filename;
			}
		} catch (Exception e) {
			image=null;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return image;
	}
	
	
	
	public static boolean downloadFile(String filename,byte[]content,HttpServletResponse response) throws IOException{
		boolean result=false;
		try {
			filename = new String(filename.getBytes(), "iso-8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename + "");
		ServletOutputStream out = response.getOutputStream();
	
		
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return true;
	}
}
