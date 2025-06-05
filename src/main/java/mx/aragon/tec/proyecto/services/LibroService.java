package mx.aragon.tec.proyecto.services;

import mx.aragon.tec.proyecto.modelos.Libro;
import mx.aragon.tec.proyecto.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public boolean guardarLibro(Libro libro) {
        Libro result = libroRepository.save(libro);
        return result != null;
    }

    public Libro buscarLibroById(Integer id) {
        return libroRepository.getById(id);
    }
}
