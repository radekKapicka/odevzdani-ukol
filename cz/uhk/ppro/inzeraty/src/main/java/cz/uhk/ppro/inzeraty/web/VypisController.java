package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VypisController {
    private UlozisteInzeratu vypisInzeratu = null;

    public UlozisteInzeratu getVypisInzeratu() {
        return vypisInzeratu;
    }

    @Autowired
    public void setVypisInzeratu(UlozisteInzeratu vypisInzeratu) {
        this.vypisInzeratu = vypisInzeratu;
    }


    @RequestMapping("/vypis")
    public ModelAndView zobrazit() {
        ModelAndView model = new ModelAndView("vypis");
        model.addObject("inzerat", vypisInzeratu.getInzeraty());
        return model;
    }
    @RequestMapping("/vypis-prodej")
    public ModelAndView zobrazitProdej() {
        ModelAndView model = new ModelAndView("vypisProdej");
        model.addObject("inzerat", vypisInzeratu.getInzeratyByKategorie("prodej"));
        return model;
    }

    @RequestMapping("/vypis-nakup")
    public ModelAndView zobrazitNakup() {
        ModelAndView model = new ModelAndView("vypisNakup");
        model.addObject("inzerat", vypisInzeratu.getInzeratyByKategorie("nakup"));
        return model;
    }

    @RequestMapping("/vypis-vymena")
    public ModelAndView zobrazitVymena() {
        ModelAndView model = new ModelAndView("vypisVymena");
        model.addObject("inzerat", vypisInzeratu.getInzeratyByKategorie("vymena"));
        return model;
    }

}