package mx.aragon.tec.proyecto.controlladores;

import mx.aragon.tec.proyecto.modelos.Libro;
import mx.aragon.tec.proyecto.services.LibroService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String home() {return "home";}

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("libro", new Libro());
        return "formlibro";
    }

    @PostMapping("/guardar")
    public String guardar(
            //@RequestParam String titulo
            @ModelAttribute Libro libro
    ){
        LoggerFactory.getLogger(getClass()).info("Guardando libro: " + libro);
        libroService.guardarLibro(libro);
        return "redirect:/libros/nuevo?exito";
    }

    @GetMapping("/catalogo")
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.obtenerTodosLibros();
        model.addAttribute("libros", libros);
        return "LibrosGuardados";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros/catalogo";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Libro libro = libroService.buscarLibroById(id);
        if (libro == null) {
            return "redirect:/libros/catalogo";
        }
        model.addAttribute("libro", libro);
        return "formeditarlibro"; // Nuevo template para edición
    }

    @PostMapping("/actualizar")
    public String actualizarLibro(@ModelAttribute Libro libro) {
        libroService.actualizarLibro(libro);
        return "redirect:/libros/catalogo";
    }

}
