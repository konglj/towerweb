package com.tower.common.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tower.common.Config;
import com.tower.common.util.FileUpload;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.SysUser;


@Controller
@RequestMapping("/file")
public class FileWeb {

	/**
	 * 多张图片上传
	 * @param request
	 * @param fileid
	 * @return
	 */
	@RequestMapping(value = "/images_save", method = RequestMethod.POST)
	@ResponseBody
	public Object imagesSave(HttpServletRequest request) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();

    	List<String> images = FileUpload.uploadFiles(request, Config.root_path+File.separator+province);
		if (images==null || images.size()==0) {
			return ResultUtil.responseErrorMsg("上传失败");
		}
		String output = images.get(0);
		String s_images = (String) request.getSession().getAttribute("images");
		if (s_images == null) {
		    s_images = "";
		}
		s_images +=province+File.separator+output + ";";
		System.out.println("images=" + s_images);
		request.getSession().setAttribute("images", s_images);
		return ResultUtil.responseSuccessMsg(images);
	}
}
