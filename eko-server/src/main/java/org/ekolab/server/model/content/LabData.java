package org.ekolab.server.model.content;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ekolab.server.model.IdentifiedDomainModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by 777Al on 19.04.2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class LabData<V extends LabVariant> extends IdentifiedDomainModel {
    @NotNull
    private V variant;

    @NotNull
    private String userLogin;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime saveDate;

    @NotNull
    private boolean completed;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(LocalDateTime saveDate) {
        this.saveDate = saveDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public V getVariant() {
        return variant;
    }

    public void setVariant(V variant) {
        this.variant = variant;
    }
}
