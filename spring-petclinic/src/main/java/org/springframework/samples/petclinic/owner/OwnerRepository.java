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
package org.springframework.samples.petclinic.owner;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Repository class for <code>Owner</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
@FeignClient(value = "owner-service")
public interface OwnerRepository {

	@GetMapping("/owners/findByLastName/{lastName}")
	Collection<Owner> findByLastName(@PathVariable("lastName") String lastName);

	@GetMapping("/owners/{id}")
	public Owner findById(@PathVariable("id") Integer id);

	@PostMapping("/owners/")
	Owner save(@RequestBody Owner owner);

	@PostMapping("/owners/{ownerId}/addPet")
	public void addPetToOwner(@PathVariable("ownerId") Integer ownerId, @RequestParam("petId") Integer petId);

}
