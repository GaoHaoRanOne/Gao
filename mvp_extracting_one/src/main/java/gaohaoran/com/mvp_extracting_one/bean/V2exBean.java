package gaohaoran.com.mvp_extracting_one.bean;

public class V2exBean {
    private String img;
    private String name;
    private String title;
    private String tab2;
    private String commet;
    private String time;
    private String codelike;

    public V2exBean(String name, String img, String title, String tab2, String commet, String time, String codelike) {
        this.name = name;
        this.img = img;
        this.title = title;
        this.tab2 = tab2;
        this.commet = commet;
        this.time = time;
        this.codelike = codelike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTab2() {
        return tab2;
    }

    public void setTab2(String tab2) {
        this.tab2 = tab2;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCodelike() {
        return codelike;
    }

    public void setCodelike(String codelike) {
        this.codelike = codelike;
    }

    @Override
    public String toString() {
        return "V2exBean{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", tab2='" + tab2 + '\'' +
                ", commet='" + commet + '\'' +
                ", time='" + time + '\'' +
                ", codelike='" + codelike + '\'' +
                '}';
    }
}
