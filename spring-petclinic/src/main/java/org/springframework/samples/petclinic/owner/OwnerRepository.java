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

import java.util.Arrays;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
@Service
public class OwnerRepository {

	Collection<Owner> findByLastName(String lastName) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8085/owners/findByLastName/";
		ResponseEntity<Owner[]> response = restTemplate.getForEntity(fooResourceUrl + lastName, Owner[].class);
		return Arrays.asList(response.getBody());
	}

	public Owner findById(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8085/owners/";
		ResponseEntity<Owner> response = restTemplate.getForEntity(fooResourceUrl + id, Owner.class);
		return response.getBody();

	}

	void save(Owner owner) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8085/owners/";
		restTemplate.postForEntity(fooResourceUrl, owner, Owner.class);
	}

}
