package br.com.fiap.bss.repository;
import br.com.fiap.bss.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}