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
package com.ynov.microservices.pet;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@RestController
class PetController {

	private final PetRepository pets;

	public PetController(PetRepository pets) {
		this.pets = pets;
	}
	
	@GetMapping("/pet-types")
	List<PetType> findPetTypes() {
		return pets.findPetTypes();
	}

	@GetMapping("/pets")
	public Iterable<Pet> getPets() {
		return pets.findAll();
	}

	@GetMapping("/pets/{id}")
	public Optional<Pet> getPetById(@PathVariable("id") Integer id) {
		return pets.findById(id);
	}

	@PostMapping("/pets") 
	public Pet addPet(@RequestBody Pet pet) {
		return this.pets.save(pet);
	}
	
	@PostMapping("/pets/new")
	public Pet addPet(@RequestParam("firstName") String firstName, @RequestParam("ownerId") Integer ownerId,
			@RequestParam("petType") PetType type, @RequestParam("birthDate") LocalDate birthDate) {
		Pet pet = new Pet();
		pet.setName(firstName);
		pet.setOwner(ownerId);
		pet.setType(type);
		pet.setBirthDate(birthDate);
		return pets.save(pet);
	}

	@PutMapping("/pets/{id}")
	public Pet editPet(@PathVariable("id") Integer id, @RequestParam("firstName") String firstName,
			@RequestParam("ownerId") Integer ownerId, @RequestParam("petType") PetType type,
			@RequestParam("birthDate") LocalDate birthDate) {

		Optional<Pet> petOpt = pets.findById(id);
		if (petOpt.isPresent()) {
			Pet pet = petOpt.get();
			pet.setName(firstName);
			pet.setOwner(ownerId);
			pet.setType(type);
			pet.setBirthDate(birthDate);
			pets.save(pet);
		}
		return petOpt.get();
	}

	@DeleteMapping("/pets/{id}")
	public void deletePet(@PathVariable("id") Integer id) {
		pets.deleteById(id);
	}

	@PostMapping("/pets/{petId}/addVisit")
	public void addVisitToPet(@PathVariable("petId") Integer petId, @RequestParam("visitId") Integer visitId) {
		Optional<Pet> petOpt = pets.findById(petId);
		if (petOpt.isPresent()) {
			Pet pet = petOpt.get();
			pet.addVisit(visitId);
			pets.save(pet);
		}

	}

}
