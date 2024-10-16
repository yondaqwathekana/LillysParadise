package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID imageId;
    private String description;
    private String filePath;
    @CreatedDate
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    protected Image(){}
    public Image(Builder builder) {
        this.imageId = builder.imageId;
        this.description = builder.description;
        this.filePath = builder.filePath;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        imageId = UUID.randomUUID();
        createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Image image = (Image) object;
        return Objects.equals(imageId, image.imageId) && Objects.equals(description, image.description) && Objects.equals(filePath, image.filePath) && Objects.equals(createdAt, image.createdAt) && Objects.equals(updatedAt, image.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, description, filePath, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static class Builder{
        private UUID imageId;
        private String description;
        private String filePath;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder setImageId(UUID imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder copy(Image image){
            this.imageId = image.imageId;
            this.description = image.description;
            this.filePath = image.filePath;
            this.createdAt = image.createdAt;
            this.updatedAt = image.updatedAt;
            return this;
        }

        public Image build(){ return new Image(this); }
    }
}
