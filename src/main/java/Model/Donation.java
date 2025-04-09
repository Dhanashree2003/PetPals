package Model;

import java.time.LocalDateTime;

public class Donation {
    private int donationId;
    private String donorName;
    private DonationType donationType;
    private double donationAmount;
    private String donationItem;
    private LocalDateTime donationDate;

    public Donation(String donorName, DonationType donationType, double donationAmount, String donationItem, LocalDateTime donationDate) {
        this.donorName = donorName;
        this.donationType = donationType;
        this.donationAmount = donationAmount;
        this.donationItem = donationItem;
        this.donationDate = donationDate;
    }

    // Getters and Setters

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getDonationItem() {
        return donationItem;
    }

    public void setDonationItem(String donationItem) {
        this.donationItem = donationItem;
    }

    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDateTime donationDate) {
        this.donationDate = donationDate;
    }

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donorName=" + donorName + ", donationType=" + donationType
				+ ", donationAmount=" + donationAmount + ", donationItem=" + donationItem + ", donationDate="
				+ donationDate + "]";
	}

    
}
