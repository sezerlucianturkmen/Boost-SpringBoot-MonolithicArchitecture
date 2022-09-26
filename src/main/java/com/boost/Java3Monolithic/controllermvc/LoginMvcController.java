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

    MusteriService musteriService;

    @GetMapping("/loginpage")
    public ModelAndView loginGirisSayfasi(){
        String ka="kullanici adi";
        String sfr="Sifre";
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("firma","bilgeadam Java 3 grubu");
        modelAndView.addObject("kullanicibl",ka);
        modelAndView.addObject("sifrebl",sfr);
        return modelAndView;
    }
    @PostMapping("/dologin") // action daki isim ile aynı olması gerekir
    public ModelAndView doLogin(String txtkullaniciadi,String txtsifre){
        if(txtkullaniciadi.equals("admin")&&txtsifre.equals("123")){
            System.out.println("Giris basarili");
        }else{
            System.out.println("Kullanici adi veya sifre hatali");
        }
        return null;
    }
    @GetMapping("/registerpage")
    public ModelAndView register(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @GetMapping("/doregister")
    public ModelAndView doRegister(String email, String username, String password){
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
