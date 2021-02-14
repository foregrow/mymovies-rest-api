package com.mymovies.web.controllers;


import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mymovies.models.Photo;
import com.mymovies.services.PhotoService;
import com.mymovies.web.dtos.PhotoDTO;




@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RequestMapping(value="api/photos")
public class PhotoController {
	

	@Autowired
	PhotoService ps;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Photo> photos = ps.getAll();	
		List<PhotoDTO> dtos = ps.getAllDTOs(photos);		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable long id){
		Photo obj = ps.getById(id);
		
		if(obj == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		PhotoDTO dto = ps.getSingleDTO(obj);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestParam("imageFile") MultipartFile file,@RequestParam("entity") String entity,@RequestParam("id") long id) throws IOException{
		System.out.println("original img byte size - " + file.getBytes().length);
		String fileExtension = com.google.common.io.Files.getFileExtension(file.getOriginalFilename());
		System.out.println("fileExtension = " +fileExtension);
		if(!fileExtension.equals("jpg") && !fileExtension.equals("png") && !fileExtension.equals("jpeg") && !fileExtension.equals("jfif")
				&& !fileExtension.equals("jif") && !fileExtension.equals("gif")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Photo p = ps.create(file,entity,id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	


}
