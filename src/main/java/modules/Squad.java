package modules;

public class Squad {
    private String squadName;
    private String squadPurpose;
    private int squadNumber;
    private String squadGender;
    private int squadId;
    /* the property attributes have to be private to avoid being accessed directly without getters and setters or modified, thus, reducing the pesky bugs. */

    public String getSquadGender() {
        return squadGender;
    }

    public void setSquadGender(String squadGender) {
        this.squadGender = squadGender;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public String getSquadPurpose() {
        return squadPurpose;
    }

    public void setSquadPurpose(String squadPurpose) {
        this.squadPurpose = squadPurpose;
    }
}
