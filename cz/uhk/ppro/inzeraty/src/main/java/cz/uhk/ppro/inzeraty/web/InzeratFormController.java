package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inzerat")
public class InzeratFormController {
    private UlozisteInzeratu uloziste = null;
    private Validator inzeratValidator;


    @RequestMapping(method= RequestMethod.POST)
    protected String onSubmit(@RequestParam(value= "inzId",required=false) Integer id, @ModelAttribute("inzerat") Inzerat inzerat, BindingResult result) {
        inzeratValidator.validate(inzerat, result);
        if (result.hasErrors()) {
            return "pridejInzerat";
        }
        if (id!=null) {
            uloziste.odstran(id);
        }
        uloziste.pridej(inzerat);
        return "redirect:/vypis";
    }

    @RequestMapping(method=RequestMethod.GET)
    protected String form(@RequestParam(value= "inzId",required=false) Integer id, Model m) {

        if (id!=null) {
            m.addAttribute("inzerat", uloziste.getById(id));
        } else {
            m.addAttribute("inzerat", new Inzerat());
        }
        return "pridejInzerat";
    }

    public UlozisteInzeratu getUloziste() {
        return uloziste;
    }

    @Autowired
    public void setUloziste(UlozisteInzeratu uloziste) {
        this.uloziste = uloziste;
    }

    public Validator getInzeratValidator() {
        return inzeratValidator;
    }

}