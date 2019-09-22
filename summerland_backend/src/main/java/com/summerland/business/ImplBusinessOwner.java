package com.summerland.business;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.summerland.entities.House;
import com.summerland.entities.Owner;
import com.summerland.repositories.OwnerRepository;

@Service
@Transactional
public class ImplBusinessOwner implements IBusinessOwner{

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Override
	public ArrayList<Owner> getOwner() {
		return (ArrayList<Owner>) ownerRepository.findAll();
	}

	@Override
	public Owner findById(long id) {
		Optional<Owner> op_owner =  ownerRepository.findById(id);
		Owner owner=null;
		if(op_owner.isPresent()) 
		    owner = op_owner.get();
		return owner;
	}

	@Override
	public void saveOwner(Owner owner) {
		ownerRepository.save(owner);
		
	}

	@Override
	public Owner getOwnerByEmail(String email){
		if(ownerRepository.findOwnersByEmail(email).size()!=0){
			return ownerRepository.findOwnersByEmail(email).get(0);
		}
		return null;
	}

	

}
