import java.util.Date;
import java.util.UUID;

public class BusinessProfile extends User {
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    private String industry;
    private int companySizeMin;
    private int companySizeMax;

    public BusinessProfile() {}
    public BusinessProfile(String name, String address, String contactPerson, String contactPhone, String industry, int companySizeMin, int companySizeMax) {
        super(name, address);
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.companySizeMin = companySizeMin;
        this.companySizeMax = companySizeMax;
    }
    public void updateCompanySize(int newCompanySizeMin, int newCompanySizeMax) {
        this.companySizeMin = newCompanySizeMin;
        this.companySizeMax = newCompanySizeMax;
    }
    public void updateContactInfo(String newContactPerson, String newContactEmail, String newContactPhone) {
        this.contactPerson = newContactPerson;
        this.contactEmail = newContactEmail;
        this.contactPhone = newContactPhone;
    }

}
