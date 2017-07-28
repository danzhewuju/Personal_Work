package Entity;

import javax.persistence.*;

/**
 * Created by Alx on 2017/7/26.
 */
@Entity
@Table(name = "fund", schema = "fund", catalog = "")
public class FundEntity {
    private int fid;
    private String name;
    private String platform;
    private String ballpark;
    private Integer grade;
    private Integer bgrade;
    private String manager;
    private int mgrade;

    @Id
    @Column(name = "fid", nullable = false)
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "platform", nullable = true, length = 50)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "ballpark", nullable = true, length = 50)
    public String getBallpark() {
        return ballpark;
    }

    public void setBallpark(String ballpark) {
        this.ballpark = ballpark;
    }

    @Basic
    @Column(name = "grade", nullable = true)
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "bgrade", nullable = true)
    public Integer getBgrade() {
        return bgrade;
    }

    public void setBgrade(Integer bgrade) {
        this.bgrade = bgrade;
    }

    @Basic
    @Column(name = "manager", nullable = false, length = 50)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "mgrade", nullable = false)
    public int getMgrade() {
        return mgrade;
    }

    public void setMgrade(int mgrade) {
        this.mgrade = mgrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundEntity that = (FundEntity) o;

        if (fid != that.fid) return false;
        if (mgrade != that.mgrade) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (ballpark != null ? !ballpark.equals(that.ballpark) : that.ballpark != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (bgrade != null ? !bgrade.equals(that.bgrade) : that.bgrade != null) return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (ballpark != null ? ballpark.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (bgrade != null ? bgrade.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + mgrade;
        return result;
    }
}
