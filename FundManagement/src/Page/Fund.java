package Page;

/**
 * Created by Alx on 2017/7/26.
 */
public class Fund {


    private int fid;
    private String name;
    private String platform;
    private String ballpark;
    private Integer grade;
    private Integer bgrade;
    private String manager;
    private int mgrade;


    public Fund() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBallpark() {
        return ballpark;
    }

    public void setBallpark(String ballpark) {
        this.ballpark = ballpark;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getBgrade() {
        return bgrade;
    }

    public void setBgrade(Integer bgrade) {
        this.bgrade = bgrade;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getMgrade() {
        return mgrade;
    }

    public void setMgrade(int mgrade) {
        this.mgrade = mgrade;
    }
}
