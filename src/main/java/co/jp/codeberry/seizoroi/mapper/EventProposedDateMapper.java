package co.jp.codeberry.seizoroi.mapper;

import co.jp.codeberry.seizoroi.entity.EventProposedDate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface EventProposedDateMapper {

    @Options(useGeneratedKeys = true)
    @Insert("insert into event_proposed_date (event_id, date_str) values (#{eventId}, #{dateStr})")
    void save(EventProposedDate eventProposedDate);
}
