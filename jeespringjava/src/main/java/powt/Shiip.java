package powt;

public class Shiip {
    private Kaptain kaptain;

    public Shiip(Kaptain kaptain) {
        this.kaptain = kaptain;
    }

    public Kaptain getKaptain() {
        return kaptain;
    }

    public void setKaptain(Kaptain kaptain) {
        this.kaptain = kaptain;
    }

    @Override
    public String toString() {
        return "Shiip{" +
                "kaptain=" + kaptain +
                '}';
    }
}
