package luyao.everything.enity;

import java.io.Serializable;

/**
 * Created by Lu
 * on 2016/11/15 11:03.
 */

public class GuideEnity implements Serializable {

    private int id;
    private String name;
    private int resId;
    private boolean isSelected = false;
    private Class z;

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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Class getZ() {
        return z;
    }

    public void setZ(Class z) {
        this.z = z;
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
