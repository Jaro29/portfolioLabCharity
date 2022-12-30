package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation,Long> {
    long countByIdNotNull();

    @Query(value = "select sum(quantity) from donation",nativeQuery = true)
    Integer totalQuantity();

    @Query(value = "select count(*) from donation",nativeQuery = true)
    Integer totalDonations();

}
