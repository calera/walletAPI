package com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.Usr; 

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	private final String EMAIL = "emaiil@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		Usr u = new Usr();
		u.setName("Set Up User");
		u.setPassword("Senha123");
		u.setEmail(EMAIL);
		
		repository.save(u);

	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}

	@Test
	public void testSave() {
		Usr u = new Usr();
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("teste@teste.com");
		
		Usr response = repository.save(u);
		
		assertNotNull(response);
		
	}
	
	public void testFindByEmail() {
		Optional<Usr> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}

}
