package mx.aragon.tec.proyecto.services;

import mx.aragon.tec.proyecto.modelos.Libro;
import mx.aragon.tec.proyecto.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public boolean guardarLibro(Libro libro) {
        Libro result = libroRepository.save(libro);
        return result != null;
    }

    public Libro buscarLibroById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public List<Libro> obtenerTodosLibros() {
        return libroRepository.findAll();
    }

    public boolean eliminarLibro(Integer id) {
        try {
            libroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actualizarLibro(Libro libro) {
        if (libroRepository.existsById(libro.getId())) {
            libroRepository.save(libro);
            return true;
        }
        return false;
    }

}
