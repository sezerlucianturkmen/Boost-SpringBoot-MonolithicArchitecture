package com.boost.Java3Monolithic.controllermvc;

import com.boost.Java3Monolithic.repository.entity.Musteri;
import com.boost.Java3Monolithic.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginMvcController {

    private final MusteriService musteriService;

    // http://localhost:9090/login/home
    @GetMapping("/loginpage")
    public ModelAndView loginGirisSayfasi(){
        /**
         * 1- Önce ModelAndView nesnesi oluşturulur.
         * 2- Model nesnesinin hangi sayfayı yöneteceği belirlenir.
         */
        String ka= "Kullanıcı Adı";
        String sfr= "Şifre";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView
                .addObject("firma",
                        "Bilgeadam A.Ş.");
        modelAndView.addObject("kullanicilbl",ka);
        modelAndView.addObject("sifrelbl",sfr);
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(String txtkullaniciadi,String txtsifre){
        if(musteriService.isExistUser(txtkullaniciadi,txtsifre)){
            return new ModelAndView("redirect:/home");
        }else{
            System.out.println("Kullanıcıadı veya şifre hatalı");
        }
        return null;
    }

    // http://localhost:9090/login/registerpage
    @GetMapping("/registerpage")
    public ModelAndView register(){
        //return new ModelAndView("register");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("/doregister")
    public ModelAndView doRegister(String email,String username,
                                   String password){
        musteriService.save(
                Musteri.builder()
                        .email(email)
                        .username(username)
                        .psw(password)
                        .build()
        );
        return new ModelAndView("redirect:loginpage");
    }

}