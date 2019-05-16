package co.jp.codeberry.seizoroi.entity;

public class EventProposedDate {

    private Long id;
    private Long eventId;
    private String dateStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public String toString() {
        return "EventProposedDate{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", dateStr='" + dateStr + '\'' +
                '}';
    }
}
