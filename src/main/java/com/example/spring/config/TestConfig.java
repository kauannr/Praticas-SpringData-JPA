package com.example.spring.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.spring.entities.Telefone;
import com.example.spring.services.UsuarioServices;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioServices usuarioServices;

    

    @Override
    public void run(String... args) throws Exception {
        /*
         * UsuarioSpring user1 = new UsuarioSpring("José Kauan", "54321",
         * "jose@gmail.com", 1);
         * usuarioRepository.save(user1);
         * 
         * System.out.println("Usuarios cadastrados: " + usuarioRepository.count());
         * 
         * System.out.println("Pesquisando por ID");
         * UsuarioSpring usuarioSpring = usuarioRepository.findById(1L).get();
         * System.out.println(usuarioSpring.getNome() + " " + usuarioSpring.getEmail() +
         * " " + usuarioSpring.getLogin()
         * + " " + usuarioSpring.getSenha() + " " + usuarioSpring.getId());
         * 
         * System.out.println("Testando o busca por nome:");
         * UsuarioSpring userSpring = usuarioRepository.buscaPorNome("Kauan");
         * System.out.println(userSpring.getNome());
         * System.out.println(userSpring.getEmail());
         * System.out.println(userSpring.getLogin());
         * System.out.println(userSpring.getId());
         * System.out.println("----------------");
         * 
         * System.out.println("Testando busca por contém nome:");
         * List<UsuarioSpring> listaUsuarios =
         * usuarioRepository.buscaContemNome("Kauan");
         * for (UsuarioSpring usuarioSpring2 : listaUsuarios) {
         * System.out.println(usuarioSpring2.getNome());
         * System.out.println(usuarioSpring2.getEmail());
         * System.out.println(usuarioSpring2.getLogin());
         * System.out.println(usuarioSpring2.getId());
         * System.out.println("----------------");
         * }
         */

        List<Telefone> minhaList = usuarioServices.getTelefonesDeUsuario(1L);
        System.out.println("Lista de telefones do usuário: ");
        for (Telefone telefone : minhaList) {
            System.out.println(telefone.getNumero_telefone());
        }
        System.out.println("-------------------");

    }

}
