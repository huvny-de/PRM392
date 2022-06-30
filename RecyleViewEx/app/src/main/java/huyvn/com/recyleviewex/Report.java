package huyvn.com.recyleviewex;

public class Report {
    private String title;
    private String description;
    private int image;
    private String textOnTheRightSide;

    public Report(String title, String description, int image, String textOnTheRightSide) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.textOnTheRightSide = textOnTheRightSide;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTextOnTheRightSide() {
        return textOnTheRightSide;
    }

    public void setTextOnTheRightSide(String textOnTheRightSide) {
        this.textOnTheRightSide = textOnTheRightSide;
    }
}
