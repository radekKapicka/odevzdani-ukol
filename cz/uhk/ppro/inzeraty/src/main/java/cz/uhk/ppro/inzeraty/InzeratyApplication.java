package cz.uhk.ppro.inzeraty;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.math.BigDecimal;

@SpringBootApplication
@ComponentScan(basePackages = {"cz.uhk.ppro.inzeraty.web"})
public class InzeratyApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(InzeratyApplication.class, args);
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    @Primary
    UlozisteInzeratu getUlozisteInzeratu() {
        UlozisteInzeratu u = new PametoveUlozisteInzeratu();
        u.pridej(new Inzerat(1,"prodám auto", "prodej", new BigDecimal("10000")));
        u.pridej(new Inzerat(2,"koupím kolo", "nakup", new BigDecimal("9000")));
        u.pridej(new Inzerat(3,"vyměním dítě", "vymena", new BigDecimal("0")));
        return u;
    }

}
