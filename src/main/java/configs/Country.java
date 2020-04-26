package configs;

/**
 * Created by Antony Genil on 2019-06-27 at 21 19 for licensing-service
 **/
public class Country {
    private String name;
    private String mode;
    private String common;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }


    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", mode='" + mode + '\'' +
                ", common='" + common + '\''  +
                '}';
    }
}
