package com.example.spring;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.example.spring.entities.Telefone;
import com.example.spring.entities.UsuarioSpring;
import com.example.spring.repositories.TelefoneRespository;
import com.example.spring.repositories.UsuarioRepository;

@SpringBootTest
@Rollback(true)
@ActiveProfiles("test")
class ApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TelefoneRespository telefoneRespository;

	@Test
	void contextLoads() {
	}

	@Test
	public void inserirUsuario() {
		UsuarioSpring user1 = new UsuarioSpring("Joao", "123456", "joao@gmail.com", 2);
		UsuarioSpring user2 = new UsuarioSpring("Maria", "123456", "maria@gmail.com", 2);
		UsuarioSpring user3 = new UsuarioSpring("Jose", "123456", "jose@gmail.com", 2);
		UsuarioSpring user4 = new UsuarioSpring("Dudu", "123456", "dudu@gmail.com", 2);

		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		usuarioRepository.save(user3);
		usuarioRepository.save(user4);

	}

	@Test
	public void deletarUsuario() {
		usuarioRepository.deleteById(37L);
	}

	@Test
	public void testDeteleCondicional() {
		usuarioRepository.deletePorNome("José Kauan");
	}

	@Test
	public void testUpdateEmail() {
		usuarioRepository.updateEmailPorNome("novoemail@gmail.com", "Joao");
	}

	@Test
	public void testCriarTelefone() {

		Optional<UsuarioSpring> usuarioSpring = usuarioRepository.findById(1L);
		Telefone telefone = new Telefone();

		telefone.setUsuarioSpring(usuarioSpring.get());
		telefone.setTipo("Celular");
		telefone.setNumero_telefone("84941064");
		telefoneRespository.save(telefone);
	}
}
