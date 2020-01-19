public class Equipo {
    String key, name, code, logo;

    public Equipo(String key, String name, String code, String logo) {
        this.key = key;
        this.name = name;
        this.code = code;
        this.logo = logo;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return getName();
    }
}