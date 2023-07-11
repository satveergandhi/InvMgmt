package com.inn.image.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.image.model.Image;
import com.inn.image.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	public Image saveImg(byte[] imgData) {
		Image image = new Image();
		image.setImgdata(imgData);
		return imageRepository.save(image);
	}
	
	public Optional<Image> getImg(Long id) {
		return imageRepository.findById(id);
	}

}
