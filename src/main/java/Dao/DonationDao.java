package Dao;

import Model.Donation;
import java.util.List;

public interface DonationDao {
    void recordDonation(Donation donation);
    List<Donation> listDonations();
}
