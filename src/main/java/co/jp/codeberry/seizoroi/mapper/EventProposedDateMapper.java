package co.jp.codeberry.seizoroi.mapper;

import co.jp.codeberry.seizoroi.entity.Event;
import co.jp.codeberry.seizoroi.entity.EventProposedDate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventProposedDateMapper {

    @Select("select * from event_proposed_date where event_id = #{id}")
    @Results({
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "dateStr", column = "date_str")
    })
    List<EventProposedDate> findById(Event event);

    @Options(useGeneratedKeys = true)
    @Insert("insert into event_proposed_date (event_id, date_str) values (#{eventId}, #{dateStr})")
    void save(EventProposedDate eventProposedDate);
}
