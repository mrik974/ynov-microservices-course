/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ynov.microservices.owner;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@RestController
class OwnerController {

	private final OwnerRepository owners;

	public OwnerController(OwnerRepository clinicService) {
		this.owners = clinicService;
	}

	@HystrixCommand
	@GetMapping("/owners")
	public Iterable<Owner> getOwners() {
		return owners.findAll();
	}

	@HystrixCommand
	@GetMapping("/owners/{id}")
	public Optional<Owner> getOwnerById(@PathVariable("id") Integer id) {
		return owners.findById(id);
	}

	@HystrixCommand
	@PostMapping("/owners/new")
	public Owner addOwner(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("city") String city, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address) {
		Owner owner = new Owner();
		owner.setFirstName(firstName);
		owner.setLastName(lastName);
		owner.setCity(city);
		owner.setTelephone(phoneNumber);
		owner.setAddress(address);
		return owners.save(owner);
	}
	
	@HystrixCommand
	@PostMapping("/owners/")
	public Owner save(@RequestBody Owner owner) {
		return owners.save(owner);
	}


	@HystrixCommand
	@DeleteMapping("/owners/{id}")
	public void deleteOwner(@PathVariable("id") Integer id) {
		owners.deleteById(id);
	}

	@HystrixCommand
	@PostMapping("/owners/{ownerId}/addPet")
	public void addPetToOwner(@PathVariable("ownerId") Integer ownerId, @RequestParam("petId") Integer petId) {
		Optional<Owner> ownerOpt = owners.findById(ownerId);
		if (ownerOpt.isPresent()) {
			Owner owner = ownerOpt.get();
			owner.addPet(petId);
			owners.save(owner);
		}
		
	}
	
	@HystrixCommand(commandKey = "owner-service-find-by-last-name")
	@GetMapping("/owners/findByLastName/{lastName}")
	public Iterable<Owner> findOwnerByLastName(@PathVariable("lastName") String lastName) throws InterruptedException {
		return owners.findByLastName(lastName);
	}	

}
