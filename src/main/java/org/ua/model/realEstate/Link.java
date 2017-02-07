package org.ua.model.realEstate;

/**
 * Created by u0100 on 04.07.2016.
 */
public class Link {
    private String dataId;
    private String link;

    public Link() {
    }

    public Link(String dataId, String link) {
        this.dataId = dataId;
        this.link = link;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;

        Link link1 = (Link) o;

        if (getDataId() != link1.getDataId()) return false;
        return getLink() != null ? getLink().equals(link1.getLink()) : link1.getLink() == null;

    }

    @Override
    public int hashCode() {
        int result = getDataId() != null ? getDataId().hashCode() : 0;
        result = 31 * result + (getLink() != null ? getLink().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "dataId='" + dataId + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
