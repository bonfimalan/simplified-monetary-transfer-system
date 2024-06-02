package io.github.bonfimalan.simplified_monetary_transfer_system.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    private ObjectId id;

    @CreatedDate
    private Date creationDate;
    @LastModifiedDate
    private Date modifiedDate;

    public String getId() {
        if(id != null) {
            return id.toString();
        }
        return "";
    }

    public void setId(String id) {
        if (id != null) {
            this.id = new ObjectId(id);
        }
    }
}
