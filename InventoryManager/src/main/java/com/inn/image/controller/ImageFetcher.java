package com.inn.image.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inn.image.model.Image;
import com.inn.image.service.ImageService;

@RestController
public class ImageFetcher {

	private final Map<Long, byte[]> image = new HashMap<>();
	private final AtomicLong counter = new AtomicLong(); 
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/uploadImage")
	public Image uploadImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
		byte[] imgByte = file.getBytes();
		return imageService.saveImg(imgByte);
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
		Optional<Image> optionalImage = imageService.getImg(id);
		if(optionalImage.isPresent()) {
			Image image = optionalImage.get();
			byte[] imgData = image.getImgdata();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<>(imgData, headers, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
}
