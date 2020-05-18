package util;

public class Pants extends Clothes {
    private String sleeve; //***Enum
    private String neckFit; //***Enum

    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public String getNeckFit() {
        return neckFit;
    }

    public void setNeckFit(String neckFit) {
        this.neckFit = neckFit;
    }
}
