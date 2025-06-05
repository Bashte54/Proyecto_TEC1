package mx.aragon.tec.proyecto.controlladores;

import mx.aragon.tec.proyecto.modelos.Libro;
import mx.aragon.tec.proyecto.services.LibroService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
