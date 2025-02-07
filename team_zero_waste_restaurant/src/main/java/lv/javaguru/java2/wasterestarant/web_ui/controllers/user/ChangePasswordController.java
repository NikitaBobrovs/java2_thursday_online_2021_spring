package lv.javaguru.java2.wasterestarant.web_ui.controllers.user;

import lv.javaguru.java2.wasterestarant.core.requests.user.ChangePasswordRequest;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangePasswordResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangePasswordController {
    @Autowired
    private ChangePasswordService changePasswordService;

    @GetMapping(value = "/changePassword")
    public String showChangePasswordPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new ChangePasswordRequest());
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String processChangePasswordRequest(@ModelAttribute(value = "request") ChangePasswordRequest request,
                                      ModelMap modelMap) {
        ChangePasswordResponse response = changePasswordService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "changePassword";
        } else {
            return "redirect:/";
        }
    }
}
