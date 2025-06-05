package mx.aragon.tec.proyecto.controlladores;

import mx.aragon.tec.proyecto.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String home() {return "home";}

    @GetMapping("/nuevo/")
    public String nuevo() {return "nuevo";}

}
