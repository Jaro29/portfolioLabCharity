package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DonationService {
    private final DonationRepository donationRepository;

    public Integer getNumberOfBags(){
        return donationRepository.totalQuantity();
    }

    public Integer getNumberOfDonations(){
        return donationRepository.totalDonations();
    }
}
