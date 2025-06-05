package mx.aragon.tec.proyecto.repositorios;

import mx.aragon.tec.proyecto.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    public Libro findLibroById(Integer id);
    public void deleteLibroById(Integer id);
}
