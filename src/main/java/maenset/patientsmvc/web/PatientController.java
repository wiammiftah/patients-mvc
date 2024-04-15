package maenset.patientsmvc.web;


import lombok.AllArgsConstructor;
import maenset.patientsmvc.entities.Patient;
import maenset.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "Keyword",defaultValue = "") String Keyword){
        Page<Patient> patientPage=patientRepository.findByNomContains(Keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",patientPage.getContent());
        model.addAttribute("pages",new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("Keyword",Keyword);
        return "patients";
    }
    @GetMapping( "/delete")
    public String delete(Long id,String Keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&Keyword"+Keyword;
    }
}
