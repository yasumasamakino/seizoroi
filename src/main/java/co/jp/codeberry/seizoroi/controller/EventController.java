package co.jp.codeberry.seizoroi.controller;

import co.jp.codeberry.seizoroi.entity.Event;
import co.jp.codeberry.seizoroi.entity.EventProposedDate;
import co.jp.codeberry.seizoroi.mapper.EventMapper;
import co.jp.codeberry.seizoroi.form.MakeEventForm;
import co.jp.codeberry.seizoroi.mapper.EventProposedDateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EventController {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EventProposedDateMapper eventProposedDateMapper;


    @GetMapping("/event")
    public ModelAndView index(MakeEventForm makeEventForm, ModelAndView mv) {

        mv.addObject("makeEventForm", makeEventForm);// フォーム内容をマッピングする
        mv.setViewName("event");
        return mv;
    }

    @Transactional
    @PostMapping("/event/register")
    public ModelAndView register(@Validated MakeEventForm makeEventForm, BindingResult result, ModelAndView mv) {

        if (result.hasErrors()) {
            mv.setViewName("event");
            return mv;
        }

        // イベントの登録情報を作る
        Event event = new Event();
        event.setName(makeEventForm.getEventName());
        event.setAdminEmail(makeEventForm.getAdminEmailaddress());

        // ランダム文字列を生成
        String random = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update((makeEventForm.getEventName() + System.currentTimeMillis()).getBytes("utf8"));
            random = String.format("%064x", new BigInteger(1, digest.digest()));
            event.setRandom(random);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // イベント情報の登録
        eventMapper.save(event);

        // イベント候補日の登録情報を作る
        EventProposedDate eventProposedDate = new EventProposedDate();
        eventProposedDate.setEventId(event.getId());

        // 候補日を改行で分割
        List<String> dateList = new ArrayList<String>();

        // 複数の改行コードに対応
        String lineFeedCodes[] = {"\r\n","\r","\n"};
        for(String lfc : lineFeedCodes) {
            Pattern p = Pattern.compile(lfc);
            Matcher m = p.matcher(makeEventForm.getProposedDate());
            if (m.find()) {
                dateList = Arrays.asList(makeEventForm.getProposedDate().split(lfc));
                break;
            }
        }

        // イベント候補日の登録
        dateList.forEach(date -> {
            eventProposedDate.setDateStr(date);
            // イベント候補日の登録
            eventProposedDateMapper.save(eventProposedDate);
        });

        mv.addObject("random",random);
        mv.setViewName("registerComplete");
        return mv;
    }

    @GetMapping("/event/member")
    public ModelAndView member(@RequestParam("rm") String random, ModelAndView mv) {

        Event event = eventMapper.findByRandom(random);
        List<EventProposedDate> eventProposedDateList = eventProposedDateMapper.findById(event);

        mv.addObject("event", event);
        mv.addObject("eventProposedDateList", eventProposedDateList);
        mv.setViewName("attendance");
        return mv;

    }
}
