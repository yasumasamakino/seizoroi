package co.jp.codeberry.seizoroi.controller;

import co.jp.codeberry.seizoroi.form.MakeEventForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @GetMapping("/event")
    public ModelAndView index(MakeEventForm makeEventForm, ModelAndView mv) {

        mv.addObject("makeEventForm", makeEventForm);// フォーム内容をマッピングする
        mv.setViewName("event");
        return mv;
    }

    @PostMapping("/event/register")
    public ModelAndView register(@Validated MakeEventForm makeEventForm, BindingResult result, ModelAndView mv) {
        System.out.println(makeEventForm);
        mv.setViewName("registerComplete");
        return mv;
    }
}
