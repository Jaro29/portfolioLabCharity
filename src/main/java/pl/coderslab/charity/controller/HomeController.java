package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
@RequiredArgsConstructor
public class HomeController {

private final InstitutionService institutionService;
private final DonationService donationService;
    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions",institutionService.getAllInstitutions());
        model.addAttribute("numberOfBags",donationService.getNumberOfBags());
        model.addAttribute("numberOfDonations",donationService.getNumberOfDonations());
        return "index";
    }
}
