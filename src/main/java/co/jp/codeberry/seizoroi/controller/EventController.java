package co.jp.codeberry.seizoroi.controller;

import co.jp.codeberry.seizoroi.entity.Event;
import co.jp.codeberry.seizoroi.mapper.EventMapper;
import co.jp.codeberry.seizoroi.form.MakeEventForm;
import co.jp.codeberry.seizoroi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.security.MessageDigest;

@Controller
public class EventController {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EventService eventService;


    @GetMapping("/event")
    public ModelAndView index(MakeEventForm makeEventForm, ModelAndView mv) {

        mv.addObject("makeEventForm", makeEventForm);// フォーム内容をマッピングする
        mv.setViewName("event");
        return mv;
    }

    @PostMapping("/event/register")
    public ModelAndView register(@Validated MakeEventForm makeEventForm, BindingResult result, ModelAndView mv) {

        Event event = new Event();
        event.setName(makeEventForm.getEventName());
        event.setAdminEmail(makeEventForm.getAdminEmailaddress());

        // ランダム文字列を生成
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update((makeEventForm.getEventName() + System.currentTimeMillis()).getBytes("utf8"));
            String random = String.format("%064x", new BigInteger(1, digest.digest()));
            event.setRandom(random);
        } catch (Exception e) {
            e.printStackTrace();
        }

        eventMapper.save(event);

        mv.setViewName("registerComplete");
        return mv;
    }
}
