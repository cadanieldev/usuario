package com.example.usuario.infrastructure.repository;


import com.example.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Informar ao java que essa é uma interface repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Esta herdando a biblioteca jpareposity, apontando o nome da tabela e o tipo dela
    //exists retorna um boolean verifica se um dado ja foi passado no banco

    boolean existsByEmail(String email); // Passando o parametro email

    Optional<Usuario> findByEmail(String email); // classe do java util, evitar o retorno de informaçoes nulas/ UsernameNotFoundException para o codigo nao quebrar se houver erro nulo
    //Agora vamos criar o metodo de login, sendo meotodo post

    //Transactional para ajudar a nao ter nenhum erro ao deletar
    @Transactional
    void deleteByEmail(String email);

}
