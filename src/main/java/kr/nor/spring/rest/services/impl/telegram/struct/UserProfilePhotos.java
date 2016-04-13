package kr.nor.spring.rest.services.impl.telegram.struct;

import java.util.List;

public class UserProfilePhotos {
    private int total_count;
    private List<PhotoSize> photos;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<PhotoSize> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoSize> photos) {
        this.photos = photos;
    }
}
