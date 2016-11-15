package luyao.everything.enity;

/**
 * Created by Lu
 * on 2016/11/15 11:03.
 */

public class GuideEnity {

    private int id;
    private String name;
    private int resId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "GuideEnity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resId=" + resId +
                '}';
    }
}
