package co.jp.codeberry.seizoroi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    @GetMapping("/history")
    public String index() {
        return "history";
    }

}
