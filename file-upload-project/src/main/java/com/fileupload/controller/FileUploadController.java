package com.fileupload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	public static String uploadDir=System.getProperty("user.dir")+"/upload_dir";
	
	@RequestMapping("/")
	public String uploadPage(Model model)
	{
		return "view";
	}
	
	@RequestMapping("/uploadfile")
	public String uploadFile(Model model,@RequestParam("files") MultipartFile[] files)
	{
		StringBuilder msg=new StringBuilder();
		
		for(MultipartFile file :files)
		{
			Path filePath=Paths.get(uploadDir,file.getOriginalFilename());
			msg.append(file.getOriginalFilename()+" ,");
			
			try {
				Files.write(filePath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("msg","Files Uploaded Successfully"+msg.toString());
		
		return "view";
		
	}

}
