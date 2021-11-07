package com.example.projetg4.controllers;

import java.io.IOException;
import java.util.Base64;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.projetg4.models.UploadFile;

@Controller
public class fileController {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@PostMapping("/file/up")
	@ResponseBody
	public String uploadImage(@RequestParam(value = "image") MultipartFile file) throws IOException{
	   

	    
	    String fileName = file.getOriginalFilename();

	        UploadFile uploadFile = new UploadFile();
	        uploadFile.setName(fileName);
	        uploadFile.setContent(new Binary(file.getBytes()));
	        uploadFile.setContenttype(file.getContentType());
	        uploadFile.setSize(file.getSize());

	        UploadFile savedFile = mongoTemplate.save(uploadFile);
  
	 
	    return savedFile.getId();

} 
	
	
	@GetMapping(value = "/file/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	@ResponseBody
	public byte[] image(@PathVariable String id ,Model model){
	    byte[] data = null;
	    UploadFile file = mongoTemplate.findById(id, UploadFile.class);
	    if(file != null){
	        data = file.getContent().getData();
	    }
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(file.getContent().getData()));
	    return data;
	}
	
}
