package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/editace")
public class EditaceInzeratu {
    UlozisteInzeratu uloziste = null;

    @RequestMapping(params="!akce")
    public ModelAndView show() throws Exception {
        return new ModelAndView("editaceInz","uloziste", uloziste);
    }

    @RequestMapping(params="akce=remove")
    public String remove(@RequestParam("inzId") int id) {
        uloziste.odstran(id);
        return "redirect:/editace";
    }

    public UlozisteInzeratu getUloziste() {
        return uloziste;
    }

    @Autowired
    public void setUloziste(UlozisteInzeratu uloziste) {
        this.uloziste = uloziste;
    }
}