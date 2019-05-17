package co.jp.codeberry.seizoroi.form;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class MakeEventForm implements Serializable {

    private static final long serialVersionUID = -4230749597623724534L;

    @NotBlank
    private String eventName;

    @NotBlank
    private String proposedDate;

    @NotBlank
    private String adminEmailaddress;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getProposedDate() {
        return proposedDate;
    }

    public void setProposedDate(String proposedDate) {
        this.proposedDate = proposedDate;
    }

    public String getAdminEmailaddress() {
        return adminEmailaddress;
    }

    public void setAdminEmailaddress(String adminEmailaddress) {
        this.adminEmailaddress = adminEmailaddress;
    }

}
