package co.jp.codeberry.seizoroi.mapper;

import co.jp.codeberry.seizoroi.entity.Event;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EventMapper {

    @Select("select * from event where random = #{random}")
    Event findByRandom(@Param("random") String random);

    @Insert("insert into event (name, admin_email, random) values (#{name}, #{adminEmail}, #{random})")
    @Options(useGeneratedKeys = true)
    void save(Event event);
}
