package com.summerland.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import com.summerland.entities.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.summerland.config.FileStorageProperties;
import com.summerland.entities.House;
import com.summerland.repositories.HouseRepository;

@Service
@Transactional
public class ImplBusinessHouse implements IBusinessHouse{

	@Autowired
	private HouseRepository houseRepository;
	
	//get all the houses
	public  ArrayList<House> getHouses() {
		
		return (ArrayList<House>) houseRepository.findAll();
	}

	@Override
	public void saveHouse(House house) {

		//First Image
		Path fileStorageLocation = Paths.get("/Users/asus/Angular Projects/Projet_Archi_log/frontend/src/assets/my_img")
                .toAbsolutePath().normalize();
		MultipartFile file=house.getImage();
		if(file != null){
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path targetLocation = fileStorageLocation.resolve(fileName);
		house.setPathimage(fileName);
        try {
			Files.copy(file.getInputStream(), targetLocation , StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		//Secondary images
		MultipartFile[] files=house.getImages();
		if(files !=null) {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file1 = files[i];
				if (file1 != null) {
					String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
					Path targetLocation = fileStorageLocation.resolve(fileName1);
					house.addPathImages(fileName1, i);
					try {
						Files.copy(file1.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		houseRepository.save(house);
	}
	
	@Override
	public ArrayList<House> listHousesOfOwner(Long id) {
		
		ArrayList<House> houses = houseRepository.findHouses(id);
		return houses;
	}

	@Override
	public House getHouseById(Long id){
		return houseRepository.getOne(id);
	}

	@Override
	public ArrayList<House> filter_houses(Filter filter) {
		ArrayList<House> houses =new ArrayList<House>();
		houses = (ArrayList<House>) houseRepository.findAll();
		for( int i=0; i < houses.size();i++){
			if(!filter.getCity().equals("All Cities")){
				if (houses.get(i).getPlace() == null || !houses.get(i).getPlace().getName().equals(filter.getCity())){
					houses.remove(i);
					i--;
					continue;
				}
			}
			if(!filter.getCatagory().equals("All Categories")){
				if (!houses.get(i).getType().equals(filter.getCatagory())){
					houses.remove(i);
					i--;
					continue;
				}
			}

			if (filter.getNumb_bathrooms()!=-1){
				if (houses.get(i).getBathrooms_number()!=filter.getNumb_bathrooms()){
					houses.remove(i);
					i--;
					continue;
				}
			}
			if (filter.getNumb_bedrooms()!=-1){
				if (houses.get(i).getRooms_number()!=filter.getNumb_bedrooms()){
					houses.remove(i);
					i--;
					continue;
				}
			}
			if (houses.get(i).getPrice()< filter.getPrice_min() ||
					houses.get(i).getPrice()>filter.getPrice_max()){
				houses.remove(i);
				i--;
				continue;
			}
			if (houses.get(i).getSurface() < filter.getSize_min() ||
					houses.get(i).getSurface() > filter.getSize_max()){
				houses.remove(i);
				i--;
				continue;
			}
		}


		return houses;

	}



}
