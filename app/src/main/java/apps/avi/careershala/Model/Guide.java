package apps.avi.careershala.Model;

public class Guide {

    private String title;
    private int imaage;

    public Guide() {
    }

    public Guide(String title, int imaage) {
        this.title = title;
        this.imaage = imaage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImaage() {
        return imaage;
    }

    public void setImaage(int imaage) {
        this.imaage = imaage;
    }
}
