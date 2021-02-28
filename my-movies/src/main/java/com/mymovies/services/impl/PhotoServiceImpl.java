package com.mymovies.services.impl;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mymovies.models.MovieTvShow;
import com.mymovies.models.Person;
import com.mymovies.models.Photo;
import com.mymovies.models.User;
import com.mymovies.repositories.PhotoRepository;
import com.mymovies.services.MovieTvShowService;
import com.mymovies.services.PersonService;
import com.mymovies.services.PhotoService;
import com.mymovies.services.UserService;
import com.mymovies.web.dtos.PhotoDTO;
@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	PhotoRepository pr;


	@Autowired
	MovieTvShowService mtss;
	
	@Autowired
	PersonService ps;
	
	@Autowired
	UserService us;
	
	@Override
	public List<Photo> getAll() {
		return pr.findAll();
	}

	@Override
	public Photo getById(long id) {
		return pr.findById(id).orElse(null);
	}

	@Override
	public Photo create(PhotoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Photo create(MultipartFile file,String entity, long id) {
	
		if(!entity.equals("mts") && !entity.equals("user") && !entity.equals("person")) {
			return null;
		}
		Photo p = new Photo();
		p.setName(file.getOriginalFilename());
		p.setType(file.getContentType());
		//byte[] bytes = null;
		try {
			//bytes = compressBytes(file.getBytes());
			p.setPicByte(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(entity.equals("mts")) {
			MovieTvShow mts = mtss.getById(id);
			p.setMovieTvShow(mts);
		}else if(entity.equals("user")) {
			User user = us.getById(id);
			p.setUser(user);
		}else if(entity.equals("person")) {
			Person person = ps.getById(id);
			p.setPerson(person);
		}
		String dataenc = "";
		try {
			dataenc = Base64.getEncoder().encodeToString(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dataForPath = "data:"+file.getContentType()+";base64,"+dataenc;
		System.out.println("dataForPath:- "+dataForPath);
		p.setPath(dataForPath);
		return pr.save(p);
		
		
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	

	@Override
	public void deleteById(long id) {
		pr.deleteById(id);
		
	}

	@Override
	public Photo update(PhotoDTO obj) {
		return null;
		
	}

	@Override
	public List<PhotoDTO> getAllDTOs(List<Photo> objs) {
		List<PhotoDTO> dtos = new ArrayList<PhotoDTO>();
		objs.forEach(el->{
			PhotoDTO dto = new PhotoDTO(el);
			dtos.add(dto);
		});
		
		return dtos;
	}

	@Override
	public PhotoDTO getSingleDTO(Photo obj) {
		PhotoDTO dto = new PhotoDTO(obj);
		return dto;
	}

	
	
	

}
